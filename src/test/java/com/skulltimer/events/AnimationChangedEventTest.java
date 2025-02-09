package com.skulltimer.events;

import com.skulltimer.mocks.PluginMocks;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnimationChangedEventTest extends PluginMocks
{
	@Mock
	AnimationChanged animationChanged;
	@Mock
	Player player;
	@Mock
	Player localPlayer;
	@Mock
	NPC npc;

	@Test
	public void playerIsNotInWilderness()
	{
		when(locationManager.isInWilderness()).thenReturn(false);
		eventBus.post(animationChanged);
		verify(combatManager, times(0)).onAnimationOrInteractionChange(any(Player.class), anyInt(), anyBoolean());
	}

	@Test
	public void playerAnimationIsDefensive()
	{
		when(locationManager.isInWilderness()).thenReturn(true);
		when(animationChanged.getActor()).thenReturn(player);
		when(player.getAnimation()).thenReturn(-1);

		eventBus.post(animationChanged);
		verify(combatManager, times(0)).onAnimationOrInteractionChange(any(Player.class), anyInt(), anyBoolean());
	}

	@Test
	public void actorIsNull()
	{
		when(locationManager.isInWilderness()).thenReturn(true);
		when(animationChanged.getActor()).thenReturn(null);

		eventBus.post(animationChanged);
		verify(combatManager, times(0)).onAnimationOrInteractionChange(any(Player.class), anyInt(), anyBoolean());
	}

	@Test
	public void actorIsNotPlayerObject()
	{
		when(locationManager.isInWilderness()).thenReturn(true);
		when(animationChanged.getActor()).thenReturn(npc);
		when(npc.getAnimation()).thenReturn(100);

		eventBus.post(animationChanged);
		verify(combatManager, times(0)).onAnimationOrInteractionChange(any(Player.class), anyInt(), anyBoolean());
	}

	@Test
	public void actorIsLocalPlayer()
	{
		when(locationManager.isInWilderness()).thenReturn(true);
		when(animationChanged.getActor()).thenReturn(localPlayer);
		when(localPlayer.getAnimation()).thenReturn(100);
		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getName()).thenReturn("LocalPlayer");

		eventBus.post(animationChanged);
		verify(combatManager, times(0)).onAnimationOrInteractionChange(any(Player.class), anyInt(), anyBoolean());
	}

	@Test
	public void conditionsMet()
	{
		when(locationManager.isInWilderness()).thenReturn(true);
		when(animationChanged.getActor()).thenReturn(player);
		when(player.getName()).thenReturn("Player");
		when(player.getAnimation()).thenReturn(100);

		when(client.getLocalPlayer()).thenReturn(localPlayer);
		when(localPlayer.getName()).thenReturn("LocalPlayer");

		eventBus.post(animationChanged);
		verify(combatManager, times(1)).onAnimationOrInteractionChange(player, 0, true);
	}
}
