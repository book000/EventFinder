package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldUnloadEvent;

public class OnWorldUnloadEvent implements Listener {
    public OnWorldUnloadEvent() {
    }

    @EventHandler
    public void onWorldUnloadEvent(WorldUnloadEvent event) {
        Main.showEvent(event);
    }
}