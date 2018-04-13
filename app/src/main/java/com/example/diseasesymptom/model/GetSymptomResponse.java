package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 29/3/2018.
 */

public class GetSymptomResponse {

    @SerializedName("id")
    private String id;
    @SerializedName("a2z")
    private String a2z;
    @SerializedName("name")
    private String name;
    @SerializedName("factid")
    private String factid;
    @SerializedName("fact")
    private String fact;
    @SerializedName("description")
    private String description;
}
