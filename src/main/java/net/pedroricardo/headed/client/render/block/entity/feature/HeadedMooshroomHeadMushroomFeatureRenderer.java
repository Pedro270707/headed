package net.pedroricardo.headed.client.render.block.entity.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullRenderManager;
import org.jetbrains.annotations.Nullable;

public class HeadedMooshroomHeadMushroomFeatureRenderer implements HeadedSkullFeatureRenderer {
    @Override
    public void renderFeature(HeadedSkullBlock.Type skullType, @Nullable Direction direction, float yaw, float deltaTime, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, HeadedSkullBlockEntity blockEntity, ItemStack itemStack) {
        BlockState blockState;
        float dislocationX;
        float dislocationY;
        if (skullType == HeadedSkullBlock.Type.RED_MOOSHROOM) {
            blockState = Blocks.RED_MUSHROOM.getDefaultState();
            dislocationX = (16 - HeadedSkullRenderManager.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(HeadedSkullBlock.Type.RED_MOOSHROOM).getHeadSizeInPixels()[2])/32;
            dislocationY = (16 - HeadedSkullRenderManager.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(HeadedSkullBlock.Type.RED_MOOSHROOM).getHeadSizeInPixels()[1])/32;
        } else {
            blockState = Blocks.BROWN_MUSHROOM.getDefaultState();
            dislocationX = (16 - HeadedSkullRenderManager.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(HeadedSkullBlock.Type.BROWN_MOOSHROOM).getHeadSizeInPixels()[2])/32;
            dislocationY = (16 - HeadedSkullRenderManager.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(HeadedSkullBlock.Type.BROWN_MOOSHROOM).getHeadSizeInPixels()[1])/32;
        }
        if (direction == null) {
            matrices.translate(0.5F, 0.0F, 0.5F);
            matrices.translate(MathHelper.sqrt(0.5F)*-MathHelper.cos((yaw+45.0F) * 0.0174532F), 0.0F, MathHelper.sqrt(0.5F)*-MathHelper.sin((yaw+45.0F) * 0.0174532F));
            matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(yaw));
        } else {
            matrices.translate(- (float)direction.getOffsetX() * dislocationX, dislocationY, - (float)direction.getOffsetZ() * dislocationX);
        }
        matrices.translate(0.0F, 0.45F, 0.0F);
        HeadedSkullRenderManager.BLOCK_RENDER_MANAGER.renderBlockAsEntity(blockState, matrices, vertexConsumers, light, OverlayTexture.DEFAULT_UV);
    }
}
