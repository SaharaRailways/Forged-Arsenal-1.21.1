package net.chaniedarray.forgedarsenal.util;

import net.chaniedarray.forgedarsenal.ForgedArsenal;
import net.chaniedarray.forgedarsenal.component.ModDataComponentTypes;
import net.chaniedarray.forgedarsenal.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(ForgedArsenal.MOD_ID, "used"),
                ((stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1F : 0F));

    }
}
