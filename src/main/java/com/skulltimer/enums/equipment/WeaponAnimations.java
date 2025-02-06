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

package com.skulltimer.enums.equipment;

import java.util.Set;
import lombok.Getter;
import net.runelite.api.AnimationID;

@Getter
public enum WeaponAnimations
{
	UNDEFINED(Set.of(AnimationID.IDLE), AnimationID.IDLE);

	private final Set<Integer> animationIDS;
	private final int specialAnimationID;

	WeaponAnimations(Set<Integer> animationIDS, Integer specialAnimationID)
	{
		this.animationIDS = animationIDS;
		this.specialAnimationID = specialAnimationID;
	}

	public boolean doesIDMatchAnimation(Integer id){
		return animationIDS.contains(id);
	}

	public boolean doesSpecialIDMatchAnimation(Integer id){
		return specialAnimationID == id;
	}
}
