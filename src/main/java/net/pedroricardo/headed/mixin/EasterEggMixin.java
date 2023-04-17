package net.pedroricardo.headed.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.pedroricardo.headed.item.HeadedItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class EasterEggMixin<T extends LivingEntity, M extends EntityModel<T>> {
    @Inject(method = "render*", at = @At("HEAD"))
    private void render(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            ItemStack headStack = player.getEquippedStack(EquipmentSlot.HEAD);
            if (headStack.getItem() == HeadedItems.VILLAGER_HEAD && player.getUuidAsString().equals("7bb71eb9-b55e-4071-9175-8ec2f42ddd79")) {
                matrixStack.push();
                matrixStack.scale(1.25f, 0.5f, 1.25f);
            }
        }
    }

    @Inject(method = "render*", at = @At("RETURN"))
    private void postRender(T livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo ci) {
        if (livingEntity instanceof PlayerEntity player) {
            ItemStack headStack = player.getEquippedStack(EquipmentSlot.HEAD);
            if (headStack.getItem() == HeadedItems.VILLAGER_HEAD && player.getUuidAsString().equals("7bb71eb9-b55e-4071-9175-8ec2f42ddd79")) {
                matrixStack.pop();
            }
        }
    }
}

