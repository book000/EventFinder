package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

public class OnStructureGrowEvent implements Listener {
    public OnStructureGrowEvent() {
    }

    @EventHandler
    public void onStructureGrowEvent(StructureGrowEvent event) {
        Main.showEvent(event);
    }
}