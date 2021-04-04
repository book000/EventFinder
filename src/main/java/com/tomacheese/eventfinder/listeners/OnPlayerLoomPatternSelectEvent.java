package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.PlayerLoomPatternSelectEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerLoomPatternSelectEvent implements Listener {
    public OnPlayerLoomPatternSelectEvent() {
    }

    @EventHandler
    public void onPlayerLoomPatternSelectEvent(PlayerLoomPatternSelectEvent event) {
        Main.showEvent(event);
    }
}