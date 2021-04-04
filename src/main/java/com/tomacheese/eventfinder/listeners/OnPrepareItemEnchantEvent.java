package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

public class OnPrepareItemEnchantEvent implements Listener {
    public OnPrepareItemEnchantEvent() {
    }

    @EventHandler
    public void onPrepareItemEnchantEvent(PrepareItemEnchantEvent event) {
        Main.showEvent(event);
    }
}