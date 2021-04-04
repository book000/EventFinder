package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ArrowBodyCountChangeEvent;

public class OnArrowBodyCountChangeEvent implements Listener {
    public OnArrowBodyCountChangeEvent() {
    }

    @EventHandler
    public void onArrowBodyCountChangeEvent(ArrowBodyCountChangeEvent event) {
        Main.showEvent(event);
    }
}