package com.example.aplikasisenibudaya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPulau extends ArrayAdapter {

    ArrayList<ClassPulau> pulauList;

    public AdapterPulau(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        pulauList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_item_pulau, null);

        TextView textView = (TextView) v.findViewById(R.id.textPulau);
        ImageView imageView = (ImageView) v.findViewById(R.id.pulauImage);
        textView.setText(pulauList.get(position).getNama_pulau());
        Picasso.get().load(pulauList.get(position).getImage()).into(imageView);
        return v;
    }



}
