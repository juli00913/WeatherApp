package com.example.slavchev.yahooweather.data;

import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Query {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("results")
    @Expose
    private Results results;

    public int getCount() {
        return count;
    }

    public String getCreated() {
        return created;
    }

    public Results getResults() { return results; }

}
