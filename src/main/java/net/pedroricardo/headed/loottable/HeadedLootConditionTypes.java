package net.pedroricardo.headed.loottable;

import com.mojang.serialization.Codec;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.Headed;

public class HeadedLootConditionTypes {
    public static final LootConditionType KILLED_BY_CHARGED_CREEPER = register("killed_by_charged_creeper", KilledByChargedCreeperLootCondition.CODEC);

    private static LootConditionType register(String id, Codec<? extends LootCondition> codec) {
        return (LootConditionType) Registry.register(Registries.LOOT_CONDITION_TYPE, new Identifier(Headed.MOD_ID, id), new LootConditionType(codec));
    }

    public static void registerModLootConditions() {
        Headed.LOGGER.debug("Registering Headed loot conditions");
    }
}
