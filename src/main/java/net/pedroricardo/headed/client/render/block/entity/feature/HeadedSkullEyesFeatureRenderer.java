package net.pedroricardo.headed.client.render.block.entity.feature;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullRenderManager;
import org.jetbrains.annotations.Nullable;

public abstract class HeadedSkullEyesFeatureRenderer implements HeadedSkullFeatureRenderer {
    @Override
    public void renderFeature(HeadedSkullBlock.Type skullType, @Nullable Direction direction, float yaw, float deltaTime, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, HeadedSkullBlockEntity blockEntity, ItemStack itemStack) {
        RenderLayer renderLayer = this.getEyesTexture();
        HeadedSkullBlockEntityModel model = this.getModel();

        HeadedSkullRenderManager.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, 15728640, model, renderLayer, 1.0F, 1.0F, 1.0F);
    }

    public abstract RenderLayer getEyesTexture();
    public abstract HeadedSkullBlockEntityModel getModel();
}
