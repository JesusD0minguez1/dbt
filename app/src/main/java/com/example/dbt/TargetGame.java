/*
////////////////////////////
TARGET GAME -- BY: MATHEW
----------------------------
FUNCTIONALITY:
1.) Player clicks start which activates onStartClick()
2.) Game picks random positions and booleans to decide which target and where to display it
3.) Player needs to click green targets to get points
4.) Game finishes and return button is displayed after the mainCountdown() method finishes
////////////////////////////
 */

package com.example.dbt;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;


public class TargetGame extends AppCompatActivity {


    private TextView timerView, scoreView, infoTxt;
    private ImageView position1, position2, position3, position4, position5, position6, position7, position8,
            position9, settings;
    private Button startBtn, returnBtn;
    private MediaPlayer targetMusic;
    private Random rng = new Random();
    boolean gameIsGoing, cardIsDisplaying, targetIsRed;
    private int redTarget, greenTarget, targetScore, prevPosition = 0, secondCountDownTime = 3;


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
            mainCountdown(30);
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
        int rand = prevPosition; boolean readyToDisplay = false;
        while (rand == prevPosition || rand == 0) { rand = (rng.nextInt(8) + 1); }
        if(rand != prevPosition && rand != 0) { readyToDisplay = true; }
<<<<<<< Updated upstream
        boolean toDisplay = randomTarget();
        if(readyToDisplay) {
            prevPosition = rand;
            switch (rand) {
                case 1:
                    activatePosition(position1, toDisplay);
                    break;
                case 2:
                    activatePosition(position2, toDisplay);
                    break;
                case 3:
                    activatePosition(position3, toDisplay);
                    break;
                case 4:
                    activatePosition(position4, toDisplay);
                    break;
                case 5:
                    activatePosition(position5, toDisplay);
                    break;
                case 6:
                    activatePosition(position6, toDisplay);
                    break;
                case 7:
                    activatePosition(position7, toDisplay);
                    break;
                case 8:
                    activatePosition(position8, toDisplay);
                    break;
                case 9:
                    activatePosition(position9, toDisplay);
=======
        if(readyToDisplay == true) {
            prevPosition = rand;
            switch (rand) {
                case 1:
                    activatePosition(position1);
                    break;
                case 2:
                    activatePosition(position2);
                    break;
                case 3:
                    activatePosition(position3);
                    break;
                case 4:
                    activatePosition(position4);
                    break;
                case 5:
                    activatePosition(position5);
                    break;
                case 6:
                    activatePosition(position6);
                    break;
                case 7:
                    activatePosition(position7);
                    break;
                case 8:
                    activatePosition(position8);
                    break;
                case 9:
                    activatePosition(position9);
>>>>>>> Stashed changes
                    break;
            }
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
<<<<<<< Updated upstream
    Activates one position for play
    */
    private void activatePosition(ImageView position, boolean targetToPlay) {
        cardIsDisplaying = true;
        position.setEnabled(true);
        secondCountdown(secondCountDownTime, position, targetToPlay);
        boolean finalToDisplay9 = targetToPlay;
        position.setOnClickListener(cardClicked -> {
            onTargetClick(finalToDisplay9);
=======
    Activates one Position
    */
    private void activatePosition(ImageView position) {
        boolean toDisplay = randomTarget();
        cardIsDisplaying = true;
        position.setEnabled(true);
        secondCountdown(secondCountDownTime, position, toDisplay);
        boolean finalToDisplay = toDisplay;
        position.setOnClickListener(cardClicked -> {
            onTargetClick(finalToDisplay);
>>>>>>> Stashed changes
            position.setVisibility(View.INVISIBLE);
            cardIsDisplaying = false;
        });
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


    /*
    Displays the correct drawable at the correct position until time limit is hit or it is clicked
    */
    public void secondCountdown(int time, ImageView position, boolean drawableToDisplay) {
        if (drawableToDisplay) { position.setImageResource(R.drawable.good_target); targetIsRed = false; }
        else { position.setImageResource(R.drawable.bad_target); targetIsRed = true; }
        int milli = time * 1000;
        if (targetIsRed) { milli = milli - 1000; }
        position.setVisibility(View.VISIBLE);
        if (drawableToDisplay) { position.setImageResource(R.drawable.good_target); targetIsRed = false; }
        else { position.setImageResource(R.drawable.bad_target); targetIsRed = true; }
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