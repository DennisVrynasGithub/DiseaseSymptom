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
import com.example.diseasesymptom.listView.DisplayListView1;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;
import com.google.gson.JsonArray;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SymptomActivity extends AppCompatActivity {

    protected TextView tx1, tx2;
    protected EditText editTextSymptom;
    protected Button buttonSymptom, buton_back;
    private String json_user_id, json_user_email, json_user_password, jsonString;
    String[] str;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        tx1 = findViewById(R.id.textView_symptom);
        editTextSymptom = findViewById(R.id.editText_symptom);
        buttonSymptom = findViewById(R.id.btn_symptom);
        buton_back = findViewById(R.id.btn_symptom_back);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        buttonSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Objects.equals(editTextSymptom.getText().toString(), "")) {
                    Toast.makeText(SymptomActivity.this, "Enter symptom", Toast.LENGTH_LONG).show();
                } else {
                    str = editTextSymptom.getText().toString().split(" ");
                    Integer i = str.length;

                    if (i == 1) {
                        getSymptom(str[0]);
                    } else if (i == 2) {
                        getSymptomTwo(str[0], str[1]);
                    } else if (i == 3) {
                        getSymptomThree(str[0], str[1], str[2]);
                    } else if (i == 4) {
                        getSymptomFour(str[0], str[1], str[2], str[3]);
                    } else if (i == 5) {
                        getSymptomFive(str[0], str[1], str[2], str[3], str[4]);
                    } else {
                        Toast.makeText(SymptomActivity.this, "You have to fill less symptoms", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        editTextSymptom.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    str = editTextSymptom.getText().toString().split(" ");
                    Integer i = str.length;

                    if (i == 1) {
                        getSymptom(str[0]);
                    } else if (i == 2) {
                        getSymptomTwo(str[0], str[1]);
                    } else if (i == 3) {
                        getSymptomThree(str[0], str[1], str[2]);
                    } else if (i == 4) {
                        getSymptomFour(str[0], str[1], str[2], str[3]);
                    } else if (i == 5) {
                        getSymptomFive(str[0], str[1], str[2], str[3], str[4]);
                    } else {
                        Toast.makeText(SymptomActivity.this, "You have to fill less symptoms", Toast.LENGTH_LONG).show();
                    }
                }
                return false;
            }
        });

        buton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SymptomActivity.this, WelcomeActivity.class);
                intent.putExtra("json_user_id", json_user_id);
                intent.putExtra("json_user_email", json_user_email);
                intent.putExtra("json_user_password", json_user_password);
                startActivity(intent);
                SymptomActivity.this.finish();
            }
        });
    }

    private void getSymptom(String symptomName) {
        if (symptomName == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Call<JsonArray> jsonCall = api.getSymptom(symptomName);
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                jsonString = response.body().toString();
                Log.i("onResponse", jsonString);
                if(jsonString.equals("[]")){
                    Toast.makeText(SymptomActivity.this, "We can't find diseases with this symptom!", Toast.LENGTH_LONG).show();
                }else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
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

    private void getSymptomTwo(String symptomOne, String symptomTwo) {
        if (symptomOne == null || symptomTwo == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Call<JsonArray> jsonCall = api.getSymptomTwo(symptomOne, symptomTwo);
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                jsonString = response.body().toString();
                Log.i("onResponse", jsonString);
                if(jsonString.equals("[]")){
                    Toast.makeText(SymptomActivity.this, "We can't find disease with these symptom!", Toast.LENGTH_LONG).show();
                }else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
                            intent.putExtra("Json_data", "{ disease:" + jsonString + "}");
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

    private void getSymptomThree(String symptomOne, String symptomTwo, String symptomThree) {
        if (symptomOne == null || symptomTwo == null || symptomThree == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Call<JsonArray> jsonCall = api.getSymptomThree(symptomOne, symptomTwo, symptomThree);
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                jsonString = response.body().toString();
                Log.i("onResponse", jsonString);
                if (jsonString.equals("[]")) {
                    Toast.makeText(SymptomActivity.this, "We can't find disease with these symptom!", Toast.LENGTH_LONG).show();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
                            intent.putExtra("Json_data", "{ disease:" + jsonString + "}");
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

    private void getSymptomFour(String symptomOne, String symptomTwo, String symptomThree, String symptomFour) {
        if (symptomOne == null || symptomTwo == null || symptomThree == null || symptomFour == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Call<JsonArray> jsonCall = api.getSymptomFour(symptomOne, symptomTwo, symptomThree, symptomFour);
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                jsonString = response.body().toString();
                Log.i("onResponse", jsonString);
                if (jsonString.equals("[]")) {
                    Toast.makeText(SymptomActivity.this, "We can't find disease with these symptom!", Toast.LENGTH_LONG).show();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
                            intent.putExtra("Json_data", "{ disease:" + jsonString + "}");
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

    private void getSymptomFive(String symptomOne, String symptomTwo, String symptomThree, String symptomFour, String symptomFive) {
        if (symptomOne == null || symptomTwo == null || symptomThree == null || symptomFour == null || symptomFive == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Call<JsonArray> jsonCall = api.getSymptomFive(symptomOne, symptomTwo, symptomThree, symptomFour, symptomFive);
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                jsonString = response.body().toString();
                Log.i("onResponse", jsonString);
                if(jsonString.equals("[]")){
                    Toast.makeText(SymptomActivity.this, "We can't find disease with these symptom!", Toast.LENGTH_LONG).show();
                }else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(SymptomActivity.this, DisplayListView1.class);
                                intent.putExtra("Json_data", "{ disease:" + jsonString + "}");
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
