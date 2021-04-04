package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;

public class OnPlayerUnregisterChannelEvent implements Listener {
    public OnPlayerUnregisterChannelEvent() {
    }

    @EventHandler
    public void onPlayerUnregisterChannelEvent(PlayerUnregisterChannelEvent event) {
        Main.showEvent(event);
    }
}