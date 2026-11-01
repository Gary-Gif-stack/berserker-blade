package com.berserker;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

/** Server -> client: current meter values for the HUD. */
public record SyncPayload(int rage, int rageActive, int rageCooldown,
						  int adr, int adrActive, int adrCooldown) implements CustomPayload {
	public static final CustomPayload.Id<SyncPayload> ID =
			new CustomPayload.Id<>(Identifier.of(BerserkerMod.MOD_ID, "sync"));
	public static final PacketCodec<RegistryByteBuf, SyncPayload> CODEC = PacketCodec.tuple(
			PacketCodecs.VAR_INT, SyncPayload::rage,
			PacketCodecs.VAR_INT, SyncPayload::rageActive,
			PacketCodecs.VAR_INT, SyncPayload::rageCooldown,
			PacketCodecs.VAR_INT, SyncPayload::adr,
			PacketCodecs.VAR_INT, SyncPayload::adrActive,
			PacketCodecs.VAR_INT, SyncPayload::adrCooldown,
			SyncPayload::new);

	public static final SyncPayload EMPTY = new SyncPayload(0, 0, 0, 0, 0, 0);

	@Override
	public CustomPayload.Id<? extends CustomPayload> getId() {
		return ID;
	}
}
