package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 30/3/2018.
 */

public class GetHistoryResponse {

    @SerializedName("name")
    private String name;
    @SerializedName("date")
    private String date;
    @SerializedName("id")
    private String id;

    public GetHistoryResponse(String name, String date, String id) {
        this.name = name;
        this.date = date;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
