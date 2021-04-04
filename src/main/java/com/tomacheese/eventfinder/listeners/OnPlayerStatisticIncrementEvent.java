package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class OnPlayerStatisticIncrementEvent implements Listener {
    public OnPlayerStatisticIncrementEvent() {
    }

    @EventHandler
    public void onPlayerStatisticIncrementEvent(PlayerStatisticIncrementEvent event) {
        Main.showEvent(event);
    }
}