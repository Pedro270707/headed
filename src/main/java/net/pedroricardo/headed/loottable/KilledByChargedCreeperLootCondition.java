//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.pedroricardo.headed.loottable;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

import com.mojang.serialization.Codec;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameter;
import net.minecraft.loot.context.LootContextParameters;

public class KilledByChargedCreeperLootCondition implements LootCondition {
    static final KilledByChargedCreeperLootCondition INSTANCE = new KilledByChargedCreeperLootCondition();
    public static final Codec<KilledByChargedCreeperLootCondition> CODEC = Codec.unit(INSTANCE);

    private KilledByChargedCreeperLootCondition() {
    }

    public LootConditionType getType() {
        return HeadedLootConditionTypes.KILLED_BY_CHARGED_CREEPER;
    }

    public Set<LootContextParameter<?>> getRequiredParameters() {
        return ImmutableSet.of(LootContextParameters.KILLER_ENTITY);
    }
    /**
     * IMPORTANT!
     * Put this condition as the last one.
     * This is because if it's true, even if a
     * posterior condition is false, it'll call
     * onHeadDropped(), which consequently sets
     * shouldDropHead() to false.
     * Then, if there is another pool with this
     * condition, it won't be triggered due to
     * shouldDropHead() being false.
     **/
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
        return () -> INSTANCE;
    }
}
