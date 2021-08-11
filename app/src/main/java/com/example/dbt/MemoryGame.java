package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MemoryGame extends FileManager {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);
    }
}