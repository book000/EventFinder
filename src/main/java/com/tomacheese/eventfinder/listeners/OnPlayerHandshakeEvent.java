package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerHandshakeEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerHandshakeEvent implements Listener {
    public OnPlayerHandshakeEvent() {
    }

    @EventHandler
    public void onPlayerHandshakeEvent(PlayerHandshakeEvent event) {
        Main.showEvent(event);
    }
}