package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;

public class OnChunkPopulateEvent implements Listener {
    public OnChunkPopulateEvent() {
    }

    @EventHandler
    public void onChunkPopulateEvent(ChunkPopulateEvent event) {
        Main.showEvent(event);
    }
}