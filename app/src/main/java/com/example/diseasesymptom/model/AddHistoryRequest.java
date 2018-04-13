package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 30/3/2018.
 */

public class AddHistoryRequest {

    @SerializedName("id")
    private String id;
    @SerializedName("disease_id")
    private String disease_id;

    public AddHistoryRequest() {
    }

    public AddHistoryRequest(String id, String disease_id) {
        this.id = id;
        this.disease_id = disease_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(String disease_id) {
        this.disease_id = disease_id;
    }
}
