package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class OnChunkUnloadEvent implements Listener {
    public OnChunkUnloadEvent() {
    }

    @EventHandler
    public void onChunkUnloadEvent(ChunkUnloadEvent event) {
        Main.showEvent(event);
    }
}