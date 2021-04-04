package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.CreeperIgniteEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnCreeperIgniteEvent implements Listener {
    public OnCreeperIgniteEvent() {
    }

    @EventHandler
    public void onCreeperIgniteEvent(CreeperIgniteEvent event) {
        Main.showEvent(event);
    }
}