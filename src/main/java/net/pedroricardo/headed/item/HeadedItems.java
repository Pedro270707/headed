package net.pedroricardo.headed.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;
import net.pedroricardo.headed.Headed;
import net.pedroricardo.headed.block.HeadedBlocks;

public class HeadedItems {

    public static final Item VILLAGER_HEAD = registerItem("villager_head", new VerticallyAttachableBlockItem(HeadedBlocks.VILLAGER_HEAD, HeadedBlocks.VILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item EVOKER_HEAD = registerItem("evoker_head", new VerticallyAttachableBlockItem(HeadedBlocks.EVOKER_HEAD, HeadedBlocks.EVOKER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item VINDICATOR_HEAD = registerItem("vindicator_head", new VerticallyAttachableBlockItem(HeadedBlocks.VINDICATOR_HEAD, HeadedBlocks.VINDICATOR_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item PILLAGER_HEAD = registerItem("pillager_head", new VerticallyAttachableBlockItem(HeadedBlocks.PILLAGER_HEAD, HeadedBlocks.PILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item ZOMBIE_VILLAGER_HEAD = registerItem("zombie_villager_head", new VerticallyAttachableBlockItem(HeadedBlocks.ZOMBIE_VILLAGER_HEAD, HeadedBlocks.ZOMBIE_VILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item ILLUSIONER_HEAD = registerItem("illusioner_head", new VerticallyAttachableBlockItem(HeadedBlocks.ILLUSIONER_HEAD, HeadedBlocks.ILLUSIONER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item SHEEP_HEAD = registerItem("sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.SHEEP_HEAD, HeadedBlocks.SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item WHITE_SHEEP_HEAD = registerItem("white_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.WHITE_SHEEP_HEAD, HeadedBlocks.WHITE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item ORANGE_SHEEP_HEAD = registerItem("orange_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.ORANGE_SHEEP_HEAD, HeadedBlocks.ORANGE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item MAGENTA_SHEEP_HEAD = registerItem("magenta_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.MAGENTA_SHEEP_HEAD, HeadedBlocks.MAGENTA_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item LIGHT_BLUE_SHEEP_HEAD = registerItem("light_blue_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.LIGHT_BLUE_SHEEP_HEAD, HeadedBlocks.LIGHT_BLUE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item YELLOW_SHEEP_HEAD = registerItem("yellow_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.YELLOW_SHEEP_HEAD, HeadedBlocks.YELLOW_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item LIME_SHEEP_HEAD = registerItem("lime_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.LIME_SHEEP_HEAD, HeadedBlocks.LIME_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item PINK_SHEEP_HEAD = registerItem("pink_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.PINK_SHEEP_HEAD, HeadedBlocks.PINK_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item GRAY_SHEEP_HEAD = registerItem("gray_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.GRAY_SHEEP_HEAD, HeadedBlocks.GRAY_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item LIGHT_GRAY_SHEEP_HEAD = registerItem("light_gray_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.LIGHT_GRAY_SHEEP_HEAD, HeadedBlocks.LIGHT_GRAY_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item CYAN_SHEEP_HEAD = registerItem("cyan_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.CYAN_SHEEP_HEAD, HeadedBlocks.CYAN_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item PURPLE_SHEEP_HEAD = registerItem("purple_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.PURPLE_SHEEP_HEAD, HeadedBlocks.PURPLE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BLUE_SHEEP_HEAD = registerItem("blue_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.BLUE_SHEEP_HEAD, HeadedBlocks.BLUE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BROWN_SHEEP_HEAD = registerItem("brown_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.BROWN_SHEEP_HEAD, HeadedBlocks.BROWN_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item GREEN_SHEEP_HEAD = registerItem("green_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.GREEN_SHEEP_HEAD, HeadedBlocks.GREEN_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item RED_SHEEP_HEAD = registerItem("red_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.RED_SHEEP_HEAD, HeadedBlocks.RED_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BLACK_SHEEP_HEAD = registerItem("black_sheep_head", new VerticallyAttachableBlockItem(HeadedBlocks.BLACK_SHEEP_HEAD, HeadedBlocks.BLACK_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item ALLAY_HEAD = registerItem("allay_head", new VerticallyAttachableBlockItem(HeadedBlocks.ALLAY_HEAD, HeadedBlocks.ALLAY_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item VEX_HEAD = registerItem("vex_head", new VerticallyAttachableBlockItem(HeadedBlocks.VEX_HEAD, HeadedBlocks.VEX_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item PIGLIN_BRUTE_HEAD = registerItem("piglin_brute_head", new VerticallyAttachableBlockItem(HeadedBlocks.PIGLIN_BRUTE_HEAD, HeadedBlocks.PIGLIN_BRUTE_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item ZOMBIFIED_PIGLIN_HEAD = registerItem("zombified_piglin_head", new VerticallyAttachableBlockItem(HeadedBlocks.ZOMBIFIED_PIGLIN_HEAD, HeadedBlocks.ZOMBIFIED_PIGLIN_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item LEUCISTIC_AXOLOTL_HEAD = registerItem("leucistic_axolotl_head", new VerticallyAttachableBlockItem(HeadedBlocks.LEUCISTIC_AXOLOTL_HEAD, HeadedBlocks.LEUCISTIC_AXOLOTL_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BROWN_AXOLOTL_HEAD = registerItem("brown_axolotl_head", new VerticallyAttachableBlockItem(HeadedBlocks.BROWN_AXOLOTL_HEAD, HeadedBlocks.BROWN_AXOLOTL_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item CYAN_AXOLOTL_HEAD = registerItem("cyan_axolotl_head", new VerticallyAttachableBlockItem(HeadedBlocks.CYAN_AXOLOTL_HEAD, HeadedBlocks.CYAN_AXOLOTL_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item GOLD_AXOLOTL_HEAD = registerItem("gold_axolotl_head", new VerticallyAttachableBlockItem(HeadedBlocks.GOLD_AXOLOTL_HEAD, HeadedBlocks.GOLD_AXOLOTL_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BLUE_AXOLOTL_HEAD = registerItem("blue_axolotl_head", new VerticallyAttachableBlockItem(HeadedBlocks.BLUE_AXOLOTL_HEAD, HeadedBlocks.BLUE_AXOLOTL_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item COW_HEAD = registerItem("cow_head", new VerticallyAttachableBlockItem(HeadedBlocks.COW_HEAD, HeadedBlocks.COW_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BROWN_MOOSHROOM_HEAD = registerItem("brown_mooshroom_head", new VerticallyAttachableBlockItem(HeadedBlocks.BROWN_MOOSHROOM_HEAD, HeadedBlocks.BROWN_MOOSHROOM_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item RED_MOOSHROOM_HEAD = registerItem("red_mooshroom_head", new VerticallyAttachableBlockItem(HeadedBlocks.RED_MOOSHROOM_HEAD, HeadedBlocks.RED_MOOSHROOM_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));

    protected static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Headed.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Headed.LOGGER.debug("Registering Headed items");
    }
}
