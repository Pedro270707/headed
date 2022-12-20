package net.pedroricardo.headed.client.render.block.entity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationPropertyHelper;
import net.pedroricardo.headed.Headed;
import net.pedroricardo.headed.block.AbstractModSkullBlock;
import net.pedroricardo.headed.block.ModSkullBlock;
import net.pedroricardo.headed.block.ModWallSkullBlock;
import net.pedroricardo.headed.block.entity.ModSkullBlockEntity;
import net.pedroricardo.headed.client.render.entity.model.ModEntityModelLayers;
import net.pedroricardo.headed.client.render.entity.model.VillagerHeadEntityModel;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class ModSkullBlockEntityRenderer implements BlockEntityRenderer<ModSkullBlockEntity> {
    private final Map<ModSkullBlock.SkullType, ModSkullBlockEntityModel> MODELS;
    private static final Map<ModSkullBlock.SkullType, Identifier> TEXTURES = (Map)Util.make(Maps.newHashMap(), (map) -> {
        map.put(ModSkullBlock.Type.VILLAGER, new Identifier("textures/entity/villager/villager.png"));
    });

    public static Map<ModSkullBlock.SkullType, ModSkullBlockEntityModel> getModels(EntityModelLoader modelLoader) {
        ImmutableMap.Builder<ModSkullBlock.SkullType, ModSkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.put(ModSkullBlock.Type.VILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.VILLAGER_HEAD)));
        return builder.build();
    }

    public ModSkullBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.MODELS = getModels(ctx.getLayerRenderDispatcher());
    }

    @Override
    public void render(ModSkullBlockEntity skullBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        float g = skullBlockEntity.getPoweredTicks(f);
        BlockState blockState = skullBlockEntity.getCachedState();
        boolean bl = blockState.getBlock() instanceof ModWallSkullBlock;
        Direction direction = bl ? (Direction)blockState.get(ModWallSkullBlock.FACING) : null;
        int k = bl ? RotationPropertyHelper.fromDirection(direction) : (Integer)blockState.get(ModSkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);
        ModSkullBlock.SkullType skullType = ((AbstractModSkullBlock)blockState.getBlock()).getSkullType();
        ModSkullBlockEntityModel skullBlockEntityModel = (ModSkullBlockEntityModel)this.MODELS.get(skullType);
        RenderLayer renderLayer = getRenderLayer(skullType, skullBlockEntity.getOwner());
        renderSkull(direction, h, g, matrixStack, vertexConsumerProvider, i, skullBlockEntityModel, renderLayer);
        Headed.LOGGER.debug("Rendering skull");
    }

    public static void renderSkull(@Nullable Direction direction, float yaw, float animationProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ModSkullBlockEntityModel model, RenderLayer renderLayer) {
        matrices.push();
        if (direction == null) {
            matrices.translate(0.5F, 0.0F, 0.5F);
        } else {
            float f = 0.25F;
            matrices.translate(0.5F - (float)direction.getOffsetX() * 0.25F, 0.25F, 0.5F - (float)direction.getOffsetZ() * 0.25F);
        }

        matrices.scale(-1.0F, -1.0F, 1.0F);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);
        model.setHeadRotation(animationProgress, yaw, 0.0F);
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }

    public static RenderLayer getRenderLayer(ModSkullBlock.SkullType type, @Nullable GameProfile profile) {
        Identifier identifier = (Identifier)TEXTURES.get(type);
        return RenderLayer.getEntityCutoutNoCullZOffset(identifier);
    }
}