package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 29/3/2018.
 */

public class GetDiseaseByIdResponse {

    @SerializedName("id")
    private String user_email;
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
