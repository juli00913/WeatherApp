package com.example.slavchev.yahooweather.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Units {

    @SerializedName("temperature")
    @Expose
    private String tempLetter;

    public String getTempLetter() { return tempLetter; }
}
