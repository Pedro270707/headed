package net.pedroricardo.headed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.block.entity.ModBlockEntities;
import net.pedroricardo.headed.client.render.block.entity.ModSkullBlockEntityRenderer;
import net.pedroricardo.headed.client.render.entity.model.VillagerHeadEntityModel;

public class HeadedClient implements ClientModInitializer {
    public static final EntityModelLayer VILLAGER_HEAD = new EntityModelLayer(new Identifier(Headed.MOD_ID, "villager_head"), "main");
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntities.SKULL, ModSkullBlockEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(VILLAGER_HEAD, VillagerHeadEntityModel::getTexturedModelData);
    }
}
