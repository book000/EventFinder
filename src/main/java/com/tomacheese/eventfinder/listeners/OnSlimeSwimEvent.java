package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.SlimeSwimEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnSlimeSwimEvent implements Listener {
    public OnSlimeSwimEvent() {
    }

    @EventHandler
    public void onSlimeSwimEvent(SlimeSwimEvent event) {
        Main.showEvent(event);
    }
}