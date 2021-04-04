package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class OnChunkLoadEvent implements Listener {
    public OnChunkLoadEvent() {
    }

    @EventHandler
    public void onChunkLoadEvent(ChunkLoadEvent event) {
        Main.showEvent(event);
    }
}