package com.example.mathpuzzles;

import static com.example.mathpuzzles.config.tick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Pazzles_level_activity extends AppCompatActivity {

    GridView gridView;
    private int levelNo;
    private int cnt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pazzles_level);
        gridView=findViewById(R.id.level_view);

        levelNo=getIntent().getIntExtra("levelNo",levelNo);
        cnt=getIntent().getIntExtra("cnt",cnt);

        levalAdapter adapter=new levalAdapter(Pazzles_level_activity.this,config.no);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

    }
}