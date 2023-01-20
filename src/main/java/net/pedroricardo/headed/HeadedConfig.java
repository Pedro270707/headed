package net.pedroricardo.headed;

import com.kyanite.paragon.api.ConfigGroup;
import com.kyanite.paragon.api.ConfigOption;
import com.kyanite.paragon.api.interfaces.Config;
import com.kyanite.paragon.api.interfaces.serializers.ConfigSerializer;
import com.kyanite.paragon.api.interfaces.serializers.JSON5Serializer;

public class HeadedConfig implements Config {
    public static final ConfigOption<Boolean> TAMED_CATS_DROP_NAMED_HEAD = new ConfigOption<>("tamed_cats_drop_named_head", true);
    public static final ConfigOption<Boolean> TOAST_RABBITS_DROP_NAMED_HEAD = new ConfigOption<>("toast_rabbits_drop_named_head", true);
    public static final ConfigOption<Boolean> TAMED_WOLVES_DROP_TAMED_HEAD = new ConfigOption<>("tamed_wolves_drop_tamed_head", true);
    public static final ConfigOption<Boolean> ALL_SHEEP_DROP_SHEARED_HEAD = new ConfigOption<>("all_sheep_drop_sheared_head", false);
    public static final ConfigOption<Boolean> ALL_COLORED_SHEEP_DROP_WHITE_SHEEP_HEAD = new ConfigOption<>("all_colored_sheep_drop_white_sheep_head", false);
    public static final ConfigOption<Boolean> ALL_AXOLOTLS_DROP_LEUCISTIC_AXOLOTL_HEAD = new ConfigOption<>("all_axolotls_drop_leucistic_axolotl_head", false);
    public static final ConfigOption<Boolean> BROWN_MOOSHROOMS_DROP_RED_MOOSHROOM_HEAD = new ConfigOption<>("brown_mooshrooms_drop_red_mooshroom_head", false);
    public static final ConfigOption<Boolean> ALL_CATS_DROP_WHITE_CAT_HEAD = new ConfigOption<>("all_cats_drop_white_cat_head", false);
    public static final ConfigOption<Boolean> SNOW_FOXES_DROP_NORMAL_FOX_HEAD = new ConfigOption<>("snow_foxes_drop_normal_fox_head", false);
    public static final ConfigOption<Boolean> ALL_PANDAS_DROP_NORMAL_PANDA_HEAD = new ConfigOption<>("all_pandas_drop_normal_panda_head", false);
    public static final ConfigOption<Boolean> ALL_PARROTS_DROP_RED_PARROT_HEAD = new ConfigOption<>("all_parrots_drop_red_parrot_head", false);
    public static final ConfigOption<Boolean> CAVE_SPIDERS_DROP_NORMAL_SPIDER_HEAD = new ConfigOption<>("cave_spiders_drop_normal_spider_head", false);
    public static final ConfigOption<Boolean> ALL_RABBITS_DROP_BROWN_RABBIT_HEAD = new ConfigOption<>("all_rabbits_drop_brown_rabbit_head", false);
    public static final ConfigOption<Boolean> JEB_SHEEP_DROP_JEB_HEAD = new ConfigOption<>("jeb_sheep_drop_jeb_head", true);
    public static final ConfigOption<Boolean> SNOW_GOLEMS_WITH_PUMPKIN_DROP_SNOW_GOLEM_HEAD = new ConfigOption<>("snow_golems_with_pumpkin_drop_snow_golem_head", false);
    public static final ConfigOption<Boolean> WITHER_SKULL_GRANTS_WITHER_IMMUNITY = new ConfigOption<>("wither_skull_grants_wither_immunity", true);
    public static final ConfigOption<Boolean> FOX_HEADS_TICK = new ConfigOption<>("fox_heads_tick", true);

