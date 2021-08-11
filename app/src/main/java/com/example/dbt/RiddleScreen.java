package com.example.dbt;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;


public class RiddleScreen extends AppCompatActivity {


    private ArrayList<String> riddles = new ArrayList<String>();
    private ArrayList<String> questions = new ArrayList<String>();
    private ProgressBar progBar = (ProgressBar) findViewById(R.id.progressBar);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riddle_screen);
    }


    private void trackProgress() {
        progBar.setMax(riddles.size());
    }
}