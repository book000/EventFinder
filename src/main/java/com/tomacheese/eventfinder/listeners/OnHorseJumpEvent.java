package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.HorseJumpEvent;

public class OnHorseJumpEvent implements Listener {
    public OnHorseJumpEvent() {
    }

    @EventHandler
    public void onHorseJumpEvent(HorseJumpEvent event) {
        Main.showEvent(event);
    }
}