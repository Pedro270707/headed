//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.pedroricardo.headed.loottable;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import java.util.Set;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameter;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.util.JsonSerializer;

public class KilledByChargedCreeperLootCondition implements LootCondition {
    static final KilledByChargedCreeperLootCondition INSTANCE = new KilledByChargedCreeperLootCondition();

    private KilledByChargedCreeperLootCondition() {
    }

    public LootConditionType getType() {
        return HeadedLootConditionTypes.KILLED_BY_CHARGED_CREEPER;
    }

    public Set<LootContextParameter<?>> getRequiredParameters() {
        return ImmutableSet.of(LootContextParameters.KILLER_ENTITY);
    }
    /*
    * IMPORTANT!
    * Put this condition as the last one.
    * This is because if it's true, even if a
    * posterior condition is false, it'll call
    * onHeadDropped(), which consequently sets
    * shouldDropHead() to false.
    * Then, if there is another pool with this
    * condition, it won't be triggered due to
    * shouldDropHead() being false.
    * */
    public boolean test(LootContext lootContext) {
        if (lootContext.hasParameter(LootContextParameters.KILLER_ENTITY)) {
            Entity killer = lootContext.get(LootContextParameters.KILLER_ENTITY);

            if (killer instanceof CreeperEntity creeper && creeper.shouldDropHead()) {
                creeper.onHeadDropped();
                return true;
            }
        }
        return false;
    }

    public static LootCondition.Builder builder() {
        return () -> {
            return INSTANCE;
        };
    }

    public static class Serializer implements JsonSerializer<KilledByChargedCreeperLootCondition> {
        public Serializer() {
        }

        public void toJson(JsonObject jsonObject, KilledByChargedCreeperLootCondition killedByPlayerLootCondition, JsonSerializationContext jsonSerializationContext) {
        }

        public KilledByChargedCreeperLootCondition fromJson(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
            return KilledByChargedCreeperLootCondition.INSTANCE;
        }
    }
}
