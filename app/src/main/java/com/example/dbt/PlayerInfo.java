package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PlayerInfo extends AppCompatActivity {


    private ImageView memGameIcon, triviaGameIcon, simonGameIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);


        memGameIcon = findViewById(R.id.memGameIcon);
        memGameIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                Intent memGame = new Intent(getApplicationContext(), MemoryGame.class);
                startActivity(memGame);
            }
        });
        triviaGameIcon = findViewById(R.id.triviaGameIcon);
        triviaGameIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                Intent triviaGame = new Intent(getApplicationContext(), RiddleScreen.class);
                startActivity(triviaGame);
            }
        });
        simonGameIcon = findViewById(R.id.simonGameIcon);
        simonGameIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                try {
                    Intent simonGame = new Intent(getApplicationContext(), Simon.class);
                    startActivity(simonGame);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void settings(View v)
    {
        ImageView settings = findViewById(R.id.settings1);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingMenu set = new SettingMenu();
                set.showWindow(PlayerInfo.this, settings);
            }
        });
    }
}