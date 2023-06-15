package com.example.mathpuzzles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Winner_activity extends AppCompatActivity implements View.OnClickListener {

    TextView cont,menu,textwin;

    private int levelNo;
    private int cnt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        cont=findViewById(R.id.cont);
        menu=findViewById(R.id.menu);
        textwin=findViewById(R.id.txtwin);

        levelNo=getIntent().getIntExtra("level",levelNo);
        cnt=getIntent().getIntExtra("cnt",cnt);
        textwin.setText("PUZZLE "+cnt+" COMPLETED");
        levelNo++;
        cnt++;

        cont.setOnClickListener(this);
        menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==cont.getId())
        {

            Intent intent=new Intent(Winner_activity.this,Continue_activity.class);
            intent.putExtra("level",levelNo);
            intent.putExtra("cnt",cnt);
            startActivity(intent);
        }
        if(v.getId()==menu.getId())
        {
            Intent intent=new Intent(Winner_activity.this,MainActivity.class);
            intent.putExtra("level",levelNo);
            intent.putExtra("cnt",cnt);
            startActivity(intent);
        }
    }
}