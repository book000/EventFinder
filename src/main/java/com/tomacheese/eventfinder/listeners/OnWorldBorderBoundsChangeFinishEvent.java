package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.world.border.WorldBorderBoundsChangeFinishEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnWorldBorderBoundsChangeFinishEvent implements Listener {
    public OnWorldBorderBoundsChangeFinishEvent() {
    }

    @EventHandler
    public void onWorldBorderBoundsChangeFinishEvent(WorldBorderBoundsChangeFinishEvent event) {
        Main.showEvent(event);
    }
}