package com.example.mathpuzzles;


import static com.example.mathpuzzles.MainActivity.preferences;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;




public class levalAdapter extends BaseAdapter {
    Pazzles_level_activity pazzles_level_activity;
    private int lastlevel;
    int[] no;
    int cnt;
    private String status;


    public levalAdapter(Pazzles_level_activity pazzles_level_activity, int[] no,int cnt) {
        this.pazzles_level_activity = pazzles_level_activity;
        this.no=no;
        this.cnt=cnt;
    }

    @Override
    public int getCount() {
        return no.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(pazzles_level_activity).inflate(R.layout.pazzles_level_item, parent, false);
        ImageView lock = view.findViewById(R.id.lockno);
        ImageView tick = view.findViewById(R.id.tick);
        TextView textView = view.findViewById(R.id.txtno);
        lock.setImageResource(config.lock);
        int lastLevel = preferences.getInt("lastlevel", -1);
        String status = preferences.getString("levelstatus" + position, "Pending");
        String page=preferences.getString("page","pp");
        if(page.equals("p0")) {
            if (position == 0) {

                lock.setVisibility(View.GONE);
                textView.setText("" + no[position]);
                textView.setVisibility(View.VISIBLE);
            }
            if (status.equals("win")) {
                lock.setVisibility(View.GONE);
                textView.setText("" + no[position]);
                textView.setVisibility(View.VISIBLE);
                tick.setVisibility(View.VISIBLE);
                tick.setImageResource(config.tick);
            }
            if (status.equals("win") || lastLevel + 1 == position) {
                lock.setVisibility(View.GONE);
                textView.setText("" + no[position]);
                textView.setVisibility(View.VISIBLE);
            }
            if (status.equals("win") || status.equals("skip") || position == lastlevel + 1) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(pazzles_level_activity, Continue_activity.class);
                        intent.putExtra("level", position);

                        pazzles_level_activity.startActivity(intent);
                    }
                });
            }

        }
//
//        if(page.equals("p1"))
//        {
//            if(position==25)
//            {
//                //String status = preferences.getString("levelstatus"+(position+25),"pending");
//                int levelNo = preferences.getInt("levelNo", 0);
//                textView.setText("");
//
//                if (status.equals("win")) {
//                    lock.setVisibility(View.INVISIBLE);
//                    textView.setText("" + config.no2[position]);
//                    tick.setImageResource(config.tick);
//                } else if (status.equals("skip") || levelNo == position + 25) {
//                    lock.setVisibility(View.INVISIBLE);
//                    textView.setText("" + config.no2[position]);
//                }
//
//                tick.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(pazzles_level_activity, Continue_activity.class);
//                        intent.putExtra("levelNo", position + 24);
//                        pazzles_level_activity.startActivity(intent);
//                    }
//                });
//            }
//        }
//
//        if(page.equals("p2")){
//            String status = preferences.getString("levelstatus"+(position+49),"pending");
//            int levelNo = preferences.getInt("levelNo",0);
//            textView.setText("");
//
//            if(status.equals("win")){
//                lock.setVisibility(View.INVISIBLE);
//                textView.setText(""+no[position]);
//                tick.setImageResource(config.tick);
//            } else if (status.equals("skip") || levelNo==position+49) {
//                lock.setVisibility(View.INVISIBLE);
//                textView.setText(""+no[position]);
//            }
//
//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(pazzles_level_activity,Continue_activity.class);
//                    intent.putExtra("levelNo",position+48);
//                    pazzles_level_activity.startActivity(intent);
//                }
//            });
//        }
//
//        if(page.equals("p3")){
//            String status = preferences.getString("levelstatus"+(position+74),"pending");
//            int levelNo = preferences.getInt("levelNo",0);
//            textView.setText("");
//
//            if(status.equals("win")){
//                lock.setVisibility(View.INVISIBLE);
//                textView.setText(""+no[position]);
//                tick.setImageResource(config.tick);
//            } else if (status.equals("skip") || levelNo==position+74) {
//                lock.setVisibility(View.INVISIBLE);
//                textView.setText(""+no[position]);
//            }
//
//            textView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(pazzles_level_activity,Continue_activity.class);
//                    intent.putExtra("levelNo",position+73);
//                    pazzles_level_activity.startActivity(intent);
//                }
//            });
//        }


        return view;

    }

}


