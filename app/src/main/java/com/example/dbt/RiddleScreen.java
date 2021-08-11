package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class RiddleScreen extends FileManager {


    private HashMap<Integer, String> riddleAnswer = new HashMap<Integer, String>(9);
    private HashMap<Integer, String> riddles = new HashMap<Integer, String>(9);
    private ProgressBar progBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riddle_screen);
        populateRiddles();
        populateQuestions();
        progBar = findViewById(R.id.progressBar);
        progBar.setMax(0);
        displayRiddles(2);
        displayRiddlesOption();
    }


    private void populateRiddles() {
        try {
            riddleAnswer.put(0, "Test Riddle 1");
            riddleAnswer.put(1, "Test Riddle 2");
            riddleAnswer.put(2, "test Riddle 3");
        }
        catch (Exception pr) {
            pr.printStackTrace();
        }
    }


    private void populateQuestions() {
        try {
            riddles.put(1,"Riddle 1 : Question 1");
            riddles.put(2, "Riddle 2 : Question 1");
            riddles.put(3, "Riddle 3 : Question 1");
            riddles.put(4,"Riddle 1 : Question 2");
            riddles.put(5, "Riddle 2 : Question 2");
            riddles.put(6, "Riddle 3 : Question 2");
            riddles.put(7,"Riddle 1 : Question 3");
            riddles.put(8, "Riddle 2 : Question 3");
            riddles.put(9, "Riddle 3 : Question 3");
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

    private void displayRiddles(int pp)
    {
        TextView riddleDisplay = findViewById(R.id.riddleInfotxt);
        int p = 0;
        while(p != pp + 1)
        {
            riddleDisplay.setText(riddles.get(p));
            trackProgress(p);
        }
    }

    public void displayRiddlesOption()
    {
        try
        {
            RadioButton op1 = findViewById(R.id.op1);
            RadioButton op2 = findViewById(R.id.op2);
            RadioButton op3 = findViewById(R.id.op3);
            RadioButton op4 = findViewById(R.id.op4);
            RadioButton op5 = findViewById(R.id.op5);

            int p = 0;
            switch (p)
            {
                case 0:
                    op1.setText(riddleAnswer.get(0));
                    op2.setText("Option");
                    op3.setText("dd");
                    op4.setText("ferwer");
                    op5.setText("rwbr");
                    break;

                case 1:
                    op1.setText("sfsf");
                    op2.setText(riddleAnswer.get(1));
                    op3.setText("dd");
                    op4.setText("ferwer");
                    op5.setText("rwbr");
                    break;
                case 2:
                    op1.setText("sfsf");
                    op2.setText(riddleAnswer.get(2));
                    op3.setText("dd");
                    op4.setText("ferwer");
                    op5.setText("rwbr");
                    break;
                case 3:
                    op1.setText("sfsfes");
                    op2.setText(riddleAnswer.get(3));
                    op3.setText("dsfdf");
                    op4.setText("ferwedsr");
                    op5.setText("rwber");
                    break;
            }

        }catch (Exception e){e.printStackTrace();}

    }

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