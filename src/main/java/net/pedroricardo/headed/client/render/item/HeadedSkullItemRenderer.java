package net.pedroricardo.headed.client.render.item;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.pedroricardo.headed.block.AbstractHeadedSkullBlock;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullRenderManager;

public class HeadedSkullItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    @Override
    public void render(ItemStack itemStack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Item item = itemStack.getItem();
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            if (block instanceof AbstractHeadedSkullBlock) {
                HeadedSkullBlock.SkullType skullType = ((AbstractHeadedSkullBlock) block).getSkullType();
                HeadedSkullBlockEntityModel skullModel = HeadedSkullRenderManager.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(skullType);
                RenderLayer renderLayer = HeadedSkullRenderManager.getInstance().getRenderLayer(null, itemStack, skullType);

                if (mode == ModelTransformationMode.GUI) {
                    HeadedSkullRenderManager.renderSkullWithFeature(skullType, null, 180.0F, 0, matrices, vertexConsumers, light, skullModel, renderLayer, 1.0F, 1.0F, 1.0F, null, itemStack);
                    matrices.pop();
                } else if (mode != ModelTransformationMode.HEAD) {
                    HeadedSkullRenderManager.renderSkullWithFeature(skullType, null, 180.0F, 0, matrices, vertexConsumers, light, skullModel, renderLayer, 1.0F, 1.0F, 1.0F, null, itemStack);
                }
            }
        }
    }
}
