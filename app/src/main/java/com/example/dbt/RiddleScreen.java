package com.example.dbt;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.HashMap;


public class RiddleScreen extends AppCompatActivity {


    private ArrayList<String> riddles = new ArrayList<String>();
    private HashMap<Integer, String> questions = new HashMap<Integer, String>();
    private ProgressBar progBar = (ProgressBar) findViewById(R.id.progressBar);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riddle_screen);
    }


    private void populateRiddles() {
        riddles.add("Test Riddle 1");
        riddles.add("Test Riddle 2");
        riddles.add("test Riddle 3");
    }


    private void populateQuestions() {
        questions.put(0,"Riddle 1 : Question 1");
        questions.put(0, "Riddle 2 : Question 1");
        questions.put(0, "Riddle 3 : Question 1");
        questions.put(1,"Riddle 1 : Question 2");
        questions.put(1, "Riddle 2 : Question 2");
        questions.put(1, "Riddle 3 : Question 2");
        questions.put(2,"Riddle 1 : Question 3");
        questions.put(2, "Riddle 2 : Question 3");
        questions.put(2, "Riddle 3 : Question 3");
    }


    private void trackProgress() {
        progBar.setMax(riddles.size());
    }
}