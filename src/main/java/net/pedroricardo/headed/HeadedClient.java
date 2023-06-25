package net.pedroricardo.headed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.block.entity.HeadedBlockEntities;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityRenderer;
import net.pedroricardo.headed.client.render.entity.feature.HeadedHeadFeatureRenderer;
import net.pedroricardo.headed.client.render.entity.model.*;
import net.pedroricardo.headed.init.ItemRendererRegistry;
import net.pedroricardo.headed.item.HeadedItems;

@Environment(EnvType.CLIENT)
public class HeadedClient implements ClientModInitializer {
    private static final EntityModelLayer VILLAGER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "villager_head"), "main");
    private static final EntityModelLayer EVOKER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "evoker_head"), "main");
    private static final EntityModelLayer VINDICATOR_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "vindicator_head"), "main");
    private static final EntityModelLayer PILLAGER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "pillager_head"), "main");
    private static final EntityModelLayer ZOMBIE_VILLAGER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "zombie_villager_head"), "main");
    private static final EntityModelLayer WANDERING_TRADER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "wandering_trader_head"), "main");
    private static final EntityModelLayer ILLUSIONER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "illusioner_head"), "main");
    private static final EntityModelLayer SHEEP_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "sheep_head"), "main");
    private static final EntityModelLayer SHEEP_WOOL = new EntityModelLayer(new Identifier(Headed.MOD_ID, "sheep_head"), "wool");
    private static final EntityModelLayer ALLAY_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "allay_head"), "main");
    private static final EntityModelLayer VEX_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "vex_head"), "main");
    private static final EntityModelLayer PIGLIN_BRUTE_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "piglin_brute_head"), "main");
    private static final EntityModelLayer ZOMBIFIED_PIGLIN_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "zombified_piglin_head"), "main");
    private static final EntityModelLayer AXOLOTL_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "axolotl_head"), "main");
    private static final EntityModelLayer COW_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "cow_head"), "main");
    private static final EntityModelLayer POLAR_BEAR_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "polar_bear_head"), "main");
    private static final EntityModelLayer OCELOT_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "ocelot_head"), "main");
    private static final EntityModelLayer ENDERMAN_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "enderman_head"), "main");
    private static final EntityModelLayer FOX_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "fox_head"), "main");
    private static final EntityModelLayer IRON_GOLEM_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "iron_golem_head"), "main");
    private static final EntityModelLayer PANDA_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "panda_head"), "main");
    private static final EntityModelLayer DROWNED_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "drowned_head"), "main");
    private static final EntityModelLayer DROWNED_HEAD_OUTER_LAYER = new EntityModelLayer(new Identifier(Headed.MOD_ID, "drowned_head"), "outer");
    private static final EntityModelLayer PARROT_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "parrot_head"), "main");
    private static final EntityModelLayer STRAY_SKULL = new EntityModelLayer(new Identifier(Headed.MOD_ID, "stray_skull"), "main");
    private static final EntityModelLayer STRAY_SKULL_OUTER_LAYER = new EntityModelLayer(new Identifier(Headed.MOD_ID, "stray_skull"), "outer");
    private static final EntityModelLayer SHULKER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "shulker_head"), "main");
    private static final EntityModelLayer HUSK_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "husk_head"), "main");
    private static final EntityModelLayer PIG_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "pig_head"), "main");
    private static final EntityModelLayer SPIDER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "spider_head"), "main");
    private static final EntityModelLayer SPIDER_EYES = new EntityModelLayer(new Identifier(Headed.MOD_ID, "spider_head"), "eyes");
    private static final EntityModelLayer BLAZE_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "blaze_head"), "main");
    private static final EntityModelLayer RABBIT_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "rabbit_head"), "main");
    private static final EntityModelLayer TURTLE_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "turtle_head"), "main");
    private static final EntityModelLayer WITHER_SKULL = new EntityModelLayer(new Identifier(Headed.MOD_ID, "wither_skull"), "main");
    private static final EntityModelLayer WOLF_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "wolf_head"), "main");
    private static final EntityModelLayer BAT_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "bat_head"), "main");
    private static final EntityModelLayer WITCH_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "witch_head"), "main");
    private static final EntityModelLayer CHICKEN_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "chicken_head"), "main");
    private static final EntityModelLayer PHANTOM_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "phantom_head"), "main");
    private static final EntityModelLayer PHANTOM_EYES = new EntityModelLayer(new Identifier(Headed.MOD_ID, "phantom_head"), "eyes");
    private static final EntityModelLayer SNOW_GOLEM_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "snow_golem_head"), "main");

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(HeadedBlockEntities.SKULL, HeadedSkullBlockEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(VILLAGER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EVOKER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VINDICATOR_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PILLAGER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ZOMBIE_VILLAGER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(WANDERING_TRADER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ILLUSIONER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SHEEP_HEAD, SheepHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SHEEP_WOOL, SheepHeadWoolEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ALLAY_HEAD, AllayHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VEX_HEAD, AllayHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PIGLIN_BRUTE_HEAD, HeadedPiglinHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ZOMBIFIED_PIGLIN_HEAD, HeadedPiglinHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(AXOLOTL_HEAD, AxolotlHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(COW_HEAD, CowHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(POLAR_BEAR_HEAD, PolarBearHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(OCELOT_HEAD, OcelotHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ENDERMAN_HEAD, EndermanHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(FOX_HEAD, FoxHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(IRON_GOLEM_HEAD, IronGolemHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PANDA_HEAD, PandaHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DROWNED_HEAD, () -> GenericSkullEntityModel.getTexturedModelData(new Dilation(0.0F), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(DROWNED_HEAD_OUTER_LAYER, () -> GenericSkullEntityModel.getTexturedModelData(new Dilation(0.25F), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(PARROT_HEAD, ParrotHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(STRAY_SKULL, () -> StraySkullEntityModel.getTexturedModelData(new Dilation(0.0F)));
        EntityModelLayerRegistry.registerModelLayer(STRAY_SKULL_OUTER_LAYER, () -> StraySkullEntityModel.getTexturedModelData(new Dilation(0.25F)));
        EntityModelLayerRegistry.registerModelLayer(SHULKER_HEAD, ShulkerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(HUSK_HEAD, () -> GenericSkullEntityModel.getTexturedModelData(new Dilation(0.0F), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(PIG_HEAD, PigHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SPIDER_HEAD, () -> SpiderHeadEntityModel.getTexturedModelData(new Dilation(0.0F)));
        EntityModelLayerRegistry.registerModelLayer(SPIDER_EYES, () -> SpiderHeadEntityModel.getTexturedModelData(new Dilation(0.0F)));
        EntityModelLayerRegistry.registerModelLayer(BLAZE_HEAD, () -> GenericSkullEntityModel.getTexturedModelData(new Dilation(0.0F), 64, 32));
        EntityModelLayerRegistry.registerModelLayer(RABBIT_HEAD, RabbitHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(TURTLE_HEAD, TurtleHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(WITHER_SKULL, () -> GenericSkullEntityModel.getTexturedModelData(new Dilation(0.0F), 64, 64));
        EntityModelLayerRegistry.registerModelLayer(WOLF_HEAD, WolfHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(BAT_HEAD, BatHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(WITCH_HEAD, WitchHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(CHICKEN_HEAD, ChickenHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PHANTOM_HEAD, PhantomHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PHANTOM_EYES, PhantomHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SNOW_GOLEM_HEAD, SnowGolemHeadEntityModel::getTexturedModelData);

        ItemRendererRegistry.register(HeadedItems.VILLAGER_HEAD);
        ItemRendererRegistry.register(HeadedItems.EVOKER_HEAD);
        ItemRendererRegistry.register(HeadedItems.VINDICATOR_HEAD);
        ItemRendererRegistry.register(HeadedItems.PILLAGER_HEAD);
        ItemRendererRegistry.register(HeadedItems.ZOMBIE_VILLAGER_HEAD);
        ItemRendererRegistry.register(HeadedItems.WANDERING_TRADER_HEAD);
        ItemRendererRegistry.register(HeadedItems.ILLUSIONER_HEAD);
        ItemRendererRegistry.register(HeadedItems.SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.WHITE_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.ORANGE_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.MAGENTA_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.LIGHT_BLUE_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.YELLOW_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.LIME_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.PINK_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.GRAY_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.LIGHT_GRAY_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.CYAN_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.PURPLE_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.BLUE_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.BROWN_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.GREEN_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.RED_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.BLACK_SHEEP_HEAD);
        ItemRendererRegistry.register(HeadedItems.ALLAY_HEAD);
        ItemRendererRegistry.register(HeadedItems.VEX_HEAD);
        ItemRendererRegistry.register(HeadedItems.PIGLIN_BRUTE_HEAD);
        ItemRendererRegistry.register(HeadedItems.ZOMBIFIED_PIGLIN_HEAD);
        ItemRendererRegistry.register(HeadedItems.LEUCISTIC_AXOLOTL_HEAD);
        ItemRendererRegistry.register(HeadedItems.BROWN_AXOLOTL_HEAD);
        ItemRendererRegistry.register(HeadedItems.CYAN_AXOLOTL_HEAD);
        ItemRendererRegistry.register(HeadedItems.GOLD_AXOLOTL_HEAD);
        ItemRendererRegistry.register(HeadedItems.BLUE_AXOLOTL_HEAD);
        ItemRendererRegistry.register(HeadedItems.COW_HEAD);
        ItemRendererRegistry.register(HeadedItems.BROWN_MOOSHROOM_HEAD);
        ItemRendererRegistry.register(HeadedItems.RED_MOOSHROOM_HEAD);
        ItemRendererRegistry.register(HeadedItems.POLAR_BEAR_HEAD);
        ItemRendererRegistry.register(HeadedItems.OCELOT_HEAD);
        ItemRendererRegistry.register(HeadedItems.ALL_BLACK_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.BLACK_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.BRITISH_SHORTHAIR_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.CALICO_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.JELLIE_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.PERSIAN_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.RAGDOLL_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.RED_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.SIAMESE_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.TABBY_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.WHITE_CAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.ENDERMAN_HEAD);
        ItemRendererRegistry.register(HeadedItems.FOX_HEAD);
        ItemRendererRegistry.register(HeadedItems.SNOW_FOX_HEAD);
        ItemRendererRegistry.register(HeadedItems.IRON_GOLEM_HEAD);
        ItemRendererRegistry.register(HeadedItems.AGGRESSIVE_PANDA_HEAD);
        ItemRendererRegistry.register(HeadedItems.BROWN_PANDA_HEAD);
        ItemRendererRegistry.register(HeadedItems.LAZY_PANDA_HEAD);
        ItemRendererRegistry.register(HeadedItems.PANDA_HEAD);
        ItemRendererRegistry.register(HeadedItems.PLAYFUL_PANDA_HEAD);
        ItemRendererRegistry.register(HeadedItems.WEAK_PANDA_HEAD);
        ItemRendererRegistry.register(HeadedItems.WORRIED_PANDA_HEAD);
        ItemRendererRegistry.register(HeadedItems.DROWNED_HEAD);
        ItemRendererRegistry.register(HeadedItems.RED_PARROT_HEAD);
        ItemRendererRegistry.register(HeadedItems.GREEN_PARROT_HEAD);
        ItemRendererRegistry.register(HeadedItems.BLUE_PARROT_HEAD);
        ItemRendererRegistry.register(HeadedItems.CYAN_PARROT_HEAD);
        ItemRendererRegistry.register(HeadedItems.GRAY_PARROT_HEAD);
        ItemRendererRegistry.register(HeadedItems.STRAY_SKULL);
        ItemRendererRegistry.register(HeadedItems.SHULKER_HEAD);
        ItemRendererRegistry.register(HeadedItems.HUSK_HEAD);
        ItemRendererRegistry.register(HeadedItems.PIG_HEAD);
        ItemRendererRegistry.register(HeadedItems.SPIDER_HEAD);
        ItemRendererRegistry.register(HeadedItems.CAVE_SPIDER_HEAD);
        ItemRendererRegistry.register(HeadedItems.BLAZE_HEAD);
        ItemRendererRegistry.register(HeadedItems.BLACK_RABBIT_HEAD);
        ItemRendererRegistry.register(HeadedItems.BROWN_RABBIT_HEAD);
        ItemRendererRegistry.register(HeadedItems.EVIL_RABBIT_HEAD);
        ItemRendererRegistry.register(HeadedItems.GOLD_RABBIT_HEAD);
        ItemRendererRegistry.register(HeadedItems.SALT_RABBIT_HEAD);
        ItemRendererRegistry.register(HeadedItems.WHITE_RABBIT_HEAD);
        ItemRendererRegistry.register(HeadedItems.WHITE_SPLOTCHED_RABBIT_HEAD);
        ItemRendererRegistry.register(HeadedItems.TURTLE_HEAD);
        ItemRendererRegistry.register(HeadedItems.WITHER_SKULL);
        ItemRendererRegistry.register(HeadedItems.WOLF_HEAD);
        ItemRendererRegistry.register(HeadedItems.BAT_HEAD);
        ItemRendererRegistry.register(HeadedItems.WITCH_HEAD);
        ItemRendererRegistry.register(HeadedItems.CHICKEN_HEAD);
        ItemRendererRegistry.register(HeadedItems.PHANTOM_HEAD);
        ItemRendererRegistry.register(HeadedItems.SNOW_GOLEM_HEAD);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityRenderer instanceof ModelWithHead) {
                registrationHelper.register(new HeadedHeadFeatureRenderer(entityRenderer, context.getModelLoader()));
            }
        });
    }
}
