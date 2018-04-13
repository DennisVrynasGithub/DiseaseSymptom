package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 28/3/2018.
 */

public class ProfileChangeAgeRequest {

    @SerializedName("user_age")
    private String user_age;
    @SerializedName("user_email")
    private String user_email;

    public ProfileChangeAgeRequest() {
    }

    public ProfileChangeAgeRequest(String user_age, String user_email) {
        this.user_age = user_age;
        this.user_email = user_email;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
