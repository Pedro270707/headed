package net.pedroricardo.headed.client.render.block.entity.feature;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullRenderManager;
import net.pedroricardo.headed.client.render.entity.model.HeadedEntityModelLayers;
import net.pedroricardo.headed.client.render.entity.model.StraySkullEntityModel;
import org.jetbrains.annotations.Nullable;

public class HeadedStrayHeadOuterLayerFeatureRenderer implements HeadedSkullFeatureRenderer {
    @Override
    public void renderFeature(HeadedSkullBlock.Type skullType, @Nullable Direction direction, float yaw, float deltaTime, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, HeadedSkullBlockEntity blockEntity, ItemStack itemStack) {
        RenderLayer renderLayer = RenderLayer.getEntityCutoutNoCullZOffset(new Identifier("textures/entity/skeleton/stray_overlay.png"));
        HeadedSkullBlockEntityModel model = new StraySkullEntityModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(HeadedEntityModelLayers.STRAY_SKULL_OUTER_LAYER));

        HeadedSkullRenderManager.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, model, renderLayer, 1.0F, 1.0F, 1.0F);
    }
}
