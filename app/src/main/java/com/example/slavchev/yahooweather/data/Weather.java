package com.example.slavchev.yahooweather.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Weather {

    @SerializedName("query")
    @Expose
    private Query query;

    public Query getQuery() {
        return query;
    }

}
