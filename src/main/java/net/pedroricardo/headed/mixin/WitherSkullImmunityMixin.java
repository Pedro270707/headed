package net.pedroricardo.headed.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.pedroricardo.headed.Headed;
import net.pedroricardo.headed.HeadedConfigModel;
import net.pedroricardo.headed.item.HeadedItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class WitherSkullImmunityMixin {
    @Inject(method = "canHaveStatusEffect", at = @At("HEAD"), cancellable = true)
    private void canHaveStatusEffect(StatusEffectInstance effect, CallbackInfoReturnable<Boolean> ci) {
        if (effect.getEffectType() == StatusEffects.WITHER && Headed.CONFIG.witherSkullGrantsWitherImmunity()) {
            LivingEntity entity = (LivingEntity) (Object) this;
            if (entity instanceof PlayerEntity player) {
                ItemStack headStack = player.getEquippedStack(EquipmentSlot.HEAD);
                if (headStack.getItem() == HeadedItems.WITHER_SKULL) {
                    ci.setReturnValue(false);
                }
            }
        }
    }
}