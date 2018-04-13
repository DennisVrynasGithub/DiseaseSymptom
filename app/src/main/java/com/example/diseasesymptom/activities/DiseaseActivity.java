package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.listView.DisplayListView;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;
import com.google.gson.JsonArray;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiseaseActivity extends AppCompatActivity {

    //    protected TextView txProfileCountry;
    protected EditText editeTextDisease;
    protected Button button_disease, button_back;
    private String json_user_id, jsonString, json_user_email, json_user_password;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

//        txProfileCountry = findViewById(R.id.textView3);
        editeTextDisease = findViewById(R.id.editTextDiseaseEnterDisease);
        button_disease = findViewById(R.id.btn_find_disease);
        button_back = findViewById(R.id.btn_disease_back);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        editeTextDisease.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    getDisease(editeTextDisease.getText().toString());
                }
                return false;
            }
        });

        button_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(editeTextDisease.getText().toString(), "")) {
                    Toast.makeText(DiseaseActivity.this, "Enter disease!", Toast.LENGTH_LONG).show();
                } else {
                    getDisease(editeTextDisease.getText().toString());
                }
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiseaseActivity.this, WelcomeActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                DiseaseActivity.this.finish();
            }
        });
    }


    private void getDisease(String diseaseName) {
        if (diseaseName == null) {
            Toast.makeText(this, "Enter disease!", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(DiseaseActivity.this, "Loading....please wait!!!!", Toast.LENGTH_SHORT).show();
        Call<JsonArray> jsonCall = api.getDisease(diseaseName);
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                jsonString = response.body().toString();
                Log.i("onResponse", jsonString);
                if (jsonString.equals("[]")) {
                    Toast.makeText(DiseaseActivity.this, "We can't find the disease!!!!", Toast.LENGTH_SHORT).show();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(DiseaseActivity.this, DisplayListView.class);
                            intent.putExtra("Json_data", "{ disease:" + jsonString + "}");
                            intent.putExtra("json_user_id", json_user_id);
                            startActivity(intent);
                        }
                    }, 3000);
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });
    }
}
