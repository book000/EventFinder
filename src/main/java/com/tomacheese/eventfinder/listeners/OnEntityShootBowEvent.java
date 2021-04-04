package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class OnEntityShootBowEvent implements Listener {
    public OnEntityShootBowEvent() {
    }

    @EventHandler
    public void onEntityShootBowEvent(EntityShootBowEvent event) {
        Main.showEvent(event);
    }
}