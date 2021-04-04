package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.world.WorldGameRuleChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnWorldGameRuleChangeEvent implements Listener {
    public OnWorldGameRuleChangeEvent() {
    }

    @EventHandler
    public void onWorldGameRuleChangeEvent(WorldGameRuleChangeEvent event) {
        Main.showEvent(event);
    }
}