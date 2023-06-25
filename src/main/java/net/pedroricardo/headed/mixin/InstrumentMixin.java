package net.pedroricardo.headed.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.enums.Instrument;
import net.pedroricardo.headed.block.HeadedBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Instrument.class)
public class InstrumentMixin {
    @Inject(method = "fromAboveState", at = @At("HEAD"), cancellable = true)
    private static void fromAboveState(BlockState state, CallbackInfoReturnable<Optional<Instrument>> ci) {
        if (state.isOf(HeadedBlocks.VILLAGER_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("VILLAGER")));
        } else if (state.isOf(HeadedBlocks.EVOKER_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("EVOKER")));
        } else if (state.isOf(HeadedBlocks.VINDICATOR_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("VINDICATOR")));
        } else if (state.isOf(HeadedBlocks.PILLAGER_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("PILLAGER")));
        } else if (state.isOf(HeadedBlocks.ZOMBIE_VILLAGER_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("ZOMBIE_VILLAGER")));
        } else if (state.isOf(HeadedBlocks.WANDERING_TRADER_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("WANDERING_TRADER")));
        } else if (state.isOf(HeadedBlocks.ILLUSIONER_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("ILLUSIONER")));
        } else if (state.isOf(HeadedBlocks.SHEEP_HEAD) || state.isOf(HeadedBlocks.WHITE_SHEEP_HEAD) || state.isOf(HeadedBlocks.ORANGE_SHEEP_HEAD) || state.isOf(HeadedBlocks.MAGENTA_SHEEP_HEAD) || state.isOf(HeadedBlocks.LIGHT_BLUE_SHEEP_HEAD) || state.isOf(HeadedBlocks.YELLOW_SHEEP_HEAD) || state.isOf(HeadedBlocks.LIME_SHEEP_HEAD) || state.isOf(HeadedBlocks.PINK_SHEEP_HEAD) || state.isOf(HeadedBlocks.GRAY_SHEEP_HEAD) || state.isOf(HeadedBlocks.LIGHT_GRAY_SHEEP_HEAD) || state.isOf(HeadedBlocks.CYAN_SHEEP_HEAD) || state.isOf(HeadedBlocks.PURPLE_SHEEP_HEAD) || state.isOf(HeadedBlocks.BLUE_SHEEP_HEAD) || state.isOf(HeadedBlocks.BROWN_SHEEP_HEAD) || state.isOf(HeadedBlocks.GREEN_SHEEP_HEAD) || state.isOf(HeadedBlocks.RED_SHEEP_HEAD) || state.isOf(HeadedBlocks.BLACK_SHEEP_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("SHEEP")));
        } else if (state.isOf(HeadedBlocks.ALLAY_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("ALLAY")));
        } else if (state.isOf(HeadedBlocks.VEX_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("VEX")));
        } else if (state.isOf(HeadedBlocks.PIGLIN_BRUTE_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("PIGLIN_BRUTE")));
        } else if (state.isOf(HeadedBlocks.ZOMBIFIED_PIGLIN_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("ZOMBIFIED_PIGLIN")));
        } else if (state.isOf(HeadedBlocks.LEUCISTIC_AXOLOTL_HEAD) || state.isOf(HeadedBlocks.BROWN_AXOLOTL_HEAD) || state.isOf(HeadedBlocks.CYAN_AXOLOTL_HEAD) || state.isOf(HeadedBlocks.GOLD_AXOLOTL_HEAD) || state.isOf(HeadedBlocks.BLUE_AXOLOTL_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("AXOLOTL")));
        } else if (state.isOf(HeadedBlocks.COW_HEAD) || state.isOf(HeadedBlocks.RED_MOOSHROOM_HEAD) || state.isOf(HeadedBlocks.BROWN_MOOSHROOM_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("COW")));
        } else if (state.isOf(HeadedBlocks.POLAR_BEAR_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("POLAR_BEAR")));
        } else if (state.isOf(HeadedBlocks.OCELOT_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("OCELOT")));
        } else if (state.isOf(HeadedBlocks.ALL_BLACK_CAT_HEAD) || state.isOf(HeadedBlocks.BLACK_CAT_HEAD) || state.isOf(HeadedBlocks.BRITISH_SHORTHAIR_CAT_HEAD) || state.isOf(HeadedBlocks.CALICO_CAT_HEAD) || state.isOf(HeadedBlocks.JELLIE_CAT_HEAD) || state.isOf(HeadedBlocks.PERSIAN_CAT_HEAD) || state.isOf(HeadedBlocks.RAGDOLL_CAT_HEAD) || state.isOf(HeadedBlocks.RED_CAT_HEAD) || state.isOf(HeadedBlocks.SIAMESE_CAT_HEAD) || state.isOf(HeadedBlocks.TABBY_CAT_HEAD) || state.isOf(HeadedBlocks.WHITE_CAT_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("CAT")));
        } else if (state.isOf(HeadedBlocks.ENDERMAN_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("ENDERMAN")));
        } else if (state.isOf(HeadedBlocks.FOX_HEAD) || state.isOf(HeadedBlocks.SNOW_FOX_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("FOX")));
        } else if (state.isOf(HeadedBlocks.BROWN_PANDA_HEAD) || state.isOf(HeadedBlocks.LAZY_PANDA_HEAD) || state.isOf(HeadedBlocks.PANDA_HEAD) || state.isOf(HeadedBlocks.PLAYFUL_PANDA_HEAD) || state.isOf(HeadedBlocks.WEAK_PANDA_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("PANDA")));
        } else if (state.isOf(HeadedBlocks.AGGRESSIVE_PANDA_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("AGGRESSIVE_PANDA")));
        } else if (state.isOf(HeadedBlocks.WORRIED_PANDA_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("WORRIED_PANDA")));
        } else if (state.isOf(HeadedBlocks.DROWNED_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("DROWNED")));
        } else if (state.isOf(HeadedBlocks.RED_PARROT_HEAD) || state.isOf(HeadedBlocks.GREEN_PARROT_HEAD) || state.isOf(HeadedBlocks.BLUE_PARROT_HEAD) || state.isOf(HeadedBlocks.CYAN_PARROT_HEAD) || state.isOf(HeadedBlocks.GRAY_PARROT_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("PARROT")));
        } else if (state.isOf(HeadedBlocks.STRAY_SKULL)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("STRAY")));
        } else if (state.isOf(HeadedBlocks.SHULKER_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("SHULKER")));
        } else if (state.isOf(HeadedBlocks.HUSK_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("HUSK")));
        } else if (state.isOf(HeadedBlocks.PIG_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("PIG")));
        } else if (state.isOf(HeadedBlocks.SPIDER_HEAD) || state.isOf(HeadedBlocks.CAVE_SPIDER_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("SPIDER")));
        } else if (state.isOf(HeadedBlocks.BLAZE_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("BLAZE")));
        } else if (state.isOf(HeadedBlocks.BLACK_RABBIT_HEAD) || state.isOf(HeadedBlocks.BROWN_RABBIT_HEAD) || state.isOf(HeadedBlocks.EVIL_RABBIT_HEAD) || state.isOf(HeadedBlocks.GOLD_RABBIT_HEAD) || state.isOf(HeadedBlocks.SALT_RABBIT_HEAD) || state.isOf(HeadedBlocks.WHITE_RABBIT_HEAD) || state.isOf(HeadedBlocks.WHITE_SPLOTCHED_RABBIT_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("RABBIT")));
        } else if (state.isOf(HeadedBlocks.TURTLE_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("TURTLE")));
        } else if (state.isOf(HeadedBlocks.WITHER_SKULL)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("WITHER")));
        } else if (state.isOf(HeadedBlocks.WOLF_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("WOLF")));
        } else if (state.isOf(HeadedBlocks.BAT_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("BAT")));
        } else if (state.isOf(HeadedBlocks.WITCH_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("WITCH")));
        } else if (state.isOf(HeadedBlocks.CHICKEN_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("CHICKEN")));
        } else if (state.isOf(HeadedBlocks.PHANTOM_HEAD)) {
            ci.setReturnValue(Optional.of(Instrument.valueOf("PHANTOM")));
        }
    }
}
