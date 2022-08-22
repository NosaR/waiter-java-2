package com.example.restaurant4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends BaseAdapter {
    //DEKLARASI VARIABLE
    Activity activity;
    List<Data_2> items;
    LayoutInflater inflater;

    //MEMANGGIL CONSTRUCTOR
    public DataAdapter(Activity activity, List<Data_2> items) {
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

    //MENAMPILKAN DATA
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) convertView = inflater.inflate(R.layout.list, null);

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView nim = (TextView) convertView.findViewById(R.id.nim);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView alamat = (TextView) convertView.findViewById(R.id.alamat);
        TextView telpon = (TextView) convertView.findViewById(R.id.telpon);
        TextView total = (TextView) convertView.findViewById(R.id.total);

        Data_2 data = items.get(position);

        id.setText(data.getId());
        nim.setText(data.getNim());
        nama.setText(data.getNama());
        alamat.setText(data.getAlamat());
        telpon.setText(data.getTelpon());
        total.setText(data.getTotal());

        return convertView;
    }
}
