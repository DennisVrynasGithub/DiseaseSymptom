package com.example.diseasesymptom.model;

// Created by Dennis on 10/1/2018.


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quest4 {

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("illnes")
    @Expose
    private String illnes;

    @SerializedName("caused_other")
    @Expose
    private String caused_other;

    @SerializedName("treatment")
    @Expose
    private String treatment;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("id_2")
    @Expose
    private String id_2;

    @SerializedName("Date")
    @Expose
    private String Date;

    @SerializedName("Score")
    @Expose
    private Integer Score;


    public Quest4(String gender, String age, String illnes, String caused_other, String treatment, String time, String id_2) {
        this.gender = gender;
        this.age = age;
        this.illnes = illnes;
        this.caused_other = caused_other;
        this.treatment = treatment;
        this.time = time;
        this.id_2 = id_2;
    }

    public Quest4() {

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

    public String getIllnes() {
        return illnes;
    }

    public void setIllnes(String illnes) {
        this.illnes = illnes;
    }

    public String getCaused_other() {
        return caused_other;
    }

    public void setCaused_other(String caused_other) {
        this.caused_other = caused_other;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
