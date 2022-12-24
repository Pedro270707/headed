package net.pedroricardo.headed.block;

import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.Headed;

import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final Block VILLAGER_HEAD;
    public static final Block VILLAGER_WALL_HEAD;
    public static final Block EVOKER_HEAD;
    public static final Block EVOKER_WALL_HEAD;
    public static final Block VINDICATOR_HEAD;
    public static final Block VINDICATOR_WALL_HEAD;
    public static final Block PILLAGER_HEAD;
    public static final Block PILLAGER_WALL_HEAD;
    public static final Block ZOMBIE_VILLAGER_HEAD;
    public static final Block ZOMBIE_VILLAGER_WALL_HEAD;
    public static final Block ILLUSIONER_HEAD;
    public static final Block ILLUSIONER_WALL_HEAD;
    public static final Block SHEEP_HEAD;
    public static final Block SHEEP_WALL_HEAD;
    public static final Block WHITE_SHEEP_HEAD;
    public static final Block WHITE_SHEEP_WALL_HEAD;
    public static final Block ORANGE_SHEEP_HEAD;
    public static final Block ORANGE_SHEEP_WALL_HEAD;
    public static final Block MAGENTA_SHEEP_HEAD;
    public static final Block MAGENTA_SHEEP_WALL_HEAD;
    public static final Block LIGHT_BLUE_SHEEP_HEAD;
    public static final Block LIGHT_BLUE_SHEEP_WALL_HEAD;
    public static final Block YELLOW_SHEEP_HEAD;
    public static final Block YELLOW_SHEEP_WALL_HEAD;
    public static final Block LIME_SHEEP_HEAD;
    public static final Block LIME_SHEEP_WALL_HEAD;
    public static final Block PINK_SHEEP_HEAD;
    public static final Block PINK_SHEEP_WALL_HEAD;
    public static final Block GRAY_SHEEP_HEAD;
    public static final Block GRAY_SHEEP_WALL_HEAD;
    public static final Block LIGHT_GRAY_SHEEP_HEAD;
    public static final Block LIGHT_GRAY_SHEEP_WALL_HEAD;
    public static final Block CYAN_SHEEP_HEAD;
    public static final Block CYAN_SHEEP_WALL_HEAD;
    public static final Block PURPLE_SHEEP_HEAD;
    public static final Block PURPLE_SHEEP_WALL_HEAD;
    public static final Block BLUE_SHEEP_HEAD;
    public static final Block BLUE_SHEEP_WALL_HEAD;
    public static final Block BROWN_SHEEP_HEAD;
    public static final Block BROWN_SHEEP_WALL_HEAD;
    public static final Block GREEN_SHEEP_HEAD;
    public static final Block GREEN_SHEEP_WALL_HEAD;
    public static final Block RED_SHEEP_HEAD;
    public static final Block RED_SHEEP_WALL_HEAD;
    public static final Block BLACK_SHEEP_HEAD;
    public static final Block BLACK_SHEEP_WALL_HEAD;
    public static final Block ALLAY_HEAD;
    public static final Block ALLAY_WALL_HEAD;
    public static final Block VEX_HEAD;
    public static final Block VEX_WALL_HEAD;
    public static final Block PIGLIN_BRUTE_HEAD;
    public static final Block PIGLIN_BRUTE_WALL_HEAD;
    public static final Block ZOMBIFIED_PIGLIN_HEAD;
    public static final Block ZOMBIFIED_PIGLIN_WALL_HEAD;

    static {
        VILLAGER_HEAD = register("villager_head", new ModSkullBlock(ModSkullBlock.Type.VILLAGER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        VILLAGER_WALL_HEAD = register("villager_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.VILLAGER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(VILLAGER_HEAD)));
        EVOKER_HEAD = register("evoker_head", new ModSkullBlock(ModSkullBlock.Type.EVOKER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        EVOKER_WALL_HEAD = register("evoker_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.EVOKER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(EVOKER_HEAD)));
        VINDICATOR_HEAD = register("vindicator_head", new ModSkullBlock(ModSkullBlock.Type.VINDICATOR, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        VINDICATOR_WALL_HEAD = register("vindicator_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.VINDICATOR, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(VINDICATOR_HEAD)));
        PILLAGER_HEAD = register("pillager_head", new ModSkullBlock(ModSkullBlock.Type.PILLAGER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        PILLAGER_WALL_HEAD = register("pillager_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.PILLAGER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(PILLAGER_HEAD)));
        ZOMBIE_VILLAGER_HEAD = register("zombie_villager_head", new ModSkullBlock(ModSkullBlock.Type.ZOMBIE_VILLAGER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        ZOMBIE_VILLAGER_WALL_HEAD = register("zombie_villager_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.ZOMBIE_VILLAGER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(ZOMBIE_VILLAGER_HEAD)));
        SHEEP_HEAD = register("sheep_head", new ModSkullBlock(ModSkullBlock.Type.SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        SHEEP_WALL_HEAD = register("sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(SHEEP_HEAD)));
        WHITE_SHEEP_HEAD = register("white_sheep_head", new ModSkullBlock(ModSkullBlock.Type.WHITE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        WHITE_SHEEP_WALL_HEAD = register("white_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.WHITE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(WHITE_SHEEP_HEAD)));
        ORANGE_SHEEP_HEAD = register("orange_sheep_head", new ModSkullBlock(ModSkullBlock.Type.ORANGE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        ORANGE_SHEEP_WALL_HEAD = register("orange_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.ORANGE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(ORANGE_SHEEP_HEAD)));
        MAGENTA_SHEEP_HEAD = register("magenta_sheep_head", new ModSkullBlock(ModSkullBlock.Type.MAGENTA_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        MAGENTA_SHEEP_WALL_HEAD = register("magenta_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.MAGENTA_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(MAGENTA_SHEEP_HEAD)));
        LIGHT_BLUE_SHEEP_HEAD = register("light_blue_sheep_head", new ModSkullBlock(ModSkullBlock.Type.LIGHT_BLUE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        LIGHT_BLUE_SHEEP_WALL_HEAD = register("light_blue_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.LIGHT_BLUE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(LIGHT_BLUE_SHEEP_HEAD)));
        YELLOW_SHEEP_HEAD = register("yellow_sheep_head", new ModSkullBlock(ModSkullBlock.Type.YELLOW_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        YELLOW_SHEEP_WALL_HEAD = register("yellow_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.YELLOW_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(YELLOW_SHEEP_HEAD)));
        LIME_SHEEP_HEAD = register("lime_sheep_head", new ModSkullBlock(ModSkullBlock.Type.LIME_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        LIME_SHEEP_WALL_HEAD = register("lime_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.LIME_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(LIME_SHEEP_HEAD)));
        PINK_SHEEP_HEAD = register("pink_sheep_head", new ModSkullBlock(ModSkullBlock.Type.PINK_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        PINK_SHEEP_WALL_HEAD = register("pink_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.PINK_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(PINK_SHEEP_HEAD)));
        GRAY_SHEEP_HEAD = register("gray_sheep_head", new ModSkullBlock(ModSkullBlock.Type.GRAY_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        GRAY_SHEEP_WALL_HEAD = register("gray_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.GRAY_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(GRAY_SHEEP_HEAD)));
        LIGHT_GRAY_SHEEP_HEAD = register("light_gray_sheep_head", new ModSkullBlock(ModSkullBlock.Type.LIGHT_GRAY_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        LIGHT_GRAY_SHEEP_WALL_HEAD = register("light_gray_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.LIGHT_GRAY_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(LIGHT_GRAY_SHEEP_HEAD)));
        CYAN_SHEEP_HEAD = register("cyan_sheep_head", new ModSkullBlock(ModSkullBlock.Type.CYAN_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        CYAN_SHEEP_WALL_HEAD = register("cyan_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.CYAN_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(CYAN_SHEEP_HEAD)));
        PURPLE_SHEEP_HEAD = register("purple_sheep_head", new ModSkullBlock(ModSkullBlock.Type.PURPLE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        PURPLE_SHEEP_WALL_HEAD = register("purple_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.PURPLE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(PURPLE_SHEEP_HEAD)));
        BLUE_SHEEP_HEAD = register("blue_sheep_head", new ModSkullBlock(ModSkullBlock.Type.BLUE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        BLUE_SHEEP_WALL_HEAD = register("blue_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.BLUE_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(BLUE_SHEEP_HEAD)));
        BROWN_SHEEP_HEAD = register("brown_sheep_head", new ModSkullBlock(ModSkullBlock.Type.BROWN_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        BROWN_SHEEP_WALL_HEAD = register("brown_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.BROWN_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(BROWN_SHEEP_HEAD)));
        GREEN_SHEEP_HEAD = register("green_sheep_head", new ModSkullBlock(ModSkullBlock.Type.GREEN_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        GREEN_SHEEP_WALL_HEAD = register("green_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.GREEN_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(GREEN_SHEEP_HEAD)));
        RED_SHEEP_HEAD = register("red_sheep_head", new ModSkullBlock(ModSkullBlock.Type.RED_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        RED_SHEEP_WALL_HEAD = register("red_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.RED_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(RED_SHEEP_HEAD)));
        BLACK_SHEEP_HEAD = register("black_sheep_head", new ModSkullBlock(ModSkullBlock.Type.BLACK_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        BLACK_SHEEP_WALL_HEAD = register("black_sheep_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.BLACK_SHEEP, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(BLACK_SHEEP_HEAD)));
        ALLAY_HEAD = register("allay_head", new ModSkullBlock(ModSkullBlock.Type.ALLAY, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).luminance(state -> 15)));
        ALLAY_WALL_HEAD = register("allay_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.ALLAY, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).luminance(state -> 15).dropsLike(ALLAY_HEAD)));
        VEX_HEAD = register("vex_head", new ModSkullBlock(ModSkullBlock.Type.VEX, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        VEX_WALL_HEAD = register("vex_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.VEX, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(VEX_HEAD)));
        ILLUSIONER_HEAD = register("illusioner_head", new ModSkullBlock(ModSkullBlock.Type.ILLUSIONER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        ILLUSIONER_WALL_HEAD = register("illusioner_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.ILLUSIONER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(ILLUSIONER_HEAD)));
        PIGLIN_BRUTE_HEAD = register("piglin_brute_head", new ModSkullBlock(ModSkullBlock.Type.PIGLIN_BRUTE, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        PIGLIN_BRUTE_WALL_HEAD = register("piglin_brute_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.PIGLIN_BRUTE, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(PIGLIN_BRUTE_HEAD)));
        ZOMBIFIED_PIGLIN_HEAD = register("zombified_piglin_head", new ModSkullBlock(ModSkullBlock.Type.ZOMBIFIED_PIGLIN, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        ZOMBIFIED_PIGLIN_WALL_HEAD = register("zombified_piglin_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.ZOMBIFIED_PIGLIN, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(ZOMBIFIED_PIGLIN_HEAD)));
    }

    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Headed.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Headed.LOGGER.debug("Registering Headed blocks");
    }
}
