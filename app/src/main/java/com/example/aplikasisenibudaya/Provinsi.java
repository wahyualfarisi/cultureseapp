package com.example.aplikasisenibudaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Provinsi extends AppCompatActivity {

    GridView gridProvinsiList;
    ArrayList<ClassProvinsi> provinsiList = new ArrayList<>();
    ArrayList<ClassDetailContent> tariTradisionalList = new ArrayList<>();
    ArrayList<ClassDetailContent> laguDaerah = new ArrayList<>();
    ArrayList<ClassDetailContent> pakaianAdatList = new ArrayList<>();
    ArrayList<ClassDetailContent> rumahAdatList = new ArrayList<>();
    ArrayList<ClassDetailContent> senjataLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provinsi);

        TextView textView = findViewById(R.id.textPulauDetail);
        ImageView imageViewDetailTop = findViewById(R.id.imagePulauDetail);

        textView.setText( getIntent().getStringExtra("nama_pulau"));
        Picasso.get().load( getIntent().getStringExtra("image") ).into(imageViewDetailTop);

        //set title
        setTitle("Provinsi");

        //
        gridProvinsiList = (GridView) findViewById(R.id.GridProvinsi);
        try {
            JSONObject obj = new JSONObject(loadJsonFromAsset());
            JSONArray provinsiArray = obj.getJSONArray("provinsi");
            for (int i = 0; i < provinsiArray.length(); i++) {
                JSONObject provinsi = provinsiArray.getJSONObject(i);
                JSONObject tari = provinsi.getJSONObject("tari_tradisional");
                JSONObject lagu = provinsi.getJSONObject("lagu_daerah");
                JSONObject pakaianAdat = provinsi.getJSONObject("pakaian_adat");
                JSONObject rumahAdat = provinsi.getJSONObject("rumah_adat");
                JSONObject senjata = provinsi.getJSONObject("senjata_khas");

                if( provinsi.getString("kode_pulau").equals( getIntent().getStringExtra("kode_pulau") ) ){
                    provinsiList.add(
                            new ClassProvinsi(
                                    provinsi.getString("kode_provinsi"),
                                    provinsi.getString("nama_provinsi"),
                                    provinsi.getString("kode_pulau"),
                                    provinsi.getString("image")
                            )
                    );

                    tariTradisionalList.add(
                            new ClassDetailContent(
                                    tari.getString("name"),
                                    tari.getString("description"),
                                    tari.getString("image"),
                                    tari.getString("video")
                            )
                    );

                    laguDaerah.add(
                            new ClassDetailContent(
                                    lagu.getString("name"),
                                    lagu.getString("description"),
                                    lagu.getString("image"),
                                    lagu.getString("video")
                            )
                    );

                    pakaianAdatList.add(
                            new ClassDetailContent(
                                    pakaianAdat.getString("name"),
                                    pakaianAdat.getString("description"),
                                    pakaianAdat.getString("image"),
                                    ""
                            )
                    );

                    rumahAdatList.add(
                            new ClassDetailContent(
                                    rumahAdat.getString("name"),
                                    rumahAdat.getString("description"),
                                    rumahAdat.getString("image"),
                                    ""
                            )
                    );

                    senjataLists.add(
                            new ClassDetailContent(
                                    senjata.getString("name"),
                                    senjata.getString("description"),
                                    senjata.getString("image"),
                                    ""
                            )
                    );
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AdapterProvinsi adapterProvinsi = new AdapterProvinsi(this, R.layout.grid_item_provinsi, provinsiList);
        gridProvinsiList.setAdapter(adapterProvinsi);

        gridProvinsiList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(Provinsi.this, DetailProvinsi.class);

                intent.putExtra("provinsi_name", provinsiList.get(position).getNama_provinsi() );

                intent.putExtra("tari_name",tariTradisionalList.get(position).getName() );
                intent.putExtra("tari_description", tariTradisionalList.get(position).getDescription());
                intent.putExtra("tari_image", tariTradisionalList.get(position).getImage());
                intent.putExtra("tari_video", tariTradisionalList.get(position).getVideo());

                intent.putExtra("lagu_name", laguDaerah.get(position).getName());
                intent.putExtra("lagu_description", laguDaerah.get(position).getDescription());
                intent.putExtra("lagu_image", laguDaerah.get(position).getImage());
                intent.putExtra("lagu_video", laguDaerah.get(position).getVideo());

                intent.putExtra("pakaian_name", pakaianAdatList.get(position).getName());
                intent.putExtra("pakaian_description", pakaianAdatList.get(position).getDescription());
                intent.putExtra("pakaian_image", pakaianAdatList.get(position).getImage());

                intent.putExtra("rumah_name", rumahAdatList.get(position).getName());
                intent.putExtra("rumah_description", rumahAdatList.get(position).getDescription());
                intent.putExtra("rumah_image", rumahAdatList.get(position).getImage());

                intent.putExtra("senjata_name", senjataLists.get(position).getName());
                intent.putExtra("senjata_description", senjataLists.get(position).getDescription());
                intent.putExtra("senjata_image", senjataLists.get(position).getImage());


                startActivity(intent);
            }
        });

    }

    public String loadJsonFromAsset() {
        String json = null;

        try {
            InputStream is = getAssets().open("provinsi.json");
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