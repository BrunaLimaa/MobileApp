package com.example.fastfashion_app;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("name")
    private String name;

    public Results(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}