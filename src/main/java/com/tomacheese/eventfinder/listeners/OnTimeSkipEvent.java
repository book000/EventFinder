package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.TimeSkipEvent;

public class OnTimeSkipEvent implements Listener {
    public OnTimeSkipEvent() {
    }

    @EventHandler
    public void onTimeSkipEvent(TimeSkipEvent event) {
        Main.showEvent(event);
    }
}