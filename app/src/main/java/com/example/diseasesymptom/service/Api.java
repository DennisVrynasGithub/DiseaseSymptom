package com.example.diseasesymptom.service;

import com.example.diseasesymptom.model.AddHistoryRequest;
import com.example.diseasesymptom.model.AddHistoryResponse;
import com.example.diseasesymptom.model.DeleteHistoryResponse;
import com.example.diseasesymptom.model.LoginRequest;
import com.example.diseasesymptom.model.LoginResponse;
import com.example.diseasesymptom.model.ProfileChangeAgeRequest;
import com.example.diseasesymptom.model.ProfileChangeAgeResponse;
import com.example.diseasesymptom.model.ProfileChangeCountryRequest;
import com.example.diseasesymptom.model.ProfileChangeCountryResponse;
import com.example.diseasesymptom.model.ProfileChangeNameRequest;
import com.example.diseasesymptom.model.ProfileChangeNameResponse;
import com.example.diseasesymptom.model.ProfileChangePasswordRequest;
import com.example.diseasesymptom.model.ProfileChangePasswordResponse;
import com.example.diseasesymptom.model.Questionnaire1Request;
import com.example.diseasesymptom.model.Questionnaire1Response;
import com.example.diseasesymptom.model.Questionnaire2Request;
import com.example.diseasesymptom.model.Questionnaire2Response;
import com.example.diseasesymptom.model.Questionnaire3Request;
import com.example.diseasesymptom.model.Questionnaire3Response;
import com.example.diseasesymptom.model.Questionnaire4Request;
import com.example.diseasesymptom.model.Questionnaire4Response;
import com.example.diseasesymptom.model.Questionnaire5Request;
import com.example.diseasesymptom.model.Questionnaire5Response;
import com.example.diseasesymptom.model.Questionnaire6Request;
import com.example.diseasesymptom.model.Questionnaire6Response;
import com.example.diseasesymptom.model.RegisterRequest;
import com.example.diseasesymptom.model.RegisterResponse;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

//Created by Dennis on 3/1/2018.
public interface Api {
    @POST("loginUser")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("createUser")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("quest1")
    Call<Questionnaire1Response> questionnaireOne(@Body Questionnaire1Request questionnaire1Request);

    @POST("quest2")
    Call<Questionnaire2Response> questionnaireTwo(@Body Questionnaire2Request questionnaire2Request);

    @POST("quest3")
    Call<Questionnaire3Response> questionnaireThree(@Body Questionnaire3Request questionnaire3Request);

    @POST("quest4")
    Call<Questionnaire4Response> questionnaireFour(@Body Questionnaire4Request questionnaire4Request);

    @POST("quest5")
    Call<Questionnaire5Response> questionnaireFive(@Body Questionnaire5Request questionnaire5Request);

    @POST("quest6")
    Call<Questionnaire6Response> questionnaireSix(@Body Questionnaire6Request questionnaire6Request);

    @POST("addHistory")
    Call<AddHistoryResponse> addHistory(@Body AddHistoryRequest addHistoryRequest);

    @PUT("getChangeUserName")
    Call<ProfileChangeNameResponse> changeName(@Body ProfileChangeNameRequest profileChangeNameRequest);

    @PUT("getChangeUserPassword")
    Call<ProfileChangePasswordResponse> changePassword(@Body ProfileChangePasswordRequest profileChangePasswordRequest);

    @PUT("getChangeUserCountry")
    Call<ProfileChangeCountryResponse> changeCountry(@Body ProfileChangeCountryRequest profileChangeCountryRequest);

    @PUT("getChangeUserAge")
    Call<ProfileChangeAgeResponse> changeAge(@Body ProfileChangeAgeRequest profileChangeAgeRequest);

    @GET("getDisease")
    Call<JsonArray> getDisease(@Query("disease") String disease);

    @GET("getSymptoms")
    Call<JsonArray> getSymptom(@Query("symptom") String symptom);

    @GET("getSymptomsTwo")
    Call<JsonArray> getSymptomTwo(@Query("a") String symptomOne, @Query("b") String symptomTwo);

    @GET("getSymptomsThree")
    Call<JsonArray> getSymptomThree(@Query("a") String symptomOne,
                                    @Query("b") String symptomTwo,
                                    @Query("c") String symptomThree);

    @GET("getSymptomsFour")
    Call<JsonArray> getSymptomFour(@Query("a") String symptomOne,
                                   @Query("b") String symptomTwo,
                                   @Query("c") String symptomThree,
                                   @Query("d") String symptomFour);

    @GET("getSymptomsFive")
    Call<JsonArray> getSymptomFive(@Query("a") String symptomOne,
                                   @Query("b") String symptomTwo,
                                   @Query("c") String symptomThree,
                                   @Query("d") String symptomFour,
                                   @Query("e") String symptomFive);

    @GET("getDiseaseById")
    Call<JsonArray> getDiseaseById(@Query("disease_id") String disease_id);

    @GET("result_quest_1")
    Call<JsonArray> getResultQuestOne(@Query("user_id") String user_id);

    @GET("result_quest_2")
    Call<JsonArray> getResultQuestTwo(@Query("user_id") String user_id);

    @GET("result_quest_3")
    Call<JsonArray> getResultQuestThree(@Query("user_id") String user_id);

    @GET("result_quest_4")
    Call<JsonArray> getResultQuestFour(@Query("user_id") String user_id);

    @GET("result_quest_5")
    Call<JsonArray> getResultQuestFive(@Query("user_id") String user_id);

    @GET("result_quest_6")
    Call<JsonArray> getResultQuestSix(@Query("user_id") String user_id);

    @GET("getUsers")
    Call<JsonArray> getUsersForAdmin();

    @GET("getHistory")
    Call<JsonArray> getHistory(@Query("user_id") String user_id);

    @DELETE("deleteHistory")
    Call<DeleteHistoryResponse> deleteHistory(@Query("id") int id, @Query("disease_id") int disease_id);

}
