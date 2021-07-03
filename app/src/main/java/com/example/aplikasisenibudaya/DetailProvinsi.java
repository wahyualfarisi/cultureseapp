package com.example.aplikasisenibudaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DetailProvinsi extends AppCompatActivity {

    String provinsi_name;

    String tari_name;
    String tari_description;
    String tari_image;
    String tari_video;

    String lagu_name, lagu_description, lagu_image, lagu_video;

    String pakaian_name, pakaian_description, pakaian_image;

    String rumah_name, rumah_description, rumah_image;

    String senjata_name, senjata_description, senjata_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_provinsi);

        provinsi_name = getIntent().getStringExtra("provinsi_name");

        tari_name = getIntent().getStringExtra("tari_name");
        tari_description = getIntent().getStringExtra("tari_description");
        tari_image = getIntent().getStringExtra("tari_image");
        tari_video = getIntent().getStringExtra("tari_video");

        lagu_name = getIntent().getStringExtra("lagu_name");
        lagu_description = getIntent().getStringExtra("lagu_description");
        lagu_image = getIntent().getStringExtra("lagu_image");
        lagu_video = getIntent().getStringExtra("lagu_video");

        pakaian_name = getIntent().getStringExtra("pakaian_name");
        pakaian_description = getIntent().getStringExtra("pakaian_description");
        pakaian_image = getIntent().getStringExtra("pakaian_image");

        rumah_name = getIntent().getStringExtra("rumah_name");
        rumah_description = getIntent().getStringExtra("rumah_description");
        rumah_image = getIntent().getStringExtra("rumah_image");

        senjata_name = getIntent().getStringExtra("senjata_name");
        senjata_description = getIntent().getStringExtra("senjata_description");
        senjata_image = getIntent().getStringExtra("senjata_image");

        setTitle(provinsi_name);

    }



    public void onClickTari(View view){
        Intent intent = new Intent( DetailProvinsi.this, TariTradisional.class  );

        intent.putExtra("tari_name", tari_name);
        intent.putExtra("tari_description", tari_description);
        intent.putExtra("tari_image", tari_image);
        intent.putExtra("tari_video", tari_video);



        startActivity(intent);
    }

    public void onClickLagu(View view){
        Intent intent = new Intent( DetailProvinsi.this, LaguDaerah.class  );


        intent.putExtra("lagu_name", lagu_name);
        intent.putExtra("lagu_description", lagu_description);
        intent.putExtra("lagu_image", lagu_image);
        intent.putExtra("lagu_video", lagu_video);

        startActivity(intent);

    }

    public void onClickPakaian(View view){
        Intent intent = new Intent( DetailProvinsi.this, PakaianAdat.class  );


        intent.putExtra("pakaian_name", pakaian_name);
        intent.putExtra("pakaian_description", pakaian_description);
        intent.putExtra("pakaian_image", pakaian_image);

        startActivity(intent);

    }

    public void onClickRumah(View view){
        Intent intent = new Intent( DetailProvinsi.this, RumahAdat.class  );


        intent.putExtra("name", rumah_name);
        intent.putExtra("desc", rumah_description);
        intent.putExtra("image", rumah_image);

        startActivity(intent);

    }

    public void onClickSenjata(View view){
        Intent intent = new Intent( DetailProvinsi.this, SenjataKhas.class  );


        intent.putExtra("name", senjata_name);
        intent.putExtra("desc", senjata_description);
        intent.putExtra("image", senjata_image);

        startActivity(intent);

    }


}