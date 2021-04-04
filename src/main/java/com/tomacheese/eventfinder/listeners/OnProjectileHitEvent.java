package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class OnProjectileHitEvent implements Listener {
    public OnProjectileHitEvent() {
    }

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
        Main.showEvent(event);
    }
}