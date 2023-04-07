package net.pedroricardo.headed.loottable;

import net.minecraft.class_8405;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.pedroricardo.headed.HeadedConfig;
import net.pedroricardo.headed.item.HeadedItems;

import static net.minecraft.entity.passive.CatVariant.*;

public class HeadedLootTable {
    public static ItemStack getHead(MobEntity entity) {
        if (entity instanceof VillagerEntity && HeadedConfig.VILLAGER_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.VILLAGER_HEAD);
        }
        if (entity instanceof EvokerEntity && HeadedConfig.EVOKER_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.EVOKER_HEAD);
        }
        if (entity instanceof VindicatorEntity && HeadedConfig.VINDICATOR_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.VINDICATOR_HEAD);
        }
        if (entity instanceof PillagerEntity && HeadedConfig.PILLAGER_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.PILLAGER_HEAD);
        }
        if (entity instanceof ZombieVillagerEntity && HeadedConfig.ZOMBIE_VILLAGER_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.ZOMBIE_VILLAGER_HEAD);
        }
        if (entity instanceof WanderingTraderEntity && HeadedConfig.WANDERING_TRADER_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.WANDERING_TRADER_HEAD);
        }
        if (entity instanceof IllusionerEntity && HeadedConfig.ILLUSIONER_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.ILLUSIONER_HEAD);
        }
        if (entity instanceof SheepEntity && (HeadedConfig.SHEEP_HEAD_DROP.get() || HeadedConfig.COLORED_SHEEP_HEAD_DROP.get())) {
            if ((((SheepEntity) entity).isSheared() || HeadedConfig.ALL_SHEEP_DROP_SHEARED_HEAD.get()) && HeadedConfig.SHEEP_HEAD_DROP.get()) {
                return new ItemStack(HeadedItems.SHEEP_HEAD);
            } else if (HeadedConfig.COLORED_SHEEP_HEAD_DROP.get()) {
                ItemStack itemStack;
                if (HeadedConfig.ALL_COLORED_SHEEP_DROP_WHITE_SHEEP_HEAD.get()) {
                    itemStack = new ItemStack(HeadedItems.WHITE_SHEEP_HEAD);
                } else {
                    itemStack = switch (((SheepEntity) entity).getColor()) {
                        case WHITE -> new ItemStack(HeadedItems.WHITE_SHEEP_HEAD);
                        case ORANGE -> new ItemStack(HeadedItems.ORANGE_SHEEP_HEAD);
                        case MAGENTA -> new ItemStack(HeadedItems.MAGENTA_SHEEP_HEAD);
                        case LIGHT_BLUE -> new ItemStack(HeadedItems.LIGHT_BLUE_SHEEP_HEAD);
                        case YELLOW -> new ItemStack(HeadedItems.YELLOW_SHEEP_HEAD);
                        case LIME -> new ItemStack(HeadedItems.LIME_SHEEP_HEAD);
                        case PINK -> new ItemStack(HeadedItems.PINK_SHEEP_HEAD);
                        case GRAY -> new ItemStack(HeadedItems.GRAY_SHEEP_HEAD);
                        case LIGHT_GRAY -> new ItemStack(HeadedItems.LIGHT_GRAY_SHEEP_HEAD);
                        case CYAN -> new ItemStack(HeadedItems.CYAN_SHEEP_HEAD);
                        case PURPLE -> new ItemStack(HeadedItems.PURPLE_SHEEP_HEAD);
                        case BLUE -> new ItemStack(HeadedItems.BLUE_SHEEP_HEAD);
                        case BROWN -> new ItemStack(HeadedItems.BROWN_SHEEP_HEAD);
                        case GREEN -> new ItemStack(HeadedItems.GREEN_SHEEP_HEAD);
                        case RED -> new ItemStack(HeadedItems.RED_SHEEP_HEAD);
                        case BLACK -> new ItemStack(HeadedItems.BLACK_SHEEP_HEAD);
                    };
                }
                if (entity.getName().getString().equals("jeb_") && HeadedConfig.JEB_SHEEP_DROP_JEB_HEAD.get())
                    itemStack.setCustomName(Text.literal(entity.getName().getString()));
                return itemStack;
            }
        }
        if (entity instanceof AllayEntity && HeadedConfig.ALLAY_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.ALLAY_HEAD);
        }
        if (entity instanceof VexEntity && HeadedConfig.VEX_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.VEX_HEAD);
        }
        if (entity instanceof PiglinEntity && HeadedConfig.PIGLIN_HEAD_DROP.get()) {
            return new ItemStack(Items.PIGLIN_HEAD);
        }
        if (entity instanceof PiglinBruteEntity && HeadedConfig.PIGLIN_BRUTE_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.PIGLIN_BRUTE_HEAD);
        }
        if (entity instanceof ZombifiedPiglinEntity && HeadedConfig.ZOMBIFIED_PIGLIN_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.ZOMBIFIED_PIGLIN_HEAD);
        }
        if (entity instanceof AxolotlEntity && HeadedConfig.AXOLOTL_HEAD_DROP.get()) {
            if (HeadedConfig.ALL_AXOLOTLS_DROP_LEUCISTIC_AXOLOTL_HEAD.get()) {
                return new ItemStack(HeadedItems.LEUCISTIC_AXOLOTL_HEAD);
            } else {
                return switch (((AxolotlEntity) entity).getVariant()) {
                    case BLUE -> new ItemStack(HeadedItems.BLUE_AXOLOTL_HEAD);
                    case CYAN -> new ItemStack(HeadedItems.CYAN_AXOLOTL_HEAD);
                    case GOLD -> new ItemStack(HeadedItems.GOLD_AXOLOTL_HEAD);
                    case LUCY -> new ItemStack(HeadedItems.LEUCISTIC_AXOLOTL_HEAD);
                    case WILD -> new ItemStack(HeadedItems.BROWN_AXOLOTL_HEAD);
                };
            }
        }
        if (entity instanceof CowEntity) {
            if (entity instanceof MooshroomEntity && HeadedConfig.MOOSHROOM_HEAD_DROP.get()) {
                if (HeadedConfig.BROWN_MOOSHROOMS_DROP_RED_MOOSHROOM_HEAD.get()) {
                    return new ItemStack(HeadedItems.RED_MOOSHROOM_HEAD);
                } else {
                    return ((MooshroomEntity) entity).getVariant() == MooshroomEntity.Type.RED ? new ItemStack(HeadedItems.RED_MOOSHROOM_HEAD) : new ItemStack(HeadedItems.BROWN_MOOSHROOM_HEAD);
                }
            } else if (entity instanceof class_8405) { // the moon cow from the new april fools update
                return new ItemStack(HeadedItems.MOON_COW_HEAD);
            }
            if (HeadedConfig.COW_HEAD_DROP.get()) {
                return new ItemStack(HeadedItems.COW_HEAD);
            }
        }
        if (entity instanceof PolarBearEntity && HeadedConfig.POLAR_BEAR_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.POLAR_BEAR_HEAD);
        }
        if (entity instanceof OcelotEntity && HeadedConfig.OCELOT_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.OCELOT_HEAD);
        }
        if (entity instanceof CatEntity && HeadedConfig.CAT_HEAD_DROP.get()) {
            ItemStack itemStack;
            if (HeadedConfig.ALL_CATS_DROP_WHITE_CAT_HEAD.get()) {
                itemStack = new ItemStack(HeadedItems.WHITE_CAT_HEAD);
            } else {
                if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(ALL_BLACK)) {
                    itemStack = new ItemStack(HeadedItems.ALL_BLACK_CAT_HEAD);
                } else if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(BLACK)) {
                    itemStack = new ItemStack(HeadedItems.BLACK_CAT_HEAD);
                } else if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(BRITISH_SHORTHAIR)) {
                    itemStack = new ItemStack(HeadedItems.BRITISH_SHORTHAIR_CAT_HEAD);
                } else if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(CALICO)) {
                    itemStack = new ItemStack(HeadedItems.CALICO_CAT_HEAD);
                } else if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(JELLIE)) {
                    itemStack = new ItemStack(HeadedItems.JELLIE_CAT_HEAD);
                } else if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(PERSIAN)) {
                    itemStack = new ItemStack(HeadedItems.PERSIAN_CAT_HEAD);
                } else if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(RAGDOLL)) {
                    itemStack = new ItemStack(HeadedItems.RAGDOLL_CAT_HEAD);
                } else if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(RED)) {
                    itemStack = new ItemStack(HeadedItems.RED_CAT_HEAD);
                } else if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(SIAMESE)) {
                    itemStack = new ItemStack(HeadedItems.SIAMESE_CAT_HEAD);
                } else if (((CatEntity) entity).getVariant() == Registries.CAT_VARIANT.get(TABBY)) {
                    itemStack = new ItemStack(HeadedItems.TABBY_CAT_HEAD);
                } else {
                    itemStack = new ItemStack(HeadedItems.WHITE_CAT_HEAD);
                }
            }
            if (((CatEntity) entity).isTamed()) {
                if (HeadedConfig.TAMED_CATS_DROP_NAMED_HEAD.get()) {
                    if (entity.hasCustomName())
                        itemStack.setCustomName(Text.translatable("block.headed.cat_head.named", entity.getName()));
                }
                itemStack.getOrCreateSubNbt("BlockEntityTag").putBoolean("Tamed", true);
            }
            return itemStack;
        }
        if (entity instanceof EndermanEntity && HeadedConfig.ENDERMAN_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.ENDERMAN_HEAD);
        }
        if (entity instanceof FoxEntity && HeadedConfig.FOX_HEAD_DROP.get()) {
            if (HeadedConfig.SNOW_FOXES_DROP_NORMAL_FOX_HEAD.get()) {
                return new ItemStack(HeadedItems.FOX_HEAD);
            } else {
                return ((FoxEntity) entity).getVariant() == FoxEntity.Type.RED ? new ItemStack(HeadedItems.FOX_HEAD) : new ItemStack(HeadedItems.SNOW_FOX_HEAD);
            }
        }
        if (entity instanceof IronGolemEntity && HeadedConfig.IRON_GOLEM_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.IRON_GOLEM_HEAD);
        }
        if (entity instanceof PandaEntity && HeadedConfig.PANDA_HEAD_DROP.get()) {
            if (!HeadedConfig.ALL_PANDAS_DROP_NORMAL_PANDA_HEAD.get()) {
                if (entity.isAttacking()) {
                    return new ItemStack(HeadedItems.AGGRESSIVE_PANDA_HEAD);
                }
                if (((PandaEntity) entity).isBrown()) {
                    return new ItemStack(HeadedItems.BROWN_PANDA_HEAD);
                }
                if (((PandaEntity) entity).isLazy()) {
                    return new ItemStack(HeadedItems.LAZY_PANDA_HEAD);
                }
                if (((PandaEntity) entity).isPlayful()) {
                    return new ItemStack(HeadedItems.PLAYFUL_PANDA_HEAD);
                }
                if (((PandaEntity) entity).isWeak()) {
                    return new ItemStack(HeadedItems.WEAK_PANDA_HEAD);
                }
                if (((PandaEntity) entity).isWorried()) {
                    return new ItemStack(HeadedItems.WORRIED_PANDA_HEAD);
                }
            }
            return new ItemStack(HeadedItems.PANDA_HEAD);
        }
        if (entity instanceof DrownedEntity && HeadedConfig.DROWNED_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.DROWNED_HEAD);
        }
        if (entity instanceof ParrotEntity && HeadedConfig.PARROT_HEAD_DROP.get()) {
            if (HeadedConfig.ALL_PARROTS_DROP_RED_PARROT_HEAD.get()) {
                return new ItemStack(HeadedItems.RED_PARROT_HEAD);
            } else {
                return switch (((ParrotEntity) entity).getVariant()) {
                    case RED_BLUE -> new ItemStack(HeadedItems.RED_PARROT_HEAD);
                    case BLUE -> new ItemStack(HeadedItems.BLUE_PARROT_HEAD);
                    case GREEN -> new ItemStack(HeadedItems.GREEN_PARROT_HEAD);
                    case YELLOW_BLUE -> new ItemStack(HeadedItems.CYAN_PARROT_HEAD);
                    case GRAY -> new ItemStack(HeadedItems.GRAY_PARROT_HEAD);
                };
            }
        }
        if (entity instanceof StrayEntity && HeadedConfig.STRAY_SKULL_DROP.get()) {
            return new ItemStack(HeadedItems.STRAY_SKULL);
        }
        if (entity instanceof ShulkerEntity && HeadedConfig.SHULKER_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.SHULKER_HEAD);
        }
        if (entity instanceof HuskEntity && HeadedConfig.HUSK_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.HUSK_HEAD);
        }
        if (entity instanceof PigEntity && HeadedConfig.PIG_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.PIG_HEAD);
        }
        if (entity instanceof SpiderEntity && HeadedConfig.SPIDER_HEAD_DROP.get()) {
            if (HeadedConfig.CAVE_SPIDERS_DROP_NORMAL_SPIDER_HEAD.get()) {
                return new ItemStack(HeadedItems.SPIDER_HEAD);
            } else {
                return entity instanceof CaveSpiderEntity ? new ItemStack(HeadedItems.CAVE_SPIDER_HEAD) : new ItemStack(HeadedItems.SPIDER_HEAD);
            }
        }
        if (entity instanceof BlazeEntity && HeadedConfig.BLAZE_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.BLAZE_HEAD);
        }
        if (entity instanceof RabbitEntity && HeadedConfig.RABBIT_HEAD_DROP.get()) {
            ItemStack itemStack;
            if (HeadedConfig.ALL_RABBITS_DROP_BROWN_RABBIT_HEAD.get()) {
                itemStack = new ItemStack(HeadedItems.BROWN_RABBIT_HEAD);
            } else {
                itemStack = switch (((RabbitEntity) entity).getVariant()) {
                    case BROWN -> new ItemStack(HeadedItems.BROWN_RABBIT_HEAD);
                    case WHITE -> new ItemStack(HeadedItems.WHITE_RABBIT_HEAD);
                    case BLACK -> new ItemStack(HeadedItems.BLACK_RABBIT_HEAD);
                    case WHITE_SPLOTCHED -> new ItemStack(HeadedItems.WHITE_SPLOTCHED_RABBIT_HEAD);
                    case GOLD -> new ItemStack(HeadedItems.GOLD_RABBIT_HEAD);
                    case SALT -> new ItemStack(HeadedItems.SALT_RABBIT_HEAD);
                    case EVIL -> new ItemStack(HeadedItems.EVIL_RABBIT_HEAD);
                };
            }
            if (entity.getName().getString().equals("Toast") && HeadedConfig.TOAST_RABBITS_DROP_NAMED_HEAD.get()) itemStack.setCustomName(Text.literal(entity.getName().getString()));
            return itemStack;
        }
        if (entity instanceof TurtleEntity && HeadedConfig.TURTLE_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.TURTLE_HEAD);
        }
        if (entity instanceof WitherEntity && HeadedConfig.WITHER_SKULL_DROP.get()) {
            return new ItemStack(HeadedItems.WITHER_SKULL);
        }
        if (entity instanceof WolfEntity && HeadedConfig.WOLF_HEAD_DROP.get()) {
            if (((WolfEntity) entity).isTamed() && HeadedConfig.TAMED_WOLVES_DROP_TAMED_HEAD.get()) {
                ItemStack itemStack = new ItemStack(HeadedItems.WOLF_HEAD);
                if (entity.hasCustomName()) itemStack.setCustomName(Text.translatable("block.headed.wolf_head.named", entity.getName()));
                itemStack.getOrCreateSubNbt("BlockEntityTag").putBoolean("Tamed", true);
                return itemStack;
            }
            return new ItemStack(HeadedItems.WOLF_HEAD);
        }
        if (entity instanceof BatEntity && HeadedConfig.BAT_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.BAT_HEAD);
        }
        if (entity instanceof WitchEntity && HeadedConfig.WITCH_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.WITCH_HEAD);
        }
        if (entity instanceof ChickenEntity && HeadedConfig.CHICKEN_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.CHICKEN_HEAD);
        }
        if (entity instanceof PhantomEntity && HeadedConfig.PHANTOM_HEAD_DROP.get()) {
            return new ItemStack(HeadedItems.PHANTOM_HEAD);
        }
        if (entity instanceof SnowGolemEntity && HeadedConfig.SNOW_GOLEM_HEAD_DROP.get()) {
            if (((SnowGolemEntity) entity).hasPumpkin() && !HeadedConfig.SNOW_GOLEMS_WITH_PUMPKIN_DROP_SNOW_GOLEM_HEAD.get()) {
                return new ItemStack(Items.CARVED_PUMPKIN);
            }
            return new ItemStack(HeadedItems.SNOW_GOLEM_HEAD);
        }
        if (entity instanceof CreeperEntity && HeadedConfig.CREEPER_HEAD_DROP.get()) {
            return new ItemStack(Items.CREEPER_HEAD);
        }
        if (entity instanceof SkeletonEntity && HeadedConfig.SKELETON_SKULL_DROP.get()) {
            return new ItemStack(Items.SKELETON_SKULL);
        }
        if (entity instanceof ZombieEntity && HeadedConfig.ZOMBIE_HEAD_DROP.get()) {
            return new ItemStack(Items.ZOMBIE_HEAD);
        }
        return ItemStack.EMPTY;
    }
}
