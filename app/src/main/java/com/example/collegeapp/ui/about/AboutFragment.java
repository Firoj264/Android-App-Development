package com.example.collegeapp.ui.about;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.collegeapp.HistoryActivity;
import com.example.collegeapp.MainActivity;
import com.example.collegeapp.R;

public class AboutFragment extends Fragment implements View.OnClickListener {
    private CardView history1,missionvission1,goal1,trustee1,administration1,whystudyhere1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_about, container, false);


        history1=view.findViewById(R.id.history);
        missionvission1=view.findViewById(R.id.missionvission);
        goal1=view.findViewById(R.id.goal);
        trustee1=view.findViewById(R.id.trustee);
        administration1=view.findViewById(R.id.administration);
        whystudyhere1=view.findViewById(R.id.whystudyhere);

        history1.setOnClickListener(this);
        missionvission1.setOnClickListener(this);
        goal1.setOnClickListener(this);
        trustee1.setOnClickListener(this);
        administration1.setOnClickListener(this);
        whystudyhere1.setOnClickListener(this);


        return view;


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

            case R.id.goal:

            case R.id.trustee:

            case R.id.administration:

            case R.id.whystudyhere:


                break;

        }
    }

}