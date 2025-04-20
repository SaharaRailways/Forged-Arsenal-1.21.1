package net.chaniedarray.forgedarsenal;

import net.chaniedarray.forgedarsenal.entity.ModEntities;
import net.chaniedarray.forgedarsenal.entity.client.DaggerProjectileModel;
import net.chaniedarray.forgedarsenal.entity.client.DaggerProjectileRenderer;
import net.chaniedarray.forgedarsenal.item.custom.DaggerItem;
import net.chaniedarray.forgedarsenal.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ForgedArsenalClient implements ClientModInitializer {
    public static KeyBinding recallKeyBinding;

    @Override
    public void onInitializeClient() {
        recallKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.forgedarsenal.spook", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_R, // The keycode of the key
                "category.forgedarsenal.weapon" // The translation key of the keybinding's category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.world != null) {
                DaggerItem.handleKeyPress(client.world, client.player);
            }
        });


        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(DaggerProjectileModel.DAGGER, DaggerProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.DAGGER, DaggerProjectileRenderer::new);
    }
}
