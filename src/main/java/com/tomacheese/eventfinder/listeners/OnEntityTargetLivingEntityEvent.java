package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class OnEntityTargetLivingEntityEvent implements Listener {
    public OnEntityTargetLivingEntityEvent() {
    }

    @EventHandler
    public void onEntityTargetLivingEntityEvent(EntityTargetLivingEntityEvent event) {
        Main.showEvent(event);
    }
}