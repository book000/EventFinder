package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.block.DragonEggFormEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnDragonEggFormEvent implements Listener {
    public OnDragonEggFormEvent() {
    }

    @EventHandler
    public void onDragonEggFormEvent(DragonEggFormEvent event) {
        Main.showEvent(event);
    }
}