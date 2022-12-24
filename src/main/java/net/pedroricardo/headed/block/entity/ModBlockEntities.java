package net.pedroricardo.headed.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.Headed;
import net.pedroricardo.headed.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<ModSkullBlockEntity> SKULL;
    public static void registerBlockEntities() {
        SKULL = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Headed.MOD_ID, "skull"),
                FabricBlockEntityTypeBuilder.create(ModSkullBlockEntity::new, ModBlocks.VILLAGER_HEAD, ModBlocks.VILLAGER_WALL_HEAD,
                        ModBlocks.EVOKER_HEAD, ModBlocks.EVOKER_WALL_HEAD,
                        ModBlocks.VINDICATOR_HEAD, ModBlocks.VINDICATOR_WALL_HEAD,
                        ModBlocks.PILLAGER_HEAD, ModBlocks.PILLAGER_WALL_HEAD,
                        ModBlocks.ZOMBIE_VILLAGER_HEAD, ModBlocks.ZOMBIE_VILLAGER_WALL_HEAD,
                        ModBlocks.ILLUSIONER_HEAD, ModBlocks.ILLUSIONER_WALL_HEAD,
                        ModBlocks.SHEEP_HEAD, ModBlocks.SHEEP_WALL_HEAD,
                        ModBlocks.WHITE_SHEEP_HEAD, ModBlocks.WHITE_SHEEP_WALL_HEAD,
                        ModBlocks.ORANGE_SHEEP_HEAD, ModBlocks.ORANGE_SHEEP_WALL_HEAD,
                        ModBlocks.MAGENTA_SHEEP_HEAD, ModBlocks.MAGENTA_SHEEP_WALL_HEAD,
                        ModBlocks.LIGHT_BLUE_SHEEP_HEAD, ModBlocks.LIGHT_BLUE_SHEEP_WALL_HEAD,
                        ModBlocks.YELLOW_SHEEP_HEAD, ModBlocks.YELLOW_SHEEP_WALL_HEAD,
                        ModBlocks.LIME_SHEEP_HEAD, ModBlocks.LIME_SHEEP_WALL_HEAD,
                        ModBlocks.PINK_SHEEP_HEAD, ModBlocks.PINK_SHEEP_WALL_HEAD,
                        ModBlocks.GRAY_SHEEP_HEAD, ModBlocks.GRAY_SHEEP_WALL_HEAD,
                        ModBlocks.LIGHT_GRAY_SHEEP_HEAD, ModBlocks.LIGHT_GRAY_SHEEP_WALL_HEAD,
                        ModBlocks.CYAN_SHEEP_HEAD, ModBlocks.CYAN_SHEEP_WALL_HEAD,
                        ModBlocks.PURPLE_SHEEP_HEAD, ModBlocks.PURPLE_SHEEP_WALL_HEAD,
                        ModBlocks.BLUE_SHEEP_HEAD, ModBlocks.BLUE_SHEEP_WALL_HEAD,
                        ModBlocks.BROWN_SHEEP_HEAD, ModBlocks.BROWN_SHEEP_WALL_HEAD,
                        ModBlocks.GREEN_SHEEP_HEAD, ModBlocks.GREEN_SHEEP_WALL_HEAD,
                        ModBlocks.RED_SHEEP_HEAD, ModBlocks.RED_SHEEP_WALL_HEAD,
                        ModBlocks.BLACK_SHEEP_HEAD, ModBlocks.BLACK_SHEEP_WALL_HEAD,
                        ModBlocks.ALLAY_HEAD, ModBlocks.ALLAY_WALL_HEAD,
                        ModBlocks.VEX_HEAD, ModBlocks.VEX_WALL_HEAD,
                        ModBlocks.PIGLIN_BRUTE_HEAD, ModBlocks.PIGLIN_BRUTE_WALL_HEAD,
                        ModBlocks.ZOMBIFIED_PIGLIN_HEAD, ModBlocks.ZOMBIFIED_PIGLIN_WALL_HEAD).build(null));
    }
}
