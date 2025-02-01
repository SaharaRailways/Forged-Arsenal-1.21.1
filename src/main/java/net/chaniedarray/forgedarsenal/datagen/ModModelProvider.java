package net.chaniedarray.forgedarsenal.datagen;

import net.chaniedarray.forgedarsenal.block.ModBlocks;
import net.chaniedarray.forgedarsenal.block.custom.NetherrackLamp;
import net.chaniedarray.forgedarsenal.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ASH_BLOCK);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.NETHERRACK_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.NETHERRACK_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.NETHERRACK_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(NetherrackLamp.LIT, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MOLTEN_IRON, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMOLDERING_ALLOY, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.SMOLDERING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SMOLDERING_PICKAXE, Models.HANDHELD);
    }
}
