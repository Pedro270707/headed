package net.pedroricardo.headed.client.render.block.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public abstract class HeadedSkullBlockEntityModel extends Model {
    public HeadedSkullBlockEntityModel() {
        super(RenderLayer::getEntityTranslucent);
    }

    public abstract void setHeadRotation(float animationProgress, float yaw, float pitch);

    public float[] getHeadSizeInPixels() {
        return new float[] {8, 8, 8};
    }
}