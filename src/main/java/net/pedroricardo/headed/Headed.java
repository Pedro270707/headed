package net.pedroricardo.headed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.pedroricardo.headed.block.HeadedBlocks;
import net.pedroricardo.headed.block.entity.HeadedBlockEntities;
import net.pedroricardo.headed.item.HeadedItems;
import net.pedroricardo.headed.loottable.HeadedLootConditionTypes;
import net.pedroricardo.headed.loottable.HeadedLootTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Headed implements ModInitializer {
	public static final String MOD_ID = "headed";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ItemGroup HEADED_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(Headed.MOD_ID, "headed_group"), () -> new ItemStack(HeadedItems.VILLAGER_HEAD));
	@Override
	public void onInitialize() {
		HeadedItems.registerModItems();
		HeadedBlocks.registerModBlocks();
		HeadedBlockEntities.registerBlockEntities();
		HeadedLootConditionTypes.registerModLootConditions();
		HeadedLootTable.registerModLootTables();
	}
}
