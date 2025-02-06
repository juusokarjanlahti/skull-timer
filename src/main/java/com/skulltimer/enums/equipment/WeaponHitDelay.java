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

/**
 * An enum used to calculate when a weapon should expect to see a hit.
 */
public enum WeaponHitDelay
{
	MELEE_STANDARD {
		@Override
		public int calculateHitDelay(int distance){
			return 0;
		}
	},
	MELEE_DELAYED_SPECIAL {
		@Override
		public int calculateHitDelay(int distance){
			return 1;
		}
	},
	RANGED_STANDARD {
		@Override
		public int calculateHitDelay(int distance){
			return 1 + (3 + distance / 6);
		}
	},
	RANGED_ACB_ZZB_SPECIAL {
		@Override
		public int calculateHitDelay(int distance){
			return 2;
		}
	},
	RANGED_WEBWEAVER_SPECIAL {
		@Override
		public int calculateHitDelay(int distance){
			return 1;
		}
	},
	RANGED_THROWN {
		@Override
		public int calculateHitDelay(int distance){
			return 1 + (distance / 6);
		}
	},
	RANGED_BLOWPIPE_SPECIAL {
		@Override
		public int calculateHitDelay(int distance){
			if (distance == 4 || distance == 5) return 2;
			else return 1 + (distance / 6);
		}
	},
	RANGED_BALLISTAE {
		@Override
		public int calculateHitDelay(int distance){
			if (distance <= 4) return 2;
			else return 3;
		}
	},
	RANGED_TONALZTICS_OF_RALOS {
		@Override
		public int calculateHitDelay(int distance){
			return 2;
		}
	},
	MAGIC_STANDARD {
		@Override
		public int calculateHitDelay(int distance){
			return 1 + (1 + distance / 3);
		}
	},
	MAGIC_STANDARD_WITH_MELEE {
		@Override
		public int calculateHitDelay(int distance){
			return 1 + (1 + distance / 3);
		}

		public int calculateMeleeHitDelay(){
			return 0;
		}
	},
	MAGIC_GRASP_DEMONBANE_NIGHTMARE_STAFF_SPECIALS {
		@Override
		public int calculateHitDelay(int distance){
			return 2;
		}
	},
	MAGIC_TUMEKENS_SHADOW {
		@Override
		public int calculateHitDelay(int distance){
			return 2 + (1 + distance / 3);
		}
	},
	OTHER_SHIELD_SPECIALS {
		@Override
		public int calculateHitDelay(int distance){
			return 2 + (4 + distance / 6);
		}
	},
	NOT_APPLICABLE {
		@Override
		public int calculateHitDelay(int distance)
		{
			return 0;
		}
	};

	public abstract int calculateHitDelay(int distance);
}
