package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class ParrotHeadEntityModel extends HeadedSkullBlockEntityModel {
    private final ModelPart head;

    public ParrotHeadEntityModel(ModelPart root) {
        this.head = root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(2, 2).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData2.addChild("head2", ModelPartBuilder.create().uv(10, 0).cuboid(-1.0F, -2.0F, -2.0F, 2.0F, 1.0F, 4.0F), ModelTransform.pivot(0.0F, -2.0F, -1.0F));
        modelPartData2.addChild("beak1", ModelPartBuilder.create().uv(11, 7).cuboid(-0.5F, -2.5F, -0.5F, 1.0F, 2.0F, 1.0F), ModelTransform.pivot(0.0F, -0.5F, -1.5F));
        modelPartData2.addChild("beak2", ModelPartBuilder.create().uv(16, 7).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 1.0F), ModelTransform.pivot(0.0F, -1.75F, -2.45F));
        modelPartData2.addChild("feather", ModelPartBuilder.create().uv(2, 18).cuboid(0.0F, -5.5F, -2.0F, 0.0F, 5.0F, 4.0F), ModelTransform.pivot(0.0F, -2.15F, 0.15F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public float[] getHeadSizeInPixels() {
        return new float[] {2.0f, 3.0f, 2.0f};
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * 0.017453292F;
        this.head.pitch = pitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}