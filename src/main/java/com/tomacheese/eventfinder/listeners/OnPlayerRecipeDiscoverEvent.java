package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;

public class OnPlayerRecipeDiscoverEvent implements Listener {
    public OnPlayerRecipeDiscoverEvent() {
    }

    @EventHandler
    public void onPlayerRecipeDiscoverEvent(PlayerRecipeDiscoverEvent event) {
        Main.showEvent(event);
    }
}