package com.example.weather_updated.Activits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView; // Import the TextView class

import com.example.weather_updated.API.WeatherApiClient;
import com.example.weather_updated.API.WeatherApiService;
import com.example.weather_updated.API.WeatherResponse;
import com.example.weather_updated.Adapters.FutureAdapter;
import com.example.weather_updated.Domains.FutureDomain;
import com.example.weather_updated.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FutureActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterTommorow;
    public RecyclerView recyclerView;
    private TextView locationTextView; // Add a TextView for location

    TextView nxtDay,tampatra,Anumanik,rainTemp,rainStatus,windTemp,windStatus,hardlyTemp,hardlyStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecylerview();
        setVariable();
        fetchWeatherData();
    }

    private void setVariable() {
        @SuppressLint("WrongViewCast")
        ConstraintLayout backBtn = findViewById(R.id.backbtn);
        backBtn.setOnClickListener(view -> startActivity(new Intent(FutureActivity.this, MainActivity.class));
        locationTextView = findViewById(R.id.locationTextView); // Initialize the location TextView
    }

    private void initRecylerview() {
        ArrayList<FutureDomain> items = new ArrayList<>();

        // ... Your existing code for initializing the RecyclerView

        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterTommorow = new FutureAdapter(items);
        recyclerView.setAdapter(adapterTommorow);
    }

    private void fetchWeatherData() {
        WeatherApiService apiService = WeatherApiClient.getRetrofitInstance().create(WeatherApiService.class);
        Call<WeatherResponse> call = apiService.getWeatherData("YOUR_API_KEY", "Dhaka", 1, "yes", "yes");

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    WeatherResponse weatherResponse = response.body();
                    // Extract data from weatherResponse and update your UI.
                    locationTextView.setText(weatherResponse.getLocation().getName());
                } else {
                    // Handle API error.
                }
            }
            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                // Handle network failure.
            }
        });
    }
}
