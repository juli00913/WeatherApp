package com.example.slavchev.yahooweather.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YahooLocation {

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("country")
    @Expose
    private String country;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
