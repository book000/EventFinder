package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.TurtleStartDiggingEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnTurtleStartDiggingEvent implements Listener {
    public OnTurtleStartDiggingEvent() {
    }

    @EventHandler
    public void onTurtleStartDiggingEvent(TurtleStartDiggingEvent event) {
        Main.showEvent(event);
    }
}