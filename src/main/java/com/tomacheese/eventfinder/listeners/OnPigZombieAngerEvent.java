package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PigZombieAngerEvent;

public class OnPigZombieAngerEvent implements Listener {
    public OnPigZombieAngerEvent() {
    }

    @EventHandler
    public void onPigZombieAngerEvent(PigZombieAngerEvent event) {
        Main.showEvent(event);
    }
}