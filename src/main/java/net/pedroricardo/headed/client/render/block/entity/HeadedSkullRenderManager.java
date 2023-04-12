package net.pedroricardo.headed.client.render.block.entity;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import net.pedroricardo.headed.client.render.block.entity.feature.*;
import net.pedroricardo.headed.client.render.entity.model.*;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class HeadedSkullRenderManager {
    private static HeadedSkullRenderManager instance;
    private Map<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> MODELS;
    public static BlockRenderManager BLOCK_RENDER_MANAGER;

    private HeadedSkullRenderManager() {
    }

    public static HeadedSkullRenderManager getInstance() {
        if (instance == null) {
            instance = new HeadedSkullRenderManager();
        }
        return instance;
    }

    public void setContext(BlockEntityRendererFactory.Context ctx) {
        BLOCK_RENDER_MANAGER = ctx.getRenderManager();
        MODELS = getModels(ctx.getLayerRenderDispatcher());
    }

    private static final Map<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> EXTERNAL_MODELS = new HashMap<>();
    private static final Map<HeadedSkullBlock.SkullType, Identifier> EXTERNAL_TEXTURES = new HashMap<>();

    public static void registerExternalRendering(HeadedSkullBlock.SkullType type, HeadedSkullBlockEntityModel model, Identifier resourceLocation, float[] headDislocation) {
        EXTERNAL_MODELS.put(type, model);
        EXTERNAL_TEXTURES.put(type, resourceLocation);
    }

    public static Map<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> getModels(EntityModelLoader modelLoader) {
        ImmutableMap.Builder<HeadedSkullBlock.SkullType, HeadedSkullBlockEntityModel> builder = ImmutableMap.builder();
        builder.putAll(EXTERNAL_MODELS);

        builder.put(HeadedSkullBlock.Type.VILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.VILLAGER_HEAD)));
        builder.put(HeadedSkullBlock.Type.EVOKER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.EVOKER_HEAD)));
        builder.put(HeadedSkullBlock.Type.VINDICATOR, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.VINDICATOR_HEAD)));
        builder.put(HeadedSkullBlock.Type.PILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PILLAGER_HEAD)));
        builder.put(HeadedSkullBlock.Type.ZOMBIE_VILLAGER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ZOMBIE_VILLAGER_HEAD)));
        builder.put(HeadedSkullBlock.Type.WANDERING_TRADER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.WANDERING_TRADER_HEAD)));
        builder.put(HeadedSkullBlock.Type.ILLUSIONER, new VillagerHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ILLUSIONER_HEAD)));
        builder.put(HeadedSkullBlock.Type.SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.WHITE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.ORANGE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.MAGENTA_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.LIGHT_BLUE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.YELLOW_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.LIME_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.PINK_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.GRAY_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.LIGHT_GRAY_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.CYAN_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.PURPLE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.BLUE_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.BROWN_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.GREEN_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.RED_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.BLACK_SHEEP, new SheepHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHEEP_HEAD)));
        builder.put(HeadedSkullBlock.Type.ALLAY, new AllayHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ALLAY_HEAD)));
        builder.put(HeadedSkullBlock.Type.VEX, new GenericSkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.VEX_HEAD)));
        builder.put(HeadedSkullBlock.Type.PIGLIN, new HeadedPiglinHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PIGLIN_HEAD)));
        builder.put(HeadedSkullBlock.Type.PIGLIN_BRUTE, new HeadedPiglinHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PIGLIN_BRUTE_HEAD)));
        builder.put(HeadedSkullBlock.Type.ZOMBIFIED_PIGLIN, new HeadedPiglinHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ZOMBIFIED_PIGLIN_HEAD)));
        builder.put(HeadedSkullBlock.Type.LEUCISTIC_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        builder.put(HeadedSkullBlock.Type.BROWN_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        builder.put(HeadedSkullBlock.Type.CYAN_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        builder.put(HeadedSkullBlock.Type.GOLD_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        builder.put(HeadedSkullBlock.Type.BLUE_AXOLOTL, new AxolotlHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.AXOLOTL_HEAD)));
        builder.put(HeadedSkullBlock.Type.COW, new CowHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.COW_HEAD)));
        builder.put(HeadedSkullBlock.Type.BROWN_MOOSHROOM, new CowHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.COW_HEAD)));
        builder.put(HeadedSkullBlock.Type.RED_MOOSHROOM, new CowHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.COW_HEAD)));
        builder.put(HeadedSkullBlock.Type.POLAR_BEAR, new PolarBearHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.POLAR_BEAR_HEAD)));
        builder.put(HeadedSkullBlock.Type.OCELOT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.ALL_BLACK_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.BLACK_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.BRITISH_SHORTHAIR_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.CALICO_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.JELLIE_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.PERSIAN_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.RAGDOLL_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.RED_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.SIAMESE_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.TABBY_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.WHITE_CAT, new OcelotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.OCELOT_HEAD)));
        builder.put(HeadedSkullBlock.Type.ENDERMAN, new EndermanHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.ENDERMAN_HEAD)));
        builder.put(HeadedSkullBlock.Type.FOX, new FoxHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.FOX_HEAD)));
        builder.put(HeadedSkullBlock.Type.SNOW_FOX, new FoxHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.FOX_HEAD)));
        builder.put(HeadedSkullBlock.Type.IRON_GOLEM, new IronGolemHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.IRON_GOLEM_HEAD)));
        builder.put(HeadedSkullBlock.Type.AGGRESSIVE_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(HeadedSkullBlock.Type.BROWN_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(HeadedSkullBlock.Type.LAZY_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(HeadedSkullBlock.Type.PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(HeadedSkullBlock.Type.PLAYFUL_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(HeadedSkullBlock.Type.WEAK_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(HeadedSkullBlock.Type.WORRIED_PANDA, new PandaHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PANDA_HEAD)));
        builder.put(HeadedSkullBlock.Type.DROWNED, new GenericSkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.DROWNED_HEAD)));
        builder.put(HeadedSkullBlock.Type.RED_PARROT, new GenericSkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PARROT_HEAD)));
        builder.put(HeadedSkullBlock.Type.GREEN_PARROT, new ParrotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PARROT_HEAD)));
        builder.put(HeadedSkullBlock.Type.BLUE_PARROT, new ParrotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PARROT_HEAD)));
        builder.put(HeadedSkullBlock.Type.CYAN_PARROT, new ParrotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PARROT_HEAD)));
        builder.put(HeadedSkullBlock.Type.GRAY_PARROT, new ParrotHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PARROT_HEAD)));
        builder.put(HeadedSkullBlock.Type.STRAY, new StraySkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.STRAY_SKULL)));
        builder.put(HeadedSkullBlock.Type.SHULKER, new StraySkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SHULKER_HEAD)));
        builder.put(HeadedSkullBlock.Type.HUSK, new GenericSkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.HUSK_HEAD)));
        builder.put(HeadedSkullBlock.Type.PIG, new PigHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PIG_HEAD)));
        builder.put(HeadedSkullBlock.Type.SPIDER, new SpiderHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SPIDER_HEAD)));
        builder.put(HeadedSkullBlock.Type.CAVE_SPIDER, new SpiderHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SPIDER_HEAD)));
        builder.put(HeadedSkullBlock.Type.BLAZE, new GenericSkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.BLAZE_HEAD)));
        builder.put(HeadedSkullBlock.Type.BLACK_RABBIT, new RabbitHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.RABBIT_HEAD)));
        builder.put(HeadedSkullBlock.Type.BROWN_RABBIT, new RabbitHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.RABBIT_HEAD)));
        builder.put(HeadedSkullBlock.Type.EVIL_RABBIT, new RabbitHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.RABBIT_HEAD)));
        builder.put(HeadedSkullBlock.Type.GOLD_RABBIT, new RabbitHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.RABBIT_HEAD)));
        builder.put(HeadedSkullBlock.Type.SALT_RABBIT, new RabbitHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.RABBIT_HEAD)));
        builder.put(HeadedSkullBlock.Type.WHITE_RABBIT, new RabbitHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.RABBIT_HEAD)));
        builder.put(HeadedSkullBlock.Type.WHITE_SPLOTCHED_RABBIT, new RabbitHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.RABBIT_HEAD)));
        builder.put(HeadedSkullBlock.Type.TURTLE, new TurtleHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.TURTLE_HEAD)));
        builder.put(HeadedSkullBlock.Type.WITHER, new GenericSkullEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.WITHER_SKULL)));
        builder.put(HeadedSkullBlock.Type.WOLF, new WolfHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.WOLF_HEAD)));
        builder.put(HeadedSkullBlock.Type.BAT, new BatHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.BAT_HEAD)));
        builder.put(HeadedSkullBlock.Type.WITCH, new WitchHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.WITCH_HEAD)));
        builder.put(HeadedSkullBlock.Type.CHICKEN, new ChickenHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.CHICKEN_HEAD)));
        builder.put(HeadedSkullBlock.Type.PHANTOM, new PhantomHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.PHANTOM_HEAD)));
        builder.put(HeadedSkullBlock.Type.SNOW_GOLEM, new SnowGolemHeadEntityModel(modelLoader.getModelPart(HeadedEntityModelLayers.SNOW_GOLEM_HEAD)));
        return builder.build();
    }

    private static final Map<HeadedSkullBlock.SkullType, Identifier> TEXTURES = Util.make(Maps.newHashMap(), (map) -> {
        map.putAll(EXTERNAL_TEXTURES);

        map.put(HeadedSkullBlock.Type.VILLAGER, new Identifier("textures/entity/villager/villager.png"));
        map.put(HeadedSkullBlock.Type.EVOKER, new Identifier("textures/entity/illager/evoker.png"));
        map.put(HeadedSkullBlock.Type.VINDICATOR, new Identifier("textures/entity/illager/vindicator.png"));
        map.put(HeadedSkullBlock.Type.PILLAGER, new Identifier("textures/entity/illager/pillager.png"));
        map.put(HeadedSkullBlock.Type.ZOMBIE_VILLAGER, new Identifier("textures/entity/zombie_villager/zombie_villager.png"));
        map.put(HeadedSkullBlock.Type.WANDERING_TRADER, new Identifier("textures/entity/wandering_trader.png"));
        map.put(HeadedSkullBlock.Type.ILLUSIONER, new Identifier("textures/entity/illager/illusioner.png"));
        map.put(HeadedSkullBlock.Type.SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.WHITE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.ORANGE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.MAGENTA_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.LIGHT_BLUE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.YELLOW_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.LIME_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.PINK_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.GRAY_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.LIGHT_GRAY_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.CYAN_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.PURPLE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.BLUE_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.BROWN_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.GREEN_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.RED_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.BLACK_SHEEP, new Identifier("textures/entity/sheep/sheep.png"));
        map.put(HeadedSkullBlock.Type.ALLAY, new Identifier("textures/entity/allay/allay.png"));
        map.put(HeadedSkullBlock.Type.VEX, new Identifier("textures/entity/illager/vex.png"));
        map.put(HeadedSkullBlock.Type.PIGLIN, new Identifier("textures/entity/piglin/piglin.png"));
        map.put(HeadedSkullBlock.Type.PIGLIN_BRUTE, new Identifier("textures/entity/piglin/piglin_brute.png"));
        map.put(HeadedSkullBlock.Type.ZOMBIFIED_PIGLIN, new Identifier("textures/entity/piglin/zombified_piglin.png"));
        map.put(HeadedSkullBlock.Type.LEUCISTIC_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_lucy.png"));
        map.put(HeadedSkullBlock.Type.BROWN_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_wild.png"));
        map.put(HeadedSkullBlock.Type.CYAN_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_cyan.png"));
        map.put(HeadedSkullBlock.Type.GOLD_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_gold.png"));
        map.put(HeadedSkullBlock.Type.BLUE_AXOLOTL, new Identifier("textures/entity/axolotl/axolotl_blue.png"));
        map.put(HeadedSkullBlock.Type.COW, new Identifier("textures/entity/cow/cow.png"));
        map.put(HeadedSkullBlock.Type.BROWN_MOOSHROOM, new Identifier("textures/entity/cow/brown_mooshroom.png"));
        map.put(HeadedSkullBlock.Type.RED_MOOSHROOM, new Identifier("textures/entity/cow/red_mooshroom.png"));
        map.put(HeadedSkullBlock.Type.POLAR_BEAR, new Identifier("textures/entity/bear/polarbear.png"));
        map.put(HeadedSkullBlock.Type.OCELOT, new Identifier("textures/entity/cat/ocelot.png"));
        map.put(HeadedSkullBlock.Type.ALL_BLACK_CAT, new Identifier("textures/entity/cat/all_black.png"));
        map.put(HeadedSkullBlock.Type.BLACK_CAT, new Identifier("textures/entity/cat/black.png"));
        map.put(HeadedSkullBlock.Type.BRITISH_SHORTHAIR_CAT, new Identifier("textures/entity/cat/british_shorthair.png"));
        map.put(HeadedSkullBlock.Type.CALICO_CAT, new Identifier("textures/entity/cat/calico.png"));
        map.put(HeadedSkullBlock.Type.JELLIE_CAT, new Identifier("textures/entity/cat/jellie.png"));
        map.put(HeadedSkullBlock.Type.PERSIAN_CAT, new Identifier("textures/entity/cat/persian.png"));
        map.put(HeadedSkullBlock.Type.RAGDOLL_CAT, new Identifier("textures/entity/cat/ragdoll.png"));
        map.put(HeadedSkullBlock.Type.RED_CAT, new Identifier("textures/entity/cat/red.png"));
        map.put(HeadedSkullBlock.Type.SIAMESE_CAT, new Identifier("textures/entity/cat/siamese.png"));
        map.put(HeadedSkullBlock.Type.TABBY_CAT, new Identifier("textures/entity/cat/tabby.png"));
        map.put(HeadedSkullBlock.Type.WHITE_CAT, new Identifier("textures/entity/cat/white.png"));
        map.put(HeadedSkullBlock.Type.ENDERMAN, new Identifier("textures/entity/enderman/enderman.png"));
        map.put(HeadedSkullBlock.Type.FOX, new Identifier("textures/entity/fox/fox.png"));
        map.put(HeadedSkullBlock.Type.SNOW_FOX, new Identifier("textures/entity/fox/snow_fox.png"));
        map.put(HeadedSkullBlock.Type.IRON_GOLEM, new Identifier("textures/entity/iron_golem/iron_golem.png"));
        map.put(HeadedSkullBlock.Type.AGGRESSIVE_PANDA, new Identifier("textures/entity/panda/aggressive_panda.png"));
        map.put(HeadedSkullBlock.Type.BROWN_PANDA, new Identifier("textures/entity/panda/brown_panda.png"));
        map.put(HeadedSkullBlock.Type.LAZY_PANDA, new Identifier("textures/entity/panda/lazy_panda.png"));
        map.put(HeadedSkullBlock.Type.PANDA, new Identifier("textures/entity/panda/panda.png"));
        map.put(HeadedSkullBlock.Type.PLAYFUL_PANDA, new Identifier("textures/entity/panda/playful_panda.png"));
        map.put(HeadedSkullBlock.Type.WEAK_PANDA, new Identifier("textures/entity/panda/weak_panda.png"));
        map.put(HeadedSkullBlock.Type.WORRIED_PANDA, new Identifier("textures/entity/panda/worried_panda.png"));
        map.put(HeadedSkullBlock.Type.DROWNED, new Identifier("textures/entity/zombie/drowned.png"));
        map.put(HeadedSkullBlock.Type.RED_PARROT, new Identifier("textures/entity/parrot/parrot_red_blue.png"));
        map.put(HeadedSkullBlock.Type.GREEN_PARROT, new Identifier("textures/entity/parrot/parrot_green.png"));
        map.put(HeadedSkullBlock.Type.BLUE_PARROT, new Identifier("textures/entity/parrot/parrot_blue.png"));
        map.put(HeadedSkullBlock.Type.CYAN_PARROT, new Identifier("textures/entity/parrot/parrot_yellow_blue.png"));
        map.put(HeadedSkullBlock.Type.GRAY_PARROT, new Identifier("textures/entity/parrot/parrot_grey.png"));
        map.put(HeadedSkullBlock.Type.STRAY, new Identifier("textures/entity/skeleton/stray.png"));
        map.put(HeadedSkullBlock.Type.SHULKER, new Identifier("textures/entity/shulker/shulker.png"));
        map.put(HeadedSkullBlock.Type.HUSK, new Identifier("textures/entity/zombie/husk.png"));
        map.put(HeadedSkullBlock.Type.PIG, new Identifier("textures/entity/pig/pig.png"));
        map.put(HeadedSkullBlock.Type.SPIDER, new Identifier("textures/entity/spider/spider.png"));
        map.put(HeadedSkullBlock.Type.CAVE_SPIDER, new Identifier("textures/entity/spider/cave_spider.png"));
        map.put(HeadedSkullBlock.Type.BLAZE, new Identifier("textures/entity/blaze.png"));
        map.put(HeadedSkullBlock.Type.BLACK_RABBIT, new Identifier("textures/entity/rabbit/black.png"));
        map.put(HeadedSkullBlock.Type.BROWN_RABBIT, new Identifier("textures/entity/rabbit/brown.png"));
        map.put(HeadedSkullBlock.Type.EVIL_RABBIT, new Identifier("textures/entity/rabbit/caerbannog.png"));
        map.put(HeadedSkullBlock.Type.GOLD_RABBIT, new Identifier("textures/entity/rabbit/gold.png"));
        map.put(HeadedSkullBlock.Type.SALT_RABBIT, new Identifier("textures/entity/rabbit/salt.png"));
        map.put(HeadedSkullBlock.Type.WHITE_RABBIT, new Identifier("textures/entity/rabbit/white.png"));
        map.put(HeadedSkullBlock.Type.WHITE_SPLOTCHED_RABBIT, new Identifier("textures/entity/rabbit/white_splotched.png"));
        map.put(HeadedSkullBlock.Type.TURTLE, new Identifier("textures/entity/turtle/big_sea_turtle.png"));
        map.put(HeadedSkullBlock.Type.WITHER, new Identifier("textures/entity/wither/wither.png"));
        map.put(HeadedSkullBlock.Type.WOLF, new Identifier("textures/entity/wolf/wolf.png"));
        map.put(HeadedSkullBlock.Type.BAT, new Identifier("textures/entity/bat.png"));
        map.put(HeadedSkullBlock.Type.WITCH, new Identifier("textures/entity/witch.png"));
        map.put(HeadedSkullBlock.Type.CHICKEN, new Identifier("textures/entity/chicken.png"));
        map.put(HeadedSkullBlock.Type.PHANTOM, new Identifier("textures/entity/phantom.png"));
        map.put(HeadedSkullBlock.Type.SNOW_GOLEM, new Identifier("textures/entity/snow_golem.png"));
    });

    private RenderLayer getRenderLayer(HeadedSkullBlock.SkullType type) {
        Identifier identifier = TEXTURES.get(type);
        if (type == HeadedSkullBlock.Type.ENDERMAN || type == HeadedSkullBlock.Type.SPIDER || type == HeadedSkullBlock.Type.CAVE_SPIDER || type == HeadedSkullBlock.Type.PHANTOM) {
            return RenderLayer.getEntityCutout(identifier);
        }
        return RenderLayer.getEntityCutoutNoCullZOffset(identifier);
    }

    public RenderLayer getRenderLayer(HeadedSkullBlockEntity blockEntity, ItemStack itemStack, HeadedSkullBlock.SkullType skullType) {
        if (HeadedSkullBlock.isTamed(blockEntity, itemStack) && skullType == HeadedSkullBlock.Type.WOLF) {
            return RenderLayer.getEntityCutoutNoCullZOffset(new Identifier("textures/entity/wolf/wolf_tame.png"));
        } else if (HeadedSkullBlock.isToast(blockEntity, itemStack) && HeadedSkullBlock.RABBIT_TYPES.contains(
                skullType)) {
            return RenderLayer.getEntityCutoutNoCullZOffset(new Identifier("textures/entity/rabbit/toast.png"));
        }
        return getRenderLayer(skullType);
    }

    private static float getDislocation(HeadedSkullBlock.SkullType skullType, float size) {
        if (skullType == HeadedSkullBlock.Type.CAVE_SPIDER) {
            return 0.325f;
        } else if (skullType == HeadedSkullBlock.Type.VEX) {
            return 0.4f;
        } else {
            return (16 - size)/32;
        }
    }

    public static void renderSkull(@Nullable HeadedSkullBlock.SkullType skullType, @Nullable Direction direction, float yaw, float animationProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, HeadedSkullBlockEntityModel model, RenderLayer renderLayer, float r, float g, float b) {
        matrices.push();
        if (direction == null) {
            matrices.translate(0.5F, 0.0F, 0.5F);
        } else {
            float dislocationY = getDislocation(skullType, model.getHeadSizeInPixels()[1]);
            float dislocationX = getDislocation(skullType, model.getHeadSizeInPixels()[2]);
            matrices.translate(0.5F - (float)direction.getOffsetX() * dislocationX, dislocationY, 0.5F - (float)direction.getOffsetZ() * dislocationX);
        }

        matrices.scale(-1.0F, -1.0F, 1.0F);
        if (skullType == HeadedSkullBlock.Type.CAVE_SPIDER) {
            matrices.scale(0.7F, 0.7F, 0.7F);
        } else if (skullType == HeadedSkullBlock.Type.VEX) {
            matrices.scale(0.4F, 0.4F, 0.4F);
        }
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);
        model.setHeadRotation(animationProgress, yaw, 0.0F);
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, r, g, b, 1.0F);
        matrices.pop();
    }

    private static void renderSkullFeature(HeadedSkullBlock.SkullType skullType, @Nullable Direction direction, float yaw, float deltaTime, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, HeadedSkullBlockEntity blockEntity, ItemStack itemStack) {
        if (HeadedSkullBlock.SHEEP_TYPES.contains(skullType) && skullType != HeadedSkullBlock.Type.SHEEP) {
            new HeadedSheepHeadWoolFeatureRenderer().renderFeature((HeadedSkullBlock.Type) skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, blockEntity, itemStack);
        } else if (skullType == HeadedSkullBlock.Type.ENDERMAN) {
            new HeadedEndermanHeadEyesFeatureRenderer().renderFeature((HeadedSkullBlock.Type) skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, blockEntity, itemStack);
        } else if (skullType == HeadedSkullBlock.Type.DROWNED) {
            new HeadedDrownedHeadOuterLayerFeatureRenderer().renderFeature((HeadedSkullBlock.Type) skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, blockEntity, itemStack);
        } else if (skullType == HeadedSkullBlock.Type.STRAY) {
            new HeadedStrayHeadOuterLayerFeatureRenderer().renderFeature((HeadedSkullBlock.Type) skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, blockEntity, itemStack);
        } else if (skullType == HeadedSkullBlock.Type.SPIDER || skullType == HeadedSkullBlock.Type.CAVE_SPIDER) {
            new HeadedSpiderHeadEyesFeatureRenderer().renderFeature((HeadedSkullBlock.Type) skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, blockEntity, itemStack);
        } else if (skullType == HeadedSkullBlock.Type.PHANTOM) {
            new HeadedPhantomHeadEyesFeatureRenderer().renderFeature((HeadedSkullBlock.Type) skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, blockEntity, itemStack);
        } else if (skullType == HeadedSkullBlock.Type.RED_MOOSHROOM || skullType == HeadedSkullBlock.Type.BROWN_MOOSHROOM) {
            new HeadedMooshroomHeadMushroomFeatureRenderer().renderFeature((HeadedSkullBlock.Type) skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, blockEntity, itemStack);
        }
    }

    public static void renderSkullWithFeature(HeadedSkullBlock.SkullType skullType, @Nullable Direction direction, float yaw, float animationProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, HeadedSkullBlockEntityModel model, RenderLayer renderLayer, float r, float g, float b, HeadedSkullBlockEntity blockEntity, ItemStack itemStack) {
        renderSkull(skullType, direction, yaw, animationProgress, matrices, vertexConsumers, light, model, renderLayer, r, g, b);
        renderSkullFeature(skullType, direction, yaw, animationProgress, matrices, vertexConsumers, light, blockEntity, itemStack);
    }
}
