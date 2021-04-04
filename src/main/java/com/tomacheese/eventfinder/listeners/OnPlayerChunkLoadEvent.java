package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.packet.PlayerChunkLoadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerChunkLoadEvent implements Listener {
    public OnPlayerChunkLoadEvent() {
    }

    @EventHandler
    public void onPlayerChunkLoadEvent(PlayerChunkLoadEvent event) {
        Main.showEvent(event);
    }
}