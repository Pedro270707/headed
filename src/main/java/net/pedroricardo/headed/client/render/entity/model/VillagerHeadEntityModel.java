package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.pedroricardo.headed.client.render.block.entity.ModSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class VillagerHeadEntityModel extends ModSkullBlockEntityModel {
    private final ModelPart head;
    private final ModelPart nose;

    public VillagerHeadEntityModel(ModelPart root) {
        this.head = root.getChild("head");
        this.nose = this.head.getChild("nose");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData2 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid("head",-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F), ModelTransform.NONE);
        modelPartData2.addChild("nose", ModelPartBuilder.create().uv(24, 0).cuboid("nose", -1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F), ModelTransform.pivot(0.0F, -2.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * 0.017453292F;
        this.head.pitch = pitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}