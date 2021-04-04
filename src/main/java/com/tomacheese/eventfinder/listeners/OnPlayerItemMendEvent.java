package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemMendEvent;

public class OnPlayerItemMendEvent implements Listener {
    public OnPlayerItemMendEvent() {
    }

    @EventHandler
    public void onPlayerItemMendEvent(PlayerItemMendEvent event) {
        Main.showEvent(event);
    }
}