package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class IsekaiTitle extends AppCompatActivity {
    MediaPlayer ButtonClick1;
    private Button start;
    MediaPlayer backgroundmusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.isekai_title);
        ButtonClick1 = MediaPlayer.create(IsekaiTitle.this, R.raw.buttonclick);

        backgroundmusic = MediaPlayer.create(this,R.raw.backgroundthememusic);
        backgroundmusic.setLooping(true);
        backgroundmusic.start();


        start = findViewById(R.id.button);
        backgroundmusic.setLooping(true);
    }
}