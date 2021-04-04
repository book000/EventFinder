package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.ProjectileCollideEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnProjectileCollideEvent implements Listener {
    public OnProjectileCollideEvent() {
    }

    @EventHandler
    public void onProjectileCollideEvent(ProjectileCollideEvent event) {
        Main.showEvent(event);
    }
}