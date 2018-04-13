package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 28/3/2018.
 */

public class Questionnaire4Request {

    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private String age;
    @SerializedName("illnes")
    private String illnes;
    @SerializedName("caused_other")
    private String caused_other;
    @SerializedName("treatment")
    private String treatment;
    @SerializedName("time")
    private String time;
    @SerializedName("sum")
    private Integer sum;
    @SerializedName("id_2")
    private String id_2;

    public Questionnaire4Request() {
    }

    public Questionnaire4Request(String gender, String age, String illnes, String caused_other, String treatment, String time, Integer sum, String id_2) {
        this.gender = gender;
        this.age = age;
        this.illnes = illnes;
        this.caused_other = caused_other;
        this.treatment = treatment;
        this.time = time;
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
