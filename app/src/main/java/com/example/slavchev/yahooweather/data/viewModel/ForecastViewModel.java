package com.example.slavchev.yahooweather.data.viewModel;

import android.app.Application;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.example.slavchev.yahooweather.BR;
import com.example.slavchev.yahooweather.data.Condition;
import com.example.slavchev.yahooweather.data.Weather;
import com.example.slavchev.yahooweather.data.WeatherLocation;
import com.example.slavchev.yahooweather.data.YahooLocation;
import com.example.slavchev.yahooweather.service.WeatherLocationCall;

import javax.inject.Inject;

import dagger.Component;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ForecastViewModel extends BaseObservable {

    private String temp;

    private String description;

    private String weatherLocation;

    private String date;

    private String toast;

    private String inputLocation;

//    @Inject
//    Call<Weather> weatherCall;

    @Inject
    WeatherLocationCall weatherLocationCall;

    public void onCreate(String location) {
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("https://query.yahooapis.com/")
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();
//
//        WeatherLocationCall weatherLocationCall = retrofit.create(WeatherLocationCall.class);
        String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")", location);
        Call<Weather> weatherCall = weatherLocationCall.locationChannel(YQL, "json");

        weatherCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                try {

                    Condition condition = response.body().getQuery().getResults().getChannel().getItem().getCondition();

                    YahooLocation yahooLocation = response.body().getQuery().getResults().getChannel().getYahooLocation();

                    temp = condition.getTemp() + " \u00B0" + "F";
                    notifyPropertyChanged(BR.temp);

                    description = condition.getDescription();
                    notifyPropertyChanged(BR.description);

                    date = condition.getDate();
                    notifyPropertyChanged(BR.date);

                    weatherLocation = yahooLocation.getCity() + ", " + yahooLocation.getCountry();
                    notifyPropertyChanged(BR.weatherLocation);

                } catch (NullPointerException e) {
                    toast = "Error: Location doesn't exist";
                    notifyPropertyChanged(BR.toast);
                    Log.e("your app", e.toString());
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                toast = "Error: Failure. " + t.toString();
                notifyPropertyChanged(BR.toast);
                Log.e("your app", t.toString());
            }
        });
    }


    public void onClick() {
        onCreate(getInputLocation());
    }

    @Bindable
    public String getTemp() {
        return temp;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public String getWeatherLocation() {
        return weatherLocation;
    }

    @Bindable
    public String getDate() {
        return date;
    }

    @Bindable
    public String getToast() {
        return toast;
    }

    @Bindable
    public String getInputLocation() {
        return inputLocation;
    }

    public void setInputLocation(String inputLocation) {
        this.inputLocation = inputLocation;
        notifyPropertyChanged(BR.location);
    }
}