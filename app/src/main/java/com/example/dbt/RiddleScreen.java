package com.example.dbt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;


public class RiddleScreen extends FileManager {


    final private HashMap<Integer, String> riddles = new HashMap<Integer, String>(6);
    final private HashMap<Integer, String> riddleAnswer = new HashMap<Integer, String>(6);
    private ProgressBar progBar;
    private int nextProg = 0;


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
            riddles.put(1, "(MHA) Aizawa's hero name?");
            riddles.put(2, "Nintendo 64 release date (US)?");
            riddles.put(3, "Where did Comire work at before?");
            riddles.put(4, "What movie was filmed in SLC?");
            riddles.put(5, "Where was Neumont before?");
            riddles.put(6, "");
        } catch (Exception pr) {
            pr.printStackTrace();
        }
    }


    private void populateQuestions() {
        try {
            riddleAnswer.put(1, "Eraser Head");
            riddleAnswer.put(2, "September 29, 1996");
            riddleAnswer.put(3, "USC");
            riddleAnswer.put(4, "The Sandlot");
            riddleAnswer.put(5, "South Jordan?");
            riddleAnswer.put(6, "Riddle 6 : Question 1");
        } catch (Exception pq) {
            pq.printStackTrace();
        }
    }


    public void checkCorrect() {
        Button btn = findViewById(R.id.riddleCA);
        RadioButton r1 = findViewById(R.id.op1);
        RadioButton r2 = findViewById(R.id.op2);
        RadioButton r3 = findViewById(R.id.op3);
        RadioButton r4 = findViewById(R.id.op4);
        RadioButton r5 = findViewById(R.id.op5);
        final boolean[] isCorrect = {false};
        final int[] p = {1};
        p[0] = 0;

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioButton cr = r1;
                switch (p[0]) {
                    case 0:
                        cr = r1;
                        displayRiddlesOption(1);
                        displayRiddles(1);
                        nextProg += 1;
                        break;
                    case 1:
                        cr = r2;
                        displayRiddlesOption(2);
                        displayRiddles(2);
                        nextProg += 1;
                        break;
                    case 2:
                        cr = r3;
                        displayRiddlesOption(3);
                        displayRiddles(3);
                        nextProg += 1;
                        break;
                    case 3:
                        cr = r5;
                        displayRiddlesOption(4);
                        displayRiddles(4);
                        nextProg += 1;
                        break;
                    case 4:
                        cr = r3;
                        displayRiddlesOption(5);
                        displayRiddles(5);
                        nextProg += 1;
                        break;
                    case 5:
                        cr = r4;
                        displayRiddlesOption(6);
                        displayRiddles(6);
                        nextProg += 1;
                        break;
                }
                if (cr.isChecked()) {
                    if (p[0] < 6) {
                        isCorrect[0] = true;
                        updateUserScore(isCorrect[0]);
                        p[0] = p[0] + 1;
                        trackProgress(p[0]);
                    }
                } else {
                    p[0] = p[0] + 1;
                    isCorrect[0] = false;
                    trackProgress(p[0]);
                    if (!(getUserScore() <= 0) && p[0] < 6) {
                        updateUserScore(isCorrect[0]);
                    }
                }
                trackProgress(nextProg);
            }
        });
    }


    @SuppressLint("SetTextI18n")
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

    private void displayRiddles(int p) {
        TextView riddleDisplay = findViewById(R.id.riddleInfotxt);
        switch (p) {
            case 1:
                riddleDisplay.setText(riddles.get(2));
                break;
            case 2:
                riddleDisplay.setText(riddles.get(3));
                break;
            case 3:
                riddleDisplay.setText(riddles.get(4));
                break;
            case 4:
                riddleDisplay.setText(riddles.get(5));
                break;
            case 5:
                riddleDisplay.setText(riddles.get(6));
                break;
            case 6:
                riddleDisplay.setText("Done");
        }
    }

    @SuppressLint("SetTextI18n")
    public void displayRiddlesOption() {
        try {
            RadioButton r1 = findViewById(R.id.op1);
            RadioButton r2 = findViewById(R.id.op2);
            RadioButton r3 = findViewById(R.id.op3);
            RadioButton r4 = findViewById(R.id.op4);
            RadioButton r5 = findViewById(R.id.op5);

            r1.setText(riddleAnswer.get(1));
            r2.setText("Head Eraser");
            r3.setText("Cancel Head");
            r4.setText("Mr. Mic");
            r5.setText("Quirk Eraser");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    private void displayRiddlesOption(int p) {
        try {
            RadioButton op1 = findViewById(R.id.op1);
            RadioButton op2 = findViewById(R.id.op2);
            RadioButton op3 = findViewById(R.id.op3);
            RadioButton op4 = findViewById(R.id.op4);
            RadioButton op5 = findViewById(R.id.op5);

            switch (p) {
                case 1:
                    op1.setText("July 5, 1997");
                    op2.setText(riddleAnswer.get(2));
                    op3.setText("Jun 23, 1996");
                    op4.setText("November 16, 1996");
                    op5.setText("March 1, 1997");
                    break;
                case 2:
                    op1.setText("Oof");
                    op2.setText("UNO");
                    op3.setText(riddleAnswer.get(3));
                    op4.setText("FLD");
                    op5.setText("MOMMA!");
                    break;
                case 3:
                    op1.setText("The Goonies");
                    op2.setText("Texas Chainsaw Massacre");
                    op3.setText("Star Wars: Episode VI");
                    op4.setText("Daddy Day Camp");
                    op5.setText(riddleAnswer.get(4));
                    break;
                case 4:
                    op1.setText("*Guitar riffs*");
                    op2.setText("I can show you");
                    op3.setText("What it's like");
                    op4.setText(riddleAnswer.get(5));
                    op5.setText("thaf;!");
                    break;
                case 5:
                    op1.setText("LIIIKKEE");
                    op2.setText("*More guitar riffs*");
                    op3.setText("*Drum ending*");
                    op4.setText(riddleAnswer.get(6));
                    op5.setText("What will it take, to rip the heart from your hate");
                    break;
                case 6:
                    op1.setText("");
                    op2.setText("");
                    op3.setText("");
                    op4.setText("");
                    op5.setText("");
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


    public void settingsRiddle(View v)
    {
        ImageView settings = findViewById(R.id.settingsRiddle);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingMenu set = new SettingMenu();
                set.showWindow(RiddleScreen.this, settings);
            }
        });
    }
}