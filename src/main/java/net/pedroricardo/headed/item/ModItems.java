package net.pedroricardo.headed.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.pedroricardo.headed.Headed;

public class ModItems {

    public static final Item TEST_ITEM = registerItem("test_item", new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof().maxCount(16)));

    protected static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Headed.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Headed.LOGGER.debug("Registering Headed items");
    }
}
