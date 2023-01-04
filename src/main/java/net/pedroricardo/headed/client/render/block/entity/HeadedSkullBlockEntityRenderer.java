package net.pedroricardo.headed.client.render.block.entity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
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
        map.put(Type.WANDERING_TRADER, new Identifier("textures/entity/wandering_trader.png"));
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
        map.put(Type.COW, new Identifier("textures/entity/cow/cow.png"));
        map.put(Type.BROWN_MOOSHROOM, new Identifier("textures/entity/cow/brown_mooshroom.png"));
        map.put(Type.RED_MOOSHROOM, new Identifier("textures/entity/cow/red_mooshroom.png"));
        map.put(Type.POLAR_BEAR, new Identifier("textures/entity/bear/polarbear.png"));
        map.put(Type.OCELOT, new Identifier("textures/entity/cat/ocelot.png"));
        map.put(Type.ALL_BLACK_CAT, new Identifier("textures/entity/cat/all_black.png"));
        map.put(Type.BLACK_CAT, new Identifier("textures/entity/cat/black.png"));
        map.put(Type.BRITISH_SHORTHAIR_CAT, new Identifier("textures/entity/cat/british_shorthair.png"));
        map.put(Type.CALICO_CAT, new Identifier("textures/entity/cat/calico.png"));
        map.put(Type.JELLIE_CAT, new Identifier("textures/entity/cat/jellie.png"));
        map.put(Type.PERSIAN_CAT, new Identifier("textures/entity/cat/persian.png"));
        map.put(Type.RAGDOLL_CAT, new Identifier("textures/entity/cat/ragdoll.png"));
        map.put(Type.RED_CAT, new Identifier("textures/entity/cat/red.png"));
        map.put(Type.SIAMESE_CAT, new Identifier("textures/entity/cat/siamese.png"));
        map.put(Type.TABBY_CAT, new Identifier("textures/entity/cat/tabby.png"));
        map.put(Type.WHITE_CAT, new Identifier("textures/entity/cat/white.png"));
        map.put(Type.ENDERMAN, new Identifier("textures/entity/enderman/enderman.png"));
        map.put(Type.FOX, new Identifier("textures/entity/fox/fox.png"));
        map.put(Type.SNOW_FOX, new Identifier("textures/entity/fox/snow_fox.png"));
        map.put(Type.IRON_GOLEM, new Identifier("textures/entity/iron_golem/iron_golem.png"));
        map.put(Type.AGGRESSIVE_PANDA, new Identifier("textures/entity/panda/aggressive_panda.png"));
        map.put(Type.BROWN_PANDA, new Identifier("textures/entity/panda/brown_panda.png"));
        map.put(Type.LAZY_PANDA, new Identifier("textures/entity/panda/lazy_panda.png"));
        map.put(Type.PANDA, new Identifier("textures/entity/panda/panda.png"));
        map.put(Type.PLAYFUL_PANDA, new Identifier("textures/entity/panda/playful_panda.png"));
        map.put(Type.WEAK_PANDA, new Identifier("textures/entity/panda/weak_panda.png"));
        map.put(Type.WORRIED_PANDA, new Identifier("textures/entity/panda/worried_panda.png"));
        map.put(Type.DROWNED, new Identifier("textures/entity/zombie/drowned.png"));
    });

    public static Map<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> getModels(EntityModelLoader modelLoader) {
        ImmutableMap.Builder<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.put(Type.VILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.VILLAGER_HEAD)));
        builder.put(Type.EVOKER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.EVOKER_HEAD)));
        builder.put(Type.VINDICATOR, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.VINDICATOR_HEAD)));
        builder.put(Type.PILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PILLAGER_HEAD)));
        builder.put(Type.ZOMBIE_VILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ZOMBIE_VILLAGER_HEAD)));
        builder.put(Type.WANDERING_TRADER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.WANDERING_TRADER_HEAD)));
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
        builder.put(Type.COW, new CowHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.COW_HEAD)));
        builder.put(Type.BROWN_MOOSHROOM, new CowHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.COW_HEAD)));
        builder.put(Type.RED_MOOSHROOM, new CowHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.COW_HEAD)));
        builder.put(Type.POLAR_BEAR, new PolarBearHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.POLAR_BEAR_HEAD)));
        builder.put(Type.OCELOT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.ALL_BLACK_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.BLACK_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.BRITISH_SHORTHAIR_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.CALICO_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.JELLIE_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.PERSIAN_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.RAGDOLL_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.RED_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.SIAMESE_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.TABBY_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.WHITE_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(Type.ENDERMAN, new EndermanHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ENDERMAN_HEAD)));
        builder.put(Type.FOX, new FoxHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.FOX_HEAD)));
        builder.put(Type.SNOW_FOX, new FoxHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.FOX_HEAD)));
        builder.put(Type.IRON_GOLEM, new IronGolemHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.IRON_GOLEM_HEAD)));
        builder.put(Type.AGGRESSIVE_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(Type.BROWN_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(Type.LAZY_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(Type.PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(Type.PLAYFUL_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(Type.WEAK_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(Type.WORRIED_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(Type.DROWNED, new GenericSkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.DROWNED_HEAD)));
        return builder.build();
    }

    private static final Map<HeadedSkullBlock.SkullType, float[]> HEAD_DIRECTION_DISLOCATION = Util.make(Maps.newHashMap(), (map) -> {
        map.put(Type.VILLAGER, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.EVOKER, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.VINDICATOR, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.PILLAGER, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.ZOMBIE_VILLAGER, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.WANDERING_TRADER, new float[]{0.25F, 0.25F, 0.25F});
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
        map.put(Type.COW, new float[]{0.3125F, 0.25F, 0.3125F});
        map.put(Type.BROWN_MOOSHROOM, new float[]{0.3125F, 0.25F, 0.3125F});
        map.put(Type.RED_MOOSHROOM, new float[]{0.3125F, 0.25F, 0.3125F});
        map.put(Type.POLAR_BEAR, new float[]{0.28125F, 0.28125F, 0.28125F});
        map.put(Type.OCELOT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.ALL_BLACK_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.BLACK_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.BRITISH_SHORTHAIR_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.CALICO_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.JELLIE_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.PERSIAN_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.RAGDOLL_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.RED_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.SIAMESE_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.TABBY_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.WHITE_CAT, new float[]{0.34375F, 0.375F, 0.34375F});
        map.put(Type.ENDERMAN, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.FOX, new float[]{0.3125F, 0.3125F, 0.3125F});
        map.put(Type.SNOW_FOX, new float[]{0.3125F, 0.3125F, 0.3125F});
        map.put(Type.IRON_GOLEM, new float[]{0.25F, 0.25F, 0.25F});
        map.put(Type.AGGRESSIVE_PANDA, new float[]{0.21875F, 0.1875F, 0.21875F});
        map.put(Type.BROWN_PANDA, new float[]{0.21875F, 0.1875F, 0.21875F});
        map.put(Type.LAZY_PANDA, new float[]{0.21875F, 0.1875F, 0.21875F});
        map.put(Type.PANDA, new float[]{0.21875F, 0.1875F, 0.21875F});
        map.put(Type.PLAYFUL_PANDA, new float[]{0.21875F, 0.1875F, 0.21875F});
        map.put(Type.WEAK_PANDA, new float[]{0.21875F, 0.1875F, 0.21875F});
        map.put(Type.WORRIED_PANDA, new float[]{0.21875F, 0.1875F, 0.21875F});
        map.put(Type.DROWNED, new float[]{0.25F, 0.25F, 0.25F});
    });

    public static Map<String, HeadedSkullBlockEntityModel> getOtherModels(EntityModelLoader modelLoader) {
        ImmutableMap.Builder<String, HeadedSkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.put("sheep_wool", new SheepHeadWoolEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_WOOL)));
        builder.put("enderman_eyes", new EndermanHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ENDERMAN_HEAD)));
        builder.put("drowned_outer_layer", new GenericSkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.DROWNED_OUTER_LAYER)));
        return builder.build();
    }

    private static final Map<String, Identifier> OTHER_TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        map.put("sheep_wool", new Identifier("textures/entity/sheep/sheep_fur.png"));
        map.put("enderman_eyes", new Identifier("textures/entity/enderman/enderman_eyes.png"));
        map.put("drowned_outer_layer", new Identifier("textures/entity/zombie/drowned_outer_layer.png"));
    });

    public HeadedSkullBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.MODELS = getModels(ctx.getLayerRenderDispatcher());
    }

    public boolean rendersOutsideBoundingBox(HeadedSkullBlockEntity skullBlockEntity) {
        return true;
    }

    public static RenderLayer getRenderLayer(HeadedSkullBlock.SkullType type) {
        Identifier identifier = TEXTURES.get(type);
        return RenderLayer.getEntityCutoutNoCullZOffset(identifier);
    }
    public static RenderLayer getOtherRenderLayer(String type) {
        Identifier identifier = OTHER_TEXTURES.get(type);
        return RenderLayer.getEntityCutoutNoCullZOffset(identifier);
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

    @Override
    public void render(HeadedSkullBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        float g = blockEntity.getPoweredTicks(tickDelta);
        BlockState blockState = blockEntity.getCachedState();
        boolean bl = blockState.getBlock() instanceof HeadedWallSkullBlock;
        Direction direction = bl ? blockState.get(HeadedWallSkullBlock.FACING) : null;
        int k = bl ? RotationPropertyHelper.fromDirection(direction) : blockState.get(HeadedSkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);
        HeadedSkullBlock.SkullType skullType = ((AbstractHeadedSkullBlock)blockState.getBlock()).getSkullType();
        HeadedSkullBlockEntityModel skullBlockEntityModel = this.MODELS.get(skullType);
        RenderLayer renderLayer = getRenderLayer(skullType);
        if (skullType == Type.FOX && !bl || skullType == Type.SNOW_FOX && !bl) {
            renderSkull(skullType, direction, h - g * 5.0F, g, matrices, vertexConsumers, light, skullBlockEntityModel, renderLayer, 1.0F, 1.0F, 1.0F);
        } else {
            renderSkull(skullType, direction, h, g, matrices, vertexConsumers, light, skullBlockEntityModel, renderLayer, 1.0F, 1.0F, 1.0F);
        }
        testForSpecialSkull(skullType, direction, h, g, matrices, vertexConsumers, light, blockEntity.getLeftHorn(), blockEntity.getRightHorn());
    }

    public static void testForSpecialSkull(HeadedSkullBlock.SkullType skullType, @Nullable Direction direction, float yaw, float deltaTime, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, boolean hasLeftHorn, boolean hasRightHorn) {
        if (skullType == Type.WHITE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.WHITE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.ORANGE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.ORANGE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.MAGENTA_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.MAGENTA);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.LIGHT_BLUE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.LIGHT_BLUE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.YELLOW_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.YELLOW);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.LIME_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.LIME);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.PINK_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.PINK);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.GRAY_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.GRAY);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.LIGHT_GRAY_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.LIGHT_GRAY);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.CYAN_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.CYAN);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.PURPLE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.PURPLE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.BLUE_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.BLUE);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.BROWN_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.BROWN);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.GREEN_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.GREEN);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.RED_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.RED);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.BLACK_SHEEP) {
            float[] hs = SheepEntity.getRgbColor(DyeColor.BLACK);
            float s = hs[0];
            float t = hs[1];
            float u = hs[2];
            RenderLayer woolRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("sheep_wool");
            HeadedSkullBlockEntityModel woolModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("sheep_wool");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, woolModel, woolRenderLayer, s, t, u);
        } else if (skullType == Type.ENDERMAN) {
            RenderLayer endermanEyesRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("enderman_eyes");
            HeadedSkullBlockEntityModel endermanEyesModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("enderman_eyes");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, 15728640, endermanEyesModel, endermanEyesRenderLayer, 1.0F, 1.0F, 1.0F);
        } else if (skullType == Type.DROWNED) {
            RenderLayer drownedOuterLayerRenderLayer = HeadedSkullBlockEntityRenderer.getOtherRenderLayer("drowned_outer_layer");
            HeadedSkullBlockEntityModel drownedOuterLayerModel = HeadedSkullBlockEntityRenderer.getOtherModels(MinecraftClient.getInstance().getEntityModelLoader()).get("drowned_outer_layer");

            HeadedSkullBlockEntityRenderer.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, drownedOuterLayerModel, drownedOuterLayerRenderLayer, 1.0F, 1.0F, 1.0F);
        }
//        else if (skullType == Type.ALL_BLACK_CAT) {
//            if (hasLeftHorn) {
//                renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, HeadedSkullBlockEntityRenderer.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(Type.SNOW_FOX), getRenderLayer(Type.SNOW_FOX), 1.0F, 1.0F, 1.0F);
//            }
//            if (hasRightHorn) {
//                renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, HeadedSkullBlockEntityRenderer.getModels(MinecraftClient.getInstance().getEntityModelLoader()).get(Type.ENDERMAN), getRenderLayer(Type.ENDERMAN), 1.0F, 1.0F, 1.0F);
//            }
//        }
    }
}