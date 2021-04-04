package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnPlayerInteractEvent implements Listener {
    public OnPlayerInteractEvent() {
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Main.showEvent(event);
    }
}