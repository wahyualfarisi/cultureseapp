package com.example.aplikasisenibudaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PakaianAdat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakaian_adat);

        TextView pakaianName = findViewById(R.id.nama_pakaian);
        TextView pakaianDesc = findViewById(R.id.pakaian_description);
        ImageView pakaianImg = findViewById(R.id.pakaian_img);

        pakaianName.setText( getIntent().getStringExtra("pakaian_name") );
        pakaianDesc.setText( getIntent().getStringExtra("pakaian_description"));
        Picasso.get().load( getIntent().getStringExtra("pakaian_image") ).into(pakaianImg);
    }
}