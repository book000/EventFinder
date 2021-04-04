package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerTradeEvent implements Listener {
    public OnPlayerTradeEvent() {
    }

    @EventHandler
    public void onPlayerTradeEvent(PlayerTradeEvent event) {
        Main.showEvent(event);
    }
}