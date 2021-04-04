package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityLoadCrossbowEvent implements Listener {
    public OnEntityLoadCrossbowEvent() {
    }

    @EventHandler
    public void onEntityLoadCrossbowEvent(EntityLoadCrossbowEvent event) {
        Main.showEvent(event);
    }
}