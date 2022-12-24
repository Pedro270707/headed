package net.pedroricardo.headed.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Map;

public class ModWallSkullBlock extends AbstractModSkullBlock {
    public static final DirectionProperty FACING;
    private static final Map<Direction, VoxelShape> FACING_TO_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_VILLAGER_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_SHEEP_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_ALLAY_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_PIGLIN_SHAPE;

    public ModWallSkullBlock(ModSkullBlock.SkullType skullType, AbstractBlock.Settings settings) {
        super(skullType, settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(FACING, Direction.NORTH));
    }

    public String getTranslationKey() {
        return this.asItem().getTranslationKey();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (this.getSkullType() == ModSkullBlock.Type.VILLAGER
                || this.getSkullType() == ModSkullBlock.Type.EVOKER
                || this.getSkullType() == ModSkullBlock.Type.VINDICATOR
                || this.getSkullType() == ModSkullBlock.Type.PILLAGER
                || this.getSkullType() == ModSkullBlock.Type.ZOMBIE_VILLAGER
                || this.getSkullType() == ModSkullBlock.Type.ILLUSIONER) {
            return FACING_TO_VILLAGER_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == ModSkullBlock.Type.SHEEP
                || this.getSkullType() == ModSkullBlock.Type.WHITE_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.ORANGE_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.MAGENTA_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.LIGHT_BLUE_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.YELLOW_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.LIME_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.PINK_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.GRAY_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.LIGHT_GRAY_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.CYAN_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.PURPLE_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.BLUE_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.BROWN_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.GREEN_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.RED_SHEEP
                || this.getSkullType() == ModSkullBlock.Type.BLACK_SHEEP) {
            return FACING_TO_SHEEP_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == ModSkullBlock.Type.ALLAY
                || this.getSkullType() == ModSkullBlock.Type.VEX) {
            return FACING_TO_ALLAY_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == ModSkullBlock.Type.PIGLIN_BRUTE
                || this.getSkullType() == ModSkullBlock.Type.ZOMBIFIED_PIGLIN) {
            return FACING_TO_PIGLIN_SHAPE.get(state.get(FACING));
        } else {
            return FACING_TO_SHAPE.get(state.get(FACING));
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = this.getDefaultState();
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction[] directions = ctx.getPlacementDirections();
        Direction[] var6 = directions;
        int var7 = directions.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Direction direction = var6[var8];
            if (direction.getAxis().isHorizontal()) {
                Direction direction2 = direction.getOpposite();
                blockState = blockState.with(FACING, direction2);
                if (!blockView.getBlockState(blockPos.offset(direction)).canReplace(ctx)) {
                    return blockState;
                }
            }
        }

        return null;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
        FACING_TO_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(4.0, 4.0, 8.0, 12.0, 12.0, 16.0), Direction.SOUTH, Block.createCuboidShape(4.0, 4.0, 0.0, 12.0, 12.0, 8.0), Direction.EAST, Block.createCuboidShape(0.0, 4.0, 4.0, 8.0, 12.0, 12.0), Direction.WEST, Block.createCuboidShape(8.0, 4.0, 4.0, 16.0, 12.0, 12.0)));
        FACING_TO_VILLAGER_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(4.0, 4.0, 8.0, 12.0, 14.0, 16.0), Direction.SOUTH, Block.createCuboidShape(4.0, 4.0, 0.0, 12.0, 14.0, 8.0), Direction.EAST, Block.createCuboidShape(0.0, 4.0, 4.0, 8.0, 14.0, 12.0), Direction.WEST, Block.createCuboidShape(8.0, 4.0, 4.0, 16.0, 14.0, 12.0)));
        FACING_TO_SHEEP_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(5.0, 5.0, 8.0, 11.0, 11.0, 16.0), Direction.SOUTH, Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 8.0), Direction.EAST, Block.createCuboidShape(0.0, 5.0, 5.0, 8.0, 11.0, 11.0), Direction.WEST, Block.createCuboidShape(8.0, 5.0, 5.0, 16.0, 11.0, 11.0)));
        FACING_TO_ALLAY_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(5.5, 5.5, 11.0, 10.5, 10.5, 16.0), Direction.SOUTH, Block.createCuboidShape(5.5, 5.5, 0.0, 10.5, 10.5, 5.0), Direction.EAST, Block.createCuboidShape(0.0, 5.5, 5.5, 5.0, 10.5, 10.5), Direction.WEST, Block.createCuboidShape(11.0, 5.5, 5.5, 16.0, 10.5, 10.5)));
        FACING_TO_PIGLIN_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(3.0, 4.0, 8.0, 13.0, 12.0, 16.0), Direction.SOUTH, Block.createCuboidShape(3.0, 4.0, 0.0, 13.0, 12.0, 8.0), Direction.EAST, Block.createCuboidShape(0.0, 4.0, 3.0, 8.0, 12.0, 13.0), Direction.WEST, Block.createCuboidShape(8.0, 4.0, 3.0, 16.0, 12.0, 13.0)));
    }
}