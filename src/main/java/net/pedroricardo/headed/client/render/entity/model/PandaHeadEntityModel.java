package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class PandaHeadEntityModel extends HeadedSkullBlockEntityModel {
    private final ModelPart head;

    public PandaHeadEntityModel(ModelPart root) {
        this.head = root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 6).cuboid(-6.5F, -10.0F, -4.5F, 13.0F, 10.0F, 9.0F).uv(45, 16).cuboid("nose", -3.5F, -5.0F, -6.5F, 7.0F, 5.0F, 2.0F).uv(52, 25).cuboid("left_ear", 3.5F, -13.0F, -1.5F, 5.0F, 4.0F, 1.0F).uv(52, 25).cuboid("right_ear", -8.5F, -13.0F, -1.5F, 5.0F, 4.0F, 1.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 64);
    }

    public float[] getHeadSizeInPixels() {
        return new float[] {13.0f, 10.0f, 9.0f};
    }
    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * 0.017453292F;
        this.head.pitch = pitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}