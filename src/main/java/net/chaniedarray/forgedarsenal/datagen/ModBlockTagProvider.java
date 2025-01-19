package net.chaniedarray.forgedarsenal.datagen;

import net.chaniedarray.forgedarsenal.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.loot.function.ApplyBonusLootFunction.oreDrops;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture< RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup){
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                    .add(ModBlocks.ASH_BLOCK);
        }


}