package net.pedroricardo.headed.client.render.block.entity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationPropertyHelper;
import net.pedroricardo.headed.block.AbstractHeadedSkullBlock;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.block.HeadedSkullBlock.Type;
import net.pedroricardo.headed.block.HeadedWallSkullBlock;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import net.pedroricardo.headed.client.render.entity.model.*;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class HeadedSkullBlockEntityRenderer implements BlockEntityRenderer<HeadedSkullBlockEntity> {
    private final Map<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> MODELS;

    private static final Map<HeadedSkullBlock.SkullType, Identifier> TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        map.put(Type.VILLAGER, new Identifier("textures/entity/villager/villager.png"));
        map.put(Type.EVOKER, new Identifier("textures/entity/illager/evoker.png"));
        map.put(Type.VINDICATOR, new Identifier("textures/entity/illager/vindicator.png"));
        map.put(Type.PILLAGER, new Identifier("textures/entity/illager/pillager.png"));
        map.put(Type.ZOMBIE_VILLAGER, new Identifier("textures/entity/zombie_villager/zombie_villager.png"));
        map.put(Type.ILLUSIONER, new Identifier("textures/entity/illager/illusioner.png"));
        map.put(Type.SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.WHITE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.ORANGE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.MAGENTA_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.LIGHT_BLUE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.YELLOW_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.LIME_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.PINK_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.GRAY_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.LIGHT_GRAY_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.CYAN_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.PURPLE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.BLUE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.BROWN_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.GREEN_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.RED_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.BLACK_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.ALLAY, new Identifier("textures/entity/allay/allay.png"));
        map.put(Type.VEX, new Identifier("textures/entity/illager/vex.png"));
        map.put(Type.PIGLIN_BRUTE, new Identifier("textures/entity/piglin/piglin_brute.png"));
        map.put(Type.ZOMBIFIED_PIGLIN, new Identifier("textures/entity/piglin/zombified_piglin.png"));
        map.put(Type.LEUCISTIC_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_lucy.png"));
        map.put(Type.BROWN_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_wild.png"));
        map.put(Type.CYAN_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_cyan.png"));
        map.put(Type.GOLD_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_gold.png"));
        map.put(Type.BLUE_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_blue.png"));
    });

    public static Map<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> getModels(EntityModelLoader modelLoader) {
        ImmutableMap.Builder<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.put(Type.VILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.VILLAGER_HEAD)));
        builder.put(Type.EVOKER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.EVOKER_HEAD)));
        builder.put(Type.VINDICATOR, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.VINDICATOR_HEAD)));
        builder.put(Type.PILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PILLAGER_HEAD)));
        builder.put(Type.ZOMBIE_VILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ZOMBIE_VILLAGER_HEAD)));
        builder.put(Type.ILLUSIONER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ILLUSIONER_HEAD)));
        builder.put(Type.SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.WHITE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.ORANGE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.MAGENTA_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.LIGHT_BLUE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.YELLOW_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.LIME_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.PINK_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.GRAY_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.LIGHT_GRAY_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.CYAN_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.PURPLE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.BLUE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.BROWN_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.GREEN_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.RED_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.BLACK_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.ALLAY, new AllayHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ALLAY_HEAD)));
        builder.put(Type.VEX, new AllayHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.VEX_HEAD)));
        builder.put(Type.PIGLIN_BRUTE, new HeadedPiglinHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PIGLIN_BRUTE_HEAD)));
        builder.put(Type.ZOMBIFIED_PIGLIN, new HeadedPiglinHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ZOMBIFIED_PIGLIN_HEAD)));
        builder.put(Type.LEUCISTIC_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        builder.put(Type.BROWN_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        builder.put(Type.CYAN_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        builder.put(Type.GOLD_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        builder.put(Type.BLUE_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        return builder.build();
    }

    private static final Map<HeadedSkullBlock.SkullType, float[]> HEAD_DIRECTION_DISLOCATION = Util.make(Maps.newHashMap(), (map) -> {
        map.put(Type.VILLAGER, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.EVOKER, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.VINDICATOR, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.PILLAGER, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.ZOMBIE_VILLAGER, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.ILLUSIONER, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.WHITE_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.ORANGE_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.MAGENTA_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.LIGHT_BLUE_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.YELLOW_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.LIME_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.PINK_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.GRAY_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.LIGHT_GRAY_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.CYAN_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.PURPLE_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.BLUE_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.BROWN_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.GREEN_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.RED_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.BLACK_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.ALLAY, new float[]{0.34375F, 0.34375F, 0.34375F});
        map.put(Type.VEX, new float[]{0.34375F, 0.34375F, 0.34375F});
        map.put(Type.PIGLIN_BRUTE, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.ZOMBIFIED_PIGLIN, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.LEUCISTIC_AXOLOTL, new float[]{0.34375F, 0.34375F, 0.34375F});
        map.put(Type.BROWN_AXOLOTL, new float[]{0.34375F, 0.34375F, 0.34375F});
        map.put(Type.CYAN_AXOLOTL, new float[]{0.34375F, 0.34375F, 0.34375F});
        map.put(Type.GOLD_AXOLOTL, new float[]{0.34375F, 0.34375F, 0.34375F});
        map.put(Type.BLUE_AXOLOTL, new float[]{0.34375F, 0.34375F, 0.34375F});
    });

    public static Map<String, HeadedSkullBlockEntityModel> getOtherModels(EntityModelLoader modelLoader) {
        ImmutableMap.Builder<String, HeadedSkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.put("sheep_wool", new SheepHeadWoolEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_WOOL)));
        return builder.build();
    }

    private static final Map<String, Identifier> OTHER_TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        map.put("sheep_wool", new Identifier("textures/entity/sheep/sheep_fur.png"));
    });

    public HeadedSkullBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.MODELS = getModels(ctx.getLayerRenderDispatcher());
    }

    public boolean rendersOutsideBoundingBox(HeadedSkullBlockEntity skullBlockEntity) {
        return true;
    }

    public static void renderSkull(HeadedSkullBlock.SkullType skullType, @Nullable Direction direction, float yaw, float animationProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, HeadedSkullBlockEntityModel model, RenderLayer renderLayer, float r, float g, float b) {
        matrices.push();
        if (direction == null) {
            matrices.translate(0.5F, 0.0F, 0.5F);
        } else {
            float dislocationX = HEAD_DIRECTION_DISLOCATION.get(skullType)[0];
            float dislocationY = HEAD_DIRECTION_DISLOCATION.get(skullType)[1];
            float dislocationZ = HEAD_DIRECTION_DISLOCATION.get(skullType)[2];
            matrices.translate(0.5F - (float)direction.getOffsetX() * dislocationX, dislocationY, 0.5F - (float)direction.getOffsetZ() * dislocationZ);
        }

        matrices.scale(-1.0F, -1.0F, 1.0F);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);
        model.setHeadRotation(animationProgress, yaw, 0.0F);
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, r, g, b, 1.0F);
        matrices.pop();
    }

    public static RenderLayer getRenderLayer(HeadedSkullBlock.SkullType type, @Nullable GameProfile profile) {
        Identifier identifier = TEXTURES.get(type);
        return RenderLayer.getEntityCutoutNoCullZOffset(identifier);
    }
    public static RenderLayer getOtherRenderLayer(String type) {
        Identifier identifier = OTHER_TEXTURES.get(type);
        return RenderLayer.getEntityCutoutNoCullZOffset(identifier);
    }

    @Override
    public void render(HeadedSkullBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        float g = entity.getPoweredTicks(tickDelta);
        BlockState blockState = entity.getCachedState();
        boolean bl = blockState.getBlock() instanceof HeadedWallSkullBlock;
        Direction direction = bl ? blockState.get(HeadedWallSkullBlock.FACING) : null;
        int k = bl ? RotationPropertyHelper.fromDirection(direction) : blockState.get(HeadedSkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);
        HeadedSkullBlock.SkullType skullType = ((AbstractHeadedSkullBlock)blockState.getBlock()).getSkullType();
        HeadedSkullBlockEntityModel skullBlockEntityModel = this.MODELS.get(skullType);
        RenderLayer renderLayer = getRenderLayer(skullType, entity.getOwner());
        renderSkull(skullType, direction, h, g, matrices, vertexConsumers, light, skullBlockEntityModel, renderLayer, 1.0F, 1.0F, 1.0F);
        testForSpecialSkull(skullType, direction, h, g, matrices, vertexConsumers, light);
    }

    public static void testForSpecialSkull(HeadedSkullBlock.SkullType skullType, @Nullable Direction direction, float yaw, float deltaTime, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (skullType == HeadedSkullBlock.Type.WHITE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.WHITE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.ORANGE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.ORANGE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.MAGENTA_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.MAGENTA);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.LIGHT_BLUE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.LIGHT_BLUE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.YELLOW_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.YELLOW);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.LIME_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.LIME);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.PINK_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.PINK);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.GRAY_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.GRAY);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.LIGHT_GRAY_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.LIGHT_GRAY);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.CYAN_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.CYAN);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.PURPLE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.PURPLE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.BLUE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.BLUE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.BROWN_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.BROWN);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.GREEN_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.GREEN);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.RED_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.RED);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == HeadedSkullBlock.Type.BLACK_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.BLACK);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        }
    }
}