package com.example.slavchev.yahooweather;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;

import com.example.slavchev.yahooweather.data.WeatherApp;
import com.example.slavchev.yahooweather.data.YahooWeatherApplication;
import com.example.slavchev.yahooweather.data.viewModel.ForecastViewModel;
import com.example.slavchev.yahooweather.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ForecastViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ForecastViewModel();
        ((YahooWeatherApplication)getApplication()).getComponent().inject(viewModel);
        viewModel.onCreate("Sofia, Bulgaria");
        viewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if(propertyId == BR.toast) {
                    serviceFailure(viewModel.getToast());
                }
            }
        });

        mBinding.setViewModel(viewModel);
    }

    public void serviceFailure(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
