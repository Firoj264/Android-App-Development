package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Aboutnavigation extends AppCompatActivity implements View.OnClickListener {
    private CardView history1,missionvission1,goal1,trustee1,administration1,whystudyhere1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutnavigation);


        history1=findViewById(R.id.history);
        missionvission1=findViewById(R.id.missionvission);
        goal1=findViewById(R.id.goal);
        trustee1=findViewById(R.id.trustee);
        administration1=findViewById(R.id.administration);
        whystudyhere1=findViewById(R.id.whystudyhere);

        history1.setOnClickListener(this);
        missionvission1.setOnClickListener(this);
        goal1.setOnClickListener(this);
        trustee1.setOnClickListener(this);
        administration1.setOnClickListener(this);
        whystudyhere1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()){

            case R.id.history:
                intent=new Intent(v.getContext(), HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.missionvission:
                intent=new Intent(v.getContext(), vissionmission.class);
                startActivity(intent);
                break;

            case R.id.goal:
                intent=new Intent(v.getContext(), Goal.class);
                startActivity(intent);
                break;

            case R.id.trustee:
                intent=new Intent(v.getContext(), Trustee.class);
                startActivity(intent);
                break;

            case R.id.administration:
                intent=new Intent(v.getContext(), Administration.class);
                startActivity(intent);
                break;

            case R.id.whystudyhere:
                intent=new Intent(v.getContext(), Whystudyhere.class);
                startActivity(intent);
                break;


        }

    }
}