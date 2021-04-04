package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.PlayerStonecutterRecipeSelectEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerStonecutterRecipeSelectEvent implements Listener {
    public OnPlayerStonecutterRecipeSelectEvent() {
    }

    @EventHandler
    public void onPlayerStonecutterRecipeSelectEvent(PlayerStonecutterRecipeSelectEvent event) {
        Main.showEvent(event);
    }
}