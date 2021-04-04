package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnPlayerDeathEvent implements Listener {
    public OnPlayerDeathEvent() {
    }

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        Main.showEvent(event);
    }
}