package com.example.slavchev.yahooweather.data;

import android.app.Application;

import com.example.slavchev.yahooweather.data.di.DaggerNetworkComponent;
import com.example.slavchev.yahooweather.data.di.NetworkComponent;

public class YahooWeatherApplication extends Application {
    private NetworkComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerNetworkComponent.builder().build();
    }

    public NetworkComponent getComponent() {
        return component;
    }
}
