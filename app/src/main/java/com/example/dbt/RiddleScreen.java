package com.example.dbt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;
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
        displayRiddles();
        displayRiddlesOption();
        checkCorrect();
    }


    private void populateRiddles() {
        try {
            riddles.put(1, "Test Riddle 1");
            riddles.put(2, "Test Riddle 2");
            riddles.put(3, "test Riddle 3");
        } catch (Exception pr) {
            pr.printStackTrace();
        }
    }


    private void populateQuestions() {
        try {
            riddleAnswer.put(1, "Riddle 1 : Question 1");
            riddleAnswer.put(2, "Riddle 2 : Question 1");
            riddleAnswer.put(3, "Riddle 3 : Question 1");
        } catch (Exception pq) {
            pq.printStackTrace();
        }
    }


    public boolean checkCorrect() {
        Button btn = findViewById(R.id.riddleCA);
        RadioButton r1 = findViewById(R.id.op1);
        RadioButton r2 = findViewById(R.id.op2);
        RadioButton r3 = findViewById(R.id.op3);
        RadioButton r4 = findViewById(R.id.op4);
        RadioButton r5 = findViewById(R.id.op5);
        final boolean[] isCorrect = {false};
        final int[] p = {1};
        p[0] = 0;

        Set<Integer> rkey = riddleAnswer.keySet();
        Set<Integer> raKey = riddles.keySet();
        
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioButton cr = r4;
                switch (p[0]) {
                    case 0:
                        cr = r1;
                        displayRiddlesOption(1);
                        break;
                    case 1:
                        cr = r2;
                        displayRiddlesOption(2);
                        break;
                    case 2:
                        cr = r4;
                        displayRiddlesOption(3);
                        break;
                }
                if (cr.isChecked()) {
                    if (p[0] <= 2) {
                        isCorrect[0] = true;
                        updateUserScore(isCorrect[0]);
                        p[0] = p[0] + 1;
                    }
                } else {

                    if (!(getUserScore() <= 0)) {
                        isCorrect[0] = false;
                        p[0] = p[0] + 1;
                        updateUserScore(isCorrect[0]);
                    }
                }
            }
        });
        return isCorrect[0];
    }


    private void updateUserScore(boolean correct) {
        TextView score = findViewById(R.id.riddleScore);
        try {
            if (correct) {
                setUserScore(getUserScore() + 5);
                score.setText(getUserScore() + "");
            } else {
                if (!(getUserScore() <= 0)) {
                    setUserScore(getUserScore() - 5);
                    score.setText(getUserScore() + "");
                }
            }
        } catch (Exception uus) {
            uus.printStackTrace();
        }
    }

    private void displayRiddles() {
        TextView riddleDisplay = findViewById(R.id.riddleInfotxt);
        for (int i = 0; i < riddles.size(); i++) {
            riddleDisplay.setText(riddles.get(1));
        }
    }

    public void displayRiddlesOption() {
        try {
            RadioButton r1 = findViewById(R.id.op1);
            RadioButton r2 = findViewById(R.id.op2);
            RadioButton r3 = findViewById(R.id.op3);
            RadioButton r4 = findViewById(R.id.op4);
            RadioButton r5 = findViewById(R.id.op5);

            r1.setText(riddleAnswer.get(1));
            r2.setText("Option");
            r3.setText("dd");
            r4.setText("ferwer");
            r5.setText("rwbr");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayRiddlesOption(int p) {
        try {
            RadioButton op1 = findViewById(R.id.op1);
            RadioButton op2 = findViewById(R.id.op2);
            RadioButton op3 = findViewById(R.id.op3);
            RadioButton op4 = findViewById(R.id.op4);
            RadioButton op5 = findViewById(R.id.op5);

            switch (p) {
                case 0:
                    op1.setText(riddleAnswer.get(1));
                    op2.setText("Option");
                    op3.setText("dd");
                    op4.setText("ferwer");
                    op5.setText("rwbr");
                    break;

                case 1:
                    op1.setText("sfsf");
                    op2.setText(riddleAnswer.get(2));
                    op3.setText("dd");
                    op4.setText("ferwer");
                    op5.setText("rwbr");
                    break;
                case 2:
                    op1.setText("Howdy!");
                    op2.setText("Are you ready for a bad time?");
                    op3.setText("Who needs arms with legs like these");
                    op4.setText(riddleAnswer.get(2));
                    op5.setText("Nyah!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void trackProgress(int newProgress) {
        try {
            if (progBar.getMax() == 0) {
                progBar.setMax(riddles.size());
            }
            if (newProgress <= riddles.size()) {
                progBar.setProgress(newProgress);
            }
        } catch (Exception tp) {
            tp.printStackTrace();
        }
    }

    public void nextActivity1(View v) {
        Button B6 = findViewById(R.id.nxtBtnRiddle);
        Intent action3 = new Intent(getApplicationContext(), MemoryGame.class);
        startActivity(action3);
    }
}