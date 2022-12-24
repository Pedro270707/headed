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
import net.pedroricardo.headed.block.AbstractModSkullBlock;
import net.pedroricardo.headed.block.ModSkullBlock;
import net.pedroricardo.headed.block.ModSkullBlock.Type;
import net.pedroricardo.headed.block.ModWallSkullBlock;
import net.pedroricardo.headed.block.entity.ModSkullBlockEntity;
import net.pedroricardo.headed.client.render.entity.model.*;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class ModSkullBlockEntityRenderer implements BlockEntityRenderer<ModSkullBlockEntity> {
    private final Map<ModSkullBlock.SkullType, ModSkullBlockEntityModel> MODELS;
    private final Map<String, ModSkullBlockEntityModel> OTHER_MODELS;
    private static final Map<ModSkullBlock.SkullType, Identifier> TEXTURES = (Map)Util.make(Maps.newHashMap(), (map) -> {
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
        map.put(Type.WHITE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(Type.ALLAY, new Identifier("textures/entity/allay/allay.png"));
        map.put(Type.VEX, new Identifier("textures/entity/illager/vex.png"));
        map.put(Type.PIGLIN_BRUTE, new Identifier("textures/entity/piglin/piglin_brute.png"));
        map.put(Type.ZOMBIFIED_PIGLIN, new Identifier("textures/entity/piglin/zombified_piglin.png"));
    });

    public static Map<ModSkullBlock.SkullType, ModSkullBlockEntityModel> getModels(EntityModelLoader modelLoader) {
        ImmutableMap.Builder<ModSkullBlock.SkullType, ModSkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.put(Type.VILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.VILLAGER_HEAD)));
        builder.put(Type.EVOKER, new VillagerHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.EVOKER_HEAD)));
        builder.put(Type.VINDICATOR, new VillagerHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.VINDICATOR_HEAD)));
        builder.put(Type.PILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.PILLAGER_HEAD)));
        builder.put(Type.ZOMBIE_VILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.ZOMBIE_VILLAGER_HEAD)));
        builder.put(Type.ILLUSIONER, new VillagerHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.ILLUSIONER_HEAD)));
        builder.put(Type.SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.WHITE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.ORANGE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.MAGENTA_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.LIGHT_BLUE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.YELLOW_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.LIME_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.PINK_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.GRAY_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.LIGHT_GRAY_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.CYAN_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.PURPLE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.BLUE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.BROWN_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.GREEN_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.RED_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.BLACK_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_HEAD)));
        builder.put(Type.ALLAY, new AllayHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.ALLAY_HEAD)));
        builder.put(Type.VEX, new AllayHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.VEX_HEAD)));
        builder.put(Type.PIGLIN_BRUTE, new ModPiglinHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.PIGLIN_BRUTE_HEAD)));
        builder.put(Type.ZOMBIFIED_PIGLIN, new ModPiglinHeadEntityModel(modelLoader.getModelPart(ModEntityModelLayers.ZOMBIFIED_PIGLIN_HEAD)));
        return builder.build();
    }

    private static final Map<ModSkullBlock.SkullType, float[]> HEAD_DIRECTION_DISLOCATION = (Map)Util.make(Maps.newHashMap(), (map) -> {
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
        map.put(Type.WHITE_SHEEP, new float[]{0.25F, 0.3125F, 0.25F});
        map.put(Type.ALLAY, new float[]{0.34375F, 0.34375F, 0.34375F});
        map.put(Type.VEX, new float[]{0.34375F, 0.34375F, 0.34375F});
        map.put(Type.PIGLIN_BRUTE, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.ZOMBIFIED_PIGLIN, new float[]{0.25F, 0.25F, 0.25F});
    });

    public static Map<String, ModSkullBlockEntityModel> getOtherModels(EntityModelLoader modelLoader) {
        ImmutableMap.Builder<String, ModSkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.put("sheep_wool", new SheepHeadWoolEntityModel(modelLoader.getModelPart(ModEntityModelLayers.SHEEP_WOOL)));
        return builder.build();
    }

    private static final Map<ModSkullBlock.SkullType, Identifier> OTHER_TEXTURES = (Map)Util.make(Maps.newHashMap(), (map) -> {
        map.put("sheep_wool", new Identifier("textures/entity/sheep/sheep_fur.png"));
    });

    public ModSkullBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.MODELS = getModels(ctx.getLayerRenderDispatcher());
        this.OTHER_MODELS = getOtherModels(ctx.getLayerRenderDispatcher());
    }

    public boolean rendersOutsideBoundingBox(ModSkullBlockEntity skullBlockEntity) {
        return true;
    }

    public static void renderSkull(ModSkullBlock.SkullType skullType, @Nullable Direction direction, float yaw, float animationProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ModSkullBlockEntityModel model, RenderLayer renderLayer, float r, float g, float b) {
        matrices.push();
        if (direction == null) {
            matrices.translate(0.5F, 0.0F, 0.5F);
        } else {
            float f = 0.25F;
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

    public static RenderLayer getRenderLayer(ModSkullBlock.SkullType type, @Nullable GameProfile profile) {
        Identifier identifier = (Identifier)TEXTURES.get(type);
        return RenderLayer.getEntityCutoutNoCullZOffset(identifier);
    }
    public static RenderLayer getOtherRenderLayer(String type) {
        Identifier identifier = (Identifier)OTHER_TEXTURES.get(type);
        return RenderLayer.getEntityCutoutNoCullZOffset(identifier);
    }

    public static float[] getHeadDirectionDislocation(String type) {
        float[] array = HEAD_DIRECTION_DISLOCATION.get(type);
        return array;
    }

    @Override
    public void render(ModSkullBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        float g = entity.getPoweredTicks(tickDelta);
        BlockState blockState = entity.getCachedState();
        boolean bl = blockState.getBlock() instanceof ModWallSkullBlock;
        Direction direction = bl ? (Direction)blockState.get(ModWallSkullBlock.FACING) : null;
        int k = bl ? RotationPropertyHelper.fromDirection(direction) : (Integer)blockState.get(ModSkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);
        ModSkullBlock.SkullType skullType = ((AbstractModSkullBlock)blockState.getBlock()).getSkullType();
        ModSkullBlockEntityModel skullBlockEntityModel = (ModSkullBlockEntityModel)this.MODELS.get(skullType);
        RenderLayer renderLayer = getRenderLayer(skullType, entity.getOwner());
        renderSkull(skullType, direction, h, g, matrices, vertexConsumers, light, skullBlockEntityModel, renderLayer, 1.0F, 1.0F, 1.0F);
        testForSpecialSkull(skullType, direction, h, g, matrices, vertexConsumers, light);
    }

    public static void testForSpecialSkull(ModSkullBlock.SkullType skullType, @Nullable Direction direction, float yaw, float deltaTime, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (skullType == ModSkullBlock.Type.WHITE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.WHITE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.ORANGE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.ORANGE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.MAGENTA_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.MAGENTA);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.LIGHT_BLUE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.LIGHT_BLUE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.YELLOW_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.YELLOW);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.LIME_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.LIME);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.PINK_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.PINK);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.GRAY_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.GRAY);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.LIGHT_GRAY_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.LIGHT_GRAY);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.CYAN_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.CYAN);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.PURPLE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.PURPLE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.BLUE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.BLUE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.BROWN_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.BROWN);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.GREEN_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.GREEN);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.RED_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.RED);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == ModSkullBlock.Type.BLACK_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.BLACK);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = ModSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            ModSkullBlockEntityModel woolModel = ModSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            ModSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        }
    }
}