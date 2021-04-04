package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRegisterChannelEvent;

public class OnPlayerRegisterChannelEvent implements Listener {
    public OnPlayerRegisterChannelEvent() {
    }

    @EventHandler
    public void onPlayerRegisterChannelEvent(PlayerRegisterChannelEvent event) {
        Main.showEvent(event);
    }
}