package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerAdvancementCriterionGrantEvent implements Listener {
    public OnPlayerAdvancementCriterionGrantEvent() {
    }

    @EventHandler
    public void onPlayerAdvancementCriterionGrantEvent(PlayerAdvancementCriterionGrantEvent event) {
        Main.showEvent(event);
    }
}