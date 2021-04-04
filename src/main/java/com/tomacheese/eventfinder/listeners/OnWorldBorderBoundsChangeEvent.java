package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnWorldBorderBoundsChangeEvent implements Listener {
    public OnWorldBorderBoundsChangeEvent() {
    }

    @EventHandler
    public void onWorldBorderBoundsChangeEvent(WorldBorderBoundsChangeEvent event) {
        Main.showEvent(event);
    }
}