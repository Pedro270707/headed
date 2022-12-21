package net.pedroricardo.headed.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;
import net.pedroricardo.headed.Headed;
import net.pedroricardo.headed.block.ModBlocks;

public class ModItems {

    public static final Item VILLAGER_HEAD = registerItem("villager_head", new VerticallyAttachableBlockItem(ModBlocks.VILLAGER_HEAD, ModBlocks.VILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item EVOKER_HEAD = registerItem("evoker_head", new VerticallyAttachableBlockItem(ModBlocks.EVOKER_HEAD, ModBlocks.EVOKER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item VINDICATOR_HEAD = registerItem("vindicator_head", new VerticallyAttachableBlockItem(ModBlocks.VINDICATOR_HEAD, ModBlocks.VINDICATOR_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item PILLAGER_HEAD = registerItem("pillager_head", new VerticallyAttachableBlockItem(ModBlocks.PILLAGER_HEAD, ModBlocks.PILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));

    protected static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Headed.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Headed.LOGGER.debug("Registering Headed items");
    }
}
