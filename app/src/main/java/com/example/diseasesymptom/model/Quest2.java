package com.example.diseasesymptom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Created by Dennis on 10/1/2018.


public class Quest2 {

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("illnes_history")
    @Expose
    private String illnes_history;

    @SerializedName("succed_time")
    @Expose
    private String succed_time;

    @SerializedName("medical_history")
    @Expose
    private String medical_history;

    @SerializedName("id_2")
    @Expose
    private String id_2;

    @SerializedName("Date")
    @Expose
    private String Date;

    @SerializedName("Score")
    @Expose
    private Integer Score;

    public Quest2() {
    }

    public Quest2(String gender, String age, String illnes_history, String succed_time, String medical_history, String id_2) {
        this.gender = gender;
        this.age = age;
        this.illnes_history = illnes_history;
        this.succed_time = succed_time;
        this.medical_history = medical_history;
        this.id_2 = id_2;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIllnes_history() {
        return illnes_history;
    }

    public void setIllnes_history(String illnes_history) {
        this.illnes_history = illnes_history;
    }

    public String getIllnes() {
        return succed_time;
    }

    public void setIllnes(String succed_time) {
        this.succed_time = succed_time;
    }

    public String getMedical_history() {
        return medical_history;
    }

    public void setMedical_history(String medical_history) {
        this.medical_history = medical_history;
    }

    public String getId_2() {
        return id_2;
    }

    public void setId_2(String id_2) {
        this.id_2 = id_2;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer Score) {
        this.Score = Score;
    }
}
