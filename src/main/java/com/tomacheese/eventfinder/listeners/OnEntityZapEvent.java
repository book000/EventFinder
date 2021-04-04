package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EntityZapEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityZapEvent implements Listener {
    public OnEntityZapEvent() {
    }

    @EventHandler
    public void onEntityZapEvent(EntityZapEvent event) {
        Main.showEvent(event);
    }
}