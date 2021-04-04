package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.PreSpawnerSpawnEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPreSpawnerSpawnEvent implements Listener {
    public OnPreSpawnerSpawnEvent() {
    }

    @EventHandler
    public void onPreSpawnerSpawnEvent(PreSpawnerSpawnEvent event) {
        Main.showEvent(event);
    }
}