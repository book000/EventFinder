package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.block.AnvilDamagedEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnAnvilDamagedEvent implements Listener {
    public OnAnvilDamagedEvent() {
    }

    @EventHandler
    public void onAnvilDamagedEvent(AnvilDamagedEvent event) {
        Main.showEvent(event);
    }
}