package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPreCreatureSpawnEvent implements Listener {
    public OnPreCreatureSpawnEvent() {
    }

    @EventHandler
    public void onPreCreatureSpawnEvent(PreCreatureSpawnEvent event) {
        Main.showEvent(event);
    }
}