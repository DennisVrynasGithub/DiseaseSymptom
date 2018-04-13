package com.example.diseasesymptom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.model.Questionnaire2Request;
import com.example.diseasesymptom.model.Questionnaire2Response;
import com.example.diseasesymptom.service.Api;
import com.example.diseasesymptom.utils.G;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Questionnaire2Activity extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4;
    Button btn, btn_n1, btn_p2, btn_n2, btn_p3, btn_n3, btn_p4, btn_p5, btn_n4, btn_back;
    EditText et4, et;
    String json_user_id, json_user_password, json_user_email, radioButton_string, radioButton_string2, radioButton_string3, radioButton_string4;
    TextView tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, TX1, TX2, TX3, TX4;
    Integer in1, in2, in3, in4, sum;
    LinearLayout ln1, ln2, ln3, ln4;

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire2);

        json_user_id = getIntent().getExtras().getString("json_user_id");
        json_user_email = getIntent().getExtras().getString("json_user_email");
        json_user_password = getIntent().getExtras().getString("json_user_password");

        radioGroup1 = findViewById(R.id.radiogroup21);
        radioGroup2 = findViewById(R.id.radiogroup22);
        radioGroup3 = findViewById(R.id.radiogroup23);
        radioGroup4 = findViewById(R.id.radiogroup24);

        ln1 = findViewById(R.id.linearLayout4);
        ln2 = findViewById(R.id.linearLayout5);
        ln3 = findViewById(R.id.linearLayout6);
        ln4 = findViewById(R.id.linearLayout26);

        tx1 = findViewById(R.id.textView54);
        tx2 = findViewById(R.id.textView55);
        tx3 = findViewById(R.id.textView56);
        tx4 = findViewById(R.id.textView57);
        tx5 = findViewById(R.id.textView58);
        tx6 = findViewById(R.id.textView59);
        tx7 = findViewById(R.id.textView60);
        tx8 = findViewById(R.id.textView61);
        tx9 = findViewById(R.id.textView62);
        et4 = findViewById(R.id.editText);
//        et = findViewById(R.id.editText7);
        btn = findViewById(R.id.btn_q2_send);

        TX1 = findViewById(R.id.textView11);
        TX2 = findViewById(R.id.textView20);
        TX3 = findViewById(R.id.textView21);
        TX4 = findViewById(R.id.textView22);

        btn_n1 = findViewById(R.id.q2_n1);
        btn_back = findViewById(R.id.q2_back);
        btn_n2 = findViewById(R.id.q2_n2);
        btn_p2 = findViewById(R.id.q2_p2);
        btn_n3 = findViewById(R.id.q2_n3);
        btn_p3 = findViewById(R.id.q2_p3);
        btn_n4 = findViewById(R.id.q2_n4);
        btn_p4 = findViewById(R.id.q2_p4);
        btn_p5 = findViewById(R.id.q2_p5);

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

