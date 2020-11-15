package com.example.collegeapp.ui.notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NoticeFragment extends Fragment {
    private ProgressBar progressbar;
    private RecyclerView deleteNoticerecyclerView;
    private NoticeAdapter adapter;
    private ArrayList<Notice_Data> list;
    private DatabaseReference reference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        deleteNoticerecyclerView=(RecyclerView) view.findViewById(R.id.deleteNoticerecyclerView);
        progressbar=view.findViewById(R.id.progressbar);

        reference= FirebaseDatabase.getInstance().getReference().child("Notice");

        deleteNoticerecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        deleteNoticerecyclerView.setHasFixedSize(true);



        getNotice();
        return view;

    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for (DataSnapshot snapshot1: snapshot.getChildren()) {

                    Notice_Data data = snapshot1.getValue(Notice_Data.class);
                    list.add(data);
                }
                    adapter=new NoticeAdapter(getContext(),list);
                    adapter.notifyDataSetChanged();
                    progressbar.setVisibility(View.GONE);
                deleteNoticerecyclerView.setAdapter(adapter);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressbar.setVisibility(View.GONE);

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
