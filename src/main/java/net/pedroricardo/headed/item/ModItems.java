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
import net.pedroricardo.headed.block.ModBlocks;

public class ModItems {

    public static final Item VILLAGER_HEAD = registerItem("villager_head", new VerticallyAttachableBlockItem(ModBlocks.VILLAGER_HEAD, ModBlocks.VILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item EVOKER_HEAD = registerItem("evoker_head", new VerticallyAttachableBlockItem(ModBlocks.EVOKER_HEAD, ModBlocks.EVOKER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item VINDICATOR_HEAD = registerItem("vindicator_head", new VerticallyAttachableBlockItem(ModBlocks.VINDICATOR_HEAD, ModBlocks.VINDICATOR_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item PILLAGER_HEAD = registerItem("pillager_head", new VerticallyAttachableBlockItem(ModBlocks.PILLAGER_HEAD, ModBlocks.PILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item ZOMBIE_VILLAGER_HEAD = registerItem("zombie_villager_head", new VerticallyAttachableBlockItem(ModBlocks.ZOMBIE_VILLAGER_HEAD, ModBlocks.ZOMBIE_VILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item ILLUSIONER_HEAD = registerItem("illusioner_head", new VerticallyAttachableBlockItem(ModBlocks.ILLUSIONER_HEAD, ModBlocks.ILLUSIONER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item SHEEP_HEAD = registerItem("sheep_head", new VerticallyAttachableBlockItem(ModBlocks.SHEEP_HEAD, ModBlocks.SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item WHITE_SHEEP_HEAD = registerItem("white_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.WHITE_SHEEP_HEAD, ModBlocks.WHITE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item ORANGE_SHEEP_HEAD = registerItem("orange_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.ORANGE_SHEEP_HEAD, ModBlocks.ORANGE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item MAGENTA_SHEEP_HEAD = registerItem("magenta_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.MAGENTA_SHEEP_HEAD, ModBlocks.MAGENTA_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item LIGHT_BLUE_SHEEP_HEAD = registerItem("light_blue_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.LIGHT_BLUE_SHEEP_HEAD, ModBlocks.LIGHT_BLUE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item YELLOW_SHEEP_HEAD = registerItem("yellow_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.YELLOW_SHEEP_HEAD, ModBlocks.YELLOW_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item LIME_SHEEP_HEAD = registerItem("lime_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.LIME_SHEEP_HEAD, ModBlocks.LIME_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item PINK_SHEEP_HEAD = registerItem("pink_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.PINK_SHEEP_HEAD, ModBlocks.PINK_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item GRAY_SHEEP_HEAD = registerItem("gray_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.GRAY_SHEEP_HEAD, ModBlocks.GRAY_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item LIGHT_GRAY_SHEEP_HEAD = registerItem("light_gray_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.LIGHT_GRAY_SHEEP_HEAD, ModBlocks.LIGHT_GRAY_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item CYAN_SHEEP_HEAD = registerItem("cyan_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.CYAN_SHEEP_HEAD, ModBlocks.CYAN_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item PURPLE_SHEEP_HEAD = registerItem("purple_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.PURPLE_SHEEP_HEAD, ModBlocks.PURPLE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BLUE_SHEEP_HEAD = registerItem("blue_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.BLUE_SHEEP_HEAD, ModBlocks.BLUE_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BROWN_SHEEP_HEAD = registerItem("brown_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.BROWN_SHEEP_HEAD, ModBlocks.BROWN_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item GREEN_SHEEP_HEAD = registerItem("green_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.GREEN_SHEEP_HEAD, ModBlocks.GREEN_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item RED_SHEEP_HEAD = registerItem("red_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.RED_SHEEP_HEAD, ModBlocks.RED_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item BLACK_SHEEP_HEAD = registerItem("black_sheep_head", new VerticallyAttachableBlockItem(ModBlocks.BLACK_SHEEP_HEAD, ModBlocks.BLACK_SHEEP_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item ALLAY_HEAD = registerItem("allay_head", new VerticallyAttachableBlockItem(ModBlocks.ALLAY_HEAD, ModBlocks.ALLAY_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item VEX_HEAD = registerItem("vex_head", new VerticallyAttachableBlockItem(ModBlocks.VEX_HEAD, ModBlocks.VEX_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
    public static final Item PIGLIN_BRUTE_HEAD = registerItem("piglin_brute_head", new VerticallyAttachableBlockItem(ModBlocks.PIGLIN_BRUTE_HEAD, ModBlocks.PIGLIN_BRUTE_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));
    public static final Item ZOMBIFIED_PIGLIN_HEAD = registerItem("zombified_piglin_head", new VerticallyAttachableBlockItem(ModBlocks.ZOMBIFIED_PIGLIN_HEAD, ModBlocks.ZOMBIFIED_PIGLIN_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON).equipmentSlot(stack -> EquipmentSlot.HEAD), Direction.DOWN));

    protected static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Headed.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Headed.LOGGER.debug("Registering Headed items");
    }
}
