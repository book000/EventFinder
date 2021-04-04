package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.PlayerLecternPageChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerLecternPageChangeEvent implements Listener {
    public OnPlayerLecternPageChangeEvent() {
    }

    @EventHandler
    public void onPlayerLecternPageChangeEvent(PlayerLecternPageChangeEvent event) {
        Main.showEvent(event);
    }
}