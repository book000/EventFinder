package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class OnCreatureSpawnEvent implements Listener {
    public OnCreatureSpawnEvent() {
    }

    @EventHandler
    public void onCreatureSpawnEvent(CreatureSpawnEvent event) {
        Main.showEvent(event);
    }
}