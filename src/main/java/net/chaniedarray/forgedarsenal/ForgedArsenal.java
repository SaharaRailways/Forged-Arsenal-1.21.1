package net.chaniedarray.forgedarsenal;

import net.chaniedarray.forgedarsenal.block.ModBlocks;
import net.chaniedarray.forgedarsenal.component.ModDataComponentTypes;
import net.chaniedarray.forgedarsenal.entity.ModEntities;
import net.chaniedarray.forgedarsenal.item.ModItemGroups;
import net.chaniedarray.forgedarsenal.item.ModItems;
import net.chaniedarray.forgedarsenal.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForgedArsenal implements ModInitializer {
	public static final String MOD_ID = "forgedarsenal";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(Items.BLAZE_POWDER, 30000);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}