package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

public class OnWorldInitEvent implements Listener {
    public OnWorldInitEvent() {
    }

    @EventHandler
    public void onWorldInitEvent(WorldInitEvent event) {
        Main.showEvent(event);
    }
}