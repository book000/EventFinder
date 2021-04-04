package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.block.PlayerShearBlockEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerShearBlockEvent implements Listener {
    public OnPlayerShearBlockEvent() {
    }

    @EventHandler
    public void onPlayerShearBlockEvent(PlayerShearBlockEvent event) {
        Main.showEvent(event);
    }
}