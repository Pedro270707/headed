package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class SnowGolemHeadEntityModel extends HeadedSkullBlockEntityModel {
    private final ModelPart root;
    protected final ModelPart head;

    public SnowGolemHeadEntityModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        Dilation dilation = new Dilation(-0.5F);
        modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -7.5F, -4.0F, 8.0F, 8.0F, 8.0F, dilation), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * 0.017453292F;
        this.head.pitch = pitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}