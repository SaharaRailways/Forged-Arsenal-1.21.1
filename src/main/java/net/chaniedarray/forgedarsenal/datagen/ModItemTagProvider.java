package net.chaniedarray.forgedarsenal.datagen;

import net.chaniedarray.forgedarsenal.item.ModItems;
import net.chaniedarray.forgedarsenal.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.MOLTON_INGOTS)
                .add(ModItems.MOLTEN_IRON);
        getOrCreateTagBuilder(ModTags.Items.BLOOMERY_FUEL)
                .add(Items.BLAZE_POWDER);

    }
}
