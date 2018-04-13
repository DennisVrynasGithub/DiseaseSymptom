package com.example.diseasesymptom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Created by Dennis on 10/1/2018.


public class Quest3 {

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("chronic_problem")
    @Expose
    private String chronic_problem;

    @SerializedName("years")
    @Expose
    private String years;

    @SerializedName("medical")
    @Expose
    private String medical;

    @SerializedName("other_illnes")
    @Expose
    private String other_illnes;

    @SerializedName("id_2")
    @Expose
    private String id_2;


    @SerializedName("Date")
    @Expose
    private String Date;

    @SerializedName("Score")
    @Expose
    private Integer Score;

    public Quest3(String gender, String age, String chronic_problem, String years, String medical, String other_illnes, String id_2) {
        this.gender = gender;
        this.age = age;
        this.chronic_problem = chronic_problem;
        this.years = years;
        this.medical = medical;
        this.other_illnes = other_illnes;
        this.id_2 = id_2;
    }

    public Quest3() {

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

    public String getChronic_problem() {
        return chronic_problem;
    }

    public void setChronic_problem(String chronic_problem) {
        this.chronic_problem = chronic_problem;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getOther_illnes() {
        return other_illnes;
    }

    public void setOther_illnes(String other_illnes) {
        this.other_illnes = other_illnes;
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
