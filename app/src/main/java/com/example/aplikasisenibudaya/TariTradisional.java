package com.example.aplikasisenibudaya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class TariTradisional extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tari_tradisional);

        youTubePlayerView = findViewById(R.id.activity_main_youtubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);

        TextView tariNameText = findViewById(R.id.nama_tari);
        TextView tariDescriptionText = findViewById(R.id.tari_description);
        ImageView tariImage = findViewById(R.id.tari_img);

        tariNameText.setText( getIntent().getStringExtra("tari_name") );
        tariDescriptionText.setText( getIntent().getStringExtra("tari_description") );
        Picasso.get().load( getIntent().getStringExtra("tari_image") ).into(tariImage);


        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                Log.d("TAG", "onReady: ");
                String videoId = getIntent().getStringExtra("tari_video");
                youTubePlayer.loadVideo(videoId, 1);
            }

        });

    }
}