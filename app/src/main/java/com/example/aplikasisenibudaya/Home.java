package com.example.aplikasisenibudaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJsonFromAsset());
            // fetch JSONArray named birds
            JSONArray birdArray = obj.getJSONArray("pulau");
            // implement for loop for getting birds list data
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