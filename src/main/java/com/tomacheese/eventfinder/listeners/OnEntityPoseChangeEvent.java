package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPoseChangeEvent;

public class OnEntityPoseChangeEvent implements Listener {
    public OnEntityPoseChangeEvent() {
    }

    @EventHandler
    public void onEntityPoseChangeEvent(EntityPoseChangeEvent event) {
        Main.showEvent(event);
    }
}