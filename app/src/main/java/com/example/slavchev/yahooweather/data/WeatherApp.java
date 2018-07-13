package com.example.slavchev.yahooweather.data;

import android.app.Application;

import com.example.slavchev.yahooweather.data.di.DaggerNetworkComponent;
import com.example.slavchev.yahooweather.data.di.NetworkComponent;
import com.example.slavchev.yahooweather.data.di.NetworkModule;

public class WeatherApp extends Application {

    private NetworkComponent networkComponent;

    @Override public void onCreate() {
        super.onCreate();

        networkComponent = DaggerNetworkComponent
                .builder()
                .networkModule(new NetworkModule())
                .build();

    }

    public NetworkComponent getNetComponent() {
        return networkComponent;
    }

}
