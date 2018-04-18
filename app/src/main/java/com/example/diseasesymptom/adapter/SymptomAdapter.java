package com.example.diseasesymptom.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.diseasesymptom.R;
import com.example.diseasesymptom.activities.ResultActivity;
import com.example.diseasesymptom.model.Symptoms;

import java.util.ArrayList;
import java.util.List;

///**
// * Created by Dennis on 9/1/2018.
// */

public class SymptomAdapter extends ArrayAdapter {

    private List list = new ArrayList();
    private Context c;

    public SymptomAdapter(Context context, int resource) {
        super(context, resource);
        this.c = context;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        final PlayerHolder playerHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_row_layout1, parent, false);
            playerHolder = new PlayerHolder();
            playerHolder.column1 = row.findViewById(R.id.symptom_id);
            playerHolder.column2 = row.findViewById(R.id.symptom_a2z);
            playerHolder.column3 = row.findViewById(R.id.symptom_name);
            playerHolder.column4 = row.findViewById(R.id.symptom_fact);
            playerHolder.btnFurtherDetails = row.findViewById(R.id.btnDetails);
            row.setTag(playerHolder);
        } else {
            playerHolder = (PlayerHolder) row.getTag();
        }
        final Symptoms symptoms = (Symptoms) this.getItem(position);
        assert symptoms != null;
        playerHolder.column1.setText((symptoms.getId()));
        playerHolder.column2.setText((symptoms.getA2z()));
        playerHolder.column3.setText((symptoms.getName()));
        playerHolder.column4.setText((symptoms.getFact()));
        playerHolder.btnFurtherDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultActivity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);
            }
        });
        return row;
    }

    private static class PlayerHolder {
        TextView column1, column2, column3, column4;
        Button btnFurtherDetails;
    }

}
