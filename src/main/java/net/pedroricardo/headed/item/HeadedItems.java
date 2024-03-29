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

import java.util.Arrays;
import java.util.List;

public class HeadedItems {

    public static final Item VILLAGER_HEAD = registerItem("villager_head", new VerticallyAttachableBlockItem(HeadedBlocks.VILLAGER_HEAD, HeadedBlocks.VILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item EVOKER_HEAD = registerItem("evoker_head", new VerticallyAttachableBlockItem(HeadedBlocks.EVOKER_HEAD, HeadedBlocks.EVOKER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item VINDICATOR_HEAD = registerItem("vindicator_head", new VerticallyAttachableBlockItem(HeadedBlocks.VINDICATOR_HEAD, HeadedBlocks.VINDICATOR_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item PILLAGER_HEAD = registerItem("pillager_head", new VerticallyAttachableBlockItem(HeadedBlocks.PILLAGER_HEAD, HeadedBlocks.PILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item ZOMBIE_VILLAGER_HEAD = registerItem("zombie_villager_head", new VerticallyAttachableBlockItem(HeadedBlocks.ZOMBIE_VILLAGER_HEAD, HeadedBlocks.ZOMBIE_VILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item WANDERING_TRADER_HEAD = registerItem("wandering_trader_head", new VerticallyAttachableBlockItem(HeadedBlocks.WANDERING_TRADER_HEAD, HeadedBlocks.WANDERING_TRADER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
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
    public static final Item DROWNED_HEAD = registerItem("drowned_head", new VerticallyAttachableBlockItem(HeadedBlocks.DROWNED_HEAD, HeadedBlocks.DROWNED_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item RED_PARROT_HEAD = registerItem("red_parrot_head", new VerticallyAttachableBlockItem(HeadedBlocks.RED_PARROT_HEAD, HeadedBlocks.RED_PARROT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item GREEN_PARROT_HEAD = registerItem("green_parrot_head", new VerticallyAttachableBlockItem(HeadedBlocks.GREEN_PARROT_HEAD, HeadedBlocks.GREEN_PARROT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BLUE_PARROT_HEAD = registerItem("blue_parrot_head", new VerticallyAttachableBlockItem(HeadedBlocks.BLUE_PARROT_HEAD, HeadedBlocks.BLUE_PARROT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item CYAN_PARROT_HEAD = registerItem("cyan_parrot_head", new VerticallyAttachableBlockItem(HeadedBlocks.CYAN_PARROT_HEAD, HeadedBlocks.CYAN_PARROT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item GRAY_PARROT_HEAD = registerItem("gray_parrot_head", new VerticallyAttachableBlockItem(HeadedBlocks.GRAY_PARROT_HEAD, HeadedBlocks.GRAY_PARROT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item STRAY_SKULL = registerItem("stray_skull", new VerticallyAttachableBlockItem(HeadedBlocks.STRAY_SKULL, HeadedBlocks.STRAY_WALL_SKULL, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item SHULKER_HEAD = registerItem("shulker_head", new VerticallyAttachableBlockItem(HeadedBlocks.SHULKER_HEAD, HeadedBlocks.SHULKER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item HUSK_HEAD = registerItem("husk_head", new VerticallyAttachableBlockItem(HeadedBlocks.HUSK_HEAD, HeadedBlocks.HUSK_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item PIG_HEAD = registerItem("pig_head", new VerticallyAttachableBlockItem(HeadedBlocks.PIG_HEAD, HeadedBlocks.PIG_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item SPIDER_HEAD = registerItem("spider_head", new VerticallyAttachableBlockItem(HeadedBlocks.SPIDER_HEAD, HeadedBlocks.SPIDER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item CAVE_SPIDER_HEAD = registerItem("cave_spider_head", new VerticallyAttachableBlockItem(HeadedBlocks.CAVE_SPIDER_HEAD, HeadedBlocks.CAVE_SPIDER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BLAZE_HEAD = registerItem("blaze_head", new VerticallyAttachableBlockItem(HeadedBlocks.BLAZE_HEAD, HeadedBlocks.BLAZE_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item BLACK_RABBIT_HEAD = registerItem("black_rabbit_head", new VerticallyAttachableBlockItem(HeadedBlocks.BLACK_RABBIT_HEAD, HeadedBlocks.BLACK_RABBIT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BROWN_RABBIT_HEAD = registerItem("brown_rabbit_head", new VerticallyAttachableBlockItem(HeadedBlocks.BROWN_RABBIT_HEAD, HeadedBlocks.BROWN_RABBIT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item EVIL_RABBIT_HEAD = registerItem("the_killer_bunny_head", new VerticallyAttachableBlockItem(HeadedBlocks.EVIL_RABBIT_HEAD, HeadedBlocks.EVIL_RABBIT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.EPIC), Direction.DOWN));
    public static final Item GOLD_RABBIT_HEAD = registerItem("gold_rabbit_head", new VerticallyAttachableBlockItem(HeadedBlocks.GOLD_RABBIT_HEAD, HeadedBlocks.GOLD_RABBIT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item SALT_RABBIT_HEAD = registerItem("salt_rabbit_head", new VerticallyAttachableBlockItem(HeadedBlocks.SALT_RABBIT_HEAD, HeadedBlocks.SALT_RABBIT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item WHITE_RABBIT_HEAD = registerItem("white_rabbit_head", new VerticallyAttachableBlockItem(HeadedBlocks.WHITE_RABBIT_HEAD, HeadedBlocks.WHITE_RABBIT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item WHITE_SPLOTCHED_RABBIT_HEAD = registerItem("white_splotched_rabbit_head", new VerticallyAttachableBlockItem(HeadedBlocks.WHITE_SPLOTCHED_RABBIT_HEAD, HeadedBlocks.WHITE_SPLOTCHED_RABBIT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item TURTLE_HEAD = registerItem("turtle_head", new VerticallyAttachableBlockItem(HeadedBlocks.TURTLE_HEAD, HeadedBlocks.TURTLE_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item WITHER_SKULL = registerItem("wither_skull", new VerticallyAttachableBlockItem(HeadedBlocks.WITHER_SKULL, HeadedBlocks.WITHER_WALL_SKULL, new FabricItemSettings().rarity(Rarity.RARE).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item WOLF_HEAD = registerItem("wolf_head", new VerticallyAttachableBlockItem(HeadedBlocks.WOLF_HEAD, HeadedBlocks.WOLF_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BAT_HEAD = registerItem("bat_head", new VerticallyAttachableBlockItem(HeadedBlocks.BAT_HEAD, HeadedBlocks.BAT_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item WITCH_HEAD = registerItem("witch_head", new VerticallyAttachableBlockItem(HeadedBlocks.WITCH_HEAD, HeadedBlocks.WITCH_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item CHICKEN_HEAD = registerItem("chicken_head", new VerticallyAttachableBlockItem(HeadedBlocks.CHICKEN_HEAD, HeadedBlocks.CHICKEN_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item PHANTOM_HEAD = registerItem("phantom_head", new VerticallyAttachableBlockItem(HeadedBlocks.PHANTOM_HEAD, HeadedBlocks.PHANTOM_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item SNOW_GOLEM_HEAD = registerItem("snow_golem_head", new VerticallyAttachableBlockItem(HeadedBlocks.SNOW_GOLEM_HEAD, HeadedBlocks.SNOW_GOLEM_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));

    public static final List<HeadVariant> AXOLOTL_HEADS = Arrays.asList(
            new HeadVariant(0, HeadedItems.LEUCISTIC_AXOLOTL_HEAD),
            new HeadVariant(1, HeadedItems.BROWN_AXOLOTL_HEAD),
            new HeadVariant(2, HeadedItems.GOLD_AXOLOTL_HEAD),
            new HeadVariant(3, HeadedItems.CYAN_AXOLOTL_HEAD),
            new HeadVariant(4, HeadedItems.BLUE_AXOLOTL_HEAD)
    );

    public record HeadVariant(int variant, Item headItem) {
    }
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Headed.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Headed.LOGGER.debug("Registering Headed items");
    }
}
