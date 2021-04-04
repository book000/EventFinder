package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkEvent;

public class OnChunkEvent implements Listener {
    public OnChunkEvent() {
    }

    @EventHandler
    public void onChunkEvent(ChunkEvent event) {
        Main.showEvent(event);
    }
}