package net.pedroricardo.headed.client.render.item;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.pedroricardo.headed.Headed;
import net.pedroricardo.headed.block.AbstractModSkullBlock;
import net.pedroricardo.headed.block.ModSkullBlock;
import net.pedroricardo.headed.client.render.block.entity.ModSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.block.entity.ModSkullBlockEntityRenderer;
import org.joml.Vector3f;

public class ModSkullItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    @Override
    public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Item item = stack.getItem();
        if (item instanceof BlockItem blockItem) {
            Block block = blockItem.getBlock();
            if (block instanceof AbstractModSkullBlock modSkullBlock) {
                ModSkullBlock.SkullType skullType = ((AbstractModSkullBlock) block).getSkullType();
                ModSkullBlockEntityModel skullModel = ModSkullBlockEntityRenderer.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(skullType);
                RenderLayer renderLayer = ModSkullBlockEntityRenderer.getRenderLayer(skullType, null);

                if (mode == ModelTransformation.Mode.GUI) {
                    ModelIdentifier back = new ModelIdentifier(new Identifier(Headed.MOD_ID, "skull"), "inventory");
                    BakedModel modelBack = MinecraftClient.getInstance().getBakedModelManager().getModel(back);
                    //RenderSystem.setupGuiFlatDiffuseLighting((Vector3f)Util.make(new Vector3f(0.2F, 1.0F, -0.7F), Vector3f::normalize), (Vector3f)Util.make(new Vector3f(-0.2F, 1.0F, 0.7F), Vector3f::normalize));
                    //BufferBuilder bufferSource = MinecraftClient.getInstance().renderBuffers().bufferSource();
                    //ms.pushPose();
                    //Lighting.setupForFlatItems();
                    //ms.translate(0.5F, 0.5F, -1.5F);
                    //modelBack.getTransforms().getTransform(camera).apply(false, ms); // applyTransform
                    ModSkullBlockEntityRenderer.renderSkull(null, 180.0F, MinecraftClient.getInstance().getTickDelta(), matrices, vertexConsumers, light, skullModel, renderLayer);
                    matrices.pop();
                } else {
                    ModSkullBlockEntityRenderer.renderSkull(null, 180.0F, MinecraftClient.getInstance().getTickDelta(), matrices, vertexConsumers, light, skullModel, renderLayer);
                }
            }
        }
    }
}
