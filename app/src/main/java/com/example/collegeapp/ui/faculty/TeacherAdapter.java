package com.example.collegeapp.ui.faculty;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {
    private List<TeacherClass> list;
    private Context context;


    public TeacherAdapter(List<TeacherClass> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder,final int position) {
        final TeacherClass item = list.get(position);

        holder.teacherName.setText(item.getName());
        holder.teacherEmail.setText(item.getEmail());
        holder.teacherPost.setText(item.getPost());

        try {
            Glide.with(context).load(item.getImage()).placeholder(R.drawable.man).into(holder.teacherImage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        int a ;

        if( list!= null && !list.isEmpty()) {

            a = list.size();
        }
        else {

            a = 0;

        }

        return a;
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {
        private TextView teacherName, teacherPost, teacherEmail;
        private ImageView teacherImage;


        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            teacherName = itemView.findViewById(R.id.teacherName);
            teacherPost = itemView.findViewById(R.id.teacherPost);
            teacherEmail = itemView.findViewById(R.id.teacherEmail);
            teacherImage = itemView.findViewById(R.id.teacherImage);


        }
    }
}
