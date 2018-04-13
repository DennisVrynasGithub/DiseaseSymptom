package com.example.diseasesymptom.model;


import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    @SerializedName("email")
    private String user_email;
    @SerializedName("password")
    private String user_password;
    @SerializedName("username")
    private String user_name;
    @SerializedName("gendre")
    private String user_gendre;
    @SerializedName("country")
    private String user_country;
    @SerializedName("age")
    private String user_age;

    public RegisterRequest() {
    }

    public RegisterRequest(String user_name, String user_password, String user_email, String user_age, String user_country, String user_gendre) {
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_gendre = user_gendre;
        this.user_country = user_country;
        this.user_age = user_age;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

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

    public String getUser_gendre() {
        return user_gendre;
    }

    public void setUser_gendre(String user_gendre) {
        this.user_gendre = user_gendre;
    }

    public String getUser_country() {
        return user_country;
    }

    public void setUser_country(String user_country) {
        this.user_country = user_country;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }
}
