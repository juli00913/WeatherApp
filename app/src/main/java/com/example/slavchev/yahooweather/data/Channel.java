package com.example.slavchev.yahooweather.data;

import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Channel {
    @SerializedName("units")
    @Expose
    private Units units;

    @SerializedName("item")
    @Expose
    private Item item;

    @SerializedName("location")
    @Expose
    private YahooLocation yahooLocation;

    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    public YahooLocation getYahooLocation() {
        return yahooLocation;
    }
}
