package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class OnPlayerToggleSprintEvent implements Listener {
    public OnPlayerToggleSprintEvent() {
    }

    @EventHandler
    public void onPlayerToggleSprintEvent(PlayerToggleSprintEvent event) {
        Main.showEvent(event);
    }
}