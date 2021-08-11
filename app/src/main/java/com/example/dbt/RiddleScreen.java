package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class RiddleScreen extends FileManager {


    private HashMap<Integer, String> riddles = new HashMap<Integer, String>(3);
    private HashMap<Integer, String> questions = new HashMap<Integer, String>(9);
    private ProgressBar progBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riddle_screen);
        populateRiddles();
        populateQuestions();
        progBar = findViewById(R.id.progressBar);
        progBar.setMax(0);
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
            questions.put(1,"Riddle 1 : Question 1");
            questions.put(2, "Riddle 2 : Question 1");
            questions.put(3, "Riddle 3 : Question 1");
            questions.put(4,"Riddle 1 : Question 2");
            questions.put(5, "Riddle 2 : Question 2");
            questions.put(6, "Riddle 3 : Question 2");
            questions.put(7,"Riddle 1 : Question 3");
            questions.put(8, "Riddle 2 : Question 3");
            questions.put(9, "Riddle 3 : Question 3");
        }
        catch (Exception pq) {
            pq.printStackTrace();
        }
    }


    @Override
    public boolean checkCorrect() {
        return true;
    }


    private void updateUserScore() {
        try {
            if(checkCorrect() == true) {
                setUserScore(getUserScore() + 5);
            }
            else {
                if(getUserScore() != 0) {
                    setUserScore(getUserScore() - 5);
                }
            }
        }
        catch (Exception uus) {
            uus.printStackTrace();
        }
    }
   /* private void displayRiddles()
    {
        TextView riddleDisplay = findViewById(R.id.riddleInfotxt);
        for(int i; i < questions.size(); i++)
        {
            riddleDisplay.setText(questions.keySet(i)
        }
    }*/

    private void trackProgress(int newProgress) {
        try {
            if(progBar.getMax() == 0) {
                progBar.setMax(riddles.size());
            }
            if(newProgress <= riddles.size()) {
                progBar.setProgress(newProgress);
            }
        }
        catch (Exception tp) {
            tp.printStackTrace();
        }
    }
}