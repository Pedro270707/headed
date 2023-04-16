package net.pedroricardo.headed.item;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.pedroricardo.headed.Headed;

public class HeadedDispenserBehavior {
    public static void registerModDispenserBehavior() {
        DispenserBehavior dispenserBehavior = new FallibleItemDispenserBehavior() {
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                this.setSuccess(ArmorItem.dispenseArmor(pointer, stack));
                return stack;
            }
        };
        DispenserBlock.registerBehavior(HeadedItems.VILLAGER_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.EVOKER_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.VINDICATOR_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.PILLAGER_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.ZOMBIE_VILLAGER_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.WANDERING_TRADER_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.ILLUSIONER_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.PIGLIN_BRUTE_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.ZOMBIFIED_PIGLIN_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.ENDERMAN_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.IRON_GOLEM_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.AGGRESSIVE_PANDA_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.BROWN_PANDA_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.LAZY_PANDA_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.PANDA_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.PLAYFUL_PANDA_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.WEAK_PANDA_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.WORRIED_PANDA_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.DROWNED_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.STRAY_SKULL, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.HUSK_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.PIG_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.SPIDER_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.BLAZE_HEAD, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.WITHER_SKULL, dispenserBehavior);
        DispenserBlock.registerBehavior(HeadedItems.WITCH_HEAD, dispenserBehavior);
        Headed.LOGGER.debug("Registering Headed dispenser behavior");
    }
}
