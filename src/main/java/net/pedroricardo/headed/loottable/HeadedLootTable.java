package net.pedroricardo.headed.loottable;

import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.pedroricardo.headed.item.HeadedItems;

import static net.minecraft.entity.passive.CatVariant.*;

public class HeadedLootTable {
    public static Item getHead(MobEntity entity) {
        if (entity instanceof VillagerEntity) {
            return HeadedItems.VILLAGER_HEAD;
        }
        if (entity instanceof EvokerEntity) {
            return HeadedItems.EVOKER_HEAD;
        }
        if (entity instanceof VindicatorEntity) {
            return HeadedItems.VINDICATOR_HEAD;
        }
        if (entity instanceof PillagerEntity) {
            return HeadedItems.PILLAGER_HEAD;
        }
        if (entity instanceof ZombieVillagerEntity) {
            return HeadedItems.ZOMBIE_VILLAGER_HEAD;
        }
        if (entity instanceof WanderingTraderEntity) {
            return HeadedItems.WANDERING_TRADER_HEAD;
        }
        if (entity instanceof IllusionerEntity) {
            return HeadedItems.ILLUSIONER_HEAD;
        }
        if (entity instanceof SheepEntity) {
            if (((SheepEntity) entity).isSheared()) {
                return HeadedItems.SHEEP_HEAD;
            }
            return switch (((SheepEntity) entity).getColor()) {
                case WHITE -> HeadedItems.WHITE_SHEEP_HEAD;
                case ORANGE -> HeadedItems.ORANGE_SHEEP_HEAD;
                case MAGENTA -> HeadedItems.MAGENTA_SHEEP_HEAD;
                case LIGHT_BLUE -> HeadedItems.LIGHT_BLUE_SHEEP_HEAD;
                case YELLOW -> HeadedItems.YELLOW_SHEEP_HEAD;
                case LIME -> HeadedItems.LIME_SHEEP_HEAD;
                case PINK -> HeadedItems.PINK_SHEEP_HEAD;
                case GRAY -> HeadedItems.GRAY_SHEEP_HEAD;
                case LIGHT_GRAY -> HeadedItems.LIGHT_GRAY_SHEEP_HEAD;
                case CYAN -> HeadedItems.CYAN_SHEEP_HEAD;
                case PURPLE -> HeadedItems.PURPLE_SHEEP_HEAD;
                case BLUE -> HeadedItems.BLUE_SHEEP_HEAD;
                case BROWN -> HeadedItems.BROWN_SHEEP_HEAD;
                case GREEN -> HeadedItems.GREEN_SHEEP_HEAD;
                case RED -> HeadedItems.RED_SHEEP_HEAD;
                case BLACK -> HeadedItems.BLACK_SHEEP_HEAD;
            };
        }
        if (entity instanceof AllayEntity) {
            return HeadedItems.ALLAY_HEAD;
        }
        if (entity instanceof VexEntity) {
            return HeadedItems.VEX_HEAD;
        }
        if (entity instanceof PiglinBruteEntity) {
            return HeadedItems.PIGLIN_BRUTE_HEAD;
        }
        if (entity instanceof ZombifiedPiglinEntity) {
            return HeadedItems.ZOMBIFIED_PIGLIN_HEAD;
        }
        if (entity instanceof AxolotlEntity) {
            return switch (((AxolotlEntity) entity).getVariant()) {
                case BLUE -> HeadedItems.BLUE_AXOLOTL_HEAD;
                case CYAN -> HeadedItems.CYAN_AXOLOTL_HEAD;
                case GOLD -> HeadedItems.GOLD_AXOLOTL_HEAD;
                case LUCY -> HeadedItems.LEUCISTIC_AXOLOTL_HEAD;
                case WILD -> HeadedItems.BROWN_AXOLOTL_HEAD;
            };
        }
        if (entity instanceof CowEntity) {
            if (entity instanceof MooshroomEntity) {
                return ((MooshroomEntity) entity).getVariant() == MooshroomEntity.Type.RED ? HeadedItems.RED_MOOSHROOM_HEAD : HeadedItems.BROWN_MOOSHROOM_HEAD;
            }
            return HeadedItems.COW_HEAD;
        }
        if (entity instanceof PolarBearEntity) {
            return HeadedItems.POLAR_BEAR_HEAD;
        }
        if (entity instanceof OcelotEntity) {
            return HeadedItems.OCELOT_HEAD;
        }
        if (entity instanceof CatEntity) {
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(ALL_BLACK)) {
                return HeadedItems.ALL_BLACK_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(BLACK)) {
                return HeadedItems.BLACK_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(BRITISH_SHORTHAIR)) {
                return HeadedItems.BRITISH_SHORTHAIR_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(CALICO)) {
                return HeadedItems.CALICO_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(JELLIE)) {
                return HeadedItems.JELLIE_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(PERSIAN)) {
                return HeadedItems.PERSIAN_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(RAGDOLL)) {
                return HeadedItems.RAGDOLL_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(RED)) {
                return HeadedItems.RED_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(SIAMESE)) {
                return HeadedItems.SIAMESE_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(TABBY)) {
                return HeadedItems.TABBY_CAT_HEAD;
            }
            if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(WHITE)) {
                return HeadedItems.WHITE_CAT_HEAD;
            }
        }
        if (entity instanceof EndermanEntity) {
            return HeadedItems.ENDERMAN_HEAD;
        }
        if (entity instanceof FoxEntity) {
            return ((FoxEntity) entity).getVariant() == FoxEntity.Type.RED ? HeadedItems.FOX_HEAD : HeadedItems.SNOW_FOX_HEAD;
        }
        if (entity instanceof IronGolemEntity) {
            return HeadedItems.IRON_GOLEM_HEAD;
        }
        if (entity instanceof PandaEntity) {
            if (entity.isAttacking()) {
                return HeadedItems.AGGRESSIVE_PANDA_HEAD;
            }
            if (((PandaEntity) entity).isBrown()) {
                return HeadedItems.AGGRESSIVE_PANDA_HEAD;
            }
            if (((PandaEntity) entity).isLazy()) {
                return HeadedItems.LAZY_PANDA_HEAD;
            }
            if (((PandaEntity) entity).isPlayful()) {
                return HeadedItems.PLAYFUL_PANDA_HEAD;
            }
            if (((PandaEntity) entity).isWeak()) {
                return HeadedItems.WEAK_PANDA_HEAD;
            }
            if (((PandaEntity) entity).isWorried()) {
                return HeadedItems.WORRIED_PANDA_HEAD;
            }
            return HeadedItems.PANDA_HEAD;
        }
        if (entity instanceof DrownedEntity) {
            return HeadedItems.DROWNED_HEAD;
        }
        return Items.AIR;
    }
}
