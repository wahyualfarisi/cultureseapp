package com.example.aplikasisenibudaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    GridView GridpulauLists;
    ArrayList<ClassPulau> pulauList = new ArrayList<ClassPulau>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GridpulauLists = (GridView) findViewById(R.id.gridPulauList);
        try {
            JSONObject obj = new JSONObject(loadJsonFromAsset());
            JSONArray birdArray = obj.getJSONArray("pulau");
            for (int i = 0; i < birdArray.length(); i++) {
                JSONObject pulau = birdArray.getJSONObject(i);
                pulauList.add(
                        new ClassPulau(
                                pulau.getString("kode_pulau") ,
                                pulau.getString("nama_pulau"),
                                pulau.getString("image")
                        )
                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AdapterPulau adapterPulau = new AdapterPulau(this, R.layout.grid_item_pulau, pulauList);
        GridpulauLists.setAdapter(adapterPulau);

        GridpulauLists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Home.this, Provinsi.class);
                intent.putExtra("kode_pulau", pulauList.get(position).getKode_pulau());
                intent.putExtra("nama_pulau", pulauList.get(position).getNama_pulau());
                intent.putExtra("image", pulauList.get(position).getImage());

                startActivity(intent);
            }
        });
    }

    public String loadJsonFromAsset() {
        String json = null;

        try {
            InputStream is = getAssets().open("pulau.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}