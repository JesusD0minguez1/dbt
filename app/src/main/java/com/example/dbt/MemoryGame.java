package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MemoryGame extends FileManager {

    TextView timer;
    TextView score;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);

        //Declare views
        timer = findViewById(R.id.timerView);
        score = findViewById(R.id.scoreView);
    }
}