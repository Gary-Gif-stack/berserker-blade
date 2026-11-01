package com.berserker;

/** All tuning values in one place. Times are in ticks (20 ticks = 1 second). */
public final class Balance {
	private Balance() {}

	// ---- Rage ----
	public static final int RAGE_MAX = 100;               // meter size
	public static final float RAGE_PER_DAMAGE = 5f;      // meter gained per 1 damage taken (20 dmg = full)
	public static final int RAGE_DURATION = 10 * 20;     // 10 s
	public static final int RAGE_COOLDOWN = 60 * 20;     // 1 minute
	public static final double RAGE_DAMAGE_BONUS = 0.4;  // +40% = x1.4

	// ---- Adrenaline ----
	public static final int ADR_FILL_TICKS = 60 * 20;           // 60 s of not being hit to fill
	public static final int ADR_DURATION = RAGE_DURATION / 2;   // drains twice as fast as rage = 5 s
	public static final int ADR_COOLDOWN = 2 * 60 * 20;         // 2 minutes
	public static final double ADR_DAMAGE_BONUS = 1.0;          // +100% = x2
	public static final double ADR_SPEED_BONUS = 0.3;           // +30% = x1.3
}
