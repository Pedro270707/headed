package net.pedroricardo.headed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.pedroricardo.headed.block.ModBlocks;
import net.pedroricardo.headed.block.entity.ModBlockEntities;
import net.pedroricardo.headed.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Headed implements ModInitializer {
	public static final String MOD_ID = "headed";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
			content.addAfter(Items.DRAGON_HEAD, ModItems.VILLAGER_HEAD);
			content.addAfter(ModItems.VILLAGER_HEAD, ModItems.EVOKER_HEAD);
			content.addAfter(ModItems.EVOKER_HEAD, ModItems.VINDICATOR_HEAD);
			content.addAfter(ModItems.VINDICATOR_HEAD, ModItems.PILLAGER_HEAD);
		});
	}
}
