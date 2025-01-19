package net.chaniedarray.forgedarsenal.datagen;

import net.chaniedarray.forgedarsenal.block.ModBlocks;
import net.chaniedarray.forgedarsenal.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> MOLTEN_INGOT_SMELTABLES = List.of(Items.IRON_INGOT, Items.GOLD_INGOT);

        offerSmelting(exporter, MOLTEN_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.MOLTEN_IRON, 0.7F, 400, "molten_iron");
        offerBlasting(exporter, MOLTEN_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.MOLTEN_IRON, 0.7F, 200, "molten_iron");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern("i")
                .pattern("s")
                .input('i', ModItems.SMOLDERING_ALLOY)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.SMOLDERING_ALLOY), conditionsFromItem(ModItems.SMOLDERING_ALLOY))
                .offerTo(exporter);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ASH, ModBlocks.ASH_BLOCK);

    }
}
