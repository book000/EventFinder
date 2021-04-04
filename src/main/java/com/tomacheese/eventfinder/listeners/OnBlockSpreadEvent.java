package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

public class OnBlockSpreadEvent implements Listener {
    public OnBlockSpreadEvent() {
    }

    @EventHandler
    public void onBlockSpreadEvent(BlockSpreadEvent event) {
        Main.showEvent(event);
    }
}