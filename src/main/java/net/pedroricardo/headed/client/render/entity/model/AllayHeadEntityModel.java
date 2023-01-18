package net.pedroricardo.headed.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.AllayEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;

@Environment(EnvType.CLIENT)
public class AllayHeadEntityModel extends HeadedSkullBlockEntityModel {
    private final ModelPart root;
    private final ModelPart head;

    public AllayHeadEntityModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        return AllayEntityModel.getTexturedModelData();
    }

    public void setHeadRotation(float animationProgress, float yaw, float pitch) {
        this.head.yaw = yaw * 0.017453292F;
        this.head.pitch = pitch * 0.017453292F;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.translate(0.0F, 0.25F, 0.0F);
        this.head.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}