package net.pedroricardo.headed.client.render.block.entity.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullRenderManager;
import org.jetbrains.annotations.Nullable;

public class HeadedMooshroomHeadMushroomFeatureRenderer implements HeadedSkullFeatureRenderer {
    @Override
    public void renderFeature(HeadedSkullBlock.Type skullType, @Nullable Direction direction, float yaw, float deltaTime, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, HeadedSkullBlockEntity blockEntity, ItemStack itemStack) {
        BlockState blockState = skullType == HeadedSkullBlock.Type.RED_MOOSHROOM ? Blocks.RED_MUSHROOM.getDefaultState() : Blocks.BROWN_MUSHROOM.getDefaultState();
        if (direction == null) {
            matrices.translate(0.5F, 0.0F, 0.5F);
            matrices.translate(Math.sqrt(0.5)*-Math.cos((yaw+45) * 0.0174532F), 0.0F, Math.sqrt(0.5)*-Math.sin((yaw+45) * 0.0174532F));
            matrices.multiply(Vec3f.NEGATIVE_Y.getDegreesQuaternion(yaw));
        } else {
            float dislocationX = HeadedSkullRenderManager.getHeadDirectionDislocation(skullType)[0];
            float dislocationY = HeadedSkullRenderManager.getHeadDirectionDislocation(skullType)[1];
            float dislocationZ = HeadedSkullRenderManager.getHeadDirectionDislocation(skullType)[2];
            matrices.translate(- (float)direction.getOffsetX() * dislocationX, dislocationY, - (float)direction.getOffsetZ() * dislocationZ);
        }
        matrices.translate(0.0F, 0.45F, 0.0F);
        HeadedSkullRenderManager.BLOCK_RENDER_MANAGER.renderBlockAsEntity(blockState, matrices, vertexConsumers, light, OverlayTexture.DEFAULT_UV);
    }
}
