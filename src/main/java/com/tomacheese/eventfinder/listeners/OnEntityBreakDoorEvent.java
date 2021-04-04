package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreakDoorEvent;

public class OnEntityBreakDoorEvent implements Listener {
    public OnEntityBreakDoorEvent() {
    }

    @EventHandler
    public void onEntityBreakDoorEvent(EntityBreakDoorEvent event) {
        Main.showEvent(event);
    }
}