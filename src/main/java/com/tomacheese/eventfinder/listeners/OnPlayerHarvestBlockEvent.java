package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerHarvestBlockEvent;

public class OnPlayerHarvestBlockEvent implements Listener {
    public OnPlayerHarvestBlockEvent() {
    }

    @EventHandler
    public void onPlayerHarvestBlockEvent(PlayerHarvestBlockEvent event) {
        Main.showEvent(event);
    }
}