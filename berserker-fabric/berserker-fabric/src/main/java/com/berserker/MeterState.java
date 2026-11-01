package com.berserker;

/** Per-player server-side meter data. */
public class MeterState {
	public int rage;          // 0..RAGE_MAX
	public int rageActive;    // ticks left of rage
	public int rageCooldown;  // ticks left of cooldown

	public int adr;           // 0..ADR_FILL_TICKS
	public int adrActive;     // ticks left of adrenaline state
	public int adrCooldown;   // ticks left of cooldown

	public boolean dirty = true;
	public SyncPayload lastSent = null;

	public SyncPayload toPayload() {
		return new SyncPayload(rage, rageActive, rageCooldown, adr, adrActive, adrCooldown);
	}
}
