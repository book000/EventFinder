package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;

public class OnPlayerItemBreakEvent implements Listener {
    public OnPlayerItemBreakEvent() {
    }

    @EventHandler
    public void onPlayerItemBreakEvent(PlayerItemBreakEvent event) {
        Main.showEvent(event);
    }
}