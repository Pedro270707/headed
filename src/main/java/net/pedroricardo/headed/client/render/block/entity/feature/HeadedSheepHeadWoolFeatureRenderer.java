package net.pedroricardo.headed.client.render.block.entity.feature;

import com.google.common.collect.Maps;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Direction;
import net.pedroricardo.headed.block.HeadedSkullBlock;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullBlockEntityModel;
import net.pedroricardo.headed.client.render.block.entity.HeadedSkullRenderManager;
import net.pedroricardo.headed.client.render.entity.model.HeadedEntityModelLayers;
import net.pedroricardo.headed.client.render.entity.model.SheepHeadWoolEntityModel;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class HeadedSheepHeadWoolFeatureRenderer implements HeadedSkullFeatureRenderer {

    private static final Map<HeadedSkullBlock.Type, DyeColor> SHEEP_DYE_COLORS = Util.make(Maps.newHashMap(), (map) -> {
        map.put(HeadedSkullBlock.Type.WHITE_SHEEP, DyeColor.WHITE);
        map.put(HeadedSkullBlock.Type.ORANGE_SHEEP, DyeColor.ORANGE);
        map.put(HeadedSkullBlock.Type.MAGENTA_SHEEP, DyeColor.MAGENTA);
        map.put(HeadedSkullBlock.Type.LIGHT_BLUE_SHEEP, DyeColor.LIGHT_BLUE);
        map.put(HeadedSkullBlock.Type.YELLOW_SHEEP, DyeColor.YELLOW);
        map.put(HeadedSkullBlock.Type.LIME_SHEEP, DyeColor.LIME);
        map.put(HeadedSkullBlock.Type.PINK_SHEEP, DyeColor.PINK);
        map.put(HeadedSkullBlock.Type.GRAY_SHEEP, DyeColor.GRAY);
        map.put(HeadedSkullBlock.Type.LIGHT_GRAY_SHEEP, DyeColor.LIGHT_GRAY);
        map.put(HeadedSkullBlock.Type.CYAN_SHEEP, DyeColor.CYAN);
        map.put(HeadedSkullBlock.Type.PURPLE_SHEEP, DyeColor.PURPLE);
        map.put(HeadedSkullBlock.Type.BLUE_SHEEP, DyeColor.BLUE);
        map.put(HeadedSkullBlock.Type.BROWN_SHEEP, DyeColor.BROWN);
        map.put(HeadedSkullBlock.Type.GREEN_SHEEP, DyeColor.GREEN);
        map.put(HeadedSkullBlock.Type.RED_SHEEP, DyeColor.RED);
        map.put(HeadedSkullBlock.Type.BLACK_SHEEP, DyeColor.BLACK);
    });

    @Override
    public void renderFeature(HeadedSkullBlock.Type skullType, @Nullable Direction direction, float yaw, float deltaTime, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, HeadedSkullBlockEntity blockEntity, ItemStack itemStack) {
        float s;
        float t;
        float u;
        String skullName;
        if (blockEntity != null) {
            skullName = Optional.ofNullable(blockEntity.getCustomName()).orElse(Text.of("")).getString();
        } else {
            skullName = Optional.ofNullable(itemStack.getName()).orElse(Text.of("")).getString();
        }
        if (skullName.equals("jeb_")) {
            int time;
            if (MinecraftClient.getInstance().world == null) {
                time = 0;
            } else {
                time = (int)MinecraftClient.getInstance().world.getTime();
            }
            int n = time / 25 + 1;
            int o = DyeColor.values().length;
            int p = n % o;
            int q = (n + 1) % o;
            float r = (float)(time % 25) / 25.0F;
            float[] fs = SheepEntity.getRgbColor(DyeColor.byId(p));
            float[] gs = SheepEntity.getRgbColor(DyeColor.byId(q));
            s = fs[0] * (1.0F - r) + gs[0] * r;
            t = fs[1] * (1.0F - r) + gs[1] * r;
            u = fs[2] * (1.0F - r) + gs[2] * r;
        } else {
            float[] hs = SheepEntity.getRgbColor(SHEEP_DYE_COLORS.get(skullType));
            s = hs[0];
            t = hs[1];
            u = hs[2];
        }
        RenderLayer renderLayer = RenderLayer.getEntityCutoutNoCullZOffset(new Identifier("textures/entity/sheep/sheep_fur.png"));
        HeadedSkullBlockEntityModel model = new SheepHeadWoolEntityModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(HeadedEntityModelLayers.SHEEP_WOOL));

        HeadedSkullRenderManager.renderSkull(skullType, direction, yaw, deltaTime, matrices, vertexConsumers, light, model, renderLayer, s, t, u);
    }
}
