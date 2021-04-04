package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

public class OnPlayerEditBookEvent implements Listener {
    public OnPlayerEditBookEvent() {
    }

    @EventHandler
    public void onPlayerEditBookEvent(PlayerEditBookEvent event) {
        Main.showEvent(event);
    }
}