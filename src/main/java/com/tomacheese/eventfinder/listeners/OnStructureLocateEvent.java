package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.world.StructureLocateEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnStructureLocateEvent implements Listener {
    public OnStructureLocateEvent() {
    }

    @EventHandler
    public void onStructureLocateEvent(StructureLocateEvent event) {
        Main.showEvent(event);
    }
}