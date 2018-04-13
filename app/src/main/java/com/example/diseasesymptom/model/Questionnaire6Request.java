package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 28/3/2018.
 */

public class Questionnaire6Request {

    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private String age;
    @SerializedName("heredity_history")
    private String heredity_history;
    @SerializedName("illnes_heredity")
    private String illnes_heredity;
    @SerializedName("treatment")
    private String treatment;
    @SerializedName("sum")
    private Integer sum;
    @SerializedName("id_2")
    private String id_2;

    public Questionnaire6Request() {
    }

    public Questionnaire6Request(String gender, String age, String heredity_history, String illnes_heredity, String treatment, Integer sum, String id_2) {
        this.gender = gender;
        this.age = age;
        this.heredity_history = heredity_history;
        this.illnes_heredity = illnes_heredity;
        this.treatment = treatment;
        this.sum = sum;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getId_2() {
        return id_2;
    }

    public void setId_2(String id_2) {
        this.id_2 = id_2;
    }
}
