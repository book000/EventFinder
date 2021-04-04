package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerCareerChangeEvent;

public class OnVillagerCareerChangeEvent implements Listener {
    public OnVillagerCareerChangeEvent() {
    }

    @EventHandler
    public void onVillagerCareerChangeEvent(VillagerCareerChangeEvent event) {
        Main.showEvent(event);
    }
}