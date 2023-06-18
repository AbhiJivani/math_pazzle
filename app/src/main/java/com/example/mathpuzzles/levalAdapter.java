package com.example.mathpuzzles;

import static com.example.mathpuzzles.MainActivity.preferences;
import static com.example.mathpuzzles.config.ans;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class levalAdapter extends BaseAdapter
{
    Pazzles_level_activity pazzles_level_activity;
    private int lastlevel;
    int[] no;


    public levalAdapter(Pazzles_level_activity pazzles_level_activity, int[] no) {
        this.pazzles_level_activity = pazzles_level_activity;
        this.no=no;
    }

    @Override
    public int getCount() {
        return ans.length;
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
        tick.setImageResource(config.tick);

        int lastLevel = preferences.getInt("lastlevel", -1);
        String status = preferences.getString("levelstatus" + position, "Pending");
        String page = preferences.getString("page", "pp");
        Log.d("KKK", "getView: lastlevel=" + lastLevel);
        Log.d("KKK", "getView: Position=" + position + "\tStatus=" + status);
            if (position == 0)
            {
                lock.setVisibility(View.GONE);
                textView.setText("" + (position+1));
                textView.setVisibility(View.VISIBLE);
            }

            if (status.equals("win"))//1 ==
            {
                lock.setVisibility(View.GONE);
                textView.setText("" + (position+1));
                textView.setVisibility(View.VISIBLE);
                tick.setVisibility(View.VISIBLE);
            } else if (status.equals("win") || lastLevel + 1 == position) {
                lock.setVisibility(View.GONE);
                textView.setText("" +(position+1));
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
        return view;

    }

}


