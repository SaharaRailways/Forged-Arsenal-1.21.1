package net.chaniedarray.forgedarsenal.item;

import net.chaniedarray.forgedarsenal.ForgedArsenal;
import net.chaniedarray.forgedarsenal.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup FORGED_ARSENAL_GROUP = Registry .register(Registries.ITEM_GROUP,
            Identifier.of(ForgedArsenal.MOD_ID, "forged_arsenal_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SMOLDERING_ALLOY))
                    .displayName(Text.translatable("itemGroup.forgedarsenal.forged_arsenal_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SMOLDERING_ALLOY);
                        entries.add(ModItems.MOLTEN_IRON);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModBlocks.ASH_BLOCK);
                        entries.add(ModItems.ASH);
                        entries.add(ModItems.CHOCOLATE);
                        entries.add(ModBlocks.NETHERRACK_LAMP);
                        entries.add(ModItems.SMOLDERING_SWORD);
                        entries.add(ModItems.SMOLDERING_PICKAXE);
                    }).build());



    public static void registerItemGroups() {
        ForgedArsenal.LOGGER.info("Registering item groups for " + ForgedArsenal.MOD_ID);

    }

}
