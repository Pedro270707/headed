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
public class ModEntityModelLayers {
    private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();
    public static final EntityModelLayer VILLAGER_HEAD = registerMain("villager_head");

    public ModEntityModelLayers() {
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