package net.pedroricardo.headed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.Deadmau5FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.block.entity.ModBlockEntities;
import net.pedroricardo.headed.client.render.block.entity.ModSkullBlockEntityRenderer;
import net.pedroricardo.headed.client.render.entity.feature.ModHeadFeatureRenderer;
import net.pedroricardo.headed.client.render.entity.model.*;
import net.pedroricardo.headed.init.ItemRendererRegistry;
import net.pedroricardo.headed.item.ModItems;

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

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.SKULL, ModSkullBlockEntityRenderer::new);

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
        EntityModelLayerRegistry.registerModelLayer(PIGLIN_BRUTE_HEAD, ModPiglinHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ZOMBIFIED_PIGLIN_HEAD, ModPiglinHeadEntityModel::getTexturedModelData);

        ItemRendererRegistry.register(ModItems.VILLAGER_HEAD);
        ItemRendererRegistry.register(ModItems.EVOKER_HEAD);
        ItemRendererRegistry.register(ModItems.VINDICATOR_HEAD);
        ItemRendererRegistry.register(ModItems.PILLAGER_HEAD);
        ItemRendererRegistry.register(ModItems.ZOMBIE_VILLAGER_HEAD);
        ItemRendererRegistry.register(ModItems.ILLUSIONER_HEAD);
        ItemRendererRegistry.register(ModItems.SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.WHITE_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.ORANGE_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.MAGENTA_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.LIGHT_BLUE_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.YELLOW_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.LIME_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.PINK_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.GRAY_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.LIGHT_GRAY_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.CYAN_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.PURPLE_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.BLUE_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.BROWN_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.GREEN_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.RED_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.BLACK_SHEEP_HEAD);
        ItemRendererRegistry.register(ModItems.ALLAY_HEAD);
        ItemRendererRegistry.register(ModItems.VEX_HEAD);
        ItemRendererRegistry.register(ModItems.PIGLIN_BRUTE_HEAD);
        ItemRendererRegistry.register(ModItems.ZOMBIFIED_PIGLIN_HEAD);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper.register(new ModHeadFeatureRenderer(entityRenderer, context.getModelLoader())));
    }
}
