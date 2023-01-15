package net.pedroricardo.headed.client.render.entity.model;

import com.google.common.collect.Sets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.Headed;

import java.util.Set;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
public class HeadedEntityModelLayers {
    private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();
    public static final EntityModelLayer VILLAGER_HEAD = registerMain("villager_head");
    public static final EntityModelLayer EVOKER_HEAD = registerMain("evoker_head");
    public static final EntityModelLayer VINDICATOR_HEAD = registerMain("vindicator_head");
    public static final EntityModelLayer PILLAGER_HEAD = registerMain("pillager_head");
    public static final EntityModelLayer ZOMBIE_VILLAGER_HEAD = registerMain("zombie_villager_head");
    public static final EntityModelLayer WANDERING_TRADER_HEAD = registerMain("wandering_trader_head");
    public static final EntityModelLayer ILLUSIONER_HEAD = registerMain("illusioner_head");
    public static final EntityModelLayer SHEEP_HEAD = registerMain("sheep_head");
    public static final EntityModelLayer SHEEP_WOOL = register("sheep_head", "wool");
    public static final EntityModelLayer ALLAY_HEAD = registerMain("allay_head");
    public static final EntityModelLayer VEX_HEAD = registerMain("vex_head");
    public static final EntityModelLayer PIGLIN_HEAD = registerMain("piglin_head");
    public static final EntityModelLayer PIGLIN_BRUTE_HEAD = registerMain("piglin_brute_head");
    public static final EntityModelLayer ZOMBIFIED_PIGLIN_HEAD = registerMain("zombified_piglin_head");
    public static final EntityModelLayer AXOLOTL_HEAD = registerMain("axolotl_head");
    public static final EntityModelLayer COW_HEAD = registerMain("cow_head");
    public static final EntityModelLayer POLAR_BEAR_HEAD = registerMain("polar_bear_head");
    public static final EntityModelLayer OCELOT_HEAD = registerMain("ocelot_head");
    public static final EntityModelLayer ENDERMAN_HEAD = registerMain("enderman_head");
    public static final EntityModelLayer FOX_HEAD = registerMain("fox_head");
    public static final EntityModelLayer IRON_GOLEM_HEAD = registerMain("iron_golem_head");
    public static final EntityModelLayer PANDA_HEAD = registerMain("panda_head");
    public static final EntityModelLayer DROWNED_HEAD = registerMain("drowned_head");
    public static final EntityModelLayer DROWNED_HEAD_OUTER_LAYER = register("drowned_head", "outer");
    public static final EntityModelLayer PARROT_HEAD = registerMain("parrot_head");
    public static final EntityModelLayer STRAY_SKULL = registerMain("stray_skull");
    public static final EntityModelLayer STRAY_SKULL_OUTER_LAYER = register("stray_skull", "outer");
    public static final EntityModelLayer SHULKER_HEAD = registerMain("shulker_head");
    public static final EntityModelLayer HUSK_HEAD = registerMain("husk_head");
    public static final EntityModelLayer PIG_HEAD = registerMain("pig_head");
    public static final EntityModelLayer SPIDER_HEAD = registerMain("spider_head");
    public static final EntityModelLayer SPIDER_EYES = register("spider_head", "eyes");
    public static final EntityModelLayer BLAZE_HEAD = registerMain("blaze_head");
    public static final EntityModelLayer RABBIT_HEAD = registerMain("rabbit_head");
    public static final EntityModelLayer TURTLE_HEAD = registerMain("turtle_head");
    public static final EntityModelLayer WITHER_SKULL = registerMain("wither_skull");
    public static final EntityModelLayer WOLF_HEAD = registerMain("wolf_head");
    public static final EntityModelLayer BAT_HEAD = registerMain("bat_head");
    public static final EntityModelLayer WITCH_HEAD = registerMain("witch_head");
    public static final EntityModelLayer CHICKEN_HEAD = registerMain("chicken_head");
    public static final EntityModelLayer PHANTOM_HEAD = registerMain("phantom_head");
    public static final EntityModelLayer PHANTOM_EYES = register("phantom_head", "eyes");
    public static final EntityModelLayer SNOW_GOLEM_HEAD = registerMain("snow_golem_head");

    public HeadedEntityModelLayers() {
    }

    private static EntityModelLayer registerMain(String id) {
        return register(id, "main");
    }

    private static EntityModelLayer register(String id, String layer) {
        EntityModelLayer entityModelLayer = create(id, layer);
        if (!LAYERS.add(entityModelLayer)) {
            throw new IllegalStateException("Duplicate registration for " + entityModelLayer);
        } else {
            return entityModelLayer;
        }
    }

    private static EntityModelLayer create(String id, String layer) {
        return new EntityModelLayer(new Identifier(Headed.MOD_ID, id), layer);
    }

    public static Stream<EntityModelLayer> getLayers() {
        return LAYERS.stream();
    }
}