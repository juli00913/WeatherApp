package com.example.slavchev.yahooweather.data;

import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {


    @SerializedName("condition")
    @Expose
    private Condition condition;

    public Condition getCondition() { return condition; }

}
