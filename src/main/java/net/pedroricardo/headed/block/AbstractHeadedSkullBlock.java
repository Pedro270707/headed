package net.pedroricardo.headed.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Wearable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.pedroricardo.headed.HeadedConfig;
import net.pedroricardo.headed.block.entity.HeadedBlockEntities;
import net.pedroricardo.headed.block.entity.HeadedSkullBlockEntity;
import net.pedroricardo.headed.item.HeadedItems;
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
            boolean bl = state.isOf(HeadedBlocks.PIGLIN_BRUTE_HEAD) || state.isOf(HeadedBlocks.PIGLIN_BRUTE_WALL_HEAD) || state.isOf(HeadedBlocks.ZOMBIFIED_PIGLIN_HEAD) || state.isOf(HeadedBlocks.ZOMBIFIED_PIGLIN_WALL_HEAD) || ((state.isOf(HeadedBlocks.FOX_HEAD) || state.isOf(HeadedBlocks.SNOW_FOX_HEAD)) && HeadedConfig.FOX_HEADS_TICK.get());
            if (bl) {
                return checkType(type, HeadedBlockEntities.SKULL, HeadedSkullBlockEntity::tick);
            }
        }

        return null;
    }

    public HeadedSkullBlock.SkullType getSkullType() {
        return this.type;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName() && (itemStack.getOrCreateSubNbt("BlockEntityTag").getBoolean(HeadedSkullBlockEntity.IS_TAMED_KEY) || itemStack.getItem().equals(HeadedItems.WHITE_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.ORANGE_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.MAGENTA_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.LIGHT_BLUE_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.YELLOW_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.LIME_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.PINK_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.GRAY_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.LIGHT_GRAY_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.CYAN_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.PURPLE_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.BLUE_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.BROWN_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.GREEN_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.RED_SHEEP_HEAD) || itemStack.getItem().equals(HeadedItems.BLACK_SHEEP_HEAD)) || itemStack.getItem().equals(HeadedItems.BLACK_RABBIT_HEAD) || itemStack.getItem().equals(HeadedItems.BROWN_RABBIT_HEAD) || itemStack.getItem().equals(HeadedItems.EVIL_RABBIT_HEAD) || itemStack.getItem().equals(HeadedItems.GOLD_RABBIT_HEAD) || itemStack.getItem().equals(HeadedItems.SALT_RABBIT_HEAD) || itemStack.getItem().equals(HeadedItems.WHITE_RABBIT_HEAD) || itemStack.getItem().equals(HeadedItems.WHITE_SPLOTCHED_RABBIT_HEAD)) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof HeadedSkullBlockEntity) {
                ((HeadedSkullBlockEntity) blockEntity).setCustomName(itemStack.getName());
            }
        }
    }

    private ActionResult dyeActionResult(PlayerEntity player, Hand hand, World world, BlockPos pos) {
        if (!player.isCreative())
            player.getStackInHand(hand).decrement(1);
        world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0f, 1.0f);
        world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        player.incrementStat(Stats.USED.getOrCreateStat(player.getStackInHand(hand).getItem()));
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        if (state.isOf(HeadedBlocks.WHITE_SHEEP_HEAD) || state.isOf(HeadedBlocks.ORANGE_SHEEP_HEAD) || state.isOf(HeadedBlocks.MAGENTA_SHEEP_HEAD) || state.isOf(HeadedBlocks.LIGHT_BLUE_SHEEP_HEAD) || state.isOf(HeadedBlocks.YELLOW_SHEEP_HEAD) || state.isOf(HeadedBlocks.LIME_SHEEP_HEAD) || state.isOf(HeadedBlocks.PINK_SHEEP_HEAD) || state.isOf(HeadedBlocks.GRAY_SHEEP_HEAD) || state.isOf(HeadedBlocks.LIGHT_GRAY_SHEEP_HEAD) || state.isOf(HeadedBlocks.CYAN_SHEEP_HEAD) || state.isOf(HeadedBlocks.PURPLE_SHEEP_HEAD) || state.isOf(HeadedBlocks.BLUE_SHEEP_HEAD) || state.isOf(HeadedBlocks.BROWN_SHEEP_HEAD) || state.isOf(HeadedBlocks.GREEN_SHEEP_HEAD) || state.isOf(HeadedBlocks.RED_SHEEP_HEAD) || state.isOf(HeadedBlocks.BLACK_SHEEP_HEAD)) {
            if (world.isClient)
                return ActionResult.CONSUME;
            else {
                int rotation = state.get(Properties.ROTATION);
                if (player.getStackInHand(hand).isOf(Items.WHITE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.WHITE_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                else if (player.getStackInHand(hand).isOf(Items.ORANGE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.ORANGE_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.MAGENTA_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.MAGENTA_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.LIGHT_BLUE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.LIGHT_BLUE_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.YELLOW_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.YELLOW_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.LIME_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.LIME_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.PINK_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.PINK_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.GRAY_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.GRAY_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.LIGHT_GRAY_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.LIGHT_GRAY_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.CYAN_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.CYAN_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.PURPLE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.PURPLE_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.BLUE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.BLUE_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.BROWN_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.BROWN_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.GREEN_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.GREEN_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.RED_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.RED_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.BLACK_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.BLACK_SHEEP_HEAD.getDefaultState().with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }

                return ActionResult.FAIL;
            }
        } else if (state.isOf(HeadedBlocks.WHITE_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.ORANGE_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.MAGENTA_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.LIGHT_BLUE_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.YELLOW_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.LIME_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.PINK_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.GRAY_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.LIGHT_GRAY_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.CYAN_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.PURPLE_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.BLUE_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.BROWN_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.GREEN_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.RED_SHEEP_WALL_HEAD) || state.isOf(HeadedBlocks.BLACK_SHEEP_WALL_HEAD)) {
            if (world.isClient)
                return ActionResult.SUCCESS;
            else {
                Direction facing = state.get(Properties.FACING);
                if (player.getStackInHand(hand).isOf(Items.WHITE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.WHITE_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.ORANGE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.ORANGE_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.MAGENTA_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.MAGENTA_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.LIGHT_BLUE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.LIGHT_BLUE_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.YELLOW_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.YELLOW_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.LIME_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.LIME_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.PINK_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.PINK_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.GRAY_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.GRAY_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.LIGHT_GRAY_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.LIGHT_GRAY_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.CYAN_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.CYAN_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.PURPLE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.PURPLE_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.BLUE_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.BLUE_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.BROWN_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.BROWN_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.GREEN_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.GREEN_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.RED_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.RED_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                if (player.getStackInHand(hand).isOf(Items.BLACK_DYE)) {
                    world.setBlockState(pos, HeadedBlocks.BLACK_SHEEP_WALL_HEAD.getDefaultState().with(Properties.FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
                return ActionResult.FAIL;
            }
        }
        return ActionResult.FAIL;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}