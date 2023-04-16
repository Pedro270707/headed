package net.pedroricardo.headed.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.Headed;

public class HeadedSoundEvents {
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_VILLAGER = registerReference("block.note_block.imitate.villager");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_EVOKER = registerReference("block.note_block.imitate.evoker");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_VINDICATOR = registerReference("block.note_block.imitate.vindicator");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_PILLAGER = registerReference("block.note_block.imitate.pillager");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_ZOMBIE_VILLAGER = registerReference("block.note_block.imitate.zombie_villager");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_WANDERING_TRADER = registerReference("block.note_block.imitate.wandering_trader");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_ILLUSIONER = registerReference("block.note_block.imitate.illusioner");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_SHEEP = registerReference("block.note_block.imitate.sheep");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_ALLAY = registerReference("block.note_block.imitate.allay"); // entity.allay.ambient_without_item
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_VEX = registerReference("block.note_block.imitate.vex");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_PIGLIN_BRUTE = registerReference("block.note_block.imitate.piglin_brute");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_ZOMBIFIED_PIGLIN = registerReference("block.note_block.imitate.zombified_piglin");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_AXOLOTL = registerReference("block.note_block.imitate.axolotl"); // entity.axolotl.idle_air
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_COW = registerReference("block.note_block.imitate.cow");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_POLAR_BEAR = registerReference("block.note_block.imitate.polar_bear");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_OCELOT = registerReference("block.note_block.imitate.ocelot");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_CAT = registerReference("block.note_block.imitate.cat");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_STRAY_CAT = registerReference("block.note_block.imitate.stray_cat"); // Tamed mobs need to drop tamed head for this to work properly. if you're not me and the last commit was a month ago please remind me to fix this
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_ENDERMAN = registerReference("block.note_block.imitate.enderman");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_FOX = registerReference("block.note_block.imitate.fox");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_PANDA = registerReference("block.note_block.imitate.panda");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_AGGRESSIVE_PANDA = registerReference("block.note_block.imitate.aggressive_panda"); // entity.panda.aggressive_ambient
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_WORRIED_PANDA = registerReference("block.note_block.imitate.worried_panda"); // entity.panda.worried_ambient
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_DROWNED = registerReference("block.note_block.imitate.drowned");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_PARROT = registerReference("block.note_block.imitate.parrot");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_STRAY = registerReference("block.note_block.imitate.stray");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_SHULKER = registerReference("block.note_block.imitate.shulker");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_HUSK = registerReference("block.note_block.imitate.husk");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_PIG = registerReference("block.note_block.imitate.pig");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_SPIDER = registerReference("block.note_block.imitate.spider");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_BLAZE = registerReference("block.note_block.imitate.blaze");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_RABBIT = registerReference("block.note_block.imitate.rabbit");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_TURTLE = registerReference("block.note_block.imitate.turtle"); // entity.turtle.ambient_land
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_WITHER = registerReference("block.note_block.imitate.wither");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_WOLF = registerReference("block.note_block.imitate.wolf");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_TAMED_WOLF = registerReference("block.note_block.imitate.tamed_wolf"); // entity.wolf.pant
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_BAT = registerReference("block.note_block.imitate.bat");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_WITCH = registerReference("block.note_block.imitate.witch");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_CHICKEN = registerReference("block.note_block.imitate.chicken");
    public static final RegistryEntry.Reference<SoundEvent> BLOCK_NOTE_BLOCK_IMITATE_PHANTOM = registerReference("block.note_block.imitate.phantom");

    private static RegistryEntry.Reference<SoundEvent> registerReference(String id) {
        return registerReference(new Identifier(Headed.MOD_ID, id));
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id) {
        return registerReference(id, id);
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(Identifier id, Identifier soundId) {
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }

    public static void registerModSoundEvents() {
        Headed.LOGGER.debug("Registering Headed sound events");
    }
}
