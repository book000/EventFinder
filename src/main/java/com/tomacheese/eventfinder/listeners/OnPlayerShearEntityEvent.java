package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class OnPlayerShearEntityEvent implements Listener {
    public OnPlayerShearEntityEvent() {
    }

    @EventHandler
    public void onPlayerShearEntityEvent(PlayerShearEntityEvent event) {
        Main.showEvent(event);
    }
}