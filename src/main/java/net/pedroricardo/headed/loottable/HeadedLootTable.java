package net.pedroricardo.headed.loottable;

import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.pedroricardo.headed.item.HeadedItems;

import static net.minecraft.entity.passive.CatVariant.*;

public class HeadedLootTable {
    public static ItemStack getHead(MobEntity entity) {
        if (entity instanceof VillagerEntity) {
            return new ItemStack(HeadedItems.VILLAGER_HEAD);
        }
        if (entity instanceof EvokerEntity) {
            return new ItemStack(HeadedItems.EVOKER_HEAD);
        }
        if (entity instanceof VindicatorEntity) {
            return new ItemStack(HeadedItems.VINDICATOR_HEAD);
        }
        if (entity instanceof PillagerEntity) {
            return new ItemStack(HeadedItems.PILLAGER_HEAD);
        }
        if (entity instanceof ZombieVillagerEntity) {
            return new ItemStack(HeadedItems.ZOMBIE_VILLAGER_HEAD);
        }
        if (entity instanceof WanderingTraderEntity) {
            return new ItemStack(HeadedItems.WANDERING_TRADER_HEAD);
        }
        if (entity instanceof IllusionerEntity) {
            return new ItemStack(HeadedItems.ILLUSIONER_HEAD);
        }
        if (entity instanceof SheepEntity) {
            if (((SheepEntity) entity).isSheared()) {
                return new ItemStack(HeadedItems.SHEEP_HEAD);
            }
            ItemStack itemStack = switch (((SheepEntity) entity).getColor()) {
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
            if (entity.getName().getString().equals("jeb_")) itemStack.setCustomName(Text.literal(entity.getName().getString()));
            return itemStack;
        }
        if (entity instanceof AllayEntity) {
            return new ItemStack(HeadedItems.ALLAY_HEAD);
        }
        if (entity instanceof VexEntity) {
            return new ItemStack(HeadedItems.VEX_HEAD);
        }
        if (entity instanceof PiglinBruteEntity) {
            return new ItemStack(HeadedItems.PIGLIN_BRUTE_HEAD);
        }
        if (entity instanceof ZombifiedPiglinEntity) {
            return new ItemStack(HeadedItems.ZOMBIFIED_PIGLIN_HEAD);
        }
        if (entity instanceof AxolotlEntity) {
            return switch (((AxolotlEntity) entity).getVariant()) {
                case BLUE -> new ItemStack(HeadedItems.BLUE_AXOLOTL_HEAD);
                case CYAN -> new ItemStack(HeadedItems.CYAN_AXOLOTL_HEAD);
                case GOLD -> new ItemStack(HeadedItems.GOLD_AXOLOTL_HEAD);
                case LUCY -> new ItemStack(HeadedItems.LEUCISTIC_AXOLOTL_HEAD);
                case WILD -> new ItemStack(HeadedItems.BROWN_AXOLOTL_HEAD);
            };
        }
        if (entity instanceof CowEntity) {
            if (entity instanceof MooshroomEntity) {
                return ((MooshroomEntity) entity).getMooshroomType() == MooshroomEntity.Type.RED ? new ItemStack(HeadedItems.RED_MOOSHROOM_HEAD) : new ItemStack(HeadedItems.BROWN_MOOSHROOM_HEAD);
            }
            return new ItemStack(HeadedItems.COW_HEAD);
        }
        if (entity instanceof PolarBearEntity) {
            return new ItemStack(HeadedItems.POLAR_BEAR_HEAD);
        }
        if (entity instanceof OcelotEntity) {
            return new ItemStack(HeadedItems.OCELOT_HEAD);
        }
        if (entity instanceof CatEntity) {
            ItemStack itemStack;
            if (((CatEntity) entity).getVariant() == ALL_BLACK) {
                itemStack = new ItemStack(HeadedItems.ALL_BLACK_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == BLACK) {
                itemStack = new ItemStack(HeadedItems.BLACK_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == BRITISH_SHORTHAIR) {
                itemStack = new ItemStack(HeadedItems.BRITISH_SHORTHAIR_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == CALICO) {
                itemStack = new ItemStack(HeadedItems.CALICO_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == JELLIE) {
                itemStack = new ItemStack(HeadedItems.JELLIE_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == PERSIAN) {
                itemStack = new ItemStack(HeadedItems.PERSIAN_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == RAGDOLL) {
                itemStack = new ItemStack(HeadedItems.RAGDOLL_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == RED) {
                itemStack = new ItemStack(HeadedItems.RED_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == SIAMESE) {
                itemStack = new ItemStack(HeadedItems.SIAMESE_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == TABBY) {
                itemStack = new ItemStack(HeadedItems.TABBY_CAT_HEAD);
            } else if (((CatEntity) entity).getVariant() == WHITE) {
                itemStack = new ItemStack(HeadedItems.WHITE_CAT_HEAD);
            } else {
                itemStack = new ItemStack(Items.AIR);
            }
            if (((CatEntity) entity).isTamed()) {
                if (entity.hasCustomName()) itemStack.setCustomName(Text.translatable("block.headed.cat_head.named", entity.getName()));
                itemStack.getOrCreateSubNbt("BlockEntityTag").putBoolean("Tamed", true);
            }
            return itemStack;
        }
        if (entity instanceof EndermanEntity) {
            return new ItemStack(HeadedItems.ENDERMAN_HEAD);
        }
        if (entity instanceof FoxEntity) {
            return ((FoxEntity) entity).getFoxType() == FoxEntity.Type.RED ? new ItemStack(HeadedItems.FOX_HEAD) : new ItemStack(HeadedItems.SNOW_FOX_HEAD);
        }
        if (entity instanceof IronGolemEntity) {
            return new ItemStack(HeadedItems.IRON_GOLEM_HEAD);
        }
        if (entity instanceof PandaEntity) {
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
            return new ItemStack(HeadedItems.PANDA_HEAD);
        }
        if (entity instanceof DrownedEntity) {
            return new ItemStack(HeadedItems.DROWNED_HEAD);
        }
        if (entity instanceof ParrotEntity) {
            return switch (((ParrotEntity) entity).getVariant()) {
                case 0 -> new ItemStack(HeadedItems.RED_PARROT_HEAD);
                case 1 -> new ItemStack(HeadedItems.BLUE_PARROT_HEAD);
                case 2 -> new ItemStack(HeadedItems.GREEN_PARROT_HEAD);
                case 3 -> new ItemStack(HeadedItems.CYAN_PARROT_HEAD);
                case 4 -> new ItemStack(HeadedItems.GRAY_PARROT_HEAD);
                default -> new ItemStack(HeadedItems.RED_PARROT_HEAD);
            };
        }
        if (entity instanceof StrayEntity) {
            return new ItemStack(HeadedItems.STRAY_SKULL);
        }
        if (entity instanceof ShulkerEntity) {
            return new ItemStack(HeadedItems.SHULKER_HEAD);
        }
        if (entity instanceof HuskEntity) {
            return new ItemStack(HeadedItems.HUSK_HEAD);
        }
        if (entity instanceof PigEntity) {
            return new ItemStack(HeadedItems.PIG_HEAD);
        }
        if (entity instanceof SpiderEntity) {
            return entity instanceof CaveSpiderEntity ? new ItemStack(HeadedItems.CAVE_SPIDER_HEAD) : new ItemStack(HeadedItems.SPIDER_HEAD);
        }
        if (entity instanceof BlazeEntity) {
            return new ItemStack(HeadedItems.BLAZE_HEAD);
        }
        if (entity instanceof RabbitEntity) {
            ItemStack itemStack = switch (((RabbitEntity) entity).getRabbitType()) {

                case 0 -> new ItemStack(HeadedItems.BROWN_RABBIT_HEAD);
                case 1 -> new ItemStack(HeadedItems.WHITE_RABBIT_HEAD);
                case 2 -> new ItemStack(HeadedItems.BLACK_RABBIT_HEAD);
                case 3 -> new ItemStack(HeadedItems.WHITE_SPLOTCHED_RABBIT_HEAD);
                case 4 -> new ItemStack(HeadedItems.GOLD_RABBIT_HEAD);
                case 5 -> new ItemStack(HeadedItems.SALT_RABBIT_HEAD);
                case 6 -> new ItemStack(HeadedItems.EVIL_RABBIT_HEAD);
                default ->
                        new ItemStack(HeadedItems.BROWN_RABBIT_HEAD);
            };
            if (entity.getName().getString().equals("Toast")) itemStack.setCustomName(Text.literal(entity.getName().getString()));
            return itemStack;
        }
        if (entity instanceof TurtleEntity) {
            return new ItemStack(HeadedItems.TURTLE_HEAD);
        }
        if (entity instanceof WitherEntity) {
            return new ItemStack(HeadedItems.WITHER_SKULL);
        }
        if (entity instanceof WolfEntity) {
            if (((WolfEntity) entity).isTamed()) {
                ItemStack itemStack = new ItemStack(HeadedItems.WOLF_HEAD);
                if (entity.hasCustomName()) itemStack.setCustomName(Text.translatable("block.headed.wolf_head.named", entity.getName()));
                itemStack.getOrCreateSubNbt("BlockEntityTag").putBoolean("Tamed", true);
                return itemStack;
            }
            return new ItemStack(HeadedItems.WOLF_HEAD);
        }
        if (entity instanceof BatEntity) {
            return new ItemStack(HeadedItems.BAT_HEAD);
        }
        if (entity instanceof WitchEntity) {
            return new ItemStack(HeadedItems.WITCH_HEAD);
        }
        if (entity instanceof ChickenEntity) {
            return new ItemStack(HeadedItems.CHICKEN_HEAD);
        }
        if (entity instanceof PhantomEntity) {
            return new ItemStack(HeadedItems.PHANTOM_HEAD);
        }
        if (entity instanceof SnowGolemEntity) {
            if (((SnowGolemEntity) entity).hasPumpkin()) {
                return new ItemStack(Items.CARVED_PUMPKIN);
            }
            return new ItemStack(HeadedItems.SNOW_GOLEM_HEAD);
        }
        return new ItemStack(Items.AIR);
    }
}
