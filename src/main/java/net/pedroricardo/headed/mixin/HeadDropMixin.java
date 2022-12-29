package net.pedroricardo.headed.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import net.pedroricardo.headed.item.HeadedItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public abstract class HeadDropMixin extends LivingEntity {
    protected HeadDropMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "dropEquipment", at = @At(value = "TAIL"))
    private void injected(CallbackInfo ci, DamageSource source, boolean allowDrops) {
        Entity entity = source.getAttacker();
        if (entity != ((MobEntity)(Object)this) && entity instanceof CreeperEntity creeperEntity) {
            if (creeperEntity.shouldDropHead()) {
                creeperEntity.onHeadDropped();
                ((MobEntity)(Object)this).dropItem(HeadedItems.VILLAGER_HEAD);
            }
        }
    }
}
