package com.example.slavchev.yahooweather.data.di;

import com.example.slavchev.yahooweather.MainActivity;
import com.example.slavchev.yahooweather.data.viewModel.ForecastViewModel;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    void inject(ForecastViewModel viewModel);//here I want to inject
}