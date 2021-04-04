package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.TurtleGoHomeEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnTurtleGoHomeEvent implements Listener {
    public OnTurtleGoHomeEvent() {
    }

    @EventHandler
    public void onTurtleGoHomeEvent(TurtleGoHomeEvent event) {
        Main.showEvent(event);
    }
}