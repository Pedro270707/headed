package net.pedroricardo.headed.client.render.block.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationPropertyHelper;
import net.pedroricardo.headed.block.AbstractHeadedSkullBlock;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.block.HeadedSkullBlock.Type;
import net.pedroricardo.headed.block.HeadedWallSkullBlock;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;

@Environment(EnvType.CLIENT)
public class HeadedSkullBlockEntityRenderer implements BlockEntityRenderer<HeadedSkullBlockEntity> {

    public HeadedSkullBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        HeadedSkullRenderManager.getInstance().setContext(ctx);
    }

    public boolean rendersOutsideBoundingBox(HeadedSkullBlockEntity skullBlockEntity) {
        return true;
    }

    @Override
    public void render(HeadedSkullBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        float g = blockEntity.getPoweredTicks(tickDelta);
        BlockState blockState = blockEntity.getCachedState();
        boolean bl = blockState.getBlock() instanceof HeadedWallSkullBlock;
        Direction direction = bl ? blockState.get(HeadedWallSkullBlock.FACING) : null;
        int k = bl ? RotationPropertyHelper.fromDirection(direction) : blockState.get(HeadedSkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);
        HeadedSkullBlock.SkullType skullType = ((AbstractHeadedSkullBlock)blockState.getBlock()).getSkullType();
        HeadedSkullBlockEntityModel skullBlockEntityModel = HeadedSkullRenderManager.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(skullType);
        RenderLayer renderLayer = HeadedSkullRenderManager.getInstance().getRenderLayer(blockEntity, null, skullType);
        if (skullType == Type.FOX && !bl || skullType == Type.SNOW_FOX && !bl) {
            HeadedSkullRenderManager.renderSkullWithFeature(skullType, null, h - g * 5.0F, g, matrices, vertexConsumers, light, skullBlockEntityModel, renderLayer, 1.0F, 1.0F, 1.0F, blockEntity, null);
        } else {
            HeadedSkullRenderManager.renderSkullWithFeature(skullType, direction, h, g, matrices, vertexConsumers, light, skullBlockEntityModel, renderLayer, 1.0F, 1.0F, 1.0F, blockEntity, null);
        }
    }
}