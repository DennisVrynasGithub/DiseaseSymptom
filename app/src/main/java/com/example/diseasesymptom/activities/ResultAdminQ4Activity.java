package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.listView.DisplayListVIewQ4;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultAdminQ4Activity extends AppCompatActivity {

    private String Json, disease_id, jsonString;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_admin_q4);

        disease_id = getIntent().getExtras().getString("Json_data");

        disease_id = getIntent().getExtras().getString("Json_data");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        getResultQuestFour(disease_id);
    }


    private void getResultQuestFour(String user_id) {
        if (user_id == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Call<JsonArray> jsonCall = api.getResultQuestFour(user_id);
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                jsonString = response.body().toString();
                if (jsonString.equals("[]")) {
                    Toast.makeText(ResultAdminQ4Activity.this, "Empty questionnaire!!", Toast.LENGTH_LONG).show();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(ResultAdminQ4Activity.this, DisplayListVIewQ4.class);
                            intent.putExtra("Json_data", "{ disease:" + jsonString + "}");
                            startActivity(intent);
                            ResultAdminQ4Activity.this.finish();
                        }
                    }, 1000);
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });
    }
}
