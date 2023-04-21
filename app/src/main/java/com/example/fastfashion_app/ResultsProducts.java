package com.example.fastfashion_app;

import com.google.gson.annotations.SerializedName;

public class ResultsProducts {

    @SerializedName("name")
    private String name;

    public ResultsProducts(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}