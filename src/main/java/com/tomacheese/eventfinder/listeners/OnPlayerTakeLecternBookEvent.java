package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;

public class OnPlayerTakeLecternBookEvent implements Listener {
    public OnPlayerTakeLecternBookEvent() {
    }

    @EventHandler
    public void onPlayerTakeLecternBookEvent(PlayerTakeLecternBookEvent event) {
        Main.showEvent(event);
    }
}