package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLocaleChangeEvent;

public class OnPlayerLocaleChangeEvent implements Listener {
    public OnPlayerLocaleChangeEvent() {
    }

    @EventHandler
    public void onPlayerLocaleChangeEvent(PlayerLocaleChangeEvent event) {
        Main.showEvent(event);
    }
}