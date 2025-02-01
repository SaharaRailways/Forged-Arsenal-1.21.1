package net.chaniedarray.forgedarsenal.datagen;

import net.chaniedarray.forgedarsenal.block.ModBlocks;
import net.chaniedarray.forgedarsenal.util.ModTags;
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
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                    .add(ModBlocks.NETHERRACK_LAMP);

            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                    .add(ModBlocks.ASH_BLOCK);

            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                    .add(ModBlocks.NETHERRACK_LAMP)
                    .add(ModBlocks.ASH_BLOCK);

            getOrCreateTagBuilder(ModTags.Blocks.NEEDS_SMOLDERING_TOOL)
                    .addTag(BlockTags.NEEDS_IRON_TOOL);
        }
}