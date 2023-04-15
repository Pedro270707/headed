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

public class HeadedWallSkullBlock extends AbstractHeadedSkullBlock {
    public static final DirectionProperty FACING;
    private static final Map<Direction, VoxelShape> FACING_TO_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_VILLAGER_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_SHEEP_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_ALLAY_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_VEX_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_PIGLIN_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_AXOLOTL_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_COW_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_POLAR_BEAR_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_OCELOT_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_FOX_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_IRON_GOLEM_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_PANDA_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_PARROT_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_SHULKER_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_CAVE_SPIDER_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_RABBIT_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_TURTLE_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_WOLF_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_BAT_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_CHICKEN_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_PHANTOM_SHAPE;
    private static final Map<Direction, VoxelShape> FACING_TO_SNOW_GOLEM_SHAPE;

    public HeadedWallSkullBlock(HeadedSkullBlock.SkullType skullType, AbstractBlock.Settings settings) {
        super(skullType, settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(FACING, Direction.NORTH));
    }

    public String getTranslationKey() {
        return this.asItem().getTranslationKey();
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (HeadedSkullBlock.VILLAGER_TYPES.contains(this.getSkullType())) {
            return FACING_TO_VILLAGER_SHAPE.get(state.get(FACING));
        } else if (HeadedSkullBlock.SHEEP_TYPES.contains(this.getSkullType())) {
            return FACING_TO_SHEEP_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.ALLAY) {
            return FACING_TO_ALLAY_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.VEX) {
            return FACING_TO_VEX_SHAPE.get(state.get(FACING));
        } else if (HeadedSkullBlock.PIGLIN_TYPES.contains(this.getSkullType())) {
            return FACING_TO_PIGLIN_SHAPE.get(state.get(FACING));
        } else if (HeadedSkullBlock.AXOLOTL_TYPES.contains(this.getSkullType())) {
            return FACING_TO_AXOLOTL_SHAPE.get(state.get(FACING));
        } else if (HeadedSkullBlock.COW_TYPES.contains(this.getSkullType())) {
            return FACING_TO_COW_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.POLAR_BEAR) {
            return FACING_TO_POLAR_BEAR_SHAPE.get(state.get(FACING));
        } else if (HeadedSkullBlock.OCELOT_TYPES.contains(this.getSkullType())) {
            return FACING_TO_OCELOT_SHAPE.get(state.get(FACING));
        } else if (HeadedSkullBlock.FOX_TYPES.contains(this.getSkullType())) {
            return FACING_TO_FOX_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.IRON_GOLEM) {
            return FACING_TO_IRON_GOLEM_SHAPE.get(state.get(FACING));
        } else if (HeadedSkullBlock.PANDA_TYPES.contains(this.getSkullType())) {
            return FACING_TO_PANDA_SHAPE.get(state.get(FACING));
        } else if (HeadedSkullBlock.PARROT_TYPES.contains(this.getSkullType())) {
            return FACING_TO_PARROT_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.SHULKER) {
            return FACING_TO_SHULKER_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.CAVE_SPIDER) {
            return FACING_TO_CAVE_SPIDER_SHAPE.get(state.get(FACING));
        } else if (HeadedSkullBlock.RABBIT_TYPES.contains(this.getSkullType())) {
            return FACING_TO_RABBIT_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.TURTLE) {
            return FACING_TO_TURTLE_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.WOLF) {
            return FACING_TO_WOLF_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.BAT) {
            return FACING_TO_BAT_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.CHICKEN) {
            return FACING_TO_CHICKEN_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.PHANTOM) {
            return FACING_TO_PHANTOM_SHAPE.get(state.get(FACING));
        } else if (this.getSkullType() == HeadedSkullBlock.Type.SNOW_GOLEM) {
            return FACING_TO_SNOW_GOLEM_SHAPE.get(state.get(FACING));
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
        FACING_TO_VEX_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(6.4, 6.4, 12.8, 9.6, 9.6, 16.0), Direction.SOUTH, Block.createCuboidShape(6.4, 6.4, 0.0, 9.6, 9.6, 3.2), Direction.EAST, Block.createCuboidShape(0.0, 6.4, 6.4, 3.2, 9.6, 9.6), Direction.WEST, Block.createCuboidShape(12.8, 6.4, 6.4, 16.0, 9.6, 9.6)));
        FACING_TO_PIGLIN_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(3.0, 4.0, 8.0, 13.0, 12.0, 16.0), Direction.SOUTH, Block.createCuboidShape(3.0, 4.0, 0.0, 13.0, 12.0, 8.0), Direction.EAST, Block.createCuboidShape(0.0, 4.0, 3.0, 8.0, 12.0, 13.0), Direction.WEST, Block.createCuboidShape(8.0, 4.0, 3.0, 16.0, 12.0, 13.0)));
        FACING_TO_AXOLOTL_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(4.0, 5.5, 11.0, 12.0, 10.5, 16.0), Direction.SOUTH, Block.createCuboidShape(4.0, 5.5, 0.0, 12.0, 10.5, 5.0), Direction.EAST, Block.createCuboidShape(0.0, 5.5, 4.0, 5.0, 10.5, 12.0), Direction.WEST, Block.createCuboidShape(11.0, 5.5, 4.0, 16.0, 10.5, 12.0)));
        FACING_TO_COW_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(4.0, 4.0, 10.0, 12.0, 12.0, 16.0), Direction.SOUTH, Block.createCuboidShape(4.0, 4.0, 0.0, 12.0, 12.0, 6.0), Direction.EAST, Block.createCuboidShape(0.0, 4.0, 4.0, 6.0, 12.0, 12.0), Direction.WEST, Block.createCuboidShape(10.0, 4.0, 4.0, 16.0, 12.0, 12.0)));
        FACING_TO_POLAR_BEAR_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(4.5, 4.5, 9.0, 11.5, 11.5, 16.0), Direction.SOUTH, Block.createCuboidShape(4.5, 4.5, 0.0, 11.5, 11.5, 7.0), Direction.EAST, Block.createCuboidShape(0.0, 4.5, 4.5, 7.0, 11.5, 11.5), Direction.WEST, Block.createCuboidShape(9.0, 4.5, 4.5, 16.0, 11.5, 11.5)));
        FACING_TO_OCELOT_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(5.5, 6, 11.0, 10.5, 10.0, 16.0), Direction.SOUTH, Block.createCuboidShape(5.5, 6.0, 0.0, 10.5, 10.0, 5.0), Direction.EAST, Block.createCuboidShape(0.0, 6.0, 5.5, 5.0, 10.0, 10.5), Direction.WEST, Block.createCuboidShape(11.0, 6.0, 5.5, 16.0, 10.0, 10.5)));
        FACING_TO_FOX_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(4.0, 5.0, 10.0, 12.0, 11.0, 16.0), Direction.SOUTH, Block.createCuboidShape(4.0, 5.0, 0.0, 12.0, 11.0, 6.0), Direction.EAST, Block.createCuboidShape(0.0, 5.0, 4.0, 6.0, 11.0, 12.0), Direction.WEST, Block.createCuboidShape(10.0, 5.0, 4.0, 16.0, 11.0, 12.0)));
        FACING_TO_IRON_GOLEM_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(4.0, 3.0, 8.0, 12.0, 13.0, 16.0), Direction.SOUTH, Block.createCuboidShape(4.0, 3.0, 0.0, 12.0, 13.0, 8.0), Direction.EAST, Block.createCuboidShape(0.0, 3.0, 4.0, 8.0, 13.0, 12.0), Direction.WEST, Block.createCuboidShape(8.0, 3.0, 4.0, 16.0, 13.0, 12.0)));
        FACING_TO_PANDA_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(1.5, 3.0, 7.0, 14.5, 13.0, 16.0), Direction.SOUTH, Block.createCuboidShape(1.5, 3.0, 0.0, 14.5, 13.0, 9.0), Direction.EAST, Block.createCuboidShape(0.0, 3.0, 1.5, 9.0, 13.0, 14.5), Direction.WEST, Block.createCuboidShape(7.0, 3.0, 1.5, 16.0, 13.0, 14.5)));
        FACING_TO_PARROT_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(7.0, 6.0, 12.0, 9.0, 10.0, 16.0), Direction.SOUTH, Block.createCuboidShape(7.0, 6.0, 0.0, 9.0, 10.0, 4.0), Direction.EAST, Block.createCuboidShape(0.0, 6.0, 7.0, 4.0, 10.0, 9.0), Direction.WEST, Block.createCuboidShape(12.0, 6.0, 7.0, 16.0, 10.0, 9.0)));
        FACING_TO_SHULKER_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(5.0, 5.0, 10.0, 11.0, 11.0, 16.0), Direction.SOUTH, Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 6.0), Direction.EAST, Block.createCuboidShape(0.0, 5.0, 5.0, 6.0, 11.0, 11.0), Direction.WEST, Block.createCuboidShape(10.0, 5.0, 5.0, 16.0, 11.0, 11.0)));
        FACING_TO_CAVE_SPIDER_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(5.2, 5.2, 10.4, 10.8, 10.8, 16.0), Direction.SOUTH, Block.createCuboidShape(5.2, 5.2, 0.0, 10.8, 10.8, 5.6), Direction.EAST, Block.createCuboidShape(0.0, 5.2, 5.2, 5.6, 10.8, 10.8), Direction.WEST, Block.createCuboidShape(10.4, 5.2, 5.2, 16.0, 10.8, 10.8)));
        FACING_TO_RABBIT_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(5.5, 6.0, 11.0, 10.5, 10.0, 16.0), Direction.SOUTH, Block.createCuboidShape(5.5, 6.0, 0.0, 10.5, 10.0, 5.0), Direction.EAST, Block.createCuboidShape(0.0, 6.0, 5.5, 5.0, 10.0, 10.5), Direction.WEST, Block.createCuboidShape(11.0, 6.0, 5.5, 16.0, 10.0, 10.5)));
        FACING_TO_TURTLE_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(5.0, 5.5, 10.0, 11.0, 10.5, 16.0), Direction.SOUTH, Block.createCuboidShape(5.0, 5.5, 0.0, 11.0, 10.5, 6.0), Direction.EAST, Block.createCuboidShape(0.0, 5.5, 5.0, 6.0, 10.5, 11.0), Direction.WEST, Block.createCuboidShape(10.0, 5.5, 5.0, 16.0, 10.5, 11.0)));
        FACING_TO_WOLF_SHAPE = Maps.immutableEnumMap(Map.of(Direction.NORTH, Block.createCuboidShape(5.0, 5.0, 12.0, 11.0, 11.0, 16.0), Direction.SOUTH, Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 4.0), Direction.EAST, Block.createCuboidShape(0.0, 5.0, 5.0, 4.0, 11.0, 11.0), Direction.WEST, Block.createCuboidShape(12.0, 5.0, 5.0, 16.0, 11.0, 11.0)));
        FACING_TO_BAT_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(6.95, 6.95, 13.9, 9.05, 9.05, 16.0), Direction.SOUTH, Block.createCuboidShape(6.95, 6.95, 0.0, 9.05, 9.05, 2.1), Direction.EAST, Block.createCuboidShape(0.0, 6.95, 6.95, 2.1, 9.05, 9.05), Direction.WEST, Block.createCuboidShape(13.9, 6.95, 6.95, 16.0, 9.05, 9.05)));
        FACING_TO_CHICKEN_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(6.0, 5.0, 13.0, 10.0, 11.0, 16.0), Direction.SOUTH, Block.createCuboidShape(6.0, 5.0, 0.0, 10.0, 11.0, 3.0), Direction.EAST, Block.createCuboidShape(0.0, 5.0, 6.0, 3.0, 11.0, 10.0), Direction.WEST, Block.createCuboidShape(13.0, 5.0, 6.0, 16.0, 11.0, 10.0)));
        FACING_TO_PHANTOM_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(4.5, 6.5, 11.0, 11.5, 9.5, 16.0), Direction.SOUTH, Block.createCuboidShape(4.5, 6.5, 0.0, 11.5, 9.5, 5.0), Direction.EAST, Block.createCuboidShape(0.0, 6.5, 4.5, 5.0, 9.5, 11.5), Direction.WEST, Block.createCuboidShape(11.0, 6.5, 4.5, 16.0, 9.5, 11.5)));
        FACING_TO_SNOW_GOLEM_SHAPE = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.createCuboidShape(4.5, 4.5, 9.0, 11.5, 11.5, 16.0), Direction.SOUTH, Block.createCuboidShape(4.5, 4.5, 0.0, 11.5, 11.5, 7.0), Direction.EAST, Block.createCuboidShape(0.0, 4.5, 4.5, 7.0, 11.5, 11.5), Direction.WEST, Block.createCuboidShape(9.0, 4.5, 4.5, 16.0, 11.5, 11.5)));
    }
}