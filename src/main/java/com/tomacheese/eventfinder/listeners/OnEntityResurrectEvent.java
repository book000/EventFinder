package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;

public class OnEntityResurrectEvent implements Listener {
    public OnEntityResurrectEvent() {
    }

    @EventHandler
    public void onEntityResurrectEvent(EntityResurrectEvent event) {
        Main.showEvent(event);
    }
}