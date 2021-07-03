package com.example.aplikasisenibudaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RumahAdat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumah_adat);

        TextView rumahName = findViewById(R.id.nama_rumah);
        TextView rumahDescription = findViewById(R.id.rumah_description);
        ImageView rumahImage = findViewById(R.id.rumah_img);

        rumahName.setText( getIntent().getStringExtra("name") );
        rumahDescription.setText( getIntent().getStringExtra("desc"));
        Picasso.get().load( getIntent().getStringExtra("image") ).into(rumahImage);
    }

    public void home(View view) {
        Intent intent = new Intent(RumahAdat.this, Home.class);
        startActivity(intent);
    }
}