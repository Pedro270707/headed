package net.pedroricardo.headed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.block.ModSkullBlock;
import net.pedroricardo.headed.block.entity.ModBlockEntities;
import net.pedroricardo.headed.client.render.block.entity.ModSkullBlockEntityRenderer;
import net.pedroricardo.headed.client.render.entity.model.VillagerHeadEntityModel;
import net.pedroricardo.headed.client.render.item.ModSkullItemRenderer;
import net.pedroricardo.headed.init.ItemRendererRegistry;
import net.pedroricardo.headed.item.ModItems;

@Environment(EnvType.CLIENT)
public class HeadedClient implements ClientModInitializer {
    private static final EntityModelLayer VILLAGER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "villager_head"), "main");
    private static final EntityModelLayer EVOKER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "evoker_head"), "main");
    private static final EntityModelLayer VINDICATOR_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "vindicator_head"), "main");
    private static final EntityModelLayer PILLAGER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "pillager_head"), "main");
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.SKULL, ModSkullBlockEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(VILLAGER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(EVOKER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(VINDICATOR_HEAD, VillagerHeadEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PILLAGER_HEAD, VillagerHeadEntityModel::getTexturedModelData);

        ItemRendererRegistry.register(ModItems.VILLAGER_HEAD);
        ItemRendererRegistry.register(ModItems.EVOKER_HEAD);
        ItemRendererRegistry.register(ModItems.VINDICATOR_HEAD);
        ItemRendererRegistry.register(ModItems.PILLAGER_HEAD);
    }
}
