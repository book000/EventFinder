package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerReplenishTradeEvent;

public class OnVillagerReplenishTradeEvent implements Listener {
    public OnVillagerReplenishTradeEvent() {
    }

    @EventHandler
    public void onVillagerReplenishTradeEvent(VillagerReplenishTradeEvent event) {
        Main.showEvent(event);
    }
}