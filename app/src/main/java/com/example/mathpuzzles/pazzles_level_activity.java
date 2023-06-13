package com.example.mathpuzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class pazzles_level_activity extends AppCompatActivity {

    levalAdapter adapter;
    GridView gridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pazzles_level);
        gridView=findViewById(R.id.level_view);



    }
}