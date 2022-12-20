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
        SKULL = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Headed.MOD_ID, "skull"), FabricBlockEntityTypeBuilder.create(ModSkullBlockEntity::new, ModBlocks.VILLAGER_HEAD, ModBlocks.VILLAGER_WALL_HEAD).build(null));
    }
}
