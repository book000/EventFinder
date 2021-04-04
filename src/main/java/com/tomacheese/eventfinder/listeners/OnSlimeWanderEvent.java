package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.SlimeWanderEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnSlimeWanderEvent implements Listener {
    public OnSlimeWanderEvent() {
    }

    @EventHandler
    public void onSlimeWanderEvent(SlimeWanderEvent event) {
        Main.showEvent(event);
    }
}