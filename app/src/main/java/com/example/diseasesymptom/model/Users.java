package com.example.diseasesymptom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Created by Dennis on 3/1/2018.


public class Users {

    @SerializedName("user_name")
    @Expose
    private String user_name;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("user_password")
    @Expose
    private String user_password;

    @SerializedName("user_email")
    @Expose
    private String user_email;

    @SerializedName("user_country")
    @Expose
    private String user_country;

    @SerializedName("user_gendre")
    @Expose
    private String user_gendre;

    @SerializedName("user_age")
    @Expose
    private String user_age;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getCountry() {
        return user_country;
    }

    public void setCountry(String user_country) {
        this.user_country = user_country;
    }

    public String getGendre() {
        return user_gendre;
    }

    public void setGendre(String user_gendre) {
        this.user_gendre = user_gendre;
    }

    public String getAge() {
        return user_age;
    }

    public void setAge(String user_age) {
        this.user_age = user_age;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Users(String user_name,String user_id, String user_password, String user_email, String user_country, String user_gendre, String user_age) {
        this.user_name = user_name;
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_country = user_country;
        this.user_gendre = user_gendre;
        this.user_age = user_age;
    }

    public Users() {
    }
}
