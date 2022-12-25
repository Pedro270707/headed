package net.pedroricardo.headed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.model.EntityModelLayer;
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
    private static final EntityModelLayer ILLUSIONER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "illusioner_head"), "main");
    private static final EntityModelLayer SHEEP_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "sheep_head"), "main");
    private static final EntityModelLayer SHEEP_WOOL = new EntityModelLayer(new Identifier(Headed.MOD_ID, "sheep_head"), "wool");
    private static final EntityModelLayer ALLAY_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "allay_head"), "main");
    private static final EntityModelLayer VEX_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "vex_head"), "main");
    private static final EntityModelLayer PIGLIN_BRUTE_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "piglin_brute_head"), "main");
    private static final EntityModelLayer ZOMBIFIED_PIGLIN_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "zombified_piglin_head"), "main");
    private static final EntityModelLayer AXOLOTL_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "axolotl_head"), "main");

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(HeadedBlockEntities.SKULL, HeadedSkullBlockEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(VILLAGER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EVOKER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VINDICATOR_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PILLAGER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ZOMBIE_VILLAGER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ILLUSIONER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SHEEP_HEAD, SheepHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SHEEP_WOOL, SheepHeadWoolEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ALLAY_HEAD, AllayHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VEX_HEAD, AllayHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PIGLIN_BRUTE_HEAD, HeadedPiglinHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ZOMBIFIED_PIGLIN_HEAD, HeadedPiglinHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(AXOLOTL_HEAD, AxolotlHeadEntityModel::getTexturedModelData);

        ItemRendererRegistry.register(HeadedItems.VILLAGER_HEAD);
        ItemRendererRegistry.register(HeadedItems.EVOKER_HEAD);
        ItemRendererRegistry.register(HeadedItems.VINDICATOR_HEAD);
        ItemRendererRegistry.register(HeadedItems.PILLAGER_HEAD);
        ItemRendererRegistry.register(HeadedItems.ZOMBIE_VILLAGER_HEAD);
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


        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper.register(new HeadedHeadFeatureRenderer(entityRenderer, context.getModelLoader())));
    }
}
