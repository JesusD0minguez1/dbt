package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);
        Button B5 =findViewById(R.id.button5);
    }

    public  void nextActivity(View v)
    {
        Intent action2 = new Intent(getApplicationContext(), RiddleScreen.class);
        startActivity(action2);
    }

}