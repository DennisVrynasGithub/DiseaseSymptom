package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.listView.DisplayListViewQ2;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultAdminActivity extends AppCompatActivity {

    private String disease_id, jsonString;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result__admin);

        disease_id = getIntent().getExtras().getString("Json_data");

        disease_id = getIntent().getExtras().getString("Json_data");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        getResultQuestTwo(disease_id);
    }


    private void getResultQuestTwo(String user_id) {
        if (user_id == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Call<JsonArray> jsonCall = api.getResultQuestTwo(user_id);
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                jsonString = response.body().toString();
                if (jsonString.equals("[]")) {
                    Toast.makeText(ResultAdminActivity.this, "Empty questionnaire!!", Toast.LENGTH_LONG).show();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(ResultAdminActivity.this, DisplayListViewQ2.class);
                            intent.putExtra("Json_data", "{ disease:" + jsonString + "}");
                            startActivity(intent);
                            ResultAdminActivity.this.finish();
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
