package net.pedroricardo.headed.client.render.item;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.pedroricardo.headed.block.AbstractHeadedSkullBlock;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityRenderer;

public class HeadedSkullItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    @Override
    public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Item item = stack.getItem();
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            if (block instanceof AbstractHeadedSkullBlock) {
                HeadedSkullBlock.SkullType skullType = ((AbstractHeadedSkullBlock) block).getSkullType();
                HeadedSkullBlockEntityModel skullModel = HeadedSkullBlockEntityRenderer.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(skullType);
                RenderLayer renderLayer = HeadedSkullBlockEntityRenderer.getRenderLayer(skullType);

                boolean hasLeftHorn = false;
                boolean hasRightHorn = false;
                if (stack.hasNbt()) {
                    NbtCompound nbtCompound = stack.getNbt();
                    if (nbtCompound.contains("HasLeftHorn", 10)) {
                        hasLeftHorn = nbtCompound.getBoolean("HasLeftHorn");
                    }
                    if (nbtCompound.contains("HasRightHorn", 10)) {
                        hasRightHorn = nbtCompound.getBoolean("HasRightHorn");
                    }
                }

                if (mode == ModelTransformation.Mode.GUI) {
                    HeadedSkullBlockEntityRenderer.renderSkull(skullType, null, 180.0F, 0, matrices, vertexConsumers, light, skullModel, renderLayer, 1.0F, 1.0F, 1.0F);
                    HeadedSkullBlockEntityRenderer.testForSkullFeature(skullType, null, 180.0F, 0, matrices, vertexConsumers, light, hasLeftHorn, hasRightHorn);
//                    Headed.LOGGER.debug("HeadedSkullItemRenderer GUI: " + hasLeftHorn + " " + hasRightHorn);
                    matrices.pop();
                } else if (mode != ModelTransformation.Mode.HEAD) {
                    HeadedSkullBlockEntityRenderer.renderSkull(skullType, null, 180.0F, 0, matrices, vertexConsumers, light, skullModel, renderLayer, 1.0F, 1.0F, 1.0F);
                    HeadedSkullBlockEntityRenderer.testForSkullFeature(skullType, null, 180.0F, 0, matrices, vertexConsumers, light, hasLeftHorn, hasRightHorn);
//                    Headed.LOGGER.debug("HeadedSkullItemRenderer HEAD: " + hasLeftHorn + " " + hasRightHorn);
                }
            }
        }
    }
}
