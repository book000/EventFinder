package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.PlayerNameEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerNameEntityEvent implements Listener {
    public OnPlayerNameEntityEvent() {
    }

    @EventHandler
    public void onPlayerNameEntityEvent(PlayerNameEntityEvent event) {
        Main.showEvent(event);
    }
}