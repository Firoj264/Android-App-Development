package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.net.Inet4Address;

public class Faculties_navigation extends AppCompatActivity {
    private Spinner cseCategory,cseCategory2,cseCategory3,cseCategory4;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculties_navigation);
        cseCategory=findViewById(R.id.cse);
        cseCategory2=findViewById(R.id.cse2);
        cseCategory3=findViewById(R.id.cse3);
        cseCategory4=findViewById(R.id.cse4);

        String[] items=new String[]{"Faculty of Science and Engineering","Computer Science and Engineering","Electrical and Electronic Engineering","Department of Mechanical Engineering","Department of Textile Engineering","Department of Civil Engineering","Department of Pharmacy"};
        cseCategory.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,items));
        String[] items2=new String[]{"Faculty of Arts & Social Science","Department of English","Department of Law"};
        cseCategory2.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,items2));
        String[] items3=new String[]{"Faculty of Business & Economics","Department of Business Administration"};
        cseCategory3.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,items3));
        String[] items4=new String[]{"Faculty of Agriculture","Department of Agriculture"};
        cseCategory4.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,items4));


        cseCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category=cseCategory.getSelectedItem().toString();
                if (category=="Computer Science and Engineering"){
                    Intent intent=new Intent(Faculties_navigation.this,Cse_home.class);
                    startActivity(intent);
                    finish();
                }else if (category=="Electrical and Electronic Engineering"){
                    Intent intent=new Intent(Faculties_navigation.this,Eee_home.class);
                    startActivity(intent);
                    finish();

                }else if (category=="Department of Mechanical Engineering"){
                    Intent intent=new Intent(Faculties_navigation.this,Eee_home.class);
                    startActivity(intent);
                    finish();

                }else if (category=="Department of Textile Engineering"){
                    Intent intent=new Intent(Faculties_navigation.this,Eee_home.class);
                    startActivity(intent);
                    finish();

                }else if (category=="Department of Civil Engineering") {
                    Intent intent = new Intent(Faculties_navigation.this, Eee_home.class);
                    startActivity(intent);
                    finish();
                }else if (category=="Department of Pharmacy") {
                    Intent intent = new Intent(Faculties_navigation.this, Eee_home.class);
                    startActivity(intent);
                    finish();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

}