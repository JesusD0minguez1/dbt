package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IsekaiGameOver extends AppCompatActivity {
    MediaPlayer backgroundmusic3;
    String playerName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.isekai_game_over);

        backgroundmusic3 = MediaPlayer.create(this,R.raw.game_overdavid_renda);
        backgroundmusic3.setLooping(true);
        backgroundmusic3.start();

        Intent action5 = getIntent();
        playerName2 = action5.getStringExtra("c5");
        TextView name = findViewById(R.id.textView9);
        TextView name2 = findViewById(R.id.textView10);
        name.setText(playerName2);
        name2.setText(playerName2);

    }

    public void startOverClick(View v){
        Intent action2 = new Intent(getApplicationContext(),IsekaiTitle.class);
        startActivity(action2);
        backgroundmusic3.stop();
    }

    public void exitClick(View v){
        finishAffinity();
        backgroundmusic3.stop();
    }

}