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
import net.pedroricardo.headed.block.AbstractModSkullBlock;
import net.pedroricardo.headed.block.ModSkullBlock;
import net.pedroricardo.headed.client.render.block.entity.ModSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.block.entity.ModSkullBlockEntityRenderer;

public class ModSkullItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    @Override
    public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Item item = stack.getItem();
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            if (block instanceof AbstractModSkullBlock) {
                ModSkullBlock.SkullType skullType = ((AbstractModSkullBlock) block).getSkullType();
                ModSkullBlockEntityModel skullModel = ModSkullBlockEntityRenderer.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(skullType);
                RenderLayer renderLayer = ModSkullBlockEntityRenderer.getRenderLayer(skullType, null);

                if (mode == ModelTransformation.Mode.GUI) {
                    ModSkullBlockEntityRenderer.renderSkull(skullType, null, 180.0F, 0, matrices, vertexConsumers, light, skullModel, renderLayer, 1.0F, 1.0F, 1.0F);
                    ModSkullBlockEntityRenderer.testForSpecialSkull(skullType, null, 180.0F, 0, matrices, vertexConsumers, light);
                    matrices.pop();
//                } else if (mode == ModelTransformation.Mode.HEAD) {
//                    matrices.translate(-0.375F, 0.0625F, -0.375F);
//                    matrices.scale(1.75F, 1.75F, 1.75F);
//                    ModSkullBlockEntityRenderer.renderSkull(skullType, null, 0.0F, 0, matrices, vertexConsumers, light, skullModel, renderLayer, 1.0F, 1.0F, 1.0F);
//                    ModSkullBlockEntityRenderer.testForSpecialSkull(skullType, null, 0.0F, 0, matrices, vertexConsumers, light);
                } else {
                    ModSkullBlockEntityRenderer.renderSkull(skullType, null, 180.0F, 0, matrices, vertexConsumers, light, skullModel, renderLayer, 1.0F, 1.0F, 1.0F);
                    ModSkullBlockEntityRenderer.testForSpecialSkull(skullType, null, 180.0F, 0, matrices, vertexConsumers, light);
                }
            }
        }
    }
}
