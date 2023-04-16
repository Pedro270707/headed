package net.pedroricardo.headed.sound;

import com.chocohead.mm.api.ClassTinkerers;
import com.chocohead.mm.api.EnumAdder;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.registry.entry.RegistryEntry;
import net.pedroricardo.headed.Headed;

public class HeadedEarlyRisers implements Runnable {

    private Object[] instrumentArgs(String id, RegistryEntry registryEntry) {
        try {
            return new Object[] { "id", registryEntry, Enum.valueOf((Class<Enum>)Class.forName(
                    FabricLoader.getInstance().getMappingResolver().mapClassName(
                            "intermediary", "net.minecraft.class_2766$class_7994"
                    )
            ), "MOB_HEAD") };
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Headed.LOGGER.info("Running HeadedEarlyRisers!");
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        String instrument = remapper.mapClassName("intermediary", "net.minecraft.class_2766");
        String type = remapper.mapClassName("intermediary", "net.minecraft.class_2766$class_7994");
        String soundEvent = remapper.mapClassName("intermediary", "net.minecraft.class_6880");
        EnumAdder adder = ClassTinkerers.enumBuilder(instrument, String.class, 'L' + soundEvent + ';', 'L' + type + ';');
        adder.addEnum("VILLAGER", () -> {
            try {
                return new Object[] { "villager", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_VILLAGER, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("EVOKER", () -> {
            try {
                return new Object[] { "evoker", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_EVOKER, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("VINDICATOR", () -> {
            try {
                return new Object[] { "vindicator", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_VINDICATOR, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("PILLAGER", () -> {
            try {
                return new Object[] { "pillager", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PILLAGER, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("ZOMBIE_VILLAGER", () -> {
            try {
                return new Object[] { "zombie_villager", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ZOMBIE_VILLAGER, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("WANDERING_TRADER", () -> {
            try {
                return new Object[] { "wandering_trader", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WANDERING_TRADER, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("ILLUSIONER", () -> {
            try {
                return new Object[] { "illusioner", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ILLUSIONER, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("SHEEP", () -> {
            try {
                return new Object[] { "sheep", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_SHEEP, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("ALLAY", () -> {
            try {
                return new Object[] { "allay", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ALLAY, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("VEX", () -> {
            try {
                return new Object[] { "vex", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_VEX, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("PIGLIN_BRUTE", () -> {
            try {
                return new Object[] { "piglin_brute", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PIGLIN_BRUTE, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("ZOMBIFIED_PIGLIN", () -> {
            try {
                return new Object[] { "zombified_piglin", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ZOMBIFIED_PIGLIN, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("AXOLOTL", () -> {
            try {
                return new Object[] { "axolotl", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_AXOLOTL, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("COW", () -> {
            try {
                return new Object[] { "cow", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_COW, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("POLAR_BEAR", () -> {
            try {
                return new Object[] { "polar_bear", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_POLAR_BEAR, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("OCELOT", () -> {
            try {
                return new Object[] { "ocelot", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_OCELOT, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("CAT", () -> {
            try {
                return new Object[] { "cat", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_CAT, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("STRAY_CAT", () -> {
            try {
                return new Object[] { "stray_cat", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_STRAY_CAT, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("ENDERMAN", () -> {
            try {
                return new Object[] { "enderman", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_ENDERMAN, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("FOX", () -> {
            try {
                return new Object[] { "fox", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_FOX, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("PANDA", () -> {
            try {
                return new Object[] { "panda", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PANDA, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("AGGRESSIVE_PANDA", () -> {
            try {
                return new Object[] { "aggressive_panda", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_AGGRESSIVE_PANDA, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("WORRIED_PANDA", () -> {
            try {
                return new Object[] { "worried_panda", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WORRIED_PANDA, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("DROWNED", () -> {
            try {
                return new Object[] { "drowned", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_DROWNED, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("PARROT", () -> {
            try {
                return new Object[] { "parrot", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PARROT, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("STRAY", () -> {
            try {
                return new Object[] { "stray", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_STRAY, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("SHULKER", () -> {
            try {
                return new Object[] { "shulker", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_SHULKER, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("HUSK", () -> {
            try {
                return new Object[] { "husk", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_HUSK, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("PIG", () -> {
            try {
                return new Object[] { "pig", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PIG, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("SPIDER", () -> {
            try {
                return new Object[] { "spider", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_SPIDER, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("BLAZE", () -> {
            try {
                return new Object[] { "blaze", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_BLAZE, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("RABBIT", () -> {
            try {
                return new Object[] { "rabbit", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_RABBIT, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("TURTLE", () -> {
            try {
                return new Object[] { "turtle", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_TURTLE, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("WITHER", () -> {
            try {
                return new Object[] { "wither", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WITHER, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("WOLF", () -> {
            try {
                return new Object[] { "wolf", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WOLF, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("TAMED_WOLF", () -> {
            try {
                return new Object[] { "tamed_wolf", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_TAMED_WOLF, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("BAT", () -> {
            try {
                return new Object[] { "bat", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_BAT, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("WITCH", () -> {
            try {
                return new Object[] { "witch", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_WITCH, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("CHICKEN", () -> {
            try {
                return new Object[] { "chicken", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_CHICKEN, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.addEnum("PHANTOM", () -> {
            try {
                return new Object[] { "phantom", HeadedSoundEvents.BLOCK_NOTE_BLOCK_IMITATE_PHANTOM, Enum.valueOf((Class<Enum>)Class.forName(
                        FabricLoader.getInstance().getMappingResolver().mapClassName(
                                "intermediary", "net.minecraft.class_2766$class_7994"
                        )
                ), "MOB_HEAD") };
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        adder.build();
    }
}
