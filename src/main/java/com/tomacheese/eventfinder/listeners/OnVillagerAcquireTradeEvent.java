package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;

public class OnVillagerAcquireTradeEvent implements Listener {
    public OnVillagerAcquireTradeEvent() {
    }

    @EventHandler
    public void onVillagerAcquireTradeEvent(VillagerAcquireTradeEvent event) {
        Main.showEvent(event);
    }
}