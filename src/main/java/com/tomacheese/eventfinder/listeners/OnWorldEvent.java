package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldEvent;

public class OnWorldEvent implements Listener {
    public OnWorldEvent() {
    }

    @EventHandler
    public void onWorldEvent(WorldEvent event) {
        Main.showEvent(event);
    }
}