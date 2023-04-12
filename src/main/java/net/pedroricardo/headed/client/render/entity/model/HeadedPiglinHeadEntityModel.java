package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.PiglinEntityModel;
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
        PiglinEntityModel.addHead(Dilation.NONE, modelData);
        return TexturedModelData.of(modelData, 64, 64);
    }

    public float[] getHeadSizeInPixels() {
        return new float[] {10.0f, 8.0f, 8.0f};
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
