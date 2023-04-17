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
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
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
            boolean bl = state.isOf(HeadedBlocks.PIGLIN_HEAD)
                    || state.isOf(HeadedBlocks.PIGLIN_WALL_HEAD)
                    || state.isOf(HeadedBlocks.PIGLIN_BRUTE_HEAD)
                    || state.isOf(HeadedBlocks.PIGLIN_BRUTE_WALL_HEAD)
                    || state.isOf(HeadedBlocks.ZOMBIFIED_PIGLIN_HEAD)
                    || state.isOf(HeadedBlocks.ZOMBIFIED_PIGLIN_WALL_HEAD)
                    || state.isOf(HeadedBlocks.FOX_HEAD)
                    || state.isOf(HeadedBlocks.SNOW_FOX_HEAD);
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
        world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_DYE_USE, SoundCategory.PLAYERS, 1.0f, 1.0f);
        world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        player.incrementStat(Stats.USED.getOrCreateStat(player.getStackInHand(hand).getItem()));
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        if (player.getStackInHand(hand).getItem() instanceof DyeItem dye) {
            if (HeadedBlocks.SHEEP_HEADS.containsValue(state.getBlock()) && state.getBlock() != HeadedBlocks.SHEEP_HEADS.get(dye.getColor())) {
                if (world.isClient) {
                    return ActionResult.SUCCESS;
                } else {
                    int rotation = state.get(Properties.ROTATION);
                    world.setBlockState(pos, HeadedBlocks.SHEEP_HEADS.get(dye.getColor()).getDefaultState()
                            .with(Properties.ROTATION, rotation));
                    return dyeActionResult(player, hand, world, pos);
                }
            } else if (HeadedBlocks.SHEEP_WALL_HEADS.containsValue(state.getBlock()) && state.getBlock() != HeadedBlocks.SHEEP_WALL_HEADS.get(dye.getColor())) {
                if (world.isClient) {
                    return ActionResult.SUCCESS;
                } else {
                    Direction facing = state.get(Properties.HORIZONTAL_FACING);
                    world.setBlockState(pos, HeadedBlocks.SHEEP_WALL_HEADS.get(dye.getColor()).getDefaultState()
                            .with(Properties.HORIZONTAL_FACING, facing));
                    return dyeActionResult(player, hand, world, pos);
                }
            }
        }
        return ActionResult.PASS;
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}