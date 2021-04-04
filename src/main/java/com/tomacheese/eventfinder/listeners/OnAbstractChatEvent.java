package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.AbstractChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnAbstractChatEvent implements Listener {
    public OnAbstractChatEvent() {
    }

    @EventHandler
    public void onAbstractChatEvent(AbstractChatEvent event) {
        Main.showEvent(event);
    }
}