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
import com.example.diseasesymptom.model.Questionnaire4Request;
import com.example.diseasesymptom.model.Questionnaire4Response;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Questionnaire4Activity extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6;
    Button btn, btn_n1, btn_p2, btn_n2, btn_p3, btn_n3, btn_p4, btn_p5, btn_n4, btn_p6, btn_n5, btn_dp, btn_dn, btn_back;
    String json_user_id, json_user_password, json_user_email, radioButton_string, radioButton_string2, radioButton_string3, radioButton_string4, radioButton_string5, radioButton_string6;
    TextView tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, TX1, TX2, TX3, TX4, TX5, TX6;
    Integer in1, in2, in3, in4, sum;
    LinearLayout ln1, ln2, ln3, ln4, ln5, ln6;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire4);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        radioGroup1 = findViewById(R.id.radiogroup41);
        radioGroup2 = findViewById(R.id.radiogroup42);
        radioGroup3 = findViewById(R.id.radiogroup43);
        radioGroup4 = findViewById(R.id.radiogroup44);
        radioGroup5 = findViewById(R.id.radiogroupr45);
        radioGroup6 = findViewById(R.id.radiogroup46);

        ln1 = findViewById(R.id.linearLayout12);
        ln2 = findViewById(R.id.linearLayout13);
        ln3 = findViewById(R.id.linearLayout14);
        ln4 = findViewById(R.id.linearLayout15);
        ln5 = findViewById(R.id.linearLayout16);
        ln6 = findViewById(R.id.linearLayout28);

        tx1 = findViewById(R.id.textView454);
        tx2 = findViewById(R.id.textView455);
        tx3 = findViewById(R.id.textView456);
        tx4 = findViewById(R.id.textView457);
        tx5 = findViewById(R.id.textView458);
        tx6 = findViewById(R.id.textView459);
        tx7 = findViewById(R.id.textView460);
        tx8 = findViewById(R.id.textView461);
        tx9 = findViewById(R.id.textView462);
        btn = findViewById(R.id.btn_q4_send);

        TX1 = findViewById(R.id.textView13);
        TX2 = findViewById(R.id.textView31);
        TX3 = findViewById(R.id.textView32);
        TX4 = findViewById(R.id.textView33);
        TX5 = findViewById(R.id.textView34);
        TX6 = findViewById(R.id.textView35);

        btn_n1 = findViewById(R.id.q4_n1);
        btn_back = findViewById(R.id.q4_back);
        btn_n2 = findViewById(R.id.q4_n2);
        btn_p2 = findViewById(R.id.q4_p2);
        btn_n3 = findViewById(R.id.q4_n3);
        btn_p3 = findViewById(R.id.q4_p3);
        btn_n5 = findViewById(R.id.q4_n5);
        btn_n4 = findViewById(R.id.q4_n4);
        btn_p4 = findViewById(R.id.q4_p4);
        btn_p5 = findViewById(R.id.q4_p5);
        btn_p6 = findViewById(R.id.q4_p6);

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
        ln6.setVisibility(View.INVISIBLE);

        btn_n2.setVisibility(View.INVISIBLE);
        btn_n3.setVisibility(View.INVISIBLE);
        btn_n4.setVisibility(View.INVISIBLE);
        btn_n5.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
        btn_p2.setVisibility(View.INVISIBLE);
        btn_p3.setVisibility(View.INVISIBLE);
        btn_p4.setVisibility(View.INVISIBLE);
        btn_p5.setVisibility(View.INVISIBLE);
        btn_p6.setVisibility(View.INVISIBLE);

        TX2.setVisibility(View.INVISIBLE);
        TX3.setVisibility(View.INVISIBLE);
        TX4.setVisibility(View.INVISIBLE);
        TX5.setVisibility(View.INVISIBLE);
        TX6.setVisibility(View.INVISIBLE);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Questionnaire4Activity.this, DashboardActivity.class);
                startActivity(intent);
                Questionnaire4Activity.this.finish();
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
                btn_n5.setVisibility(View.VISIBLE);
                btn_p5.setVisibility(View.VISIBLE);
            }
        });
        btn_n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX5.setVisibility(View.INVISIBLE);
                ln5.setVisibility(View.INVISIBLE);
                btn_p5.setVisibility(View.INVISIBLE);
                btn_n5.setVisibility(View.INVISIBLE);

                TX6.setVisibility(View.VISIBLE);
                ln6.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
                btn_p6.setVisibility(View.VISIBLE);
            }
        });
        btn_p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX6.setVisibility(View.INVISIBLE);
                ln6.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.INVISIBLE);
                btn_p6.setVisibility(View.INVISIBLE);

                TX5.setVisibility(View.VISIBLE);
                ln5.setVisibility(View.VISIBLE);
                btn_p5.setVisibility(View.VISIBLE);
                btn_n5.setVisibility(View.VISIBLE);
            }
        });
        btn_p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX5.setVisibility(View.INVISIBLE);
                ln5.setVisibility(View.INVISIBLE);
                btn_n5.setVisibility(View.INVISIBLE);
                btn_p5.setVisibility(View.INVISIBLE);

                TX4.setVisibility(View.VISIBLE);
                ln4.setVisibility(View.VISIBLE);
                btn_p4.setVisibility(View.VISIBLE);
                btn_n4.setVisibility(View.VISIBLE);
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


        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton196:
                        radioButton_string6 = "10";
                        break;
                    case R.id.radioButton197:
                        radioButton_string6 = "9";
                        break;
                    case R.id.radioButton198:
                        radioButton_string6 = "8";
                        break;
                    case R.id.radioButton199:
                        radioButton_string6 = "7";
                        break;
                    case R.id.radioButton200:
                        radioButton_string6 = "6";
                        break;
                    case R.id.radioButton201:
                        radioButton_string6 = "5";
                        break;
                    case R.id.radioButton202:
                        radioButton_string6 = "4";
                        break;
                    case R.id.radioButton203:
                        radioButton_string6 = "3";
                        break;
                    case R.id.radioButton204:
                        radioButton_string6 = "2";
                        break;
                    case R.id.radioButton205:
                        radioButton_string6 = "1";
                        break;
                }
            }
        });

        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton186:
                        radioButton_string5 = "10";
                        break;
                    case R.id.radioButton187:
                        radioButton_string5 = "9";
                        break;
                    case R.id.radioButton188:
                        radioButton_string5 = "8";
                        break;
                    case R.id.radioButton189:
                        radioButton_string5 = "7";
                        break;
                    case R.id.radioButton190:
                        radioButton_string5 = "6";
                        break;
                    case R.id.radioButton191:
                        radioButton_string5 = "5";
                        break;
                    case R.id.radioButton192:
                        radioButton_string5 = "4";
                        break;
                    case R.id.radioButton193:
                        radioButton_string5 = "3";
                        break;
                    case R.id.radioButton194:
                        radioButton_string5 = "2";
                        break;
                    case R.id.radioButton195:
                        radioButton_string5 = "1";
                        break;
                }
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton176:
                        radioButton_string4 = "10";
                        break;
                    case R.id.radioButton177:
                        radioButton_string4 = "9";
                        break;
                    case R.id.radioButton178:
                        radioButton_string4 = "8";
                        break;
                    case R.id.radioButton179:
                        radioButton_string4 = "7";
                        break;
                    case R.id.radioButton180:
                        radioButton_string4 = "6";
                        break;
                    case R.id.radioButton181:
                        radioButton_string4 = "5";
                        break;
                    case R.id.radioButton182:
                        radioButton_string4 = "4";
                        break;
                    case R.id.radioButton183:
                        radioButton_string4 = "3";
                        break;
                    case R.id.radioButton184:
                        radioButton_string4 = "2";
                        break;
                    case R.id.radioButton185:
                        radioButton_string4 = "1";
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton166:
                        radioButton_string3 = "10";
                        break;
                    case R.id.radioButton167:
                        radioButton_string3 = "9";
                        break;
                    case R.id.radioButton168:
                        radioButton_string3 = "8";
                        break;
                    case R.id.radioButton169:
                        radioButton_string3 = "7";
                        break;
                    case R.id.radioButton170:
                        radioButton_string3 = "6";
                        break;
                    case R.id.radioButton171:
                        radioButton_string3 = "5";
                        break;
                    case R.id.radioButton172:
                        radioButton_string3 = "4";
                        break;
                    case R.id.radioButton173:
                        radioButton_string3 = "3";
                        break;
                    case R.id.radioButton174:
                        radioButton_string3 = "2";
                        break;
                    case R.id.radioButton175:
                        radioButton_string3 = "1";
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton159:
                        radioButton_string2 = "70-80";
                        break;
                    case R.id.radioButton160:
                        radioButton_string2 = "60-70";
                        break;
                    case R.id.radioButton161:
                        radioButton_string2 = "50-60";
                        break;
                    case R.id.radioButton162:
                        radioButton_string2 = "40-50";
                        break;
                    case R.id.radioButton163:
                        radioButton_string2 = "30-40";
                        break;
                    case R.id.radioButton164:
                        radioButton_string2 = "20-30";
                        break;
                    case R.id.radioButton165:
                        radioButton_string2 = "10-20";
                        break;
                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton158:
                        radioButton_string = "Malignant hypertension";
                        break;
                    case R.id.radioButton157:
                        radioButton_string = "Moderate hypertension";
                        break;
                    case R.id.radioButton156:
                        radioButton_string = "Mild hypertension";
                        break;
                    case R.id.radioButton155:
                        radioButton_string = "Boundary increased";
                        break;
                    case R.id.radioButton154:
                        radioButton_string = "Ideal";
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioButton_string == null || radioButton_string6 == null || radioButton_string4 == null || radioButton_string3 == null || radioButton_string2 == null || radioButton_string5 == null) {
                    Toast.makeText(Questionnaire4Activity.this, "Invalid input!!!!", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    in1 = Integer.parseInt(radioButton_string6);
                    in2 = Integer.parseInt(radioButton_string5);
                    in3 = Integer.parseInt(radioButton_string3);
                    in4 = Integer.parseInt(radioButton_string4);
                    sum = in1 + in2 + in3 + in4;
                    if (sum >= 0 && sum <= 15) {
                        tx1.setVisibility(View.VISIBLE);
                        tx2.setVisibility(View.VISIBLE);
                        tx3.setVisibility(View.VISIBLE);
                        tx4.setVisibility(View.INVISIBLE);
                        tx5.setVisibility(View.INVISIBLE);
                        tx6.setVisibility(View.INVISIBLE);
                        tx7.setVisibility(View.INVISIBLE);
                        tx8.setVisibility(View.INVISIBLE);
                        tx9.setVisibility(View.INVISIBLE);
                    } else if (sum >= 16 && sum <= 30) {
                        tx1.setVisibility(View.INVISIBLE);
                        tx2.setVisibility(View.INVISIBLE);
                        tx3.setVisibility(View.INVISIBLE);
                        tx4.setVisibility(View.VISIBLE);
                        tx5.setVisibility(View.VISIBLE);
                        tx6.setVisibility(View.VISIBLE);
                        tx7.setVisibility(View.INVISIBLE);
                        tx8.setVisibility(View.INVISIBLE);
                        tx9.setVisibility(View.INVISIBLE);
                    } else if (sum >= 31) {
                        tx1.setVisibility(View.INVISIBLE);
                        tx2.setVisibility(View.INVISIBLE);
                        tx3.setVisibility(View.INVISIBLE);
                        tx4.setVisibility(View.INVISIBLE);
                        tx5.setVisibility(View.INVISIBLE);
                        tx6.setVisibility(View.INVISIBLE);
                        tx7.setVisibility(View.VISIBLE);
                        tx8.setVisibility(View.VISIBLE);
                        tx9.setVisibility(View.VISIBLE);
                    }


                    questionnaireFour(radioButton_string,
                            radioButton_string2,
                            radioButton_string3,
                            radioButton_string4,
                            radioButton_string5,
                            radioButton_string6,
                            sum,
                            json_user_id);
                }
            }
        });
    }

    private void questionnaireFour(String radioButton_string1, String radioButton_string2, String radioButton_string3, String radioButton_string4, String radioButton_string5, String radioButton_string6, Integer sum, String json_user_id) {
        if (radioButton_string == null || radioButton_string5 == null || radioButton_string4 == null || radioButton_string3 == null || radioButton_string2 == null || sum == null) {
            return;
        }

        Questionnaire4Request request = new Questionnaire4Request(radioButton_string1, radioButton_string2, radioButton_string3, radioButton_string4, radioButton_string5, radioButton_string6, sum, json_user_id);
        api.questionnaireFour(request).enqueue(new Callback<Questionnaire4Response>() {
            @Override
            public void onResponse(Call<Questionnaire4Response> call, Response<Questionnaire4Response> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    Toast.makeText(Questionnaire4Activity.this, "Send complete", Toast.LENGTH_LONG).show();
                } else {
                    //error
                    Toast.makeText(Questionnaire4Activity.this, "Send failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Questionnaire4Response> call, Throwable t) {
                Toast.makeText(Questionnaire4Activity.this, "Send failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
