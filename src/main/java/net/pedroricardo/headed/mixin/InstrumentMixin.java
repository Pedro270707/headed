package net.pedroricardo.headed.mixin;

import net.minecraft.block.enums.Instrument;
import net.minecraft.registry.entry.RegistryEntry;
import net.pedroricardo.headed.sound.HeadedInstruments;
import net.pedroricardo.headed.sound.HeadedSoundEvents;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.Locale;

@Mixin(Instrument.class)
public class InstrumentMixin {
    @SuppressWarnings("unused")
    InstrumentMixin(String enumName, int ord, String name, RegistryEntry sound, Instrument.Type type) {
        throw new UnsupportedOperationException("Replaced by Mixin");
    }

    @Shadow
    @Mutable
    @Final
    private static Instrument[] field_12652;

    @Unique
    private static Instrument create(String enumName, int ord, RegistryEntry sound) {
        return (Instrument) (Object)new InstrumentMixin(
                enumName, ord, enumName.toLowerCase(Locale.ROOT), sound, Instrument.Type.MOB_HEAD
        );
    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/block/enums/Instrument;field_12652:[Lnet/minecraft/block/enums/Instrument;", shift = At.Shift.AFTER))
    private static void headed_injectEnum(CallbackInfo ci) {
        int ordinal = field_12652.length;
        field_12652 = Arrays.copyOf(field_12652, ordinal + 40);
        HeadedInstruments.VILLAGER = field_12652[ordinal] = create("VILLAGER", ordinal, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_VILLAGER);
        HeadedInstruments.EVOKER = field_12652[ordinal + 1] = create("EVOKER", ordinal + 1, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_EVOKER);
        HeadedInstruments.VINDICATOR = field_12652[ordinal + 2] = create("VINDICATOR", ordinal + 2, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_VINDICATOR);
        HeadedInstruments.PILLAGER = field_12652[ordinal + 3] = create("PILLAGER", ordinal + 3, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PILLAGER);
        HeadedInstruments.ZOMBIE_VILLAGER = field_12652[ordinal + 4] = create("ZOMBIE_VILLAGER", ordinal + 4, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ZOMBIE_VILLAGER);
        HeadedInstruments.WANDERING_TRADER = field_12652[ordinal + 5] = create("WANDERING_TRADER", ordinal + 5, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WANDERING_TRADER);
        HeadedInstruments.ILLUSIONER = field_12652[ordinal + 6] = create("ILLUSIONER", ordinal + 6, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ILLUSIONER);
        HeadedInstruments.SHEEP = field_12652[ordinal + 7] = create("SHEEP", ordinal + 7, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_SHEEP);
        HeadedInstruments.ALLAY = field_12652[ordinal + 8] = create("ALLAY", ordinal + 8, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ALLAY);
        HeadedInstruments.VEX = field_12652[ordinal + 9] = create("VEX", ordinal + 9, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_VEX);
        HeadedInstruments.PIGLIN_BRUTE = field_12652[ordinal + 10] = create("PIGLIN_BRUTE", ordinal + 10, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PIGLIN_BRUTE);
        HeadedInstruments.ZOMBIFIED_PIGLIN = field_12652[ordinal + 11] = create("ZOMBIFIED_PIGLIN", ordinal + 11, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ZOMBIFIED_PIGLIN);
        HeadedInstruments.AXOLOTL = field_12652[ordinal + 12] = create("AXOLOTL", ordinal + 12, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_AXOLOTL);
        HeadedInstruments.COW = field_12652[ordinal + 13] = create("COW", ordinal + 13, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_COW);
        HeadedInstruments.POLAR_BEAR = field_12652[ordinal + 14] = create("POLAR_BEAR", ordinal + 14, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_POLAR_BEAR);
        HeadedInstruments.OCELOT = field_12652[ordinal + 15] = create("OCELOT", ordinal + 15, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_OCELOT);
        HeadedInstruments.CAT = field_12652[ordinal + 16] = create("CAT", ordinal + 16, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_CAT);
        HeadedInstruments.STRAY_CAT = field_12652[ordinal + 17] = create("STRAY_CAT", ordinal + 17, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_STRAY_CAT);
        HeadedInstruments.ENDERMAN = field_12652[ordinal + 18] = create("ENDERMAN", ordinal + 18, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ENDERMAN);
        HeadedInstruments.FOX = field_12652[ordinal + 19] = create("FOX", ordinal + 19, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_FOX);
        HeadedInstruments.PANDA = field_12652[ordinal + 20] = create("PANDA", ordinal + 20, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PANDA);
        HeadedInstruments.AGGRESSIVE_PANDA = field_12652[ordinal + 21] = create("AGGRESSIVE_PANDA", ordinal + 21, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_AGGRESSIVE_PANDA);
        HeadedInstruments.WORRIED_PANDA = field_12652[ordinal + 22] = create("WORRIED_PANDA", ordinal + 22, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WORRIED_PANDA);
        HeadedInstruments.DROWNED = field_12652[ordinal + 23] = create("DROWNED", ordinal + 23, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_DROWNED);
        HeadedInstruments.PARROT = field_12652[ordinal + 24] = create("PARROT", ordinal + 24, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PARROT);
        HeadedInstruments.STRAY = field_12652[ordinal + 25] = create("STRAY", ordinal + 25, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_STRAY);
        HeadedInstruments.SHULKER = field_12652[ordinal + 26] = create("SHULKER", ordinal + 26, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_SHULKER);
        HeadedInstruments.HUSK = field_12652[ordinal + 27] = create("HUSK", ordinal + 27, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_HUSK);
        HeadedInstruments.PIG = field_12652[ordinal + 28] = create("PIG", ordinal + 28, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PIG);
        HeadedInstruments.SPIDER = field_12652[ordinal + 29] = create("SPIDER", ordinal + 29, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_SPIDER);
        HeadedInstruments.BLAZE = field_12652[ordinal + 30] = create("BLAZE", ordinal + 30, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_BLAZE);
        HeadedInstruments.RABBIT = field_12652[ordinal + 31] = create("RABBIT", ordinal + 31, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_RABBIT);
        HeadedInstruments.TURTLE = field_12652[ordinal + 32] = create("TURTLE", ordinal + 32, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_TURTLE);
        HeadedInstruments.WITHER = field_12652[ordinal + 33] = create("WITHER", ordinal + 33, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WITHER);
        HeadedInstruments.WOLF = field_12652[ordinal + 34] = create("WOLF", ordinal + 34, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WOLF);
        HeadedInstruments.TAMED_WOLF = field_12652[ordinal + 35] = create("TAMED_WOLF", ordinal + 35, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_TAMED_WOLF);
        HeadedInstruments.BAT = field_12652[ordinal + 36] = create("BAT", ordinal + 36, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_BAT);
        HeadedInstruments.WITCH = field_12652[ordinal + 37] = create("WITCH", ordinal + 37, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WITCH);
        HeadedInstruments.CHICKEN = field_12652[ordinal + 38] = create("CHICKEN", ordinal + 38, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_CHICKEN);
        HeadedInstruments.PHANTOM = field_12652[ordinal + 39] = create("PHANTOM", ordinal + 39, HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PHANTOM);
    }
}
