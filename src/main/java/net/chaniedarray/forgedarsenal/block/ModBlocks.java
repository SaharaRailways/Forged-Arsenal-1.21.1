package net.chaniedarray.forgedarsenal.block;

import net.chaniedarray.forgedarsenal.ForgedArsenal;
import net.chaniedarray.forgedarsenal.block.custom.AshBlock;
import net.chaniedarray.forgedarsenal.block.custom.NetherrackLamp;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ASH_BLOCK = registerBlock("ash_block",
            new AshBlock(AbstractBlock.Settings.create().strength(4f).sounds(BlockSoundGroup.SAND)));

    public static final Block NETHERRACK_LAMP = registerBlock("netherrack_lamp",
            new NetherrackLamp(AbstractBlock.Settings.create().strength(6f).requiresTool()
                    .sounds(BlockSoundGroup.GLASS).luminance(state -> state.get(NetherrackLamp.LIT) ? 15 : 0)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ForgedArsenal.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
         Registry.register(Registries.ITEM, Identifier.of(ForgedArsenal.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ForgedArsenal.LOGGER.info("Registering blocks for " + ForgedArsenal.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent((ItemGroups.BUILDING_BLOCKS)).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ASH_BLOCK);
        });
    }
}
