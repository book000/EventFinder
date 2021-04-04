package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.SlimePathfindEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnSlimePathfindEvent implements Listener {
    public OnSlimePathfindEvent() {
    }

    @EventHandler
    public void onSlimePathfindEvent(SlimePathfindEvent event) {
        Main.showEvent(event);
    }
}