package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

public class OnWorldLoadEvent implements Listener {
    public OnWorldLoadEvent() {
    }

    @EventHandler
    public void onWorldLoadEvent(WorldLoadEvent event) {
        Main.showEvent(event);
    }
}