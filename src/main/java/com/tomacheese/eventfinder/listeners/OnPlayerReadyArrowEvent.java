package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerReadyArrowEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerReadyArrowEvent implements Listener {
    public OnPlayerReadyArrowEvent() {
    }

    @EventHandler
    public void onPlayerReadyArrowEvent(PlayerReadyArrowEvent event) {
        Main.showEvent(event);
    }
}