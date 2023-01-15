package net.pedroricardo.headed.client.render.block.entity.feature;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.entity.model.EndermanHeadEntityModel;
import net.pedroricardo.headed.client.render.entity.model.HeadedEntityModelLayers;

public class HeadedEndermanHeadEyesFeatureRenderer extends HeadedSkullEyesFeatureRenderer {

    @Override
    public RenderLayer getEyesTexture() {
        return RenderLayer.getEyes(new Identifier("textures/entity/enderman/enderman_eyes.png"));
    }

    @Override
    public HeadedSkullBlockEntityModel getModel() {
        return new EndermanHeadEntityModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(HeadedEntityModelLayers.ENDERMAN_HEAD));
    }
}
