package com.tomacheese.eventfinder.listeners;

import com.destroystokyo.paper.event.entity.PlayerNaturallySpawnCreaturesEvent;
import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerNaturallySpawnCreaturesEvent implements Listener {
    public OnPlayerNaturallySpawnCreaturesEvent() {
    }

    @EventHandler
    public void onPlayerNaturallySpawnCreaturesEvent(PlayerNaturallySpawnCreaturesEvent event) {
        Main.showEvent(event);
    }
}