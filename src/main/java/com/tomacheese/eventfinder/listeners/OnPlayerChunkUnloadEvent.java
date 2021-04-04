package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.packet.PlayerChunkUnloadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerChunkUnloadEvent implements Listener {
    public OnPlayerChunkUnloadEvent() {
    }

    @EventHandler
    public void onPlayerChunkUnloadEvent(PlayerChunkUnloadEvent event) {
        Main.showEvent(event);
    }
}