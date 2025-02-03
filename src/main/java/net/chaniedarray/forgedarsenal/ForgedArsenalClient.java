package net.chaniedarray.forgedarsenal;

import net.chaniedarray.forgedarsenal.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;

public class ForgedArsenalClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicates.registerModelPredicates();
    }
}
