package net.pedroricardo.headed.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.Wearable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.pedroricardo.headed.block.entity.ModBlockEntities;
import net.pedroricardo.headed.block.entity.ModSkullBlockEntity;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractModSkullBlock extends BlockWithEntity implements Wearable {
    private final ModSkullBlock.SkullType type;

    public AbstractModSkullBlock(ModSkullBlock.SkullType type, AbstractBlock.Settings settings) {
        super(settings);
        this.type = type;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ModSkullBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient) {
            boolean bl = state.isOf(ModBlocks.PIGLIN_BRUTE_HEAD) || state.isOf(ModBlocks.PIGLIN_BRUTE_WALL_HEAD) || state.isOf(ModBlocks.ZOMBIFIED_PIGLIN_HEAD) || state.isOf(ModBlocks.ZOMBIFIED_PIGLIN_WALL_HEAD);
            if (bl) {
                return checkType(type, ModBlockEntities.SKULL, ModSkullBlockEntity::tick);
            }
        }

        return null;
    }

    public ModSkullBlock.SkullType getSkullType() {
        return this.type;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}