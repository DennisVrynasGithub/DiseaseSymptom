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
import com.example.diseasesymptom.activities.ResultAdminActivity;
import com.example.diseasesymptom.activities.ResultAdminQ1Activity;
import com.example.diseasesymptom.activities.ResultAdminQ3Activity;
import com.example.diseasesymptom.activities.ResultAdminQ4Activity;
import com.example.diseasesymptom.activities.ResultAdminQ5Activity;
import com.example.diseasesymptom.activities.ResultAdminQ6Activity;
import com.example.diseasesymptom.model.Admin_user_list_result;

import java.util.ArrayList;
import java.util.List;

public class AdminUserList extends ArrayAdapter {

    private List list = new ArrayList();
    private Context c;

    public AdminUserList(Context context, int resource) {
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
        final AdminUserList.PlayerHolder playerHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_row_admin_user_list, parent, false);
            playerHolder = new AdminUserList.PlayerHolder();
            playerHolder.column1 = row.findViewById(R.id.tx_id);
            playerHolder.column2 = row.findViewById(R.id.tx_name);
            playerHolder.questionnaireResultOne = row.findViewById(R.id.btn_admin_user);
            playerHolder.questResultTwo = row.findViewById(R.id.btn_admin_q1);
            playerHolder.questResultThree = row.findViewById(R.id.btn_admin_q3);
            playerHolder.questResultFour = row.findViewById(R.id.btn_admin_q4);
            playerHolder.questResultFive = row.findViewById(R.id.btn_admin_q5);
            playerHolder.questResultSix = row.findViewById(R.id.btn_admin_q6);
            row.setTag(playerHolder);
        } else {
            playerHolder = (AdminUserList.PlayerHolder) row.getTag();
        }
        final Admin_user_list_result symptoms = (Admin_user_list_result) this.getItem(position);
        assert symptoms != null;
        playerHolder.column1.setText((symptoms.getId()));
        playerHolder.column2.setText((symptoms.getName()));
        playerHolder.questionnaireResultOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminActivity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);
            }
        });
        playerHolder.questResultTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ1Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);
            }
        });
        playerHolder.questResultThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ3Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);
            }
        });
        playerHolder.questResultFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ4Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);
            }
        });
        playerHolder.questResultFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ5Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);
            }
        });
        playerHolder.questResultSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c.getApplicationContext(), ResultAdminQ6Activity.class);
                intent.putExtra("Json_data", playerHolder.column1.getText().toString());
                c.startActivity(intent);
            }
        });
        return row;
    }

    private static class PlayerHolder {
        TextView column1, column2;
        Button questionnaireResultOne, questResultTwo, questResultThree, questResultFour, questResultFive, questResultSix;
    }
}