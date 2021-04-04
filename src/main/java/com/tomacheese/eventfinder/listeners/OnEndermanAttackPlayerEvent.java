package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EndermanAttackPlayerEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEndermanAttackPlayerEvent implements Listener {
    public OnEndermanAttackPlayerEvent() {
    }

    @EventHandler
    public void onEndermanAttackPlayerEvent(EndermanAttackPlayerEvent event) {
        Main.showEvent(event);
    }
}