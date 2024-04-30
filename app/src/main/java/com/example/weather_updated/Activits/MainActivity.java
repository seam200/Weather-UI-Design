package com.example.weather_updated.Activits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weather_updated.API.WeatherApiClient;
import com.example.weather_updated.API.WeatherApiService;
import com.example.weather_updated.API.WeatherResponse;
import com.example.weather_updated.Adapters.HourlyAdapter;
import com.example.weather_updated.Domains.Hourly;
import com.example.weather_updated.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecylerview();
        setVariable();
    }

    private void setVariable() {
        TextView nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FutureActivity.class)));
    }

    private void initRecylerview() {
        ArrayList<Hourly> items = new ArrayList<>();

        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",29,"sunny"));
        items.add(new Hourly("12 pm",30,"wind"));
        items.add(new Hourly("1 am",29,"rainy"));
        items.add(new Hourly("2 am",27,"storm"));

        recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly = new HourlyAdapter(items);
        recyclerView.setAdapter(adapterHourly);
    }
    // In MainActivity.java
    WeatherApiService apiService = WeatherApiClient.getRetrofitInstance().create(WeatherApiService.class);
    Call<WeatherResponse> call = apiService.getWeatherData("YOUR_API_KEY", "Dhaka", 1, "yes", "yes");

call.enqueue(new Callback<WeatherResponse>() {
        @Override
        public void onResponse Object Response = new Object();
        boolean response;
        Object WeatherResponse;
        Object Call;
        (Call < WeatherResponse > call, (WeatherResponse > Response) > response) {
            if (response.isSuccessful()) {
                WeatherResponse weatherResponse = response.body();
                // Extract data from weatherResponse and update your UI.
                // Example: locationTextView.setText(weatherResponse.getLocation().getName());
            } else {
                // Handle API error.
            }
        }

        @Override
        public void onFailure Object Throwable = new Object();
        (!(WeatherResponse <= Call) > call, Throwable t) {
            // Handle network failure.
        }
    });

// In FutureActivity.java, you can follow a similar approach.

}