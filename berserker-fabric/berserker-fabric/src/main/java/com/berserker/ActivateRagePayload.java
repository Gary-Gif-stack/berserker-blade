package com.berserker;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

/** Client -> server: "I pressed the rage key". */
public record ActivateRagePayload() implements CustomPayload {
	public static final CustomPayload.Id<ActivateRagePayload> ID =
			new CustomPayload.Id<>(Identifier.of(BerserkerMod.MOD_ID, "activate_rage"));
	public static final PacketCodec<RegistryByteBuf, ActivateRagePayload> CODEC =
			PacketCodec.unit(new ActivateRagePayload());

	@Override
	public CustomPayload.Id<? extends CustomPayload> getId() {
		return ID;
	}
}
