package net.pedroricardo.headed.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;
import net.pedroricardo.headed.Headed;

public class ModBlocks {
    public static final Block VILLAGER_HEAD;
    public static final Block VILLAGER_WALL_HEAD;
    public static final Block EVOKER_HEAD;
    public static final Block EVOKER_WALL_HEAD;
    public static final Block VINDICATOR_HEAD;
    public static final Block VINDICATOR_WALL_HEAD;

    static {
        VILLAGER_HEAD = register("villager_head", new ModSkullBlock(ModSkullBlock.Type.VILLAGER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        VILLAGER_WALL_HEAD = register("villager_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.VILLAGER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(VILLAGER_HEAD)));
        EVOKER_HEAD = register("evoker_head", new ModSkullBlock(ModSkullBlock.Type.EVOKER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        EVOKER_WALL_HEAD = register("evoker_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.EVOKER, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(EVOKER_HEAD)));
        VINDICATOR_HEAD = register("vindicator_head", new ModSkullBlock(ModSkullBlock.Type.VINDICATOR, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F)));
        VINDICATOR_WALL_HEAD = register("vindicator_wall_head", new ModWallSkullBlock(ModSkullBlock.Type.VINDICATOR, AbstractBlock.Settings.of(Material.DECORATION).strength(1.0F).dropsLike(VINDICATOR_HEAD)));
    }

    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Headed.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Registry.register(Registries.ITEM, new Identifier(Headed.MOD_ID, "villager_head"), new VerticallyAttachableBlockItem(VILLAGER_HEAD, VILLAGER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
        Registry.register(Registries.ITEM, new Identifier(Headed.MOD_ID, "evoker_head"), new VerticallyAttachableBlockItem(EVOKER_HEAD, EVOKER_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
        Registry.register(Registries.ITEM, new Identifier(Headed.MOD_ID, "vindicator_head"), new VerticallyAttachableBlockItem(VINDICATOR_HEAD, VINDICATOR_WALL_HEAD, new FabricItemSettings().rarity(Rarity.UNCOMMON), Direction.DOWN));
        Headed.LOGGER.debug("Registering Headed blocks");
    }
}
