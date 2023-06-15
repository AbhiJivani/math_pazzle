package com.example.mathpuzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Continue,Puzzles,BuyPro;
    private int cnt=1;
     int levelNo=0;

    int lastlevel;
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Continue=findViewById(R.id.cont);
        Puzzles=findViewById(R.id.puzzle);
        BuyPro=findViewById(R.id.buy);

        preferences=getSharedPreferences("mypre",MODE_PRIVATE);
        editor=preferences.edit();
        lastlevel=preferences.getInt("lastLevel",0);

        levelNo=getIntent().getIntExtra("level",levelNo);
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
            intent.putExtra("cnt",cnt);
            startActivity(intent);
        }
        if(v.getId()==Puzzles.getId())
        {
            Intent intent=new Intent(MainActivity.this, Pazzles_level_activity.class);
            intent.putExtra("level",levelNo);
            intent.putExtra("cnt",cnt);
            startActivity(intent);

        }
    }
}