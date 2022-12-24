package net.pedroricardo.headed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
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
			content.addBefore(Items.DRAGON_HEAD, ModItems.PIGLIN_BRUTE_HEAD);
			content.addAfter(ModItems.PIGLIN_BRUTE_HEAD, ModItems.ZOMBIFIED_PIGLIN_HEAD);
			content.addAfter(Items.DRAGON_HEAD, ModItems.VILLAGER_HEAD);
			content.addAfter(ModItems.VILLAGER_HEAD, ModItems.EVOKER_HEAD);
			content.addAfter(ModItems.EVOKER_HEAD, ModItems.VINDICATOR_HEAD);
			content.addAfter(ModItems.VINDICATOR_HEAD, ModItems.PILLAGER_HEAD);
			content.addAfter(ModItems.PILLAGER_HEAD, ModItems.ZOMBIE_VILLAGER_HEAD);
			content.addAfter(ModItems.ZOMBIE_VILLAGER_HEAD, ModItems.SHEEP_HEAD);
			content.addAfter(ModItems.SHEEP_HEAD, ModItems.WHITE_SHEEP_HEAD);
			content.addAfter(ModItems.WHITE_SHEEP_HEAD, ModItems.LIGHT_GRAY_SHEEP_HEAD);
			content.addAfter(ModItems.LIGHT_GRAY_SHEEP_HEAD, ModItems.GRAY_SHEEP_HEAD);
			content.addAfter(ModItems.GRAY_SHEEP_HEAD, ModItems.BLACK_SHEEP_HEAD);
			content.addAfter(ModItems.BLACK_SHEEP_HEAD, ModItems.BROWN_SHEEP_HEAD);
			content.addAfter(ModItems.BROWN_SHEEP_HEAD, ModItems.RED_SHEEP_HEAD);
			content.addAfter(ModItems.RED_SHEEP_HEAD, ModItems.ORANGE_SHEEP_HEAD);
			content.addAfter(ModItems.ORANGE_SHEEP_HEAD, ModItems.YELLOW_SHEEP_HEAD);
			content.addAfter(ModItems.YELLOW_SHEEP_HEAD, ModItems.LIME_SHEEP_HEAD);
			content.addAfter(ModItems.LIME_SHEEP_HEAD, ModItems.GREEN_SHEEP_HEAD);
			content.addAfter(ModItems.GREEN_SHEEP_HEAD, ModItems.CYAN_SHEEP_HEAD);
			content.addAfter(ModItems.CYAN_SHEEP_HEAD, ModItems.LIGHT_BLUE_SHEEP_HEAD);
			content.addAfter(ModItems.LIGHT_BLUE_SHEEP_HEAD, ModItems.BLUE_SHEEP_HEAD);
			content.addAfter(ModItems.BLUE_SHEEP_HEAD, ModItems.PURPLE_SHEEP_HEAD);
			content.addAfter(ModItems.PURPLE_SHEEP_HEAD, ModItems.MAGENTA_SHEEP_HEAD);
			content.addAfter(ModItems.MAGENTA_SHEEP_HEAD, ModItems.PINK_SHEEP_HEAD);
            content.addAfter(ModItems.PINK_SHEEP_HEAD, ModItems.ALLAY_HEAD);
			content.addAfter(ModItems.ALLAY_HEAD, ModItems.VEX_HEAD);
		});
	}
}
