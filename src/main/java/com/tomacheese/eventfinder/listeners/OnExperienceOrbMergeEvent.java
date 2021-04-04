package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.ExperienceOrbMergeEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnExperienceOrbMergeEvent implements Listener {
    public OnExperienceOrbMergeEvent() {
    }

    @EventHandler
    public void onExperienceOrbMergeEvent(ExperienceOrbMergeEvent event) {
        Main.showEvent(event);
    }
}