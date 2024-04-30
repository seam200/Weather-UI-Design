package com.example.weather_updated.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {
    @GET("forecast.json")
    Call<WeatherResponse> getWeatherData(
            @Query("http://api.weatherapi.com/v1/forecast.json?key=4efe5858850442d3bc5183235233009&q=Dhaka&days=1&aqi=yes&alerts=yes") String apiKey,
            @Query("q") String location,
            @Query("days") int days,
            @Query("aqi") String aqi,
            @Query("alerts") String alerts
    );
}

