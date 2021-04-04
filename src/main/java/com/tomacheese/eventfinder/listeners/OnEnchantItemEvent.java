package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class OnEnchantItemEvent implements Listener {
    public OnEnchantItemEvent() {
    }

    @EventHandler
    public void onEnchantItemEvent(EnchantItemEvent event) {
        Main.showEvent(event);
    }
}