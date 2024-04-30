package com.example.weather_updated.API;

import android.content.Context;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class WeatherAPIManager {
    private Context context;

    public WeatherAPIManager(Context context) {
        this.context = context;
    }

    // Define a method to fetch weather data from the API.
    public void fetchWeatherData(WeatherDataCallback callback) {
        // Implement the API request code as described in my previous answer.
        // Remember to replace "YOUR_API_KEY" with your actual API key.
        // Parse the JSON response and call the callback.
    }

    public interface WeatherDataCallback {
        void onSuccess(WeatherData weatherData);
        void onError(String errorMessage);
    }
    public interface WeatherApiService {
        @GET("forecast.json")
        Call<WeatherResponse> getWeatherData(
                @Query("http://api.weatherapi.com/v1/forecast.json?key=4efe5858850442d3bc5183235233009&q=Dhaka&days=1&aqi=yes&alerts=yes") String apiKey,
                @Query("q") String location,
                @Query("days") int days,
                @Query("http://api.weatherapi.com/v1/forecast.json?key=4efe5858850442d3bc5183235233009&q=Dhaka&days=1&aqi=yes&alerts=yes") String aqi,
                @Query("alerts") String alerts
        );
    }
}
