package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    private boolean success;
    private String message;

    @SerializedName("user_email")
    private String user_email;

    @SerializedName("user_id")
    private String user_id;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
