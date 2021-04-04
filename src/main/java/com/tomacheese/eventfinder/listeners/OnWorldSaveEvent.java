package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldSaveEvent;

public class OnWorldSaveEvent implements Listener {
    public OnWorldSaveEvent() {
    }

    @EventHandler
    public void onWorldSaveEvent(WorldSaveEvent event) {
        Main.showEvent(event);
    }
}