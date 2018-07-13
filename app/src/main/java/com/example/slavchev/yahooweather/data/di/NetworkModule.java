package com.example.slavchev.yahooweather.data.di;

import android.app.Application;

import com.example.slavchev.yahooweather.data.Channel;
import com.example.slavchev.yahooweather.data.Weather;
import com.example.slavchev.yahooweather.service.WeatherLocationCall;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

//    @Provides
//    String provideLocation() {
//        return "Sofia, Bulgaria";
//    }

    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

//    @Provides
//    Call<Weather> provideItemService(Retrofit retrofit, String location) {
//        WeatherLocationCall weatherLocationCall = retrofit.create(WeatherLocationCall.class);
//        String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")", location);
//        return weatherLocationCall.locationChannel(YQL, "json");
//
//    }
    @Provides
    WeatherLocationCall provideWeatherLocationCall(Retrofit retrofit) {
        return retrofit.create(WeatherLocationCall.class);
    }

}

