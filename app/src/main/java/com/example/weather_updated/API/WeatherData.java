package com.example.weather_updated.API;

public class WeatherData {
    private String location;
    private String temperature;
    private String condition;
    // Add more fields as needed.

    public WeatherData(String location, String temperature, String condition) {
        this.location = location;
        this.temperature = temperature;
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    // Implement getters and setters for additional fields.
}

