package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class OnPlayerKickEvent implements Listener {
    public OnPlayerKickEvent() {
    }

    @EventHandler
    public void onPlayerKickEvent(PlayerKickEvent event) {
        Main.showEvent(event);
    }
}