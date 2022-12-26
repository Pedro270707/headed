package net.pedroricardo.headed.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.Headed;
import net.pedroricardo.headed.block.HeadedBlocks;

public class HeadedBlockEntities {
    public static BlockEntityType<HeadedSkullBlockEntity> SKULL;
    public static void registerBlockEntities() {
        SKULL = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Headed.MOD_ID, "skull"),
                FabricBlockEntityTypeBuilder.create(HeadedSkullBlockEntity::new, HeadedBlocks.VILLAGER_HEAD, HeadedBlocks.VILLAGER_WALL_HEAD,
                        HeadedBlocks.EVOKER_HEAD, HeadedBlocks.EVOKER_WALL_HEAD,
                        HeadedBlocks.VINDICATOR_HEAD, HeadedBlocks.VINDICATOR_WALL_HEAD,
                        HeadedBlocks.PILLAGER_HEAD, HeadedBlocks.PILLAGER_WALL_HEAD,
                        HeadedBlocks.ZOMBIE_VILLAGER_HEAD, HeadedBlocks.ZOMBIE_VILLAGER_WALL_HEAD,
                        HeadedBlocks.ILLUSIONER_HEAD, HeadedBlocks.ILLUSIONER_WALL_HEAD,
                        HeadedBlocks.SHEEP_HEAD, HeadedBlocks.SHEEP_WALL_HEAD,
                        HeadedBlocks.WHITE_SHEEP_HEAD, HeadedBlocks.WHITE_SHEEP_WALL_HEAD,
                        HeadedBlocks.ORANGE_SHEEP_HEAD, HeadedBlocks.ORANGE_SHEEP_WALL_HEAD,
                        HeadedBlocks.MAGENTA_SHEEP_HEAD, HeadedBlocks.MAGENTA_SHEEP_WALL_HEAD,
                        HeadedBlocks.LIGHT_BLUE_SHEEP_HEAD, HeadedBlocks.LIGHT_BLUE_SHEEP_WALL_HEAD,
                        HeadedBlocks.YELLOW_SHEEP_HEAD, HeadedBlocks.YELLOW_SHEEP_WALL_HEAD,
                        HeadedBlocks.LIME_SHEEP_HEAD, HeadedBlocks.LIME_SHEEP_WALL_HEAD,
                        HeadedBlocks.PINK_SHEEP_HEAD, HeadedBlocks.PINK_SHEEP_WALL_HEAD,
                        HeadedBlocks.GRAY_SHEEP_HEAD, HeadedBlocks.GRAY_SHEEP_WALL_HEAD,
                        HeadedBlocks.LIGHT_GRAY_SHEEP_HEAD, HeadedBlocks.LIGHT_GRAY_SHEEP_WALL_HEAD,
                        HeadedBlocks.CYAN_SHEEP_HEAD, HeadedBlocks.CYAN_SHEEP_WALL_HEAD,
                        HeadedBlocks.PURPLE_SHEEP_HEAD, HeadedBlocks.PURPLE_SHEEP_WALL_HEAD,
                        HeadedBlocks.BLUE_SHEEP_HEAD, HeadedBlocks.BLUE_SHEEP_WALL_HEAD,
                        HeadedBlocks.BROWN_SHEEP_HEAD, HeadedBlocks.BROWN_SHEEP_WALL_HEAD,
                        HeadedBlocks.GREEN_SHEEP_HEAD, HeadedBlocks.GREEN_SHEEP_WALL_HEAD,
                        HeadedBlocks.RED_SHEEP_HEAD, HeadedBlocks.RED_SHEEP_WALL_HEAD,
                        HeadedBlocks.BLACK_SHEEP_HEAD, HeadedBlocks.BLACK_SHEEP_WALL_HEAD,
                        HeadedBlocks.ALLAY_HEAD, HeadedBlocks.ALLAY_WALL_HEAD,
                        HeadedBlocks.VEX_HEAD, HeadedBlocks.VEX_WALL_HEAD,
                        HeadedBlocks.PIGLIN_BRUTE_HEAD, HeadedBlocks.PIGLIN_BRUTE_WALL_HEAD,
                        HeadedBlocks.ZOMBIFIED_PIGLIN_HEAD, HeadedBlocks.ZOMBIFIED_PIGLIN_WALL_HEAD,
                        HeadedBlocks.LEUCISTIC_AXOLOTL_HEAD, HeadedBlocks.LEUCISTIC_AXOLOTL_WALL_HEAD,
                        HeadedBlocks.BROWN_AXOLOTL_HEAD, HeadedBlocks.BROWN_AXOLOTL_WALL_HEAD,
                        HeadedBlocks.CYAN_AXOLOTL_HEAD, HeadedBlocks.CYAN_AXOLOTL_WALL_HEAD,
                        HeadedBlocks.GOLD_AXOLOTL_HEAD, HeadedBlocks.GOLD_AXOLOTL_WALL_HEAD,
                        HeadedBlocks.BLUE_AXOLOTL_HEAD, HeadedBlocks.BLUE_AXOLOTL_WALL_HEAD,
                        HeadedBlocks.COW_HEAD, HeadedBlocks.COW_WALL_HEAD,
                        HeadedBlocks.BROWN_MOOSHROOM_HEAD, HeadedBlocks.BROWN_MOOSHROOM_WALL_HEAD,
                        HeadedBlocks.RED_MOOSHROOM_HEAD, HeadedBlocks.RED_MOOSHROOM_WALL_HEAD).build(null));
    }
}