    public static final ConfigOption<Boolean> VILLAGER_HEAD_DROP = new ConfigOption<>("villager_head_drop", true);
    public static final ConfigOption<Boolean> EVOKER_HEAD_DROP = new ConfigOption<>("evoker_head_drop", true);
    public static final ConfigOption<Boolean> VINDICATOR_HEAD_DROP = new ConfigOption<>("vindicator_head_drop", true);
    public static final ConfigOption<Boolean> PILLAGER_HEAD_DROP = new ConfigOption<>("pillager_head_drop", true);
    public static final ConfigOption<Boolean> ZOMBIE_VILLAGER_HEAD_DROP = new ConfigOption<>("zombie_villager_head_drop", true);
    public static final ConfigOption<Boolean> WANDERING_TRADER_HEAD_DROP = new ConfigOption<>("wandering_trader_head_drop", true);
    public static final ConfigOption<Boolean> ILLUSIONER_HEAD_DROP = new ConfigOption<>("illusioner_head_drop", true);
    public static final ConfigOption<Boolean> SHEEP_HEAD_DROP = new ConfigOption<>("sheep_head_drop", true);
    public static final ConfigOption<Boolean> COLORED_SHEEP_HEAD_DROP = new ConfigOption<>("colored_sheep_head_drop", true);
    public static final ConfigOption<Boolean> ALLAY_HEAD_DROP = new ConfigOption<>("allay_head_drop", true);
    public static final ConfigOption<Boolean> VEX_HEAD_DROP = new ConfigOption<>("vex_head_drop", true);
    public static final ConfigOption<Boolean> PIGLIN_HEAD_DROP = new ConfigOption<>("piglin_head_drop", true);
    public static final ConfigOption<Boolean> PIGLIN_BRUTE_HEAD_DROP = new ConfigOption<>("piglin_brute_head_drop", true);
    public static final ConfigOption<Boolean> ZOMBIFIED_PIGLIN_HEAD_DROP = new ConfigOption<>("zombified_piglin_head_drop", true);
    public static final ConfigOption<Boolean> AXOLOTL_HEAD_DROP = new ConfigOption<>("axolotl_head_drop", true);
    public static final ConfigOption<Boolean> COW_HEAD_DROP = new ConfigOption<>("cow_head_drop", true);
    public static final ConfigOption<Boolean> MOOSHROOM_HEAD_DROP = new ConfigOption<>("mooshroom_head_drop", true);
    public static final ConfigOption<Boolean> POLAR_BEAR_HEAD_DROP = new ConfigOption<>("polar_bear_head_drop", true);
    public static final ConfigOption<Boolean> OCELOT_HEAD_DROP = new ConfigOption<>("ocelot_head_drop", true);
    public static final ConfigOption<Boolean> CAT_HEAD_DROP = new ConfigOption<>("cat_head_drop", true);
    public static final ConfigOption<Boolean> ENDERMAN_HEAD_DROP = new ConfigOption<>("enderman_head_drop", true);
    public static final ConfigOption<Boolean> FOX_HEAD_DROP = new ConfigOption<>("fox_head_drop", true);
    public static final ConfigOption<Boolean> IRON_GOLEM_HEAD_DROP = new ConfigOption<>("iron_golem_head_drop", true);
    public static final ConfigOption<Boolean> PANDA_HEAD_DROP = new ConfigOption<>("panda_head_drop", true);
    public static final ConfigOption<Boolean> DROWNED_HEAD_DROP = new ConfigOption<>("drowned_head_drop", true);
    public static final ConfigOption<Boolean> PARROT_HEAD_DROP = new ConfigOption<>("parrot_head_drop", true);
    public static final ConfigOption<Boolean> STRAY_SKULL_DROP = new ConfigOption<>("stray_skull_drop", true);
    public static final ConfigOption<Boolean> SHULKER_HEAD_DROP = new ConfigOption<>("shulker_head_drop", true);
    public static final ConfigOption<Boolean> HUSK_HEAD_DROP = new ConfigOption<>("husk_head_drop", true);
    public static final ConfigOption<Boolean> PIG_HEAD_DROP = new ConfigOption<>("pig_head_drop", true);
    public static final ConfigOption<Boolean> SPIDER_HEAD_DROP = new ConfigOption<>("spider_head_drop", true);
    public static final ConfigOption<Boolean> BLAZE_HEAD_DROP = new ConfigOption<>("blaze_head_drop", true);
    public static final ConfigOption<Boolean> RABBIT_HEAD_DROP = new ConfigOption<>("rabbit_head_drop", true);
    public static final ConfigOption<Boolean> TURTLE_HEAD_DROP = new ConfigOption<>("turtle_head_drop", true);
    public static final ConfigOption<Boolean> WITHER_SKULL_DROP = new ConfigOption<>("wither_skull_drop", true);
    public static final ConfigOption<Boolean> WOLF_HEAD_DROP = new ConfigOption<>("wither_head_drop", true);
    public static final ConfigOption<Boolean> BAT_HEAD_DROP = new ConfigOption<>("bat_head_drop", true);
    public static final ConfigOption<Boolean> WITCH_HEAD_DROP = new ConfigOption<>("witch_head_drop", true);
    public static final ConfigOption<Boolean> CHICKEN_HEAD_DROP = new ConfigOption<>("chicken_head_drop", true);
    public static final ConfigOption<Boolean> PHANTOM_HEAD_DROP = new ConfigOption<>("phantom_head_drop", true);
    public static final ConfigOption<Boolean> SNOW_GOLEM_HEAD_DROP = new ConfigOption<>("snow_golem_head_drop", true);
    public static final ConfigOption<Boolean> CREEPER_HEAD_DROP = new ConfigOption<>("creeper_head_drop", true);
    public static final ConfigOption<Boolean> SKELETON_SKULL_DROP = new ConfigOption<>("skeleton_skull_drop", true);
    public static final ConfigOption<Boolean> ZOMBIE_HEAD_DROP = new ConfigOption<>("zombie_head_drop", true);

