package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.CauldronLevelChangeEvent;

public class OnCauldronLevelChangeEvent implements Listener {
    public OnCauldronLevelChangeEvent() {
    }

    @EventHandler
    public void onCauldronLevelChangeEvent(CauldronLevelChangeEvent event) {
        Main.showEvent(event);
    }
}