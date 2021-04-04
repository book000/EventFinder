package com.tomacheese.eventfinder.listeners;

import com.tomacheese.eventfinder.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherEvent;

public class OnWeatherEvent implements Listener {
    public OnWeatherEvent() {
    }

    @EventHandler
    public void onWeatherEvent(WeatherEvent event) {
        Main.showEvent(event);
    }
}