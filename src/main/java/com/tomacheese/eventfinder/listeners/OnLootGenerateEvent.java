package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;

public class OnLootGenerateEvent implements Listener {
    public OnLootGenerateEvent() {
    }

    @EventHandler
    public void onLootGenerateEvent(LootGenerateEvent event) {
        Main.showEvent(event);
    }
}