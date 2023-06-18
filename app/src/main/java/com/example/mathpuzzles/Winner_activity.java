package com.example.mathpuzzles;

import static com.example.mathpuzzles.MainActivity.editor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Winner_activity extends AppCompatActivity implements View.OnClickListener {

    TextView cont,menu,textwin;

    private int levelNo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        cont=findViewById(R.id.cont);
        menu=findViewById(R.id.menu);
        textwin=findViewById(R.id.txtwin);

        levelNo=getIntent().getIntExtra("level",levelNo);//1
        textwin.setText("PUZZLE "+levelNo+" COMPLETED");//1

        cont.setOnClickListener(this);
        menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==cont.getId())
        {
            Intent intent=new Intent(Winner_activity.this,Continue_activity.class);
            intent.putExtra("level",levelNo);//1
            startActivity(intent);
        }
        if(v.getId()==menu.getId())
        {
            Intent intent=new Intent(Winner_activity.this,MainActivity.class);
            intent.putExtra("level",levelNo);
            startActivity(intent);
        }
    }
}