package net.chaniedarray.forgedarsenal.item;

import net.chaniedarray.forgedarsenal.ForgedArsenal;
import net.chaniedarray.forgedarsenal.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item SMOLDERING_ALLOY = registerItem("smoldering_alloy", new Item(new Item.Settings()));
    public static final Item MOLTEN_IRON = registerItem("molten_iron", new Item(new Item.Settings()));
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item ASH = registerItem("ash", new Item(new Item.Settings()));
    public static final Item CHOCOLATE = registerItem("chocolate", new Item(new Item.Settings().food(ModFoodComponents.CHOCOLATE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.forgedarsenal.chocolate"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ForgedArsenal.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ForgedArsenal.LOGGER.info("Registering items for " + ForgedArsenal.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(SMOLDERING_ALLOY);
            fabricItemGroupEntries.add(MOLTEN_IRON);
        });
    }
}
