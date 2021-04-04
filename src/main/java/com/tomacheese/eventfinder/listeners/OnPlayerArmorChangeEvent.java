package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerArmorChangeEvent implements Listener {
    public OnPlayerArmorChangeEvent() {
    }

    @EventHandler
    public void onPlayerArmorChangeEvent(PlayerArmorChangeEvent event) {
        Main.showEvent(event);
    }
}