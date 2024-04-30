package com.example.weather_updated.API;

import android.location.Location;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {
    @SerializedName("location")
    private Location location;

    @SerializedName("current")
    private CurrentWeather current;

    public WeatherResponse(Location location, CurrentWeather current) {
        this.location = location;
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public <CurrentWeather> CurrentWeather getCurrent() {
        return (CurrentWeather) current;
    }

    private class CurrentWeather {
    }
}
