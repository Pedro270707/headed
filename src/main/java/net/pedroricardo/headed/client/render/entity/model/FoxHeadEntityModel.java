package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class FoxHeadEntityModel extends HeadedSkullBlockEntityModel {
    private final ModelPart head;

    public FoxHeadEntityModel(ModelPart root) {
        this.head = root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(1, 5).cuboid(-4.0F, -6.0F, -3.0F, 8.0F, 6.0F, 6.0F), ModelTransform.NONE);
        modelPartData2.addChild("right_ear", ModelPartBuilder.create().uv(8, 1).cuboid(-4.0F, -8.0F, -2.0F, 2.0F, 2.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("left_ear", ModelPartBuilder.create().uv(15, 1).cuboid(2.0F, -8.0F, -2.0F, 2.0F, 2.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("nose", ModelPartBuilder.create().uv(6, 18).cuboid(-2.0F, -1.99F, -6.0F, 4.0F, 2.0F, 3.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 48, 32);
    }

    @Override
    public float[] getHeadSizeInPixels() {
        return new float[] {8.0f, 6.0f, 6.0f};
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * 0.017453292F;
        this.head.pitch = pitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}