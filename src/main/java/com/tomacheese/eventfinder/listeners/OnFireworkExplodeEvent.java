package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FireworkExplodeEvent;

public class OnFireworkExplodeEvent implements Listener {
    public OnFireworkExplodeEvent() {
    }

    @EventHandler
    public void onFireworkExplodeEvent(FireworkExplodeEvent event) {
        Main.showEvent(event);
    }
}