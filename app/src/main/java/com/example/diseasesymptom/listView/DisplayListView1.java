package com.example.diseasesymptom.listView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.adapter.SymptomAdapter;
import com.example.diseasesymptom.model.Symptoms;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView1 extends AppCompatActivity {

    JSONObject jsonObject;
    JSONArray jsonArray;
    SymptomAdapter symptomAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view1);

        //Receive Json
        String json_string = getIntent().getExtras().getString("Json_data");
        listView = findViewById(R.id.listview_symptom);
        symptomAdapter = new SymptomAdapter(this, R.layout.activity_row_layout1);
        listView.setAdapter(symptomAdapter);
        try {
            // Transform json to json object
            jsonObject = new JSONObject(json_string);
            // Create array with name disease
            jsonArray = jsonObject.getJSONArray("disease");
            int count = 0;
            String id, name, factid, fact;
            while (count < jsonArray.length()) {
                // Put id , name and a2z into array
                JSONObject JO = jsonArray.getJSONObject(count);
                id = JO.getString("id");
                name = JO.getString("name");
                factid = JO.getString("factid");
                fact = JO.getString("fact");
                Symptoms symptoms = new Symptoms(id, factid, name, fact);
                symptomAdapter.add(symptoms);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
