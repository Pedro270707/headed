package net.pedroricardo.headed.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.pedroricardo.headed.block.AbstractHeadedSkullBlock;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityRenderer;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class HeadedHeadFeatureRenderer<T extends LivingEntity, M extends EntityModel<T> & ModelWithHead> extends FeatureRenderer<T, M> {
    private final float scaleX;
    private final float scaleY;
    private final float scaleZ;
    private final Map<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> headModels;

    public HeadedHeadFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        this(context, loader, 1.0F, 1.0F, 1.0F);
    }

    public HeadedHeadFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader, float scaleX, float scaleY, float scaleZ) {
        super(context);
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
        this.headModels = HeadedSkullBlockEntityRenderer.getModels(loader);
    }

    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.HEAD);
        if (!itemStack.isEmpty()) {
            Item item = itemStack.getItem();
            matrixStack.push();
            matrixStack.scale(this.scaleX, this.scaleY, this.scaleZ);
            boolean bl = livingEntity instanceof VillagerEntity || livingEntity instanceof ZombieVillagerEntity;
            float m;
            if (livingEntity.isBaby() && !(livingEntity instanceof VillagerEntity)) {
                m = 2.0F;
                float n = 1.4F;
                matrixStack.translate(0.0F, 0.03125F, 0.0F);
                matrixStack.scale(0.7F, 0.7F, 0.7F);
                matrixStack.translate(0.0F, 1.0F, 0.0F);
            }

            (this.getContextModel()).getHead().rotate(matrixStack);
            if (item instanceof BlockItem && ((BlockItem)item).getBlock() instanceof AbstractHeadedSkullBlock) {
                m = 1.1875F;
                matrixStack.scale(1.1875F, -1.1875F, -1.1875F);
                if (bl) {
                    matrixStack.translate(0.0F, 0.0625F, 0.0F);
                }

                matrixStack.translate(-0.5, 0.0, -0.5);
                HeadedSkullBlock.SkullType skullType = ((AbstractHeadedSkullBlock)((BlockItem)item).getBlock()).getSkullType();
                HeadedSkullBlockEntityModel skullBlockEntityModel = this.headModels.get(skullType);
                RenderLayer renderLayer = HeadedSkullBlockEntityRenderer.getRenderLayer(skullType);
                if (itemStack.hasNbt()) {
                    if (itemStack.getOrCreateSubNbt("BlockEntityTag").getBoolean(HeadedSkullBlockEntity.IS_TAMED_KEY) && skullType == HeadedSkullBlock.Type.WOLF) {
                        renderLayer = RenderLayer.getEntityCutoutNoCullZOffset(new Identifier("textures/entity/wolf/wolf_tame.png"));
                    } else if (itemStack.getName().getString().equals("Toast") && HeadedSkullBlock.RABBIT_TYPES.contains(skullType)) {
                        renderLayer = RenderLayer.getEntityCutoutNoCullZOffset(new Identifier("textures/entity/rabbit/toast.png"));
                    }
                }
                HeadedSkullBlockEntityRenderer.renderSkull(skullType, null, 180.0F, f, matrixStack, vertexConsumerProvider, i, skullBlockEntityModel, renderLayer, 1.0F, 1.0F, 1.0F);
                HeadedSkullBlockEntityRenderer.testForSkullFeature(skullType, null, 180.0F, f, matrixStack, vertexConsumerProvider, i, itemStack.getName());
            }

            matrixStack.pop();
        }
    }

    public static void translate(MatrixStack matrices, boolean villager) {
        float f = 0.625F;
        matrices.translate(0.0F, -0.25F, 0.0F);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
        matrices.scale(0.625F, -0.625F, -0.625F);
        if (villager) {
            matrices.translate(0.0F, 0.1875F, 0.0F);
        }

    }
}