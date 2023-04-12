package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class BatHeadEntityModel extends HeadedSkullBlockEntityModel {
    private final ModelPart head;

    public BatHeadEntityModel(ModelPart root) {
        this.head = root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F), ModelTransform.NONE);
        modelPartData2.addChild("right_ear", ModelPartBuilder.create().uv(24, 0).cuboid(-4.0F, -9.0F, -2.0F, 3.0F, 4.0F, 1.0F), ModelTransform.NONE);
        modelPartData2.addChild("left_ear", ModelPartBuilder.create().uv(24, 0).mirrored().cuboid(1.0F, -9.0F, -2.0F, 3.0F, 4.0F, 1.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 64);
    }

    public float[] getHeadSizeInPixels() {
        return new float[] {2.1f, 2.1f, 2.1f};
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * 0.017453292F;
        this.head.pitch = pitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.scale(0.35F, 0.35F, 0.35F);
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}