package net.chaniedarray.forgedarsenal.item;

import net.chaniedarray.forgedarsenal.ForgedArsenal;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SMOLDERING_ALLOY = registerItem("smoldering_alloy", new Item(new Item.Settings()));
    public static final Item MOLTON_IRON = registerItem("molton_iron", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ForgedArsenal.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ForgedArsenal.LOGGER.info("Registering items for " + ForgedArsenal.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(SMOLDERING_ALLOY);
            fabricItemGroupEntries.add(MOLTON_IRON);
        });
    }
}
