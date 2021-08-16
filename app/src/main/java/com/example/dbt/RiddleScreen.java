package com.example.dbt;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Set;


public class RiddleScreen extends FileManager {


    private HashMap<Integer, String> riddles = new HashMap<Integer, String>(3);
    private HashMap<Integer, String> riddleAnswer = new HashMap<Integer, String>(9);
    private ProgressBar progBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riddle_screen);
        populateRiddles();
        populateQuestions();
        progBar = findViewById(R.id.progressBar);
        progBar.setMax(0);
        displayRiddlesOption();
        displayRiddles();

    }


    public void settingsClick(View v)
    {
        ImageView settings2 = findViewById(R.id.settings);
        settings2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingMenu set = new SettingMenu();
                set.showWindow(RiddleScreen.this, settings2);
            }
        });

    }

    private void populateRiddles() {
        try {
            riddleAnswer.put(1, "Test Riddle 1");
            riddleAnswer.put(2, "Test Riddle 2");
            riddleAnswer.put(3, "test Riddle 3");
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
        }
        catch (Exception pq) {
            pq.printStackTrace();
        }
    }

    private void displayScore()
    {
        TextView displayScr = findViewById(R.id.riddleScore);
        displayScr.setText(String.valueOf(getUserScore()));
    }


   /* private void updateUserScore() {
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
    }*/
    private void displayRiddles()
    {
        TextView riddleDisplay = findViewById(R.id.riddleInfotxt);
        for(int i =0 ; i < riddles.size(); i++)
        {
            riddleDisplay.setText(riddles.get(1));
        }
    }

    @Override
    public void checkCorrect(View v)
    {
        Button btn = findViewById(R.id.riddleCA);
        RadioButton op1 = findViewById(R.id.op1);
        RadioButton op2 = findViewById(R.id.op2);
        RadioButton op3 = findViewById(R.id.op3);
        RadioButton op4 = findViewById(R.id.op4);
        RadioButton op5 = findViewById(R.id.op5);

        int score = getUserScore();
        Set<Integer> rkey = riddleAnswer.keySet();
        Set<Integer> raKey = riddles.keySet();
        for(int p = 0; p < riddles.size(); p++)
        {
            if(rkey.equals(raKey))
            {
                switch (p)
                {
                    case 0:
                        op1.setText(riddleAnswer.get(1));
                        op2.setText("Option");
                        op3.setText("dd");
                        op4.setText("ferwer");
                        op5.setText("rwbr");
                        if(op1.isChecked())
                        {
                            scoreStuff(p);
                        }
                        else
                        {
                            badScoreStuff(p);
                        }
                        break;

                    case 1:
                        op1.setText("sfsf");
                        op2.setText(riddleAnswer.get(2));
                        op3.setText("dd");
                        op4.setText("ferwer");
                        op5.setText("rwbr");
                        if(op2.isChecked())
                        {
                            scoreStuff(p);
                            trackProgress(p);
                        }
                        else
                        {
                            badScoreStuff(p);
                            trackProgress(p);
                        }
                        break;

                }
            }
            else
            {
                System.out.println("OK Something is up");
            }

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

            op1.setText(riddleAnswer.get(1));
            op2.setText("Option");
            op3.setText("dd");
            op4.setText("ferwer");
            op5.setText("rwbr");
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

    public void scoreStuff(int p)
    {
        int score = getUserScore();
        score += 100;
        setUserScore(score);
        displayScore();
    }
    public void badScoreStuff(int p)
    {
        int score = getUserScore();
        score -=100;
        setUserScore(score);
        displayScore();
    }

    public void nextActivity1(View v)
    {
        Button B6 =findViewById(R.id.nxtBtnRiddle);
        Intent action3 = new Intent(getApplicationContext(), MemoryGame.class);
        startActivity(action3);
    }
}