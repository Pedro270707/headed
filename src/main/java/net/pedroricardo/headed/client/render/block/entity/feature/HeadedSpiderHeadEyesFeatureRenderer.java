package net.pedroricardo.headed.client.render.block.entity.feature;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.entity.model.HeadedEntityModelLayers;
import net.pedroricardo.headed.client.render.entity.model.SpiderHeadEntityModel;

public class HeadedSpiderHeadEyesFeatureRenderer extends HeadedSkullEyesFeatureRenderer {

    @Override
    public RenderLayer getEyesTexture() {
        return RenderLayer.getEyes(new Identifier("textures/entity/spider_eyes.png"));
    }

    @Override
    public HeadedSkullBlockEntityModel getModel() {
        return new SpiderHeadEntityModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(HeadedEntityModelLayers.SPIDER_EYES));
    }
}
