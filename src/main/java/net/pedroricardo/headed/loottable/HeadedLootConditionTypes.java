package net.pedroricardo.headed.loottable;

import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonSerializer;
import net.minecraft.util.registry.Registry;
import net.pedroricardo.headed.Headed;

public class HeadedLootConditionTypes {
    public static final LootConditionType KILLED_BY_CHARGED_CREEPER;

    static {
        KILLED_BY_CHARGED_CREEPER = register("killed_by_charged_creeper", new KilledByChargedCreeperLootCondition.Serializer());
    }

    private static LootConditionType register(String id, JsonSerializer<? extends LootCondition> serializer) {
        return Registry.register(Registry.LOOT_CONDITION_TYPE, new Identifier(Headed.MOD_ID, id), new LootConditionType(serializer));
    }

    public static void registerModLootConditions() {
        Headed.LOGGER.debug("Registering Headed loot conditions");
    }
}
