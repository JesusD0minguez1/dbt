package com.example.dbt;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.HashMap;


public class RiddleScreen extends AppCompatActivity {


    private HashMap<Integer, String> riddles = new HashMap<Integer, String>(3);
    private HashMap<Integer, String> questions = new HashMap<Integer, String>(9);
    private ProgressBar progBar = (ProgressBar) findViewById(R.id.progressBar);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riddle_screen);
    }


    private void populateRiddles() {
        try {
            riddles.put(0, "Test Riddle 1");
            riddles.put(1, "Test Riddle 2");
            riddles.put(2, "test Riddle 3");
        }
        catch (Exception pr) {
            pr.printStackTrace();
        }
    }


    private void populateQuestions() {
        try {
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
        catch (Exception pq) {
            pq.printStackTrace();
        }
    }


    private boolean trackProgress(int newProgress) {
        try {
            progBar.setMax(riddles.size());
            if(newProgress <= riddles.size()) {
                progBar.setProgress(newProgress);
                return false;
            }
            else {
                return true;
            }
        }
        catch (Exception tp) {
            tp.printStackTrace();
            return false;
        }
    }
}