package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class OnPlayerSpawnLocationEvent implements Listener {
    public OnPlayerSpawnLocationEvent() {
    }

    @EventHandler
    public void onPlayerSpawnLocationEvent(PlayerSpawnLocationEvent event) {
        Main.showEvent(event);
    }
}