//        et.setVisibility(View.INVISIBLE);

        ln2.setVisibility(View.INVISIBLE);
        ln1.setVisibility(View.INVISIBLE);
        ln3.setVisibility(View.INVISIBLE);
        ln4.setVisibility(View.INVISIBLE);

        btn_n2.setVisibility(View.INVISIBLE);
        btn_n3.setVisibility(View.INVISIBLE);
        btn_n4.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.INVISIBLE);
        btn_p2.setVisibility(View.INVISIBLE);
        btn_p3.setVisibility(View.INVISIBLE);
        btn_p4.setVisibility(View.INVISIBLE);
        btn_p5.setVisibility(View.INVISIBLE);

        TX1.setVisibility(View.INVISIBLE);
        TX2.setVisibility(View.INVISIBLE);
        TX3.setVisibility(View.INVISIBLE);
        TX4.setVisibility(View.INVISIBLE);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Questionnaire2Activity.this, DashboardActivity.class);
                startActivity(intent);
                Questionnaire2Activity.this.finish();
            }
        });

        btn_n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et4.setVisibility(View.INVISIBLE);
                btn_back.setVisibility(View.INVISIBLE);
                btn_n1.setVisibility(View.INVISIBLE);

                TX1.setVisibility(View.VISIBLE);
                ln1.setVisibility(View.VISIBLE);
                btn_p2.setVisibility(View.VISIBLE);
                btn_n2.setVisibility(View.VISIBLE);
            }
        });
        btn_n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX1.setVisibility(View.INVISIBLE);
                ln1.setVisibility(View.INVISIBLE);
                btn_p2.setVisibility(View.INVISIBLE);
                btn_n2.setVisibility(View.INVISIBLE);

                TX2.setVisibility(View.VISIBLE);
                ln2.setVisibility(View.VISIBLE);
                btn_p3.setVisibility(View.VISIBLE);
                btn_n3.setVisibility(View.VISIBLE);
            }
        });
        btn_n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX2.setVisibility(View.INVISIBLE);
                ln2.setVisibility(View.INVISIBLE);
                btn_p3.setVisibility(View.INVISIBLE);
                btn_n3.setVisibility(View.INVISIBLE);

                TX3.setVisibility(View.VISIBLE);
                ln3.setVisibility(View.VISIBLE);
                btn_p4.setVisibility(View.VISIBLE);
                btn_n4.setVisibility(View.VISIBLE);
            }
        });
        btn_n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX3.setVisibility(View.INVISIBLE);
                ln3.setVisibility(View.INVISIBLE);
                btn_p4.setVisibility(View.INVISIBLE);
                btn_n4.setVisibility(View.INVISIBLE);

                TX4.setVisibility(View.VISIBLE);
                ln4.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
                btn_p5.setVisibility(View.VISIBLE);
            }
        });
        btn_p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX4.setVisibility(View.INVISIBLE);
                ln4.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.INVISIBLE);
                btn_p5.setVisibility(View.INVISIBLE);

                TX3.setVisibility(View.VISIBLE);
                ln3.setVisibility(View.VISIBLE);
                btn_p4.setVisibility(View.VISIBLE);
                btn_n4.setVisibility(View.VISIBLE);
            }
        });
        btn_p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX3.setVisibility(View.INVISIBLE);
                ln3.setVisibility(View.INVISIBLE);
                btn_n4.setVisibility(View.INVISIBLE);
                btn_p4.setVisibility(View.INVISIBLE);

                TX2.setVisibility(View.VISIBLE);
                ln2.setVisibility(View.VISIBLE);
                btn_n3.setVisibility(View.VISIBLE);
                btn_p3.setVisibility(View.VISIBLE);
            }
        });
        btn_p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX2.setVisibility(View.INVISIBLE);
                ln2.setVisibility(View.INVISIBLE);
                btn_n3.setVisibility(View.INVISIBLE);
                btn_p3.setVisibility(View.INVISIBLE);

                TX1.setVisibility(View.VISIBLE);
                ln1.setVisibility(View.VISIBLE);
                btn_n2.setVisibility(View.VISIBLE);
                btn_p2.setVisibility(View.VISIBLE);
            }
        });
        btn_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TX1.setVisibility(View.INVISIBLE);
                ln1.setVisibility(View.INVISIBLE);
                btn_n2.setVisibility(View.INVISIBLE);
                btn_p2.setVisibility(View.INVISIBLE);

                et4.setVisibility(View.VISIBLE);
                btn_n1.setVisibility(View.VISIBLE);
                btn_back.setVisibility(View.VISIBLE);
            }
        });

        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton97:
                        radioButton_string4 = "10";
                        break;
                    case R.id.radioButton98:
                        radioButton_string4 = "9";
                        break;
                    case R.id.radioButton99:
                        radioButton_string4 = "8";
                        break;
                    case R.id.radioButton100:
                        radioButton_string4 = "7";
                        break;
                    case R.id.radioButton101:
                        radioButton_string4 = "6";
                        break;
                    case R.id.radioButton102:
                        radioButton_string4 = "5";
                        break;
                    case R.id.radioButton103:
                        radioButton_string4 = "4";
                        break;
                    case R.id.radioButton104:
                        radioButton_string4 = "3";
                        break;
                    case R.id.radioButton105:
                        radioButton_string4 = "2";
                        break;
                    case R.id.radioButton106:
                        radioButton_string4 = "1";
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton87:
                        radioButton_string3 = "10";
                        break;
                    case R.id.radioButton88:
                        radioButton_string3 = "9";
                        break;
                    case R.id.radioButton89:
                        radioButton_string3 = "8";
                        break;
                    case R.id.radioButton90:
                        radioButton_string3 = "7";
                        break;
                    case R.id.radioButton91:
                        radioButton_string3 = "6";
                        break;
                    case R.id.radioButton92:
                        radioButton_string3 = "5";
                        break;
                    case R.id.radioButton93:
                        radioButton_string3 = "4";
                        break;
                    case R.id.radioButton94:
                        radioButton_string3 = "3";
                        break;
                    case R.id.radioButton95:
                        radioButton_string3 = "2";
                        break;
                    case R.id.radioButton96:
                        radioButton_string3 = "1";
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton77:
                        radioButton_string2 = "10";
                        break;
                    case R.id.radioButton78:
                        radioButton_string2 = "9";
                        break;
                    case R.id.radioButton79:
                        radioButton_string2 = "8";
                        break;
                    case R.id.radioButton80:
                        radioButton_string2 = "7";
                        break;
                    case R.id.radioButton81:
                        radioButton_string2 = "6";
                        break;
                    case R.id.radioButton82:
                        radioButton_string2 = "5";
                        break;
                    case R.id.radioButton83:
                        radioButton_string2 = "4";
                        break;
                    case R.id.radioButton84:
                        radioButton_string2 = "3";
                        break;
                    case R.id.radioButton85:
                        radioButton_string2 = "2";
                        break;
                    case R.id.radioButton86:
                        radioButton_string2 = "1";
                        break;
                }
            }
        });

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton22:
                        radioButton_string = "10";
                        break;
                    case R.id.radioButton68:
                        radioButton_string = "9";
                        break;
                    case R.id.radioButton69:
                        radioButton_string = "8";
                        break;
                    case R.id.radioButton70:
                        radioButton_string = "7";
                        break;
                    case R.id.radioButton71:
                        radioButton_string = "6";
                        break;
                    case R.id.radioButton72:
                        radioButton_string = "5";
                        break;
                    case R.id.radioButton73:
                        radioButton_string = "4";
                        break;
                    case R.id.radioButton74:
                        radioButton_string = "3";
                        break;
                    case R.id.radioButton75:
                        radioButton_string = "2";
                        break;
                    case R.id.radioButton76:
                        radioButton_string = "1";
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (radioButton_string == null || radioButton_string4 == null || radioButton_string3 == null || radioButton_string2 == null) {
                    Toast.makeText(Questionnaire2Activity.this, "Invalid input!!!!", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    in1 = Integer.parseInt(radioButton_string2);
                    in2 = Integer.parseInt(radioButton_string3);
                    in3 = Integer.parseInt(radioButton_string4);
                    in4 = Integer.parseInt(radioButton_string);
                    sum = in1 + in2 + in3 + in4;
                    if (sum >= 0 && sum <= 15) {
                        tx1.setVisibility(View.VISIBLE);
                        tx2.setVisibility(View.VISIBLE);
                        tx3.setVisibility(View.VISIBLE);
                    } else if (sum >= 16 && sum <= 30) {
                        tx4.setVisibility(View.VISIBLE);
                        tx5.setVisibility(View.VISIBLE);
                        tx6.setVisibility(View.VISIBLE);
                    } else if (sum >= 31) {
                        tx7.setVisibility(View.VISIBLE);
                        tx8.setVisibility(View.VISIBLE);
                        tx9.setVisibility(View.VISIBLE);
                    }

                    questionnaireTwo(et4.getText().toString(),
                            radioButton_string,
                            radioButton_string4,
                            radioButton_string3,
                            radioButton_string2,
                            sum,
                            json_user_id);
                }
            }
        });
    }

    private void questionnaireTwo(String editText,
                                  String radioButton_string,
                                  String radioButton_string4,
                                  String radioButton_string3,
                                  String radioButton_string2,
                                  Integer sum,
                                  String json_user_id) {

        if (radioButton_string == null || editText == null || radioButton_string4 == null || radioButton_string3 == null || radioButton_string2 == null || sum == null) {
            Toast.makeText(this, "Invalid input!", Toast.LENGTH_LONG).show();
            return;
        }

        Questionnaire2Request request = new Questionnaire2Request(editText, radioButton_string, radioButton_string2, radioButton_string3, radioButton_string4, sum, json_user_id);
        api.questionnaireTwo(request).enqueue(new Callback<Questionnaire2Response>() {
            @Override
            public void onResponse(Call<Questionnaire2Response> call, Response<Questionnaire2Response> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    Toast.makeText(Questionnaire2Activity.this, "Send complete", Toast.LENGTH_LONG).show();
                } else {
                    //error
                    Toast.makeText(Questionnaire2Activity.this, "Send failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Questionnaire2Response> call, Throwable t) {
                Toast.makeText(Questionnaire2Activity.this, "Send failed!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
