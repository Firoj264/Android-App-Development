package com.example.collegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    RecyclerView nobinboronimages,others;
    DatabaseReference reference;
    GalleryAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        nobinboronimages = view.findViewById(R.id.nobinboronRecycler);
        others = view.findViewById(R.id.othersRecycler);


        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getNobinboronImages();
        getOtherImage();
        return view;

    }

    private void getNobinboronImages() {
        reference.child("Nobin boron").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String data= (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter=new GalleryAdapter(getContext(),imageList);
                nobinboronimages.setLayoutManager(new GridLayoutManager(getContext(),3));
                nobinboronimages.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void getOtherImage() {
        reference.child("Others Event").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String data= (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter=new GalleryAdapter(getContext(),imageList);
                others.setLayoutManager(new GridLayoutManager(getContext(),3));
                others.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}