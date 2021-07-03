package com.example.aplikasisenibudaya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class LaguDaerah extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagu_daerah);

        youTubePlayerView = findViewById(R.id.lagu_video);
        getLifecycle().addObserver(youTubePlayerView);

        TextView laguNameText = findViewById(R.id.lagu_name);
        TextView laguDescriptionText = findViewById(R.id.lagu_description);
        ImageView laguImage = findViewById(R.id.lagu_img);

        laguNameText.setText( getIntent().getStringExtra("lagu_name") );
        laguDescriptionText.setText( getIntent().getStringExtra("lagu_description"));
        Picasso.get().load( getIntent().getStringExtra("lagu_image")).into(laguImage);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = getIntent().getStringExtra("lagu_video");
                youTubePlayer.loadVideo(videoId, 0);
            }

        });

    }
}