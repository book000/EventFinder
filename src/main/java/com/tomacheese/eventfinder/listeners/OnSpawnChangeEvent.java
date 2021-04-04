package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.SpawnChangeEvent;

public class OnSpawnChangeEvent implements Listener {
    public OnSpawnChangeEvent() {
    }

    @EventHandler
    public void onSpawnChangeEvent(SpawnChangeEvent event) {
        Main.showEvent(event);
    }
}