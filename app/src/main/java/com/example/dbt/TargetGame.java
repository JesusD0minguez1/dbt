/*
////////////////////////////
TARGET GAME -- BY: MATHEW
----------------------------
FUNCTIONALITY:
1.) Player clicks start which activates onStartClick()
2.) Game picks random positions and booleans to decide which target and where to display it
3.) Player needs to click green targets to get points
4.) Gamme finishes and return button is displayed after the mainCountdown() method finishes
////////////////////////////
 */

package com.example.dbt;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TargetGame extends MainActivity {


    private TextView timerView, scoreView, infoTxt;
    private ImageView position1, position2, position3, position4, position5, position6, position7, position8,
            position9, settings;
    private Button startBtn, returnBtn;
    private MediaPlayer targetMusic;
    private Random rng = new Random();
    boolean gameIsGoing, cardIsDisplaying;
    private int redTarget, greenTarget, targetScore;
    private ArrayList<Integer> times = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8));


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.target_game);


        timerView = findViewById(R.id.tTimerView); scoreView = findViewById(R.id.tScoreView);
        infoTxt = findViewById(R.id.targetInfoTxt); startBtn = findViewById(R.id.startButtonTarg);
        returnBtn = findViewById(R.id.returnBtnTarget);
        position1 = findViewById(R.id.position1); position2 = findViewById(R.id.position2);
        position3 = findViewById(R.id.position3); position4 = findViewById(R.id.position4);
        position5 = findViewById(R.id.position5); position6 = findViewById(R.id.position6);
        position7 = findViewById(R.id.position7); position8 = findViewById(R.id.position8);
        position9 = findViewById(R.id.position9);
        greenTarget = R.drawable.good_target; redTarget = R.drawable.bad_target;
        returnBtn.setVisibility(View.INVISIBLE);

        //Settings Menu && Music
        settings = findViewById(R.id.settingsTarg);
        targetMusic = MediaPlayer.create(this.getApplicationContext(), R.raw.break_the_targets);
        try { targetMusic.prepareAsync(); } catch (Exception prep) {prep.printStackTrace(); }
        settings.setOnClickListener(v -> { SettingMenu set = new SettingMenu(); set.showWindow(TargetGame.this, settings, targetMusic); });
    }


    /*
    Starts the game
    */
    public void onStartClick(View v) {
        try {
            startBtn.setVisibility(View.INVISIBLE);
            returnBtn.setEnabled(false);
            returnBtn.setVisibility(View.INVISIBLE);
            position1.setTag("1"); position2.setTag("2"); position3.setTag("3"); position4.setTag("4");
            position5.setTag("5"); position6.setTag("6"); position7.setTag("7"); position8.setTag("8");
            position9.setTag("9");
            position1.setVisibility(View.INVISIBLE); position2.setVisibility(View.INVISIBLE); position3.setVisibility(View.INVISIBLE); position4.setVisibility(View.INVISIBLE);
            position5.setVisibility(View.INVISIBLE); position6.setVisibility(View.INVISIBLE); position7.setVisibility(View.INVISIBLE); position8.setVisibility(View.INVISIBLE);
            position9.setVisibility(View.INVISIBLE);
            gameIsGoing = true;
            if(!targetMusic.isPlaying()) { targetMusic.start(); }
            mainCountdown(10);
            pickRandomPosition();

        }
        catch(Exception start) { start.printStackTrace(); }
    }


    /*
    Checks the drawable and sets score based on that
    */
    private void onTargetClick(boolean drawable) {
        if (drawable) { setScore(true); }
        else { setScore(false); }
    }


    /*
    Sets targetScore and scoreView
    */
    private void setScore(boolean isCorrect) {
        try {
            scoreView.setText("");
            if(isCorrect) { targetScore += 100; }
            else {
                int newTargScore = targetScore;
                if(newTargScore != 0 && newTargScore >= 100) { targetScore -= 100; }
                else if(newTargScore < 100 && newTargScore != 0) { targetScore = targetScore - newTargScore; }
                else { targetScore = 0; }
            }
            scoreView.setText("Score: " + targetScore);
        }
        catch (Exception score) { score.printStackTrace(); }
    }


    /*
    Picks random position and sets visible with random target
    */
    private void pickRandomPosition() {
        int rand = 0;
        while (rand == 0) { rand = (rng.nextInt(10) - 1); }
        boolean toDisplay = false;
        switch (rand) {
            case 1:
                cardIsDisplaying = true;
                toDisplay = randomTarget();
                position1.setEnabled(true);
                secondCountdown(2, position1, toDisplay);
                boolean finalToDisplay1 = toDisplay;
                position1.setOnClickListener(cardClicked -> {
                    onTargetClick(finalToDisplay1);
                    position1.setVisibility(View.INVISIBLE);
                    cardIsDisplaying = false;
                });
                break;
            case 2:
                cardIsDisplaying = true;
                toDisplay = randomTarget();
                position2.setEnabled(true);
                secondCountdown(2, position2, toDisplay);
                boolean finalToDisplay2 = toDisplay;
                position2.setOnClickListener(cardClicked -> {
                    onTargetClick(finalToDisplay2);
                    position2.setVisibility(View.INVISIBLE);
                    cardIsDisplaying = false;
                });
                break;
            case 3:
                cardIsDisplaying = true;
                toDisplay = randomTarget();
                position3.setEnabled(true);
                secondCountdown(2, position3, toDisplay);
                boolean finalToDisplay3 = toDisplay;
                position3.setOnClickListener(cardClicked -> {
                    onTargetClick(finalToDisplay3);
                    position3.setVisibility(View.INVISIBLE);
                    cardIsDisplaying = false;
                });
                break;
            case 4:
                cardIsDisplaying = true;
                toDisplay = randomTarget();
                position4.setEnabled(true);
                secondCountdown(2, position4, toDisplay);
                boolean finalToDisplay4 = toDisplay;
                position4.setOnClickListener(cardClicked -> {
                    onTargetClick(finalToDisplay4);
                    position4.setVisibility(View.INVISIBLE);
                    cardIsDisplaying = false;
                });
                break;
            case 5:
                cardIsDisplaying = true;
                toDisplay = randomTarget();
                position5.setEnabled(true);
                secondCountdown(2, position5, toDisplay);
                boolean finalToDisplay5 = toDisplay;
                position6.setOnClickListener(cardClicked -> {
                    onTargetClick(finalToDisplay5);
                    position5.setVisibility(View.INVISIBLE);
                    cardIsDisplaying = false;
                });
                break;
            case 6:
                cardIsDisplaying = true;
                toDisplay = randomTarget();
                position6.setEnabled(true);
                secondCountdown(2, position6, toDisplay);
                boolean finalToDisplay6 = toDisplay;
                position6.setOnClickListener(cardClicked -> {
                    onTargetClick(finalToDisplay6);
                    position6.setVisibility(View.INVISIBLE);
                    cardIsDisplaying = false;
                });
                break;
            case 7:
                cardIsDisplaying = true;
                toDisplay = randomTarget();
                position7.setEnabled(true);
                secondCountdown(2, position7, toDisplay);
                boolean finalToDisplay7 = toDisplay;
                position7.setOnClickListener(cardClicked -> {
                    onTargetClick(finalToDisplay7);
                    position7.setVisibility(View.INVISIBLE);
                    cardIsDisplaying = false;
                });
                break;
            case 8:
                cardIsDisplaying = true;
                toDisplay = randomTarget();
                position8.setEnabled(true);
                secondCountdown(2, position3, toDisplay);
                boolean finalToDisplay8 = toDisplay;
                position8.setOnClickListener(cardClicked -> {
                    onTargetClick(finalToDisplay8);
                    position8.setVisibility(View.INVISIBLE);
                    cardIsDisplaying = false;
                });
                break;
            case 9:
                cardIsDisplaying = true;
                toDisplay = randomTarget();
                position9.setEnabled(true);
                secondCountdown(2, position9, toDisplay);
                boolean finalToDisplay9 = toDisplay;
                position9.setOnClickListener(cardClicked -> {
                    onTargetClick(finalToDisplay9);
                    position9.setVisibility(View.INVISIBLE);
                    cardIsDisplaying = false;
                });
                break;
        }
    }


    /*
    Picks random boolean: if true green target, if false red target
     */
    private boolean randomTarget() { return rng.nextBoolean(); }


    /*
    Makes all positions non-clickable
     */
    private void disableAllPositions() {
        position1.setEnabled(false); position2.setEnabled(false); position3.setEnabled(false);
        position4.setEnabled(false); position5.setEnabled(false); position6.setEnabled(false);
        position7.setEnabled(false); position8.setEnabled(false); position9.setEnabled(false);
    }


    /*
    Countdown(s) courtesy of Joey:
    -Sets gameIsGoing to true on start and then false on end;
    */
    public void mainCountdown(int time) {
        int milli = time * 1000;
        new CountDownTimer(milli, 1000) {
            public void onTick(long millisUntilFinished) {
                if (!cardIsDisplaying) { pickRandomPosition(); }
                timerView.setText("Timer: " + (millisUntilFinished / 1000));
            }
            public void onFinish() {  endGame(); } }.start();
    }
    public void secondCountdown(int time, ImageView position, boolean drawableToDisplay) {
        int milli = time * 1000;
        position.setVisibility(View.VISIBLE);
        if (drawableToDisplay) { position.setImageResource(R.drawable.good_target); }
        else { position.setImageResource(R.drawable.bad_target); }
        new CountDownTimer(milli, 1000) {
            public void onTick(long millisUntilFinished) { }
            public void onFinish() {
                if(position.getVisibility() == View.VISIBLE) { position.setVisibility(View.INVISIBLE); }
                if(position.isEnabled()) { position.setEnabled(false); cardIsDisplaying = false; }
            } }.start();
    }


    /*
Ends the game and displays the next button
*/
    private void endGame() {
        disableAllPositions();
        gameIsGoing = false;
        returnBtn.setEnabled(true);
        returnBtn.setVisibility(View.VISIBLE);
        returnBtn.setOnClickListener(cardClicked -> {
            Intent playerInfo = new Intent(getApplicationContext(), PlayerInfo.class);
            if(targetMusic.isPlaying()) { targetMusic.pause(); targetMusic.release(); }
            startActivity(playerInfo);
        });
        timerView.setText(""); infoTxt.setText("Game Over!");
    }
}