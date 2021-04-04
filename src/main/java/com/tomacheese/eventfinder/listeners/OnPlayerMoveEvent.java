package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnPlayerMoveEvent implements Listener {
    public OnPlayerMoveEvent() {
    }

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {
        Main.showEvent(event);
    }
}