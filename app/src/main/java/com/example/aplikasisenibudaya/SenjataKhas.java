package com.example.aplikasisenibudaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SenjataKhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senjata_khas);

        TextView senjataName = findViewById(R.id.nama_senjata);
        TextView senjataDesc = findViewById(R.id.senjata_description);
        ImageView senjataImg = findViewById(R.id.senjata_img);

        senjataName.setText( getIntent().getStringExtra("name") );
        senjataDesc.setText( getIntent().getStringExtra("desc"));
        Picasso.get().load( getIntent().getStringExtra("image") ).into( senjataImg );
    }
}