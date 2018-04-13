package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 28/3/2018.
 */

public class ProfileChangeCountryRequest {

    @SerializedName("user_country")
    private String user_country;
    @SerializedName("user_email")
    private String user_email;

    public ProfileChangeCountryRequest() {
    }

    public ProfileChangeCountryRequest(String user_country, String user_email) {
        this.user_country = user_country;
        this.user_email = user_email;
    }

    public String getUser_country() {
        return user_country;
    }

    public void setUser_country(String user_country) {
        this.user_country = user_country;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
