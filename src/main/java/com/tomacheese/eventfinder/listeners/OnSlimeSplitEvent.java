package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SlimeSplitEvent;

public class OnSlimeSplitEvent implements Listener {
    public OnSlimeSplitEvent() {
    }

    @EventHandler
    public void onSlimeSplitEvent(SlimeSplitEvent event) {
        Main.showEvent(event);
    }
}