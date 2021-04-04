package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EntityKnockbackByEntityEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityKnockbackByEntityEvent implements Listener {
    public OnEntityKnockbackByEntityEvent() {
    }

    @EventHandler
    public void onEntityKnockbackByEntityEvent(EntityKnockbackByEntityEvent event) {
        Main.showEvent(event);
    }
}