    public static final ConfigGroup PASSIVE_MOB_HEADS = new ConfigGroup("passive_mob_heads", VILLAGER_HEAD_DROP, SHEEP_HEAD_DROP, COLORED_SHEEP_HEAD_DROP, ALLAY_HEAD_DROP, AXOLOTL_HEAD_DROP, COW_HEAD_DROP, MOOSHROOM_HEAD_DROP, POLAR_BEAR_HEAD_DROP, OCELOT_HEAD_DROP, CAT_HEAD_DROP, FOX_HEAD_DROP, IRON_GOLEM_HEAD_DROP, PANDA_HEAD_DROP, PARROT_HEAD_DROP, PIG_HEAD_DROP, RABBIT_HEAD_DROP, TURTLE_HEAD_DROP, WOLF_HEAD_DROP, BAT_HEAD_DROP, CHICKEN_HEAD_DROP, SNOW_GOLEM_HEAD_DROP);
    public static final ConfigGroup HOSTILE_MOB_HEADS = new ConfigGroup("hostile_mob_heads", EVOKER_HEAD_DROP, VINDICATOR_HEAD_DROP, PILLAGER_HEAD_DROP, ZOMBIE_VILLAGER_HEAD_DROP, WANDERING_TRADER_HEAD_DROP, ILLUSIONER_HEAD_DROP, VEX_HEAD_DROP, PIGLIN_HEAD_DROP, PIGLIN_BRUTE_HEAD_DROP, ZOMBIFIED_PIGLIN_HEAD_DROP, ENDERMAN_HEAD_DROP, DROWNED_HEAD_DROP, STRAY_SKULL_DROP, SHULKER_HEAD_DROP, HUSK_HEAD_DROP, SPIDER_HEAD_DROP, BLAZE_HEAD_DROP, WITHER_SKULL_DROP, WITCH_HEAD_DROP, PHANTOM_HEAD_DROP, CREEPER_HEAD_DROP, SKELETON_SKULL_DROP, ZOMBIE_HEAD_DROP);

    @Override
    public ConfigSerializer getSerializer() {
        return JSON5Serializer.builder(this).build();
    }
}
