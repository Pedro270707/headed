package net.pedroricardo.headed.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.pedroricardo.headed.loottable.HeadedLootTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public class HeadDropMixin {
    @Inject(at = @At("HEAD"), method = "dropEquipment")
    private void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops, CallbackInfo info) {
        Entity entity = source.getAttacker();
        if (entity != ((MobEntity)(Object)this) && entity instanceof CreeperEntity creeperEntity) {
            if (creeperEntity.shouldDropHead()) {
                creeperEntity.onHeadDropped();
                ((MobEntity)(Object)this).dropItem(HeadedLootTable.getHead((MobEntity)(Object)this));
            }
        }
    }
}