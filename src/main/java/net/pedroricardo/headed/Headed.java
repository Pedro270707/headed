package net.pedroricardo.headed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.pedroricardo.headed.block.HeadedBlocks;
import net.pedroricardo.headed.block.entity.HeadedBlockEntities;
import net.pedroricardo.headed.item.HeadedItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Headed implements ModInitializer {
	public static final String MOD_ID = "headed";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		HeadedItems.registerModItems();
		HeadedBlocks.registerModBlocks();
		HeadedBlockEntities.registerBlockEntities();
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
			content.addBefore(Items.DRAGON_HEAD, HeadedItems.PIGLIN_BRUTE_HEAD);
			content.addAfter(HeadedItems.PIGLIN_BRUTE_HEAD, HeadedItems.ZOMBIFIED_PIGLIN_HEAD);
			content.addAfter(Items.DRAGON_HEAD, HeadedItems.VILLAGER_HEAD);
			content.addAfter(HeadedItems.VILLAGER_HEAD, HeadedItems.EVOKER_HEAD);
			content.addAfter(HeadedItems.EVOKER_HEAD, HeadedItems.VINDICATOR_HEAD);
			content.addAfter(HeadedItems.VINDICATOR_HEAD, HeadedItems.PILLAGER_HEAD);
			content.addAfter(HeadedItems.PILLAGER_HEAD, HeadedItems.ZOMBIE_VILLAGER_HEAD);
			content.addAfter(HeadedItems.ZOMBIE_VILLAGER_HEAD, HeadedItems.SHEEP_HEAD);
			content.addAfter(HeadedItems.SHEEP_HEAD, HeadedItems.WHITE_SHEEP_HEAD);
			content.addAfter(HeadedItems.WHITE_SHEEP_HEAD, HeadedItems.LIGHT_GRAY_SHEEP_HEAD);
			content.addAfter(HeadedItems.LIGHT_GRAY_SHEEP_HEAD, HeadedItems.GRAY_SHEEP_HEAD);
			content.addAfter(HeadedItems.GRAY_SHEEP_HEAD, HeadedItems.BLACK_SHEEP_HEAD);
			content.addAfter(HeadedItems.BLACK_SHEEP_HEAD, HeadedItems.BROWN_SHEEP_HEAD);
			content.addAfter(HeadedItems.BROWN_SHEEP_HEAD, HeadedItems.RED_SHEEP_HEAD);
			content.addAfter(HeadedItems.RED_SHEEP_HEAD, HeadedItems.ORANGE_SHEEP_HEAD);
			content.addAfter(HeadedItems.ORANGE_SHEEP_HEAD, HeadedItems.YELLOW_SHEEP_HEAD);
			content.addAfter(HeadedItems.YELLOW_SHEEP_HEAD, HeadedItems.LIME_SHEEP_HEAD);
			content.addAfter(HeadedItems.LIME_SHEEP_HEAD, HeadedItems.GREEN_SHEEP_HEAD);
			content.addAfter(HeadedItems.GREEN_SHEEP_HEAD, HeadedItems.CYAN_SHEEP_HEAD);
			content.addAfter(HeadedItems.CYAN_SHEEP_HEAD, HeadedItems.LIGHT_BLUE_SHEEP_HEAD);
			content.addAfter(HeadedItems.LIGHT_BLUE_SHEEP_HEAD, HeadedItems.BLUE_SHEEP_HEAD);
			content.addAfter(HeadedItems.BLUE_SHEEP_HEAD, HeadedItems.PURPLE_SHEEP_HEAD);
			content.addAfter(HeadedItems.PURPLE_SHEEP_HEAD, HeadedItems.MAGENTA_SHEEP_HEAD);
			content.addAfter(HeadedItems.MAGENTA_SHEEP_HEAD, HeadedItems.PINK_SHEEP_HEAD);
            content.addAfter(HeadedItems.PINK_SHEEP_HEAD, HeadedItems.ALLAY_HEAD);
			content.addAfter(HeadedItems.ALLAY_HEAD, HeadedItems.VEX_HEAD);
			content.addAfter(HeadedItems.VEX_HEAD, HeadedItems.LEUCISTIC_AXOLOTL_HEAD);
			content.addAfter(HeadedItems.LEUCISTIC_AXOLOTL_HEAD, HeadedItems.BROWN_AXOLOTL_HEAD);
			content.addAfter(HeadedItems.BROWN_AXOLOTL_HEAD, HeadedItems.CYAN_AXOLOTL_HEAD);
			content.addAfter(HeadedItems.CYAN_AXOLOTL_HEAD, HeadedItems.GOLD_AXOLOTL_HEAD);
			content.addAfter(HeadedItems.GOLD_AXOLOTL_HEAD, HeadedItems.BLUE_AXOLOTL_HEAD);
			content.addAfter(HeadedItems.BLUE_AXOLOTL_HEAD, HeadedItems.COW_HEAD);
			content.addAfter(HeadedItems.COW_HEAD, HeadedItems.BROWN_MOOSHROOM_HEAD);
			content.addAfter(HeadedItems.BROWN_MOOSHROOM_HEAD, HeadedItems.RED_MOOSHROOM_HEAD);
		});
	}
}
