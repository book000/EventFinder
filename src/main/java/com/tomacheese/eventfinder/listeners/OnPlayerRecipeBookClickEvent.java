package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerRecipeBookClickEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerRecipeBookClickEvent implements Listener {
    public OnPlayerRecipeBookClickEvent() {
    }

    @EventHandler
    public void onPlayerRecipeBookClickEvent(PlayerRecipeBookClickEvent event) {
        Main.showEvent(event);
    }
}