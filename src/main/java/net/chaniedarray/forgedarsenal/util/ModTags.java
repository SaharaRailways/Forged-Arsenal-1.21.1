package net.chaniedarray.forgedarsenal.util;

import net.chaniedarray.forgedarsenal.ForgedArsenal;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SMOLDERING_TOOL = createTag("needs_smoldering_tool");
        public static final TagKey<Block> INCORRECT_FOR_SMOLDERING_TOOL = createTag("incorrect_for_smoldering_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ForgedArsenal.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MOLTON_INGOTS = createTag("molten_ingots");
        public static final TagKey<Item> BLOOMERY_FUEL = createTag("bloomery_fuel");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ForgedArsenal.MOD_ID, name));
        }
    }
}
