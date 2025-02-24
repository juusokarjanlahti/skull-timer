/*
 * Copyright (c) 2023, Callum Rossiter
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.skulltimer.data;

import com.skulltimer.enums.CombatStatus;
import lombok.Data;

/**
 * An object representing a record of a combat (a player that the local player has attacked/been attacked by) interaction with the local player.
 */
@Data
public class CombatInteraction
{
	private CombatStatus combatStatus = CombatStatus.ATTACKED;

	/**
	 * A method to determine if the player has retaliated against the local player.
	 * @return {@code true} if the players {@link CombatStatus} is either {@code RETALIATED}, {@code INACTIVE} or
	 * {@code ATTACKER}. Otherwise, returns {@code false}.
	 */
	public boolean hasRetaliated()
	{
		return combatStatus == CombatStatus.RETALIATED ||
			combatStatus == CombatStatus.INACTIVE ||
			combatStatus == CombatStatus.ATTACKER;
	}

	/**
	 * A method to determine if the player was the instigator of the combat interaction.
	 * @return {@code true} if the player started the fight. Otherwise, returns {@code false}.
	 */
	public boolean isAttacker()
	{
		return combatStatus == CombatStatus.ATTACKER;
	}
}
