package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.model.Questionnaire6Request;
import com.example.diseasesymptom.model.Questionnaire6Response;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Questionnaire6Activity extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5;
    Button btn, btn_n1, btn_p2, btn_n2, btn_p3, btn_n3, btn_p4, btn_p5, btn_n4, btn_back;
    String json_user_id, json_user_password, json_user_email, radioButton_string, radioButton_string2, radioButton_string3, radioButton_string4, radioButton_string5;
    TextView tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, TX1, TX2, TX3, TX4, TX5;
    Integer in1, in2, in3, in4, in5;
    LinearLayout ln1, ln2, ln3, ln4, ln5;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire6);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        radioGroup1 = findViewById(R.id.radiogroup61);
        radioGroup2 = findViewById(R.id.radiogroup62);
        radioGroup3 = findViewById(R.id.radiogroup63);
        radioGroup4 = findViewById(R.id.radiogroup64);
        radioGroup5 = findViewById(R.id.radiogroup65);

        ln1 = findViewById(R.id.linearLayout21);
        ln2 = findViewById(R.id.linearLayout22);
        ln3 = findViewById(R.id.linearLayout23);
        ln4 = findViewById(R.id.linearLayout24);
        ln5 = findViewById(R.id.linearLayout30);

        tx1 = findViewById(R.id.textView654);
        tx2 = findViewById(R.id.textView655);
        tx3 = findViewById(R.id.textView656);
        tx4 = findViewById(R.id.textView657);
        tx5 = findViewById(R.id.textView658);
        tx6 = findViewById(R.id.textView659);
        tx7 = findViewById(R.id.textView660);
        tx8 = findViewById(R.id.textView661);
        tx9 = findViewById(R.id.textView662);
        btn = findViewById(R.id.btn_q6_send);

        TX1 = findViewById(R.id.textView15);
        TX2 = findViewById(R.id.textView37);
        TX3 = findViewById(R.id.textView38);
        TX4 = findViewById(R.id.textView39);
        TX5 = findViewById(R.id.textView40);


        btn_n1 = findViewById(R.id.q6_n1);
        btn_back = findViewById(R.id.q6_back);
        btn_n2 = findViewById(R.id.q6_n2);
        btn_p2 = findViewById(R.id.q6_p2);
        btn_n3 = findViewById(R.id.q6_n3);
        btn_p3 = findViewById(R.id.q6_p3);
        btn_n4 = findViewById(R.id.q6_n4);
        btn_p4 = findViewById(R.id.q6_p4);
        btn_p5 = findViewById(R.id.q6_p5);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(G.HOST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

        tx1.setVisibility(View.INVISIBLE);
        tx2.setVisibility(View.INVISIBLE);
        tx3.setVisibility(View.INVISIBLE);
        tx4.setVisibility(View.INVISIBLE);
        tx5.setVisibility(View.INVISIBLE);
        tx6.setVisibility(View.INVISIBLE);
        tx7.setVisibility(View.INVISIBLE);
        tx8.setVisibility(View.INVISIBLE);
        tx9.setVisibility(View.INVISIBLE);

        ln2.setVisibility(View.INVISIBLE);
        ln3.setVisibility(View.INVISIBLE);
        ln4.setVisibility(View.INVISIBLE);
        ln5.setVisibility(View.INVISIBLE);

        btn_n2.setVisibility(View.INVISIBLE);
        btn_n3.setVisibility(View.INVISIBLE);
        btn_n4.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
        btn_p2.setVisibility(View.INVISIBLE);
        btn_p3.setVisibility(View.INVISIBLE);
        btn_p4.setVisibility(View.INVISIBLE);
        btn_p5.setVisibility(View.INVISIBLE);

        TX2.setVisibility(View.INVISIBLE);
        TX3.setVisibility(View.INVISIBLE);
        TX4.setVisibility(View.INVISIBLE);
        TX5.setVisibility(View.INVISIBLE);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Questionnaire6Activity.this, DashboardActivity.class);
                startActivity(intent);
                Questionnaire6Activity.this.finish();
            }
        });

        btn_n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX1.setVisibility(View.INVISIBLE);
                ln1.setVisibility(View.INVISIBLE);
                btn_back.setVisibility(View.INVISIBLE);
                btn_n1.setVisibility(View.INVISIBLE);

                TX2.setVisibility(View.VISIBLE);
                ln2.setVisibility(View.VISIBLE);
                btn_p2.setVisibility(View.VISIBLE);
                btn_n2.setVisibility(View.VISIBLE);
            }
        });
        btn_n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX2.setVisibility(View.INVISIBLE);
                ln2.setVisibility(View.INVISIBLE);
                btn_p2.setVisibility(View.INVISIBLE);
                btn_n2.setVisibility(View.INVISIBLE);

                TX3.setVisibility(View.VISIBLE);
                ln3.setVisibility(View.VISIBLE);
                btn_p3.setVisibility(View.VISIBLE);
                btn_n3.setVisibility(View.VISIBLE);
            }
        });
        btn_n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX3.setVisibility(View.INVISIBLE);
                ln3.setVisibility(View.INVISIBLE);
                btn_p3.setVisibility(View.INVISIBLE);
                btn_n3.setVisibility(View.INVISIBLE);

                TX4.setVisibility(View.VISIBLE);
                ln4.setVisibility(View.VISIBLE);
                btn_p4.setVisibility(View.VISIBLE);
                btn_n4.setVisibility(View.VISIBLE);
            }
        });
        btn_n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX4.setVisibility(View.INVISIBLE);
                ln4.setVisibility(View.INVISIBLE);
                btn_p4.setVisibility(View.INVISIBLE);
                btn_n4.setVisibility(View.INVISIBLE);

                TX5.setVisibility(View.VISIBLE);
                ln5.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
                btn_p5.setVisibility(View.VISIBLE);
            }
        });
        btn_p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX5.setVisibility(View.INVISIBLE);
                ln5.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.INVISIBLE);
                btn_p5.setVisibility(View.INVISIBLE);

                TX4.setVisibility(View.VISIBLE);
                ln4.setVisibility(View.VISIBLE);
                btn_n4.setVisibility(View.VISIBLE);
                btn_p4.setVisibility(View.VISIBLE);
            }
        });
        btn_p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX4.setVisibility(View.INVISIBLE);
                ln4.setVisibility(View.INVISIBLE);
                btn_n4.setVisibility(View.INVISIBLE);
                btn_p4.setVisibility(View.INVISIBLE);

                TX3.setVisibility(View.VISIBLE);
                ln3.setVisibility(View.VISIBLE);
                btn_n3.setVisibility(View.VISIBLE);
                btn_p3.setVisibility(View.VISIBLE);
            }
        });
        btn_p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX3.setVisibility(View.INVISIBLE);
                ln3.setVisibility(View.INVISIBLE);
                btn_n3.setVisibility(View.INVISIBLE);
                btn_p3.setVisibility(View.INVISIBLE);

                TX2.setVisibility(View.VISIBLE);
                ln2.setVisibility(View.VISIBLE);
                btn_n2.setVisibility(View.VISIBLE);
                btn_p2.setVisibility(View.VISIBLE);
            }
        });
        btn_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX2.setVisibility(View.INVISIBLE);
                ln2.setVisibility(View.INVISIBLE);
                btn_n2.setVisibility(View.INVISIBLE);
                btn_p2.setVisibility(View.INVISIBLE);

                TX1.setVisibility(View.VISIBLE);
                ln1.setVisibility(View.VISIBLE);
                btn_n1.setVisibility(View.VISIBLE);
                btn_back.setVisibility(View.VISIBLE);
            }
        });

        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton293:
                        radioButton_string5 = "10";
                        break;
                    case R.id.radioButton294:
                        radioButton_string5 = "9";
                        break;
                    case R.id.radioButton295:
                        radioButton_string5 = "8";
                        break;
                    case R.id.radioButton296:
                        radioButton_string5 = "7";
                        break;
                    case R.id.radioButton297:
                        radioButton_string5 = "6";
                        break;
                    case R.id.radioButton298:
                        radioButton_string5 = "5";
                        break;
                    case R.id.radioButton299:
                        radioButton_string5 = "4";
                        break;
                    case R.id.radioButton300:
                        radioButton_string5 = "3";
                        break;
                    case R.id.radioButton301:
                        radioButton_string5 = "2";
                        break;
                    case R.id.radioButton302:
                        radioButton_string5 = "1";
                        break;
                }
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton283:
                        radioButton_string4 = "10";
                        break;
                    case R.id.radioButton284:
                        radioButton_string4 = "9";
                        break;
                    case R.id.radioButton285:
                        radioButton_string4 = "8";
                        break;
                    case R.id.radioButton286:
                        radioButton_string4 = "7";
                        break;
                    case R.id.radioButton287:
                        radioButton_string4 = "6";
                        break;
                    case R.id.radioButton288:
                        radioButton_string4 = "5";
                        break;
                    case R.id.radioButton289:
                        radioButton_string4 = "4";
                        break;
                    case R.id.radioButton290:
                        radioButton_string4 = "3";
                        break;
                    case R.id.radioButton291:
                        radioButton_string4 = "2";
                        break;
                    case R.id.radioButton292:
                        radioButton_string4 = "1";
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton273:
                        radioButton_string3 = "10";
                        break;
                    case R.id.radioButton274:
                        radioButton_string3 = "9";
                        break;
                    case R.id.radioButton275:
                        radioButton_string3 = "8";
                        break;
                    case R.id.radioButton276:
                        radioButton_string3 = "7";
                        break;
                    case R.id.radioButton277:
                        radioButton_string3 = "6";
                        break;
                    case R.id.radioButton278:
                        radioButton_string3 = "5";
                        break;
                    case R.id.radioButton279:
                        radioButton_string3 = "4";
                        break;
                    case R.id.radioButton280:
                        radioButton_string3 = "3";
                        break;
                    case R.id.radioButton281:
                        radioButton_string3 = "2";
                        break;
                    case R.id.radioButton282:
                        radioButton_string3 = "1";
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton263:
                        radioButton_string2 = "10";
                        break;
                    case R.id.radioButton264:
                        radioButton_string2 = "9";
                        break;
                    case R.id.radioButton265:
                        radioButton_string2 = "8";
                        break;
                    case R.id.radioButton266:
                        radioButton_string2 = "7";
                        break;
                    case R.id.radioButton267:
                        radioButton_string2 = "6";
                        break;
                    case R.id.radioButton268:
                        radioButton_string2 = "5";
                        break;
                    case R.id.radioButton269:
                        radioButton_string2 = "4";
                        break;
                    case R.id.radioButton270:
                        radioButton_string2 = "3";
                        break;
                    case R.id.radioButton271:
                        radioButton_string2 = "2";
                        break;
                    case R.id.radioButton272:
                        radioButton_string2 = "1";
                        break;
                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton66:
                        radioButton_string = "10";
                        break;
                    case R.id.radioButton254:
                        radioButton_string = "9";
                        break;
                    case R.id.radioButton255:
                        radioButton_string = "8";
                        break;
                    case R.id.radioButton256:
                        radioButton_string = "7";
                        break;
                    case R.id.radioButton257:
                        radioButton_string = "6";
                        break;
                    case R.id.radioButton258:
                        radioButton_string = "5";
                        break;
                    case R.id.radioButton259:
                        radioButton_string = "4";
                        break;
                    case R.id.radioButton260:
                        radioButton_string = "3";
                        break;
                    case R.id.radioButton261:
                        radioButton_string = "2";
                        break;
                    case R.id.radioButton262:
                        radioButton_string = "1";
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioButton_string == null || radioButton_string5 == null || radioButton_string4 == null || radioButton_string3 == null || radioButton_string2 == null) {
                    Toast.makeText(Questionnaire6Activity.this, "Invalid input!!!!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    in1 = Integer.parseInt(radioButton_string2);
                    in2 = Integer.parseInt(radioButton_string3);
                    in3 = Integer.parseInt(radioButton_string4);
                    in4 = Integer.parseInt(radioButton_string5);
                    in5 = Integer.parseInt(radioButton_string);
                    Integer sum = in1 + in2 + in3 + in4 + in5;
                    if (sum >= 0 && sum <= 20) {
                        tx1.setVisibility(View.VISIBLE);
                        tx2.setVisibility(View.VISIBLE);
                        tx3.setVisibility(View.VISIBLE);
                    } else if (sum >= 21 && sum <= 40) {
                        tx4.setVisibility(View.VISIBLE);
                        tx5.setVisibility(View.VISIBLE);
                        tx6.setVisibility(View.VISIBLE);
                    } else if (sum >= 41) {
                        tx7.setVisibility(View.VISIBLE);
                        tx8.setVisibility(View.VISIBLE);
                        tx9.setVisibility(View.VISIBLE);
                    }


                    questionnaireSix(radioButton_string,
                            radioButton_string5,
                            radioButton_string4,
                            radioButton_string3,
                            radioButton_string2,
                            sum,
                            json_user_id);
                }
            }
        });
    }

    private void questionnaireSix(String radioButton_string, String radioButton_string5, String radioButton_string4, String radioButton_string3, String radioButton_string2, Integer sum, String json_user_id) {
        if (radioButton_string == null || radioButton_string5 == null || radioButton_string4 == null || radioButton_string3 == null || radioButton_string2 == null || sum == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Questionnaire6Request request = new Questionnaire6Request(radioButton_string, radioButton_string2, radioButton_string3, radioButton_string4, radioButton_string5, sum, json_user_id);
        api.questionnaireSix(request).enqueue(new Callback<Questionnaire6Response>() {
            @Override
            public void onResponse(Call<Questionnaire6Response> call, Response<Questionnaire6Response> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    Toast.makeText(Questionnaire6Activity.this, "Send complete", Toast.LENGTH_LONG).show();
                } else {
                    //error
                    Toast.makeText(Questionnaire6Activity.this, "Send failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Questionnaire6Response> call, Throwable t) {
                Toast.makeText(Questionnaire6Activity.this, "Send failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
