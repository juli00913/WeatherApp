package com.example.slavchev.yahooweather.data;

import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Condition {


    @SerializedName("temp")
    @Expose
    private String temp;

    @SerializedName("text")
    @Expose
    private String description;

    @SerializedName("date")
    @Expose
    private String date;

    public String getTemp() {
        return temp;
    }

    public String getDate() { return date; }

    public String getDescription() {
        return description;
    }


}
