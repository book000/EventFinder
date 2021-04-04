package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class OnPlayerLevelChangeEvent implements Listener {
    public OnPlayerLevelChangeEvent() {
    }

    @EventHandler
    public void onPlayerLevelChangeEvent(PlayerLevelChangeEvent event) {
        Main.showEvent(event);
    }
}