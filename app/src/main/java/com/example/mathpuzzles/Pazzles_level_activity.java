package com.example.mathpuzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

public class Pazzles_level_activity extends AppCompatActivity implements View.OnClickListener {

    GridView gridView;
    private int levelNo;
    ImageButton next,back;
    private int cnt=1;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pazzles_level);
        gridView = findViewById(R.id.level_view);
        next=findViewById(R.id.next);
        back=findViewById(R.id.back);

        next.setOnClickListener(this);
        back.setOnClickListener(this);
        levelNo = getIntent().getIntExtra("level", levelNo);
        levalAdapter adapter = new levalAdapter(Pazzles_level_activity.this,config.no);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==next.getId())
        {

        }
    }
}