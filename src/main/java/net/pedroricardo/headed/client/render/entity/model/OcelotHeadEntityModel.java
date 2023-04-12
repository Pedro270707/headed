package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class OcelotHeadEntityModel extends HeadedSkullBlockEntityModel {
    private final ModelPart head;

    public OcelotHeadEntityModel(ModelPart root) {
        this.head = root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid("main", -2.5F, -4.0F, -2.5F, 5.0F, 4.0F, 5.0F).uv(0, 24).cuboid("nose", -1.5F, -2.001F, -3.5F, 3.0F, 2.0F, 2.0F).uv(0, 10).cuboid("ear1", -2.0F, -5.0F, 0.5F, 1.0F, 1.0F, 2.0F).uv(6, 10).cuboid("ear2", 1.0F, -5.0F, 0.5F, 1.0F, 1.0F, 2.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public float[] getHeadSizeInPixels() {
        return new float[] {5.0f, 4.0f, 5.0f};
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * 0.017453292F;
        this.head.pitch = pitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}