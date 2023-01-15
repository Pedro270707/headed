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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.*;

public class HeadedSkullBlock extends AbstractHeadedSkullBlock {
    public static final int MAX_ROTATION_INDEX = 15;
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
    protected static final VoxelShape PARROT_SHAPE;
    protected static final VoxelShape SHULKER_SHAPE;
    protected static final VoxelShape CAVE_SPIDER_SHAPE;
    protected static final VoxelShape RABBIT_SHAPE;
    protected static final VoxelShape TURTLE_SHAPE;
    protected static final VoxelShape WOLF_SHAPE;
    protected static final VoxelShape BAT_SHAPE;
    protected static final VoxelShape CHICKEN_SHAPE;
    protected static final VoxelShape PHANTOM_SHAPE;
    protected static final VoxelShape SNOW_GOLEM_SHAPE;

    public HeadedSkullBlock(HeadedSkullBlock.SkullType skullType, AbstractBlock.Settings settings) {
        super(skullType, settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(ROTATION, 0));
    }

    public static final Set<Type> VILLAGER_TYPES = EnumSet.of(Type.VILLAGER, Type.EVOKER, Type.VINDICATOR, Type.PILLAGER, Type.ZOMBIE_VILLAGER, Type.WANDERING_TRADER, Type.ILLUSIONER, Type.WITCH);
    public static final Set<Type> SHEEP_TYPES = EnumSet.of(Type.SHEEP, Type.WHITE_SHEEP, Type.ORANGE_SHEEP, Type.MAGENTA_SHEEP, Type.LIGHT_BLUE_SHEEP, Type.YELLOW_SHEEP, Type.LIME_SHEEP, Type.PINK_SHEEP, Type.GRAY_SHEEP, Type.LIGHT_GRAY_SHEEP, Type.CYAN_SHEEP, Type.PURPLE_SHEEP, Type.BLUE_SHEEP, Type.BROWN_SHEEP, Type.GREEN_SHEEP, Type.RED_SHEEP, Type.BLACK_SHEEP);
    public static final Set<Type> ALLAY_TYPES = EnumSet.of(Type.ALLAY, Type.VEX);
    public static final Set<Type> PIGLIN_TYPES = EnumSet.of(Type.PIGLIN_BRUTE, Type.ZOMBIFIED_PIGLIN);
    public static final Set<Type> AXOLOTL_TYPES = EnumSet.of(Type.LEUCISTIC_AXOLOTL, Type.BROWN_AXOLOTL, Type.CYAN_AXOLOTL, Type.GOLD_AXOLOTL, Type.BLUE_AXOLOTL);
    public static final Set<Type> OCELOT_TYPES = EnumSet.of(Type.OCELOT, Type.ALL_BLACK_CAT, Type.BLACK_CAT, Type.BRITISH_SHORTHAIR_CAT, Type.CALICO_CAT, Type.JELLIE_CAT, Type.PERSIAN_CAT, Type.RAGDOLL_CAT, Type.RED_CAT, Type.SIAMESE_CAT, Type.TABBY_CAT, Type.WHITE_CAT);
    public static final Set<Type> PANDA_TYPES = EnumSet.of(Type.AGGRESSIVE_PANDA, Type.BROWN_PANDA, Type.LAZY_PANDA, Type.PANDA, Type.PLAYFUL_PANDA, Type.WEAK_PANDA, Type.WORRIED_PANDA);
    public static final Set<Type> PARROT_TYPES = EnumSet.of(Type.RED_PARROT, Type.GREEN_PARROT, Type.BLUE_PARROT, Type.CYAN_PARROT, Type.GRAY_PARROT);
    public static final Set<Type> RABBIT_TYPES = EnumSet.of(Type.BLACK_RABBIT, Type.BROWN_RABBIT, Type.EVIL_RABBIT, Type.GOLD_RABBIT, Type.SALT_RABBIT, Type.WHITE_RABBIT, Type.WHITE_SPLOTCHED_RABBIT);
    public static final Set<Type> COW_TYPES = EnumSet.of(Type.COW, Type.RED_MOOSHROOM, Type.BROWN_MOOSHROOM);
    public static final Set<Type> FOX_TYPES = EnumSet.of(Type.FOX, Type.SNOW_FOX);

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (VILLAGER_TYPES.contains(this.getSkullType())) {
            return VILLAGER_SHAPE;
        } else if (SHEEP_TYPES.contains(this.getSkullType())) {
            return SHEEP_SHAPE;
        } else if (ALLAY_TYPES.contains(this.getSkullType())) {
            return ALLAY_SHAPE;
        } else if (PIGLIN_TYPES.contains(this.getSkullType())) {
            return PIGLIN_SHAPE;
        } else if (AXOLOTL_TYPES.contains(this.getSkullType())) {
            return AXOLOTL_SHAPE;
        } else if (this.getSkullType() == Type.POLAR_BEAR) {
            return POLAR_BEAR_SHAPE;
        } else if (OCELOT_TYPES.contains(this.getSkullType())) {
            return OCELOT_SHAPE;
        } else if (this.getSkullType() == Type.FOX
                || this.getSkullType() == Type.SNOW_FOX) {
            return FOX_SHAPE;
        } else if (this.getSkullType() == Type.IRON_GOLEM) {
            return IRON_GOLEM_SHAPE;
        } else if (PANDA_TYPES.contains(this.getSkullType())) {
            return PANDA_SHAPE;
        } else if (PARROT_TYPES.contains(this.getSkullType())) {
            return PARROT_SHAPE;
        } else if (this.getSkullType() == Type.SHULKER) {
            return SHULKER_SHAPE;
        } else if (this.getSkullType() == Type.CAVE_SPIDER) {
            return CAVE_SPIDER_SHAPE;
        } else if (RABBIT_TYPES.contains(this.getSkullType())) {
            return RABBIT_SHAPE;
        } else if (this.getSkullType() == Type.TURTLE) {
            return TURTLE_SHAPE;
        } else if (this.getSkullType() == Type.WOLF) {
            return WOLF_SHAPE;
        } else if (this.getSkullType() == Type.BAT) {
            return BAT_SHAPE;
        } else if (this.getSkullType() == Type.CHICKEN) {
            return CHICKEN_SHAPE;
        } else if (this.getSkullType() == Type.PHANTOM) {
            return PHANTOM_SHAPE;
        } else if (this.getSkullType() == Type.SNOW_GOLEM) {
            return SNOW_GOLEM_SHAPE;
        } else {
            return SHAPE;
        }
    }

    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(ROTATION, MathHelper.floor((double)(ctx.getPlayerYaw() * 16.0F / 360.0F) + 0.5) & 15);
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
        PARROT_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 4.0, 11.0);
        SHULKER_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
        CAVE_SPIDER_SHAPE = Block.createCuboidShape(5.2, 0.0, 5.2, 10.8, 5.6, 10.8);
        RABBIT_SHAPE = Block.createCuboidShape(5.5, 0.0, 5.5, 10.5, 4.0, 10.5);
        TURTLE_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 5.0, 11.0);
        WOLF_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);
        BAT_SHAPE = Block.createCuboidShape(6.95, 0.0, 6.95, 9.05, 2.1, 9.05);
        CHICKEN_SHAPE = Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 6.0, 10.0);
        PHANTOM_SHAPE = Block.createCuboidShape(4.5, 0.0, 4.5, 11.5, 3.0, 11.5);
        SNOW_GOLEM_SHAPE = Block.createCuboidShape(4.5, 0.0, 4.5, 11.5, 7.0, 11.5);
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
        DROWNED,
        RED_PARROT,
        GREEN_PARROT,
        BLUE_PARROT,
        CYAN_PARROT,
        GRAY_PARROT,
        STRAY,
        SHULKER,
        HUSK,
        PIG,
        SPIDER,
        CAVE_SPIDER,
        BLAZE,
        BLACK_RABBIT,
        BROWN_RABBIT,
        EVIL_RABBIT,
        GOLD_RABBIT,
        SALT_RABBIT,
        WHITE_RABBIT,
        WHITE_SPLOTCHED_RABBIT,
        TURTLE,
        WITHER,
        WOLF,
        BAT,
        WITCH,
        CHICKEN,
        PHANTOM,
        SNOW_GOLEM;

        private Type() {
        }
    }
}