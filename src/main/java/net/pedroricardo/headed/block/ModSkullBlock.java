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

public class ModSkullBlock extends AbstractModSkullBlock {
    public static final int MAX_ROTATION_INDEX = RotationPropertyHelper.getMax();
    private static final int MAX_ROTATIONS;
    public static final IntProperty ROTATION;
    protected static final VoxelShape SHAPE;
    protected static final VoxelShape VILLAGER_SHAPE;

    public ModSkullBlock(ModSkullBlock.SkullType skullType, AbstractBlock.Settings settings) {
        super(skullType, settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(ROTATION, 0));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (this.getSkullType() == Type.VILLAGER || this.getSkullType() == Type.EVOKER || this.getSkullType() == Type.VINDICATOR) {
            return VILLAGER_SHAPE;
        } else {
            return SHAPE;
        }
    }

    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw() + 180.0F));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(ROTATION, rotation.rotate((Integer)state.get(ROTATION), MAX_ROTATIONS));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return (BlockState)state.with(ROTATION, mirror.mirror((Integer)state.get(ROTATION), MAX_ROTATIONS));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{ROTATION});
    }

    static {
        MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;
        ROTATION = Properties.ROTATION;
        SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
        VILLAGER_SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 10.0, 12.0);
    }

    public interface SkullType {
    }

    public static enum Type implements SkullType {
        VILLAGER,
        EVOKER,
        VINDICATOR;

        private Type() {
        }
    }
}