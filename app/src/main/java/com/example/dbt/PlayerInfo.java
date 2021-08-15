package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PlayerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);

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

    public void nextActivity(View v)
    {
        Button B5 =findViewById(R.id.playerInfoNxt);
        Intent action2 = new Intent(getApplicationContext(), RiddleScreen.class);
        startActivity(action2);
    }

}