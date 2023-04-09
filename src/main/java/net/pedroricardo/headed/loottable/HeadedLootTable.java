package net.pedroricardo.headed.loottable;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.*;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.CopyNameLootFunction;
import net.minecraft.loot.function.CopyNbtLootFunction;
import net.minecraft.loot.function.FillPlayerHeadLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.NbtPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.Headed;
import net.pedroricardo.headed.item.HeadedItems;

public class HeadedLootTable {
    // This class adds the heads to the loot table
    // Every pool uses the
    // KilledByChargedCreeperLootCondition loot table
    // condition. Check it out!
    static {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.VILLAGER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().conditionally(KilledByChargedCreeperLootCondition.builder())
                        .with(ItemEntry.builder(HeadedItems.VILLAGER_HEAD).build()).build()).build();
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.EVOKER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().conditionally(KilledByChargedCreeperLootCondition.builder())
                        .with(ItemEntry.builder(HeadedItems.EVOKER_HEAD).build()).build()).build();
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.VINDICATOR.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().conditionally(KilledByChargedCreeperLootCondition.builder())
                        .with(ItemEntry.builder(HeadedItems.VINDICATOR_HEAD).build()).build()).build();
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.PILLAGER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().conditionally(KilledByChargedCreeperLootCondition.builder())
                        .with(ItemEntry.builder(HeadedItems.PILLAGER_HEAD).build()).build()).build();
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.ZOMBIE_VILLAGER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().conditionally(KilledByChargedCreeperLootCondition.builder())
                        .with(ItemEntry.builder(HeadedItems.ZOMBIE_VILLAGER_HEAD).build()).build()).build();
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.WANDERING_TRADER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().conditionally(KilledByChargedCreeperLootCondition.builder())
                        .with(ItemEntry.builder(HeadedItems.WANDERING_TRADER_HEAD).build()).build()).build();
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.ILLUSIONER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().conditionally(KilledByChargedCreeperLootCondition.builder())
                        .with(ItemEntry.builder(HeadedItems.ILLUSIONER_HEAD).build()).build()).build();
            }
        });
        NbtCompound shearedNbtCompound = new NbtCompound();
        shearedNbtCompound.putBoolean("Sheared", true);
        NbtPredicate shearedNbtPredicate = new NbtPredicate(shearedNbtCompound);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.SHEEP.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(shearedNbtPredicate)))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())
                        .with(ItemEntry.builder(HeadedItems.SHEEP_HEAD).build()).build()).build();
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.WHITE_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.WHITE_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.ORANGE_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.ORANGE_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.MAGENTA_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.MAGENTA_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.LIGHT_BLUE_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.LIGHT_BLUE_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.YELLOW_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.YELLOW_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.LIME_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.LIME_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.PINK_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.PINK_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.GRAY_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.GRAY_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.LIGHT_GRAY_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.LIGHT_GRAY_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.CYAN_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.CYAN_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.PURPLE_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.PURPLE_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.BLUE_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.BLUE_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.BROWN_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.BROWN_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.GREEN_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.GREEN_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.RED_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.RED_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && LootTables.BLACK_SHEEP_ENTITY.equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.BLACK_SHEEP_HEAD)
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder())));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.ALLAY.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.ALLAY_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.VEX.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.VEX_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.PIGLIN_BRUTE.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.PIGLIN_BRUTE_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.ZOMBIFIED_PIGLIN.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.ZOMBIFIED_PIGLIN_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        NbtCompound lucyAxolotlNbtCompound = new NbtCompound();
        NbtCompound brownAxolotlNbtCompound = new NbtCompound();
        NbtCompound goldAxolotlNbtCompound = new NbtCompound();
        NbtCompound cyanAxolotlNbtCompound = new NbtCompound();
        NbtCompound blueAxolotlNbtCompound = new NbtCompound();
        lucyAxolotlNbtCompound.putInt("Variant", AxolotlEntity.Variant.LUCY.getId());
        brownAxolotlNbtCompound.putInt("Variant", AxolotlEntity.Variant.WILD.getId());
        goldAxolotlNbtCompound.putInt("Variant", AxolotlEntity.Variant.GOLD.getId());
        cyanAxolotlNbtCompound.putInt("Variant", AxolotlEntity.Variant.CYAN.getId());
        blueAxolotlNbtCompound.putInt("Variant", AxolotlEntity.Variant.BLUE.getId());
        NbtPredicate lucyAxolotlNbtPredicate = new NbtPredicate(lucyAxolotlNbtCompound);
        NbtPredicate brownAxolotlNbtPredicate = new NbtPredicate(brownAxolotlNbtCompound);
        NbtPredicate goldAxolotlNbtPredicate = new NbtPredicate(goldAxolotlNbtCompound);
        NbtPredicate cyanAxolotlNbtPredicate = new NbtPredicate(cyanAxolotlNbtCompound);
        NbtPredicate blueAxolotlNbtPredicate = new NbtPredicate(blueAxolotlNbtCompound);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.AXOLOTL.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.LEUCISTIC_AXOLOTL_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(lucyAxolotlNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.BROWN_AXOLOTL_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(brownAxolotlNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.GOLD_AXOLOTL_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(goldAxolotlNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.CYAN_AXOLOTL_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(cyanAxolotlNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.BLUE_AXOLOTL_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(blueAxolotlNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.COW.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.COW_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        NbtCompound redMooshroomNbtCompound = new NbtCompound();
        NbtCompound brownMooshroomNbtCompound = new NbtCompound();
        redMooshroomNbtCompound.putString("Type", MooshroomEntity.Type.RED.asString());
        brownMooshroomNbtCompound.putString("Type", MooshroomEntity.Type.BROWN.asString());
        NbtPredicate redMooshroomNbtPredicate = new NbtPredicate(redMooshroomNbtCompound);
        NbtPredicate brownMooshroomNbtPredicate = new NbtPredicate(brownMooshroomNbtCompound);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.MOOSHROOM.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(HeadedItems.RED_MOOSHROOM_HEAD))
                            .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(redMooshroomNbtPredicate)))
                            .conditionally(KilledByChargedCreeperLootCondition.builder()))
                    .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(HeadedItems.BROWN_MOOSHROOM_HEAD))
                            .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(brownMooshroomNbtPredicate)))
                            .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.POLAR_BEAR.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.POLAR_BEAR_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.OCELOT.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.OCELOT_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        NbtCompound allBlackCatNbtCompound = new NbtCompound();
        NbtCompound blackCatNbtCompound = new NbtCompound();
        NbtCompound britishShorthairCatNbtCompound = new NbtCompound();
        NbtCompound calicoCatNbtCompound = new NbtCompound();
        NbtCompound jellieCatNbtCompound = new NbtCompound();
        NbtCompound persianCatNbtCompound = new NbtCompound();
        NbtCompound ragdollCatNbtCompound = new NbtCompound();
        NbtCompound redCatNbtCompound = new NbtCompound();
        NbtCompound siameseCatNbtCompound = new NbtCompound();
        NbtCompound tabbyCatNbtCompound = new NbtCompound();
        NbtCompound whiteCatNbtCompound = new NbtCompound();
        allBlackCatNbtCompound.putString("variant", new Identifier("all_black").toString());
        blackCatNbtCompound.putString("variant", new Identifier("black").toString());
        britishShorthairCatNbtCompound.putString("variant", new Identifier("british_shorthair").toString());
        calicoCatNbtCompound.putString("variant", new Identifier("calico").toString());
        jellieCatNbtCompound.putString("variant", new Identifier("jellie").toString());
        persianCatNbtCompound.putString("variant", new Identifier("persian").toString());
        ragdollCatNbtCompound.putString("variant", new Identifier("ragdoll").toString());
        redCatNbtCompound.putString("variant", new Identifier("red").toString());
        siameseCatNbtCompound.putString("variant", new Identifier("siamese").toString());
        tabbyCatNbtCompound.putString("variant", new Identifier("tabby").toString());
        whiteCatNbtCompound.putString("variant", new Identifier("white").toString());
        NbtPredicate allBlackCatNbtPredicate = new NbtPredicate(allBlackCatNbtCompound);
        NbtPredicate blackCatNbtPredicate = new NbtPredicate(blackCatNbtCompound);
        NbtPredicate britishShorthairCatNbtPredicate = new NbtPredicate(britishShorthairCatNbtCompound);
        NbtPredicate calicoCatNbtPredicate = new NbtPredicate(calicoCatNbtCompound);
        NbtPredicate jellieCatNbtPredicate = new NbtPredicate(jellieCatNbtCompound);
        NbtPredicate persianCatNbtPredicate = new NbtPredicate(persianCatNbtCompound);
        NbtPredicate ragdollCatNbtPredicate = new NbtPredicate(ragdollCatNbtCompound);
        NbtPredicate redCatNbtPredicate = new NbtPredicate(redCatNbtCompound);
        NbtPredicate siameseCatNbtPredicate = new NbtPredicate(siameseCatNbtCompound);
        NbtPredicate tabbyCatNbtPredicate = new NbtPredicate(tabbyCatNbtCompound);
        NbtPredicate whiteCatNbtPredicate = new NbtPredicate(whiteCatNbtCompound);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.CAT.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.ALL_BLACK_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(allBlackCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.BLACK_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(blackCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.BRITISH_SHORTHAIR_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(britishShorthairCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.CALICO_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(calicoCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.JELLIE_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(jellieCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.PERSIAN_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(persianCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.RAGDOLL_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(ragdollCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.RED_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(redCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.SIAMESE_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(siameseCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.TABBY_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(tabbyCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.WHITE_CAT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(whiteCatNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        // Endermen teleport away when blown up.
        // Set up just in case.
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.ENDERMAN.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.ENDERMAN_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        NbtCompound redFoxNbtCompound = new NbtCompound();
        NbtCompound snowFoxNbtCompound = new NbtCompound();
        redFoxNbtCompound.putString("Type", FoxEntity.Type.RED.asString());
        snowFoxNbtCompound.putString("Type", FoxEntity.Type.SNOW.asString());
        NbtPredicate redFoxNbtPredicate = new NbtPredicate(redFoxNbtCompound);
        NbtPredicate snowFoxNbtPredicate = new NbtPredicate(snowFoxNbtCompound);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.FOX.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.FOX_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(redFoxNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.SNOW_FOX_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(snowFoxNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.IRON_GOLEM.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.IRON_GOLEM_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        NbtCompound normalPandaNbtCompound = new NbtCompound();
        NbtCompound aggressivePandaNbtCompound = new NbtCompound();
        NbtCompound lazyPandaNbtCompound = new NbtCompound();
        NbtCompound worriedPandaNbtCompound = new NbtCompound();
        NbtCompound playfulPandaNbtCompound = new NbtCompound();
        NbtCompound weakPandaNbtCompound = new NbtCompound();
        NbtCompound brownPandaNbtCompound = new NbtCompound();
        NbtCompound weakPandaMainNbtCompound = new NbtCompound();
        NbtCompound brownPandaMainNbtCompound = new NbtCompound();
        NbtCompound weakPandaHiddenNbtCompound = new NbtCompound();
        NbtCompound brownPandaHiddenNbtCompound = new NbtCompound();
        normalPandaNbtCompound.putString("MainGene", "normal");
        aggressivePandaNbtCompound.putString("MainGene", "aggressive");
        lazyPandaNbtCompound.putString("MainGene", "lazy");
        worriedPandaNbtCompound.putString("MainGene", "worried");
        playfulPandaNbtCompound.putString("MainGene", "playful");
        weakPandaNbtCompound.putString("MainGene", "weak");
        weakPandaNbtCompound.putString("HiddenGene", "weak");
        brownPandaNbtCompound.putString("MainGene", "brown");
        brownPandaNbtCompound.putString("HiddenGene", "brown");
        weakPandaMainNbtCompound.putString("MainGene", "weak");
        weakPandaHiddenNbtCompound.putString("HiddenGene", "weak");
        brownPandaMainNbtCompound.putString("MainGene", "brown");
        brownPandaHiddenNbtCompound.putString("HiddenGene", "brown");
        NbtPredicate normalPandaNbtPredicate = new NbtPredicate(normalPandaNbtCompound);
        NbtPredicate aggressivePandaNbtPredicate = new NbtPredicate(aggressivePandaNbtCompound);
        NbtPredicate lazyPandaNbtPredicate = new NbtPredicate(lazyPandaNbtCompound);
        NbtPredicate worriedPandaNbtPredicate = new NbtPredicate(worriedPandaNbtCompound);
        NbtPredicate playfulPandaNbtPredicate = new NbtPredicate(playfulPandaNbtCompound);
        NbtPredicate weakPandaNbtPredicate = new NbtPredicate(weakPandaNbtCompound);
        NbtPredicate brownPandaNbtPredicate = new NbtPredicate(brownPandaNbtCompound);
        NbtPredicate weakPandaMainNbtPredicate = new NbtPredicate(weakPandaMainNbtCompound);
        NbtPredicate brownPandaMainNbtPredicate = new NbtPredicate(brownPandaMainNbtCompound);
        NbtPredicate weakPandaHiddenNbtPredicate = new NbtPredicate(weakPandaHiddenNbtCompound);
        NbtPredicate brownPandaHiddenNbtPredicate = new NbtPredicate(brownPandaHiddenNbtCompound);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.PANDA.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(normalPandaNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.AGGRESSIVE_PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(aggressivePandaNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.LAZY_PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(lazyPandaNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.WORRIED_PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(worriedPandaNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.PLAYFUL_PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(playfulPandaNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.WEAK_PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(weakPandaNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(weakPandaMainNbtPredicate)))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(weakPandaNbtPredicate)).invert())
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(weakPandaHiddenNbtPredicate)))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(weakPandaNbtPredicate)).invert())
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.BROWN_PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(brownPandaNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(brownPandaMainNbtPredicate)))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(brownPandaNbtPredicate)).invert())
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.PANDA_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(brownPandaHiddenNbtPredicate)))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(brownPandaNbtPredicate)).invert())
                                .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.DROWNED.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.DROWNED_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        NbtCompound redParrotNbtCompound = new NbtCompound();
        NbtCompound blueParrotNbtCompound = new NbtCompound();
        NbtCompound greenParrotNbtCompound = new NbtCompound();
        NbtCompound cyanParrotNbtCompound = new NbtCompound();
        NbtCompound grayParrotNbtCompound = new NbtCompound();
        redParrotNbtCompound.putInt("Variant", ParrotEntity.Variant.RED_BLUE.getId());
        blueParrotNbtCompound.putInt("Variant", ParrotEntity.Variant.BLUE.getId());
        greenParrotNbtCompound.putInt("Variant", ParrotEntity.Variant.GREEN.getId());
        cyanParrotNbtCompound.putInt("Variant", ParrotEntity.Variant.YELLOW_BLUE.getId());
        grayParrotNbtCompound.putInt("Variant", ParrotEntity.Variant.GRAY.getId());
        NbtPredicate redParrotNbtPredicate = new NbtPredicate(redParrotNbtCompound);
        NbtPredicate blueParrotNbtPredicate = new NbtPredicate(blueParrotNbtCompound);
        NbtPredicate greenParrotNbtPredicate = new NbtPredicate(greenParrotNbtCompound);
        NbtPredicate cyanParrotNbtPredicate = new NbtPredicate(cyanParrotNbtCompound);
        NbtPredicate grayParrotNbtPredicate = new NbtPredicate(grayParrotNbtCompound);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.PARROT.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.RED_PARROT_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(redParrotNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.BLUE_PARROT_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(blueParrotNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.GREEN_PARROT_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(greenParrotNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.CYAN_PARROT_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(cyanParrotNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.GRAY_PARROT_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(grayParrotNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.STRAY.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.STRAY_SKULL))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.SHULKER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.SHULKER_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.HUSK.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.HUSK_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.PIG.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.PIG_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.SPIDER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.SPIDER_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.CAVE_SPIDER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.CAVE_SPIDER_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.BLAZE.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.BLAZE_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        NbtCompound brownRabbitNbtCompound = new NbtCompound();
        NbtCompound whiteRabbitNbtCompound = new NbtCompound();
        NbtCompound blackRabbitNbtCompound = new NbtCompound();
        NbtCompound whiteSplotchedRabbitNbtCompound = new NbtCompound();
        NbtCompound goldRabbitNbtCompound = new NbtCompound();
        NbtCompound saltRabbitNbtCompound = new NbtCompound();
        NbtCompound evilRabbitNbtCompound = new NbtCompound();
        brownRabbitNbtCompound.putInt("RabbitType", RabbitEntity.RabbitType.BROWN.getId());
        whiteRabbitNbtCompound.putInt("RabbitType", RabbitEntity.RabbitType.WHITE.getId());
        blackRabbitNbtCompound.putInt("RabbitType", RabbitEntity.RabbitType.BLACK.getId());
        whiteSplotchedRabbitNbtCompound.putInt("RabbitType", RabbitEntity.RabbitType.WHITE_SPLOTCHED.getId());
        goldRabbitNbtCompound.putInt("RabbitType", RabbitEntity.RabbitType.GOLD.getId());
        saltRabbitNbtCompound.putInt("RabbitType", RabbitEntity.RabbitType.SALT.getId());
        evilRabbitNbtCompound.putInt("RabbitType", RabbitEntity.RabbitType.EVIL.getId());
        NbtPredicate brownRabbitNbtPredicate = new NbtPredicate(brownRabbitNbtCompound);
        NbtPredicate whiteRabbitNbtPredicate = new NbtPredicate(whiteRabbitNbtCompound);
        NbtPredicate blackRabbitNbtPredicate = new NbtPredicate(blackRabbitNbtCompound);
        NbtPredicate whiteSplotchedRabbitNbtPredicate = new NbtPredicate(whiteSplotchedRabbitNbtCompound);
        NbtPredicate goldRabbitNbtPredicate = new NbtPredicate(goldRabbitNbtCompound);
        NbtPredicate saltRabbitNbtPredicate = new NbtPredicate(saltRabbitNbtCompound);
        NbtPredicate evilRabbitNbtPredicate = new NbtPredicate(evilRabbitNbtCompound);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.RABBIT.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.BROWN_RABBIT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(brownRabbitNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.WHITE_RABBIT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(whiteRabbitNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.BLACK_RABBIT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(blackRabbitNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.WHITE_SPLOTCHED_RABBIT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(whiteSplotchedRabbitNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.GOLD_RABBIT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(goldRabbitNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.SALT_RABBIT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(saltRabbitNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                                .with(ItemEntry.builder(HeadedItems.EVIL_RABBIT_HEAD))
                                .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(evilRabbitNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.TURTLE.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.TURTLE_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.WITHER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.WITHER_SKULL))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.WOLF.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.WOLF_HEAD))
                        .apply(CopyNameLootFunction.builder(CopyNameLootFunction.Source.THIS))
                        .apply(CopyNbtLootFunction.builder(LootContext.EntityTarget.THIS).withOperation("Tamed", "BlockEntityTag.Tamed"))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.BAT.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.BAT_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.WITCH.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.WITCH_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.CHICKEN.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.CHICKEN_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.PHANTOM.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.PHANTOM_HEAD))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        NbtCompound snowGolemPumpkinNbtCompound = new NbtCompound();
        snowGolemPumpkinNbtCompound.putBoolean("Pumpkin", true);
        NbtPredicate snowGolemPumpkinNbtPredicate = new NbtPredicate(snowGolemPumpkinNbtCompound);
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.SNOW_GOLEM.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(HeadedItems.SNOW_GOLEM_HEAD))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(snowGolemPumpkinNbtPredicate)).invert())
                                .conditionally(KilledByChargedCreeperLootCondition.builder()))
                        .pool(LootPool.builder().with(ItemEntry.builder(Items.CARVED_PUMPKIN))
                                .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().nbt(snowGolemPumpkinNbtPredicate)))
                                .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && EntityType.PLAYER.getLootTableId().equals(id)) {
                tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(Items.PLAYER_HEAD))
                        .apply(FillPlayerHeadLootFunction.builder(LootContext.EntityTarget.THIS))
                        .conditionally(KilledByChargedCreeperLootCondition.builder()));
            }
        });
    }

    public static void registerModLootTables() {
        Headed.LOGGER.debug("Registering loot table modifications");
    }
}
