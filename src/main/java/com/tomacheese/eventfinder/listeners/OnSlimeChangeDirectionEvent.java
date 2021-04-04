package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.SlimeChangeDirectionEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnSlimeChangeDirectionEvent implements Listener {
    public OnSlimeChangeDirectionEvent() {
    }

    @EventHandler
    public void onSlimeChangeDirectionEvent(SlimeChangeDirectionEvent event) {
        Main.showEvent(event);
    }
}