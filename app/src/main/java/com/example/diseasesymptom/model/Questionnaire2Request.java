package com.example.diseasesymptom.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dennis on 28/3/2018.
 */

public class Questionnaire2Request {

    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private String age;
    @SerializedName("illnes_history")
    private String illnes_history;
    @SerializedName("medical_history")
    private String medical_history;
    @SerializedName("succeed_time")
    private String succeed_time;
    @SerializedName("sum")
    private Integer sum;
    @SerializedName("id_2")
    private String id_2;

    public Questionnaire2Request() {
    }

    public Questionnaire2Request(String gender, String age, String illnes_history, String medical_history, String succeed_time, Integer sum, String id_2) {
        this.gender = gender;
        this.age = age;
        this.illnes_history = illnes_history;
        this.medical_history = medical_history;
        this.succeed_time = succeed_time;
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

    public String getIllnes_history() {
        return illnes_history;
    }

    public void setIllnes_history(String illnes_history) {
        this.illnes_history = illnes_history;
    }

    public String getMedical_history() {
        return medical_history;
    }

    public void setMedical_history(String medical_history) {
        this.medical_history = medical_history;
    }

    public String getSucceed_time() {
        return succeed_time;
    }

    public void setSucceed_time(String succeed_time) {
        this.succeed_time = succeed_time;
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
