package com.example.restaurant4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DataAdapter2 extends BaseAdapter {
    //DEKLARASI VARIABLE
    Activity activity;
    List<Data_2> items;
    LayoutInflater inflater;

    //MEMANGGIL CONSTRUCTOR
    public DataAdapter2(Activity activity, List<Data_2> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //UNTUK MEMANGGIL DATA
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) convertView = inflater.inflate(R.layout.list_2, null);

        TextView l_id = (TextView) convertView.findViewById(R.id.l_id);
        TextView l_nim = (TextView) convertView.findViewById(R.id.l_nim);

        Data_2 data = items.get(position);

        l_id.setText(data.getL_id());
        l_nim.setText(data.getL_nim());

        return convertView;
    }
}
