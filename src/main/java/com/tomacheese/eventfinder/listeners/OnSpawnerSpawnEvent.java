package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

public class OnSpawnerSpawnEvent implements Listener {
    public OnSpawnerSpawnEvent() {
    }

    @EventHandler
    public void onSpawnerSpawnEvent(SpawnerSpawnEvent event) {
        Main.showEvent(event);
    }
}