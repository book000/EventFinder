package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.PhantomPreSpawnEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPhantomPreSpawnEvent implements Listener {
    public OnPhantomPreSpawnEvent() {
    }

    @EventHandler
    public void onPhantomPreSpawnEvent(PhantomPreSpawnEvent event) {
        Main.showEvent(event);
    }
}