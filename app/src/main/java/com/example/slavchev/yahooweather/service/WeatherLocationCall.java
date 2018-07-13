package com.example.slavchev.yahooweather.service;

import com.example.slavchev.yahooweather.data.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherLocationCall {

    @GET("v1/public/yql")
    Call<Weather> locationChannel(@Query("q") String query,
                                           @Query("format") String format);
}
