package edu.temple.colorpickerwithtwoactivities;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    Context context;
    String[] colors;

    public ColorAdapter(Context context, String[] colors) {
        this.context = context;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    // Our data set of colors does not have unique IDs for its elements other than its indices, so don't need to change this default implementation. Was also told not to worry about this in class.
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;
        if (convertView instanceof TextView) {
            textView = (TextView) convertView;
        } else {
            textView = new TextView(context);
        }

        textView.setText(colors[position]);
        textView.setTextSize(24);
        textView.setPadding(5, 5, 5, 5);
        textView.setBackgroundColor(Color.parseColor(colors[position]));

        return textView;
    }
}
