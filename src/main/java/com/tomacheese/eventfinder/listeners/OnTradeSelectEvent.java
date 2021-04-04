package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.TradeSelectEvent;

public class OnTradeSelectEvent implements Listener {
    public OnTradeSelectEvent() {
    }

    @EventHandler
    public void onTradeSelectEvent(TradeSelectEvent event) {
        Main.showEvent(event);
    }
}