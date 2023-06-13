package com.example.mathpuzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Continue_activity extends AppCompatActivity implements View.OnClickListener {
    TextView levelbord,Submit,text;
    ImageView delete;
    TextView[] b=new TextView[10];

    int[] que ={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4, R.drawable.p5,
            R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10};

    String[] ans={"10","20","30","40","50","60","70","80","90","100"};
    private String temp;
    private String t;



    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        levelbord=findViewById(R.id.txt);
        Submit=findViewById(R.id.submit);
        text=findViewById(R.id.text);
        delete=findViewById(R.id.del);

        for(int i=0;i<b.length;i++)
        {

            int id = getResources().getIdentifier("b" + i, "id", getPackageName());
            b[i].findViewById(id);
            b[i].setOnClickListener(this);
            System.out.println(b[i]);
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==b[0].getId())
        {
            temp=text.getText().toString();
            t=temp+"0";
            text.setText(""+t);
        }
        if(v.getId()==b[1].getId())
        {
            temp=text.getText().toString();
            t=temp+"1";
            text.setText(""+t);
        }
        if(v.getId()==b[2].getId())
        {
            temp=text.getText().toString();
            t=temp+"2";
            text.setText(""+t);
        }
        if(v.getId()==b[3].getId())
        {
            temp=text.getText().toString();
            t=temp+"3";
            text.setText(""+t);
        }
        if(v.getId()==b[4].getId())
        {
            temp=text.getText().toString();
            t=temp+"4";
            text.setText(""+t);
        }
        if(v.getId()==b[5].getId())
        {
            temp=text.getText().toString();
            t=temp+"5";
            text.setText(""+t);
        }
        if(v.getId()==b[6].getId())
        {
            temp=text.getText().toString();
            t=temp+"6";
            text.setText(""+t);
        }
        if(v.getId()==b[7].getId())
        {
            temp=text.getText().toString();
            t=temp+"7";
            text.setText(""+t);
        }
        if(v.getId()==b[8].getId())
        {
            temp=text.getText().toString();
            t=temp+"8";
            text.setText(""+t);
        }
        if(v.getId()==b[9].getId())
        {
            temp=text.getText().toString();
            t=temp+"9";
            text.setText(""+t);
        }
        if(v.getId()==delete.getId())
        {
            temp=text.getText().toString().substring(0,temp.length()-1);
            text.setText(""+temp);

        }

    }
}