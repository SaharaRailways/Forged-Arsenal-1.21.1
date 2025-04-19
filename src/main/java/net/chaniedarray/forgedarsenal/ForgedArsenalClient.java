package net.chaniedarray.forgedarsenal;

import net.chaniedarray.forgedarsenal.entity.ModEntities;
import net.chaniedarray.forgedarsenal.entity.client.DaggerProjectileModel;
import net.chaniedarray.forgedarsenal.entity.client.DaggerProjectileRenderer;
import net.chaniedarray.forgedarsenal.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ForgedArsenalClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(DaggerProjectileModel.DAGGER, DaggerProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.DAGGER, DaggerProjectileRenderer::new);
    }
}
