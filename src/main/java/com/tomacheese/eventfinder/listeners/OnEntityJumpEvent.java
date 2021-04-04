package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EntityJumpEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEntityJumpEvent implements Listener {
    public OnEntityJumpEvent() {
    }

    @EventHandler
    public void onEntityJumpEvent(EntityJumpEvent event) {
        Main.showEvent(event);
    }
}