package com.example.mathpuzzles;

import static com.example.mathpuzzles.MainActivity.editor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

public class Pazzles_level_activity extends AppCompatActivity {

    GridView gridView;
    private int levelNo;
    ImageButton next, back;
    int cnt = 0;
    private levalAdapter adapter;
    private int position;
    private int lastlevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pazzles_level);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);

        levelNo = getIntent().getIntExtra("level", position);//1
        gridView = findViewById(R.id.level_view);

        adapter = new levalAdapter(Pazzles_level_activity.this, config.no1,cnt);
        gridView.setAdapter(adapter);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(Pazzles_level_activity.this,Continue_activity.class);
//                intent.putExtra("level",position);
//                startActivity(intent);
//            }
//        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;
                if(cnt==1)
                {
                    adapter = new levalAdapter(Pazzles_level_activity.this, config.no2,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p1");
                    editor.commit();
                    back.setVisibility(View.VISIBLE);
                }
                if(cnt==2)
                {
                    adapter=new levalAdapter(Pazzles_level_activity.this,config.no3,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p2");
                    editor.commit();
                }
                if(cnt==3)
                {
                    adapter=new levalAdapter(Pazzles_level_activity.this,config.no4,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p3");
                    editor.commit();

                }
            }

        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt--;
                if(cnt==0)
                {
                    adapter = new levalAdapter(Pazzles_level_activity.this, config.no1,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p0");
                    editor.commit();
                    back.setVisibility(View.VISIBLE);
                }
                if(cnt==2)
                {
                    adapter=new levalAdapter(Pazzles_level_activity.this,config.no2,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p1");
                    editor.commit();
                }
                if(cnt==3)
                {
                    adapter=new levalAdapter(Pazzles_level_activity.this,config.no3,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p2");
                    editor.commit();
                }

           }
        });

    }
}
