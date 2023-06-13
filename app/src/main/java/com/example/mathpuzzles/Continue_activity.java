package com.example.mathpuzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Continue_activity extends AppCompatActivity implements View.OnClickListener {
    TextView levelbord, Submit, text,textView;
    ImageView delete;
    TextView[] b = new TextView[10];

    private String temp;
    private String t;
    private ArrayList<String> imgArr;
    int levelNo;
    int cnt;
    private int pageno;
    private int position;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        levelbord = findViewById(R.id.txt);
        Submit = findViewById(R.id.submit);
        text = findViewById(R.id.text);
        delete = findViewById(R.id.del);
        delete.setOnClickListener(this);
        textView=findViewById(R.id.textview);

        position=getIntent().getIntExtra("position",position);
        textView.setBackgroundResource(config.que[position]);

        levelNo=getIntent().getIntExtra("levelNo",levelNo);
        cnt=getIntent().getIntExtra("cnt",cnt);

        Submit.setOnClickListener(this);


        levelbord.setText("Level "+cnt);
        textView.setBackgroundResource(config.que[levelNo]);

        for (int i = 0; i < b.length; i++) {
            int id = getResources().getIdentifier("b" + i, "id", getPackageName());
            b[i] = findViewById(id);
            b[i].setOnClickListener(this);
            System.out.println(b[i]);

        }
        String[] images = new String[0];
        try {
            images = getAssets().list("LevelImages/");
            imgArr = new ArrayList<String>(Arrays.asList(images));
            Log.d("YYY", "onCreate: Images=" + imgArr);
//            for(int i=0;i<images.length;i++)
//            {
//                Log.d("YYY", "onCreate: Images="+images[i]);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream stream = null;
        try {
            stream = getAssets().open("levelbord/" + imgArr.get(levelNo));
            Drawable drawable = Drawable.createFromStream(stream, null);
            ImageView img = null;
            img.setImageDrawable(drawable);
        } catch (Exception ignored) {
        }
        finally
        {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (Exception ignored) {
            }
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
        try
        {
            if(v.getId()==delete.getId())
            {
                t=text.getText().toString().substring(0,t.length()-1);
                text.setText(""+t);
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"something went worng...",Toast.LENGTH_SHORT).show();
        }

        if(v.getId()==Submit.getId())
        {
            if(text.getText().toString().equals(config.ans[levelNo]))
            {
                Intent intent=new Intent(Continue_activity.this,Winner_activity.class);
                intent.putExtra("levelNo",levelNo);
                intent.putExtra("cnt",cnt);

                startActivity(intent);
            }
            else
            {
                Toast.makeText(this,"something went worng...",Toast.LENGTH_SHORT).show();
                text.setText("");

            }
        }
    }
}