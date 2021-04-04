package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.EndermanEscapeEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnEndermanEscapeEvent implements Listener {
    public OnEndermanEscapeEvent() {
    }

    @EventHandler
    public void onEndermanEscapeEvent(EndermanEscapeEvent event) {
        Main.showEvent(event);
    }
}