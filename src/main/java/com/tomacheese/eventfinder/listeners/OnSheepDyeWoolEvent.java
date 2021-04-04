package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SheepDyeWoolEvent;

public class OnSheepDyeWoolEvent implements Listener {
    public OnSheepDyeWoolEvent() {
    }

    @EventHandler
    public void onSheepDyeWoolEvent(SheepDyeWoolEvent event) {
        Main.showEvent(event);
    }
}