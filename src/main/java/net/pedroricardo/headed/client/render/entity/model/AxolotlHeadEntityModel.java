package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class AxolotlHeadEntityModel extends HeadedSkullBlockEntityModel {

    private final ModelPart head;
    private final ModelPart topGills;
    private final ModelPart leftGills;
    private final ModelPart rightGills;

    public AxolotlHeadEntityModel(ModelPart root) {
        this.head = root.getChild("head");
        this.topGills = this.head.getChild("top_gills");
        this.leftGills = this.head.getChild("left_gills");
        this.rightGills = this.head.getChild("right_gills");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        Dilation dilation = new Dilation(0.001F);
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 1).cuboid(-4.0F, -5.0F, -2.5F, 8.0F, 5.0F, 5.0F, dilation), ModelTransform.NONE);
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(3, 37).cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 3.0F, 0.0F, dilation);
        ModelPartBuilder modelPartBuilder2 = ModelPartBuilder.create().uv(0, 40).cuboid(-3.0F, -7.0F, 0.0F, 3.0F, 7.0F, 0.0F, dilation);
        ModelPartBuilder modelPartBuilder3 = ModelPartBuilder.create().uv(11, 40).cuboid(0.0F, -7.0F, 0.0F, 3.0F, 7.0F, 0.0F, dilation);
        modelPartData2.addChild("top_gills", modelPartBuilder, ModelTransform.of(0.0F, -5.0F, 1.5F, 0.3926991F, 0, 0));
        modelPartData2.addChild("left_gills", modelPartBuilder2, ModelTransform.of(-4.0F, 0.0F, 1.5F, 0.0F, -0.3926991F, 0.0F));
        modelPartData2.addChild("right_gills", modelPartBuilder3, ModelTransform.of(4.0F, 0.0F, 1.5F, 0.0F, 0.3926991F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    private float lerpAngleDegrees(float start, float end) {
        return this.lerpAngleDegrees(0.05F, start, end);
    }

    private float lerpAngleDegrees(float delta, float start, float end) {
        return MathHelper.lerpAngleDegrees(delta, start, end);
    }

    public float[] getHeadSizeInPixels() {
        return new float[] {8, 5, 5};
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        float f = animationProgress * 0.11F;
//        float g = MathHelper.cos(f);
        this.head.pitch = pitch * 0.017453292F;
        this.head.yaw = yaw * 0.017453292F;
//        this.topGills.pitch = this.lerpAngleDegrees(this.topGills.pitch, 0.6F - 0.08F * (g * g + 2.0F * MathHelper.sin(f)));
//        this.leftGills.yaw = this.lerpAngleDegrees(this.leftGills.yaw, -this.topGills.pitch);
//        this.rightGills.yaw = this.lerpAngleDegrees(this.rightGills.yaw, -this.leftGills.yaw);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}