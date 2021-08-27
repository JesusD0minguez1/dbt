package com.example.dbt;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.HashMap;


public class RiddleScreen extends MainActivity {


    final private HashMap<Integer, String> riddles = new HashMap<>(10);
    final private HashMap<Integer, String> riddleAnswer = new HashMap<>(10);
    private ProgressBar progBar;
    private int nextProg = 0;
    private int trivScore = 0;
    MediaPlayer rdMusic;
    RadioButton r1, r2, r3, r4, r5;
    Button btn;
    RadioGroup group;
    TextView riddleDisplay, score;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riddle_screen);
        progBar = findViewById(R.id.progressBar);
        r1 = findViewById(R.id.op1); r2 = findViewById(R.id.op2); r3 = findViewById(R.id.op3);
        r4 = findViewById(R.id.op4); r5 = findViewById(R.id.op5);
        group = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.riddleCA);
        riddleDisplay = findViewById(R.id.riddleInfotxt); score = findViewById(R.id.riddleScore);
        progBar.setMax(0);
        //Settings
        ImageView settings = findViewById(R.id.settingsRiddle);
        rdMusic = MediaPlayer.create(this.getApplicationContext(), R.raw.gravity);
        try { rdMusic.prepareAsync(); } catch (Exception prep) {prep.printStackTrace(); }
        settings.setOnClickListener(v -> {
            SettingMenu set = new SettingMenu();
            set.showWindow(RiddleScreen.this, settings, rdMusic);
        });
        populateRiddles();
        populateQuestions();
        displayRiddles();
        displayRiddlesOption();
        checkCorrect();
    }



    private void populateRiddles() {
        TextView tv = findViewById(R.id.riddleScore);
        try {
            riddles.put(1, "(MHA) Aizawa's hero name?");
            riddles.put(2, "Nintendo 64 release date (US)?");
            riddles.put(3, "Where did Comire work before?");
            riddles.put(4, "What movie was filmed in SLC?");
            riddles.put(5, "Where was Neumont before?");
            riddles.put(6, "How do you kill a Wendigo?");
            riddles.put(7, "What was Walt Disney afraid of?");
            riddles.put(8, "What actor played Indiana Jones?");
            riddles.put(9, "Who explored the Pacific NW in early 1800s?");
            riddles.put(10, "Body's resistance to changes in motion or speed?");
            tv.setText(0+"");
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
            riddleAnswer.put(5, "West Jordan");
            riddleAnswer.put(6, "Fire");
            riddleAnswer.put(7, "Mice");
            riddleAnswer.put(8, "Harrison Ford");
            riddleAnswer.put(9, "Lewis & Clark");
            riddleAnswer.put(10, "Inertia");
        } catch (Exception pq) {
            pq.printStackTrace();
        }
    }



    public void checkCorrect() {
        final boolean[] isCorrect = {false};
        final int[] p = {1};
        p[0] = 0;
        btn.setOnClickListener(v -> {
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
                    cr = r4;
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
                case 6:
                    cr = r1;
                    displayRiddlesOption(7);
                    displayRiddles(7);
                    nextProg += 1;
                    break;
                case 7:
                    cr = r3;
                    displayRiddlesOption(8);
                    displayRiddles(8);
                    nextProg += 1;
                    break;
                case 8:
                    cr = r1;
                    displayRiddlesOption(9);
                    displayRiddles(9);
                    nextProg += 1;
                    break;
                case 9:
                    cr = r3;
                    displayRiddlesOption(10);
                    displayRiddles(10);
                    nextProg += 1;
                    break;
            }
            if (cr.isChecked()) {
                if (p[0] < 11) {
                    isCorrect[0] = true;
                    updateUserScore(true);
                    p[0] = p[0] + 1;
                    trackProgress(p[0]);
                }
            } else {
                p[0] = p[0] + 1;
                isCorrect[0] = false;
                trackProgress(p[0]);
                if (!(trivScore <= 0) && p[0] < 11) {
                    updateUserScore(isCorrect[0]);
                }
            }
            if(p[0] == 10) {
                btn.setText("Return");
                group.setEnabled(false); group.setVisibility(View.INVISIBLE);
                btn.setOnClickListener(cardClicked -> {
                    if(rdMusic.isPlaying()) { rdMusic.pause(); rdMusic.release(); }
                    Intent returnT = new Intent(getApplicationContext(), PlayerInfo.class);
                    startActivity(returnT);
                });
            }
            trackProgress(nextProg);
        });
    }



    private void updateUserScore(boolean correct) {
        try {
            if (correct) {
                trivScore = trivScore + 5;
                score.setText("Score: " + trivScore);


            } else {
                if (!(trivScore <= 0)) {
                    trivScore = trivScore - 5;
                    score.setText("Score: " + trivScore);
                }
            }
        } catch (Exception uus) {
            uus.printStackTrace();
        }
    }

    private void displayRiddles() {
        for (int i = 0; i < riddles.size(); i++) {
            riddleDisplay.setText(riddles.get(1));
        }
    }


    private void displayRiddles(int p) {
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
                riddleDisplay.setText(riddles.get(7));
                break;
            case 7:
                riddleDisplay.setText(riddles.get(8));
                break;
            case 8:
                riddleDisplay.setText(riddles.get(9));
                break;
            case 9:
                riddleDisplay.setText(riddles.get(10));
                break;
            case 10:
                riddleDisplay.setText("Done!");
        }
    }

    private void displayRiddlesOption() {
        try {
            setOptionsText(riddleAnswer.get(1), "Head Eraser", "Cancel Head", "Mr. Mic", "Quirk Eraser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void displayRiddlesOption(int p) {
        try {
            switch (p) {
                case 1:
                    setOptionsText("July 5, 1997", riddleAnswer.get(2), "June 23, 1996",
                            "November 16, 1996", "March 1, 1997");
                    break;
                case 2:
                    setOptionsText("Oof", "UNO", riddleAnswer.get(3),
                            "FLD", "MOMMA");
                    break;
                case 3:
                    setOptionsText("The Goonies", "Texas Chainsaw Massacre", "Star Wars: Episode VI",
                            "Daddy Day Camp", riddleAnswer.get(4));
                    break;
                case 4:
                    setOptionsText("South Jordan", "Sandy", "West Valley City",
                            riddleAnswer.get(5), "Holladay");
                    break;
                case 5:
                    setOptionsText("A Dead Person's Blood", "Borax", "Silver Bullets",
                            riddleAnswer.get(6), "Machete");
                    break;
                case 6:
                    setOptionsText(riddleAnswer.get(7), "Dogs", "Elephants", "Ducks", "Heights");
                    break;
                case 7:
                    setOptionsText("Tom Hiddleston", "Tom Hanks", riddleAnswer.get(8), "Clint Eastwood",
                            "Bruce Willis");
                    break;
                case 8:
                    setOptionsText(riddleAnswer.get(9), "Marco Polo", "Beavis and Butthead",
                            "Stanley and Livingstone", "Burke and Willis");
                    break;
                case 9:
                    setOptionsText("Motion", "Gravity", riddleAnswer.get(10), "Friction", "Tension");
                    break;
                case 10:
                    setOptionsText("", "", "", "", "");
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


    private void setOptionsText(String op1, String op2, String op3, String op4, String op5) {
        r1.setText(op1); r2.setText(op2); r3.setText(op3); r4.setText(op4); r5.setText(op5);
    }
}