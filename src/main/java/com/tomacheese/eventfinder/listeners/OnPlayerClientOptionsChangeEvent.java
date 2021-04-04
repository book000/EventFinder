package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerClientOptionsChangeEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerClientOptionsChangeEvent implements Listener {
    public OnPlayerClientOptionsChangeEvent() {
    }

    @EventHandler
    public void onPlayerClientOptionsChangeEvent(PlayerClientOptionsChangeEvent event) {
        Main.showEvent(event);
    }
}