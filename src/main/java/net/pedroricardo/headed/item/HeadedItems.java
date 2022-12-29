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
    public static final Item POLAR_BEAR_HEAD = registerItem("polar_bear_head", new VerticallyAttachableBlockItem(HeadedBlocks.POLAR_BEAR_HEAD, HeadedBlocks.POLAR_BEAR_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item OCELOT_HEAD = registerItem("ocelot_head", new VerticallyAttachableBlockItem(HeadedBlocks.OCELOT_HEAD, HeadedBlocks.OCELOT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item ALL_BLACK_CAT_HEAD = registerItem("all_black_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.ALL_BLACK_CAT_HEAD, HeadedBlocks.ALL_BLACK_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BLACK_CAT_HEAD = registerItem("black_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.BLACK_CAT_HEAD, HeadedBlocks.BLACK_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BRITISH_SHORTHAIR_CAT_HEAD = registerItem("british_shorthair_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.BRITISH_SHORTHAIR_CAT_HEAD, HeadedBlocks.BRITISH_SHORTHAIR_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item CALICO_CAT_HEAD = registerItem("calico_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.CALICO_CAT_HEAD, HeadedBlocks.CALICO_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item JELLIE_CAT_HEAD = registerItem("jellie_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.JELLIE_CAT_HEAD, HeadedBlocks.JELLIE_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item PERSIAN_CAT_HEAD = registerItem("persian_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.PERSIAN_CAT_HEAD, HeadedBlocks.PERSIAN_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item RAGDOLL_CAT_HEAD = registerItem("ragdoll_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.RAGDOLL_CAT_HEAD, HeadedBlocks.RAGDOLL_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item RED_CAT_HEAD = registerItem("red_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.RED_CAT_HEAD, HeadedBlocks.RED_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item SIAMESE_CAT_HEAD = registerItem("siamese_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.SIAMESE_CAT_HEAD, HeadedBlocks.SIAMESE_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item TABBY_CAT_HEAD = registerItem("tabby_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.TABBY_CAT_HEAD, HeadedBlocks.TABBY_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item WHITE_CAT_HEAD = registerItem("white_cat_head", new VerticallyAttachableBlockItem(HeadedBlocks.WHITE_CAT_HEAD, HeadedBlocks.WHITE_CAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item ENDERMAN_HEAD = registerItem("enderman_head", new VerticallyAttachableBlockItem(HeadedBlocks.ENDERMAN_HEAD, HeadedBlocks.ENDERMAN_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item FOX_HEAD = registerItem("fox_head", new VerticallyAttachableBlockItem(HeadedBlocks.FOX_HEAD, HeadedBlocks.FOX_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item SNOW_FOX_HEAD = registerItem("snow_fox_head", new VerticallyAttachableBlockItem(HeadedBlocks.SNOW_FOX_HEAD, HeadedBlocks.SNOW_FOX_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item IRON_GOLEM_HEAD = registerItem("iron_golem_head", new VerticallyAttachableBlockItem(HeadedBlocks.IRON_GOLEM_HEAD, HeadedBlocks.IRON_GOLEM_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item AGGRESSIVE_PANDA_HEAD = registerItem("aggressive_panda_head", new VerticallyAttachableBlockItem(HeadedBlocks.AGGRESSIVE_PANDA_HEAD, HeadedBlocks.AGGRESSIVE_PANDA_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item BROWN_PANDA_HEAD = registerItem("brown_panda_head", new VerticallyAttachableBlockItem(HeadedBlocks.BROWN_PANDA_HEAD, HeadedBlocks.BROWN_PANDA_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item LAZY_PANDA_HEAD = registerItem("lazy_panda_head", new VerticallyAttachableBlockItem(HeadedBlocks.LAZY_PANDA_HEAD, HeadedBlocks.LAZY_PANDA_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item PANDA_HEAD = registerItem("panda_head", new VerticallyAttachableBlockItem(HeadedBlocks.PANDA_HEAD, HeadedBlocks.PANDA_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item PLAYFUL_PANDA_HEAD = registerItem("playful_panda_head", new VerticallyAttachableBlockItem(HeadedBlocks.PLAYFUL_PANDA_HEAD, HeadedBlocks.PLAYFUL_PANDA_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item WEAK_PANDA_HEAD = registerItem("weak_panda_head", new VerticallyAttachableBlockItem(HeadedBlocks.WEAK_PANDA_HEAD, HeadedBlocks.WEAK_PANDA_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item WORRIED_PANDA_HEAD = registerItem("worried_panda_head", new VerticallyAttachableBlockItem(HeadedBlocks.WORRIED_PANDA_HEAD, HeadedBlocks.WORRIED_PANDA_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));

    protected static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Headed.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Headed.LOGGER.debug("Registering Headed items");
    }
}
