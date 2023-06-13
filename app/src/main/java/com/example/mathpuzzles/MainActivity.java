package com.example.mathpuzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Continue,Puzzles,BuyPro;

    private int cnt=1;
    private int levelNo=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Continue=findViewById(R.id.cont);
        Puzzles=findViewById(R.id.puzzle);
        BuyPro=findViewById(R.id.buy);

        levelNo=getIntent().getIntExtra("levelNo",levelNo);
        cnt=getIntent().getIntExtra("cnt",cnt);

        Continue.setOnClickListener(this);
        Puzzles.setOnClickListener(this);
        BuyPro.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==Continue.getId())
        {
            Intent intent=new Intent(MainActivity.this,Continue_activity.class);
            intent.putExtra("level",levelNo);
            System.out.println("next="+levelNo);
            intent.putExtra("cnt",cnt);
            startActivity(intent);
        }
        if(v.getId()==Puzzles.getId())
        {
            Intent intent=new Intent(MainActivity.this, Pazzles_level_activity.class);
            startActivity(intent);

        }
    }
}