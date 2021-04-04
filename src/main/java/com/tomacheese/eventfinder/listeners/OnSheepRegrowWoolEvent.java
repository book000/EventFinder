package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SheepRegrowWoolEvent;

public class OnSheepRegrowWoolEvent implements Listener {
    public OnSheepRegrowWoolEvent() {
    }

    @EventHandler
    public void onSheepRegrowWoolEvent(SheepRegrowWoolEvent event) {
        Main.showEvent(event);
    }
}