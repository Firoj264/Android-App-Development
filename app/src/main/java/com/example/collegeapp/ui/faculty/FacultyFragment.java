package com.example.collegeapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private RecyclerView cse_department,eee_department,bba_department,tex_department;
    private LinearLayout csNoData,eeNoData,texNoaDta,bbaNoData;
    private List<TeacherClass> list1,list2,list3,list4;
    private DatabaseReference reference,dbref;
    private TeacherAdapter adapter;
    private ProgressBar progressbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_faculty, container, false);

        cse_department=view.findViewById(R.id.cse_department);
        eee_department=view.findViewById(R.id.eee_department);
        bba_department=view.findViewById(R.id.bba_department);
        tex_department=view.findViewById(R.id.tex_department);

        csNoData=view.findViewById(R.id.csNoData);
        eeNoData=view.findViewById(R.id.eeNoData);
        texNoaDta=view.findViewById(R.id.texNoData);
        bbaNoData=view.findViewById(R.id.bbaNoData);

        progressbar=view.findViewById(R.id.progressbar);

        reference= FirebaseDatabase.getInstance().getReference().child("Teacher");


        csDepartment();
        eeDepartment();
        bbaDepartment();
        texDepartment();



       return view;
    }

    private void csDepartment() {
        dbref=reference.child("Computer Science");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1=new ArrayList<>();

                if (!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    cse_department.setVisibility(View.GONE);
                }else {
                    csNoData.setVisibility(View.GONE);
                    cse_department.setVisibility(View.VISIBLE);
                    for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                        TeacherClass data = datasnapshot.getValue(TeacherClass.class);
                        list1.add(data);
                    }
                    adapter = new TeacherAdapter(list1, getContext());
                    adapter.notifyDataSetChanged();


                    cse_department.setLayoutManager(new LinearLayoutManager(getContext()));
                    cse_department.setHasFixedSize(true);
                    progressbar.setVisibility(View.GONE);
                    cse_department.setAdapter(adapter);
                }


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void eeDepartment() {
        dbref=reference.child("EEE");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2=new ArrayList<>();

                if (!snapshot.exists()){
                    eeNoData.setVisibility(View.VISIBLE);
                    eee_department.setVisibility(View.GONE);
                }else {
                    eeNoData.setVisibility(View.GONE);
                    eee_department.setVisibility(View.VISIBLE);
                    for (DataSnapshot datasnapshot1:snapshot.getChildren()){
                        TeacherClass data=datasnapshot1.getValue(TeacherClass.class);
                        list2.add(data);
                    }
                    eee_department.setHasFixedSize(true);
                    eee_department.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list2,getContext());
                    progressbar.setVisibility(View.GONE);
                    eee_department.setAdapter(adapter);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void texDepartment() {
        dbref=reference.child("TEXTILE");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3=new ArrayList<>();

                if (!snapshot.exists()){
                    texNoaDta.setVisibility(View.VISIBLE);
                    tex_department.setVisibility(View.GONE);
                }else {
                    texNoaDta.setVisibility(View.GONE);
                    tex_department.setVisibility(View.VISIBLE);
                    for (DataSnapshot datasnapshot1:snapshot.getChildren()){
                        TeacherClass data=datasnapshot1.getValue(TeacherClass.class);
                        list3.add(data);
                    }
                    tex_department.setHasFixedSize(true);
                    tex_department.setLayoutManager(new LinearLayoutManager(getContext()));
                    progressbar.setVisibility(View.GONE);
                    adapter=new TeacherAdapter(list3,getContext());
                    tex_department.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void bbaDepartment() {
        dbref=reference.child("BBA");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4=new ArrayList<>();

                if (!snapshot.exists()){
                    bbaNoData.setVisibility(View.VISIBLE);
                    bba_department.setVisibility(View.GONE);
                }else {
                    bbaNoData.setVisibility(View.GONE);
                    bba_department.setVisibility(View.VISIBLE);
                    for (DataSnapshot datasnapshot1:snapshot.getChildren()){
                        TeacherClass data=datasnapshot1.getValue(TeacherClass.class);
                        list4.add(data);
                    }
                    bba_department.setHasFixedSize(true);
                    bba_department.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list4,getContext());
                    progressbar.setVisibility(View.GONE);
                    bba_department.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}