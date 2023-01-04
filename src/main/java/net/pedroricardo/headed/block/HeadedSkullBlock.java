package net.pedroricardo.headed.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class HeadedSkullBlock extends AbstractHeadedSkullBlock {
    public static final int MAX_ROTATION_INDEX = RotationPropertyHelper.getMax();
    private static final int MAX_ROTATIONS;
    public static final IntProperty ROTATION;
    protected static final VoxelShape SHAPE;
    protected static final VoxelShape VILLAGER_SHAPE;
    protected static final VoxelShape SHEEP_SHAPE;
    protected static final VoxelShape ALLAY_SHAPE;
    protected static final VoxelShape PIGLIN_SHAPE;
    protected static final VoxelShape AXOLOTL_SHAPE;
    protected static final VoxelShape POLAR_BEAR_SHAPE;
    protected static final VoxelShape OCELOT_SHAPE;
    protected static final VoxelShape FOX_SHAPE;
    protected static final VoxelShape IRON_GOLEM_SHAPE;
    protected static final VoxelShape PANDA_SHAPE;

    public HeadedSkullBlock(HeadedSkullBlock.SkullType skullType, AbstractBlock.Settings settings) {
        super(skullType, settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(ROTATION, 0));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (this.getSkullType() == Type.VILLAGER
                || this.getSkullType() == Type.EVOKER
                || this.getSkullType() == Type.VINDICATOR
                || this.getSkullType() == Type.PILLAGER
                || this.getSkullType() == Type.ZOMBIE_VILLAGER
                || this.getSkullType() == Type.WANDERING_TRADER
                || this.getSkullType() == Type.ILLUSIONER) {
            return VILLAGER_SHAPE;
        } else if (this.getSkullType() == Type.SHEEP
                || this.getSkullType() == Type.WHITE_SHEEP
                || this.getSkullType() == Type.ORANGE_SHEEP
                || this.getSkullType() == Type.MAGENTA_SHEEP
                || this.getSkullType() == Type.LIGHT_BLUE_SHEEP
                || this.getSkullType() == Type.YELLOW_SHEEP
                || this.getSkullType() == Type.LIME_SHEEP
                || this.getSkullType() == Type.PINK_SHEEP
                || this.getSkullType() == Type.GRAY_SHEEP
                || this.getSkullType() == Type.LIGHT_GRAY_SHEEP
                || this.getSkullType() == Type.CYAN_SHEEP
                || this.getSkullType() == Type.PURPLE_SHEEP
                || this.getSkullType() == Type.BLUE_SHEEP
                || this.getSkullType() == Type.BROWN_SHEEP
                || this.getSkullType() == Type.GREEN_SHEEP
                || this.getSkullType() == Type.RED_SHEEP
                || this.getSkullType() == Type.BLACK_SHEEP) {
            return SHEEP_SHAPE;
        } else if (this.getSkullType() == Type.ALLAY
                || this.getSkullType() == Type.VEX) {
            return ALLAY_SHAPE;
        } else if (this.getSkullType() == Type.PIGLIN_BRUTE
                || this.getSkullType() == Type.ZOMBIFIED_PIGLIN) {
            return PIGLIN_SHAPE;
        } else if (this.getSkullType() == Type.LEUCISTIC_AXOLOTL
                || this.getSkullType() == Type.BROWN_AXOLOTL
                || this.getSkullType() == Type.CYAN_AXOLOTL
                || this.getSkullType() == Type.GOLD_AXOLOTL
                || this.getSkullType() == Type.BLUE_AXOLOTL) {
            return AXOLOTL_SHAPE;
        } else if (this.getSkullType() == Type.POLAR_BEAR) {
            return POLAR_BEAR_SHAPE;
        } else if (this.getSkullType() == Type.OCELOT
                || this.getSkullType() == Type.ALL_BLACK_CAT
                || this.getSkullType() == Type.BLACK_CAT
                || this.getSkullType() == Type.BRITISH_SHORTHAIR_CAT
                || this.getSkullType() == Type.CALICO_CAT
                || this.getSkullType() == Type.JELLIE_CAT
                || this.getSkullType() == Type.PERSIAN_CAT
                || this.getSkullType() == Type.RAGDOLL_CAT
                || this.getSkullType() == Type.RED_CAT
                || this.getSkullType() == Type.SIAMESE_CAT
                || this.getSkullType() == Type.TABBY_CAT
                || this.getSkullType() == Type.WHITE_CAT) {
            return OCELOT_SHAPE;
        } else if (this.getSkullType() == Type.FOX
                || this.getSkullType() == Type.SNOW_FOX) {
            return FOX_SHAPE;
        } else if (this.getSkullType() == Type.IRON_GOLEM) {
            return IRON_GOLEM_SHAPE;
        } else if (this.getSkullType() == Type.AGGRESSIVE_PANDA
                || this.getSkullType() == Type.BROWN_PANDA
                || this.getSkullType() == Type.LAZY_PANDA
                || this.getSkullType() == Type.PANDA
                || this.getSkullType() == Type.PLAYFUL_PANDA
                || this.getSkullType() == Type.WEAK_PANDA
                || this.getSkullType() == Type.WORRIED_PANDA) {
            return PANDA_SHAPE;
        } else {
            return SHAPE;
        }
    }

    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw() + 180.0F));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(ROTATION, rotation.rotate(state.get(ROTATION), MAX_ROTATIONS));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(ROTATION, mirror.mirror(state.get(ROTATION), MAX_ROTATIONS));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{ROTATION});
    }

    static {
        MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;
        ROTATION = Properties.ROTATION;
        SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
        VILLAGER_SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 10.0, 12.0);
        SHEEP_SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 6.0, 12.0);
        ALLAY_SHAPE = Block.createCuboidShape(5.5, 0.0, 5.5, 10.5, 5.0, 10.5);
        PIGLIN_SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
        AXOLOTL_SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 5.0, 12.0);
        POLAR_BEAR_SHAPE = Block.createCuboidShape(4.5, 0.0, 4.5, 11.5, 7.0, 11.5);
        OCELOT_SHAPE = Block.createCuboidShape(5.5, 0.0, 5.5, 10.5, 4.0, 10.5);
        FOX_SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 6.0, 12.0);
        IRON_GOLEM_SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 10.0, 12.0);
        PANDA_SHAPE = Block.createCuboidShape(1.5, 0.0, 1.5, 14.5, 10.0, 14.5);
    }

    public interface SkullType {
    }

    public enum Type implements SkullType {
        VILLAGER,
        EVOKER,
        VINDICATOR,
        PILLAGER,
        ZOMBIE_VILLAGER,
        WANDERING_TRADER,
        ILLUSIONER,
        SHEEP,
        WHITE_SHEEP,
        ORANGE_SHEEP,
        MAGENTA_SHEEP,
        LIGHT_BLUE_SHEEP,
        YELLOW_SHEEP,
        LIME_SHEEP,
        PINK_SHEEP,
        GRAY_SHEEP,
        LIGHT_GRAY_SHEEP,
        CYAN_SHEEP,
        PURPLE_SHEEP,
        BLUE_SHEEP,
        BROWN_SHEEP,
        GREEN_SHEEP,
        RED_SHEEP,
        BLACK_SHEEP,
        ALLAY,
        VEX,
        PIGLIN_BRUTE,
        ZOMBIFIED_PIGLIN,
        LEUCISTIC_AXOLOTL,
        BROWN_AXOLOTL,
        CYAN_AXOLOTL,
        GOLD_AXOLOTL,
        BLUE_AXOLOTL,
        COW,
        BROWN_MOOSHROOM,
        RED_MOOSHROOM,
        POLAR_BEAR,
        OCELOT,
        ALL_BLACK_CAT,
        BLACK_CAT,
        BRITISH_SHORTHAIR_CAT,
        CALICO_CAT,
        JELLIE_CAT,
        PERSIAN_CAT,
        RAGDOLL_CAT,
        RED_CAT,
        SIAMESE_CAT,
        TABBY_CAT,
        WHITE_CAT,
        ENDERMAN,
        FOX,
        SNOW_FOX,
        IRON_GOLEM,
        AGGRESSIVE_PANDA,
        BROWN_PANDA,
        LAZY_PANDA,
        PANDA,
        PLAYFUL_PANDA,
        WEAK_PANDA,
        WORRIED_PANDA,
        DROWNED;

        private Type() {
        }
    }
}