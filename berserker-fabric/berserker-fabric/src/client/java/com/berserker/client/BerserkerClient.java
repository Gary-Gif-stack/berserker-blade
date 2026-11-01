package com.berserker.client;

import com.berserker.ActivateRagePayload;
import com.berserker.SyncPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class BerserkerClient implements ClientModInitializer {
	public static KeyBinding RAGE_KEY;

	@Override
	public void onInitializeClient() {
		RAGE_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.berserker.rage", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, "category.berserker"));

		ClientPlayNetworking.registerGlobalReceiver(SyncPayload.ID,
				(payload, context) -> ClientMeters.current = payload);

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (RAGE_KEY.wasPressed()) {
				if (client.player != null) {
					ClientPlayNetworking.send(new ActivateRagePayload());
				}
			}
		});

		ClientPlayConnectionEvents.DISCONNECT.register((handler, client) ->
				ClientMeters.current = SyncPayload.EMPTY);

		HudRenderCallback.EVENT.register(MeterHud::render);
	}
}
