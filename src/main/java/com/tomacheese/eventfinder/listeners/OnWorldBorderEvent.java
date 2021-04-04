package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.world.border.WorldBorderEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnWorldBorderEvent implements Listener {
    public OnWorldBorderEvent() {
    }

    @EventHandler
    public void onWorldBorderEvent(WorldBorderEvent event) {
        Main.showEvent(event);
    }
}