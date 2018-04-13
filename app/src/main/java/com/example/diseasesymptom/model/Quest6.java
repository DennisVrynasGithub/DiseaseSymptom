package com.example.diseasesymptom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Created by Dennis on 10/1/2018.


public class Quest6 {


    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("heredity_history")
    @Expose
    private String heredity_history;

    @SerializedName("illnes_heredity")
    @Expose
    private String illnes_heredity;

    @SerializedName("treatment")
    @Expose
    private String treatment;

    @SerializedName("id_2")
    @Expose
    private String id_2;

    @SerializedName("Date")
    @Expose
    private String Date;

    @SerializedName("Score")
    @Expose
    private Integer Score;

    public Quest6(String gender, String age, String heredity_history, String illnes_heredity, String treatment, String id_2) {
        this.gender = gender;
        this.age = age;
        this.heredity_history = heredity_history;
        this.illnes_heredity = illnes_heredity;
        this.treatment = treatment;
        this.id_2 = id_2;
    }

    public Quest6() {

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

    public String getHeredity_history() {
        return heredity_history;
    }

    public void setHeredity_history(String heredity_history) {
        this.heredity_history = heredity_history;
    }

    public String getIllnes_heredity() {
        return illnes_heredity;
    }

    public void setIllnes_heredity(String illnes_heredity) {
        this.illnes_heredity = illnes_heredity;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
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
