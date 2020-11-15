package com.example.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.collegeapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private SliderLayout sliderLayout;
    private ImageView map1,map2;
    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view=inflater.inflate(R.layout.fragment_home, container, false);
        list=new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_computer,"Computer Science","Computer Science and Engineering is a most popular faculty in City University."));
        list.add(new BranchModel(R.drawable.ic_electrical,"Electrical","Electrical Engineering is a most popular faculty in City University."));


        adapter=new BranchAdapter(getContext(),list);
        viewPager=view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);


       sliderLayout=view.findViewById(R.id.slider);
       sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
       sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
       sliderLayout.setScrollTimeInSec(1);

       setSliderViews();
       map1=view.findViewById(R.id.map1);
       map2=view.findViewById(R.id.map2);
       map1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openMap();
           }
       });
 map2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openMapcity();
           }
       });




       return view;
    }

    private void openMapcity() {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/place/City+University/@23.750867,90.389347,498m/data=!3m1!1e3!4m5!3m4!1s0x0:0xad83526c894485f0!8m2!3d23.7508674!4d90.3893474?hl=en-GB"));
        startActivity(intent);
    }

    private void openMap() {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/place/City+University+Permanent+Campus/@23.873128,90.307309,498m/data=!3m1!1e3!4m5!3m4!1s0x0:0x6f95e92193fc8978!8m2!3d23.872745!4d90.3094257?hl=en-GB"));
        startActivity(intent);

    }

    private void setSliderViews() {
        for (int i=0;i<5;i++){
            DefaultSliderView sliderView=new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageDrawable(R.drawable.download);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.universitydesignphoto);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.download);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.universitydesignphoto);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.download);
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}