package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class OnPlayerEggThrowEvent implements Listener {
    public OnPlayerEggThrowEvent() {
    }

    @EventHandler
    public void onPlayerEggThrowEvent(PlayerEggThrowEvent event) {
        Main.showEvent(event);
    }
}