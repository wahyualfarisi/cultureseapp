package com.example.aplikasisenibudaya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterProvinsi extends ArrayAdapter {

    ArrayList<ClassProvinsi> provinsiList;

    public AdapterProvinsi(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        provinsiList = objects;
    }


    @Override
    public int getCount() {
        return super.getCount();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_item_provinsi, null);

        TextView textView = (TextView) v.findViewById(R.id.textProvinsi);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageProvinsi);
        textView.setText(provinsiList.get(position).getNama_provinsi());
        Picasso.get().load(provinsiList.get(position).getImage()).into(imageView);
        return v;
    }


}
