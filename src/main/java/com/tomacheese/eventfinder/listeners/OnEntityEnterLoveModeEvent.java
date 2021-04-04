package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEnterLoveModeEvent;

public class OnEntityEnterLoveModeEvent implements Listener {
    public OnEntityEnterLoveModeEvent() {
    }

    @EventHandler
    public void onEntityEnterLoveModeEvent(EntityEnterLoveModeEvent event) {
        Main.showEvent(event);
    }
}