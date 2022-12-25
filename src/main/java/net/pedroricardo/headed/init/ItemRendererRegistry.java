package net.pedroricardo.headed.init;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.item.Item;
import net.pedroricardo.headed.client.render.item.HeadedSkullItemRenderer;
import org.jetbrains.annotations.NotNull;

public class ItemRendererRegistry {
    public static <T extends Item> T register(@NotNull T item) {
        BuiltinItemRendererRegistry.INSTANCE.register(item, new HeadedSkullItemRenderer());
        return item;
    }
}
