package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.NotePlayEvent;

public class OnNotePlayEvent implements Listener {
    public OnNotePlayEvent() {
    }

    @EventHandler
    public void onNotePlayEvent(NotePlayEvent event) {
        Main.showEvent(event);
    }
}