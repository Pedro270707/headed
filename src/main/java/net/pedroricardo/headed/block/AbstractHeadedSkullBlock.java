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
import net.pedroricardo.headed.block.entity.HeadedBlockEntities;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractHeadedSkullBlock extends BlockWithEntity implements Wearable {
    private final HeadedSkullBlock.SkullType type;

    public AbstractHeadedSkullBlock(HeadedSkullBlock.SkullType type, AbstractBlock.Settings settings) {
        super(settings);
        this.type = type;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HeadedSkullBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient) {
            boolean bl = state.isOf(HeadedBlocks.PIGLIN_BRUTE_HEAD) || state.isOf(HeadedBlocks.PIGLIN_BRUTE_WALL_HEAD) || state.isOf(HeadedBlocks.ZOMBIFIED_PIGLIN_HEAD) || state.isOf(HeadedBlocks.ZOMBIFIED_PIGLIN_WALL_HEAD) || state.isOf(HeadedBlocks.FOX_HEAD) || state.isOf(HeadedBlocks.SNOW_FOX_HEAD);
            if (bl) {
                return checkType(type, HeadedBlockEntities.SKULL, HeadedSkullBlockEntity::tick);
            }
        }

        return null;
    }

    public HeadedSkullBlock.SkullType getSkullType() {
        return this.type;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}