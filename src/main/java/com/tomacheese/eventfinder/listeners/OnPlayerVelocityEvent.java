package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerVelocityEvent;

public class OnPlayerVelocityEvent implements Listener {
    public OnPlayerVelocityEvent() {
    }

    @EventHandler
    public void onPlayerVelocityEvent(PlayerVelocityEvent event) {
        Main.showEvent(event);
    }
}