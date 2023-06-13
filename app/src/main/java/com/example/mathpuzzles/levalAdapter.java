package com.example.mathpuzzles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class levalAdapter extends BaseAdapter
{
    Pazzles_level_activity pazzles_level_activity;
    String no[];

    public levalAdapter(Pazzles_level_activity pazzles_level_activity, String[] no) {
        this.pazzles_level_activity = pazzles_level_activity;
        this.no= no;
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
    view=LayoutInflater.from(pazzles_level_activity).inflate(R.layout.pazzles_level_item,parent,false);
        ImageView imageView=view.findViewById(R.id.lockno);
        ImageView imageView1=view.findViewById(R.id.tick);
        TextView textView=view.findViewById(R.id.txtno);
        textView.setText(no[position]);
        return view;
    }
}
