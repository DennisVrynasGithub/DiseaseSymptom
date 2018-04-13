package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.listView.DisplayListHistory;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;
import com.google.gson.JsonArray;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WelcomeActivity extends AppCompatActivity {

    Button button_disease, button_symptom, button_questionnaire, button_logout, button_profile, button_admin, buttonHistory;
    String json_user_id, json_user_email,json_user_password,jsonString;

    private Api api;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    public static final String MY_PREFS_NAME_LOGIN = "MyLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME_LOGIN, MODE_PRIVATE);
        json_user_id = prefs.getString("user_id_sp", null);
        json_user_email = prefs.getString("json_user_email_sp", null);
        json_user_password = prefs.getString("json_user_password_sp", null);

//        json_user_id = getIntent().getExtras().getString("json_user_id");
//        json_user_email = getIntent().getExtras().getString("json_user_email");
//        json_user_password = getIntent().getExtras().getString("json_user_password");

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("user_id_sp", json_user_id);
        editor.apply();

        button_disease = findViewById(R.id.w_disease);
        button_symptom = findViewById(R.id.w_symptom);
        button_questionnaire = findViewById(R.id.w_questionnaire);
        button_logout = findViewById(R.id.w_logout);
        button_profile = findViewById(R.id.btnEnterProfile);
        button_admin = findViewById(R.id.btnEnterAdmin);
        buttonHistory = findViewById(R.id.btnEnterHistory);

        button_admin.setVisibility(View.INVISIBLE);

        if (Objects.equals(json_user_email.trim(), "dionisis@gmail.com") && Objects.equals(json_user_password, "dennis")){
            button_admin.setVisibility(View.VISIBLE);
        }

        button_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, DiseaseActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(G.HOST_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                api = retrofit.create(Api.class);

                getHistoryList(json_user_id);

            }
        });

        button_symptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, SymptomActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        button_questionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, FindQuestionnaireActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, DashboardActivity.class);
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME_LOGIN, MODE_PRIVATE).edit();
                editor.remove("user_id_sp");
                editor.remove("json_user_email_sp");
                editor.remove("json_user_password_sp");
                editor.apply();
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });

        button_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, AdminActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });

        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, ProfileActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
            }
        });
    }

    private void getHistoryList(final String json_user_id) {
        if (json_user_id == null) {
            Toast.makeText(WelcomeActivity.this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(WelcomeActivity.this, "Loading...please wait!!", Toast.LENGTH_LONG).show();
        Call<JsonArray> jsonCall = api.getHistory(json_user_id);
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                jsonString = response.body().toString();
                Log.i("onResponse", jsonString);
                if (jsonString.equals("[]")) {
                    Toast.makeText(WelcomeActivity.this, "The disease history is empty!", Toast.LENGTH_LONG).show();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(WelcomeActivity.this, DisplayListHistory.class);
                            intent.putExtra("Json_data", "{ disease:" + jsonString + "}");
                            intent.putExtra("json_user_id", json_user_id);
                            startActivity(intent);
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
