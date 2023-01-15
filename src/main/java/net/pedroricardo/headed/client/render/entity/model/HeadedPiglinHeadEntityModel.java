package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class HeadedPiglinHeadEntityModel extends HeadedSkullBlockEntityModel {
    private final ModelPart head;
    private final ModelPart leftEar;
    private final ModelPart rightEar;

    public HeadedPiglinHeadEntityModel(ModelPart root) {
        this.head = root.getChild("head");
        this.leftEar = this.head.getChild("left_ear");
        this.rightEar = this.head.getChild("right_ear");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -8.0F, -4.0F, 10.0F, 8.0F, 8.0F, Dilation.NONE).uv(31, 1).cuboid(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 1.0F, Dilation.NONE).uv(2, 4).cuboid(2.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, Dilation.NONE).uv(2, 0).cuboid(-3.0F, -2.0F, -5.0F, 1.0F, 2.0F, 1.0F, Dilation.NONE), ModelTransform.NONE);
        modelPartData2.addChild("left_ear", ModelPartBuilder.create().uv(51, 6).cuboid(0.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, Dilation.NONE), ModelTransform.of(4.5F, -6.0F, 0.0F, 0.0F, 0.0F, -0.5235988F));
        modelPartData2.addChild("right_ear", ModelPartBuilder.create().uv(39, 6).cuboid(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, Dilation.NONE), ModelTransform.of(-4.5F, -6.0F, 0.0F, 0.0F, 0.0F, 0.5235988F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * 0.017453292F;
        this.head.pitch = pitch * 0.017453292F;
        this.leftEar.roll = (float)(-(Math.cos((animationProgress * 3.1415927F * 0.2F * 1.2F)) + 2.5)) * 0.2F;
        this.rightEar.roll = (float)(Math.cos((animationProgress * 3.1415927F * 0.2F)) + 2.5) * 0.2F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
