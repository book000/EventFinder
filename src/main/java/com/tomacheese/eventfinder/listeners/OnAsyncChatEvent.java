package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnAsyncChatEvent implements Listener {
    public OnAsyncChatEvent() {
    }

    @EventHandler
    public void onAsyncChatEvent(AsyncChatEvent event) {
        Main.showEvent(event);
    }
}