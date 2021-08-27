package com.example.dbt;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Collections;


/*
Functionality plan -- Mat:
1. On the click of the start button shuffle imageIDs and then hide images so that we always start
 with a random set, then timer will start and you have to memorize the shapes
2. After timer ends, hide images and let the games begin
 */


public class MemoryGame extends AppCompatActivity {


    public TextView timer, scoreView, infoTxt, titleTxt;
    public ImageView card0, card1, card2, card3, card4, card5, card6, card7, card8;
    public Button returnBtn, startBtn, nextLvLBtn;
    public boolean gameStarted;
    Integer[] cards;
    private int clicked = 1, level = 1, totalMatches = 0, firstClicked, secondClicked, thirdClicked,
    firstPosition, secondPosition, thirdPosition, prevTag = 30, circle, triangle, square, cardBack,
    memScore, level1Score, level2Score, level3Score, totalScore = 0;
    MediaPlayer memMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);
        //Set next level if applicable
        Intent getLevel = getIntent();
        level = getLevel.getIntExtra("level", 0);
        totalScore = getLevel.getIntExtra("prevScore", 0);
        if (level == 0) { level = 1; }
        //Declare views
        timer = findViewById(R.id.timerView); scoreView = findViewById(R.id.scoreView);
        infoTxt = findViewById(R.id.memoryInfoText); titleTxt =findViewById(R.id.titleMemGame);
        if (level != 1) { infoTxt.setText("Level " + level); scoreView.setText("Score: " + totalScore);
        timer.setText("Timer: " + (4 - level)); }
        card0 = findViewById(R.id.card0); card0.setImageResource(R.drawable.card_back);
        card1 = findViewById(R.id.card1); card1.setImageResource(R.drawable.card_back);
        card2 = findViewById(R.id.card2); card2.setImageResource(R.drawable.card_back);
        card3 = findViewById(R.id.card3); card3.setImageResource(R.drawable.card_back);
        card4 = findViewById(R.id.card4); card4.setImageResource(R.drawable.card_back);
        card5 = findViewById(R.id.card5); card5.setImageResource(R.drawable.card_back);
        card6 = findViewById(R.id.card6); card6.setImageResource(R.drawable.card_back);
        card7 = findViewById(R.id.card7); card7.setImageResource(R.drawable.card_back);
        card8 = findViewById(R.id.card8); card8.setImageResource(R.drawable.card_back);
        returnBtn = findViewById(R.id.returnBtnMemory); startBtn = findViewById(R.id.startButtonMem);
        nextLvLBtn = findViewById(R.id.resetAcitivityBtn);
        gameStarted = false;
        //Settings menu
        ImageView settings = findViewById(R.id.settingsMem);
        memMusic = MediaPlayer.create(this.getApplicationContext(), R.raw.krabs_rave);
        try { memMusic.prepareAsync(); } catch (Exception prep) {prep.printStackTrace(); }
        settings.setOnClickListener(v -> { SettingMenu set = new SettingMenu(); set.showWindow(MemoryGame.this, settings, memMusic); });
    }


    /*
    Starts the game by saving current IDs, shuffling, saving to previousCardIDs,
    hides cards and then making them clickable while starting the timer
    */
    public void onStartBtnClick(View v) {
        try {
            //Checks to see if game is already started
            if(gameStarted == false) {
                //Set start button invisible
                startBtn.setVisibility(View.INVISIBLE);
                //Set card tags so we know their positions
                card0.setTag("0"); card1.setTag("1"); card2.setTag("2"); card3.setTag("3"); card4.setTag("4");
                card5.setTag("5"); card6.setTag("6"); card7.setTag("7"); card8.setTag("8");
                cards = getCards();
                /*
                Set on Click listeners
                 */
                card0.setOnClickListener(cardClicked -> {
                    int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                    cardClick(card0, currentTag);
                });
                card1.setOnClickListener(cardClicked -> {
                    int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                    cardClick(card1, currentTag);
                });
                card2.setOnClickListener(cardClicked -> {
                    int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                    cardClick(card2, currentTag);
                });
                card3.setOnClickListener(cardClicked -> {
                    int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                    cardClick(card3, currentTag);
                });
                card4.setOnClickListener(cardClicked -> {
                    int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                    cardClick(card4, currentTag);
                });
                card5.setOnClickListener(cardClicked -> {
                    int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                    cardClick(card5, currentTag);
                });
                card6.setOnClickListener(cardClicked -> {
                    int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                    cardClick(card6, currentTag);
                });
                card7.setOnClickListener(cardClicked -> {
                    int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                    cardClick(card7, currentTag);
                });
                card8.setOnClickListener(cardClicked -> {
                    int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                    cardClick(card8, currentTag);
                });
                setImageIds();
                Collections.shuffle(Arrays.asList(cards));
                showCards();
                switch (level) {
                    case 1:
                        countdown(3);
                        break;
                    case 2:
                        countdown(2);
                        break;
                    case 3:
                        countdown(1);
                        break;
                }
                gameStarted= true;
                memScore = 0;
            }
        }
        catch (Exception startBtn) { startBtn.printStackTrace(); }
    }


    /*
    Gives values to cards to match
    */
    private Integer[] getCards () {
        Integer[] cards;
        cards = new Integer[]{1, 2, 3, 11, 12, 13, 21, 22, 23};
        return cards;
    }


    /*
    Sets image ids of each corresponding shape
    */
    private void setImageIds() {
        circle = R.drawable.circle_card; square = R.drawable.square_card;
        triangle = R.drawable.triangle_card; cardBack = R.drawable.card_back;
    }


    /*
    On click checks if two cards are clicked then saves their position and tag to send to checkCorrect
     */
    private void cardClick(ImageView card, int cardTag) {
        if (cardTag != prevTag) {
            switch (cards[cardTag]) {
                case 1:
                case 11:
                case 21:
                    card.setImageResource(circle);
                    break;
                case 2:
                case 12:
                case 22:
                    card.setImageResource(square);
                    break;
                case 3:
                case 13:
                case 23:
                    card.setImageResource(triangle);
                    break;
            }
            switch (clicked) {
                case 1:
                    firstClicked = cards[cardTag];
                    if (firstClicked > 20) { firstClicked = firstClicked - 20; }
                    else if (firstClicked > 10) { firstClicked = firstClicked - 10; }
                    prevTag = cardTag;
                    clicked = 2;
                    firstPosition = cardTag;
                    break;
                case 2:
                    secondClicked = cards[cardTag];
                    if(secondClicked > 20) { secondClicked = secondClicked - 20; }
                    else if (secondClicked > 10) { secondClicked = secondClicked - 10; }

                    prevTag = cardTag;
                    clicked = 3;
                    secondPosition = cardTag;
                    break;
                case 3:
                    thirdClicked = cards[cardTag];
                    if (thirdClicked > 20) { thirdClicked = thirdClicked - 20; }
                    else if(thirdClicked > 10) { thirdClicked = thirdClicked -10; }
                    prevTag = 30;
                    clicked = 1;
                    thirdPosition = cardTag;
                    disableCards();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            checkCorrect();
                        }
                    }, 1000);
                    break;
            }
        }
    }


    private void checkCorrect() {
        if (firstClicked == secondClicked && firstClicked == thirdClicked && secondClicked == thirdClicked) {
            totalMatches += 1;
            hideSingleCard(firstPosition); hideSingleCard(secondPosition); hideSingleCard(thirdPosition);
            timer.setText("Correct!");
            setScore(true);
        }
        else { hideCards(); }
        if(firstClicked != secondClicked || firstClicked != thirdClicked || secondClicked != thirdClicked) {
            timer.setText("Incorrect!");
            hideCards();
            setScore(false);
        }
        enableCards();
        if (totalMatches == 3) { endGame(); }
    }


    /*
    Hide singular card based on position
    */
    private void hideSingleCard(int position) {
        switch (position) {
            case 0:
                card0.setEnabled(false);
                card0.setPadding(50, 50, 50, 50);
                break;
            case 1:
                card1.setEnabled(false);
                card1.setPadding(50, 50, 50, 50);
                break;
            case 2:
                card2.setEnabled(false);
                card2.setPadding(50, 50, 50, 50);
                break;
            case 3:
                card3.setEnabled(false);
                card3.setPadding(50, 50, 50, 50);
                break;
            case 4:
                card4.setEnabled(false);
                card4.setPadding(50, 50, 50, 50);
                break;
            case 5:
                card5.setEnabled(false);
                card5.setPadding(50, 50, 50, 50);
                break;
            case 6:
                card6.setEnabled(false);
                card6.setPadding(50, 50, 50, 50);
                break;
            case 7:
                card7.setEnabled(false);
                card7.setPadding(50, 50, 50, 50);
                break;
            case 8:
                card8.setEnabled(false);
                card8.setPadding(50, 50, 50, 50);
                break;
        }
    }


    /*
    As advertised
    */
    private void showCards() {
        ImageView card = findViewById(R.id.card0);
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case 0:
                    card = findViewById(R.id.card0);
                    break;
                case 1:
                    card = findViewById(R.id.card1);
                    break;
                case 2:
                    card = findViewById(R.id.card2);
                    break;
                case 3:
                    card = findViewById(R.id.card3);
                    break;
                case 4:
                    card = findViewById(R.id.card4);
                    break;
                case 5:
                    card = findViewById(R.id.card5);
                    break;
                case 6:
                    card = findViewById(R.id.card6);
                    break;
                case 7:
                    card = findViewById(R.id.card7);
                    break;
                case 8:
                    card = findViewById(R.id.card8);
                    break;
            }
            switch (cards[i]) {
                case 1:
                case 11:
                case 21:
                    card.setImageResource(circle);
                    break;
                case 2:
                case 12:
                case 22:
                    card.setImageResource(square);
                    break;
                case 3:
                case 13:
                case 23:
                    card.setImageResource(triangle);
                    break;
            }
        }

    }
    private void hideCards() {
        ImageView card = findViewById(R.id.card0);
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case 0:
                    card = findViewById(R.id.card0);
                    break;
                case 1:
                    card = findViewById(R.id.card1);
                    break;
                case 2:
                    card = findViewById(R.id.card2);
                    break;
                case 3:
                    card = findViewById(R.id.card3);
                    break;
                case 4:
                    card = findViewById(R.id.card4);
                    break;
                case 5:
                    card = findViewById(R.id.card5);
                    break;
                case 6:
                    card = findViewById(R.id.card6);
                    break;
                case 7:
                    card = findViewById(R.id.card7);
                    break;
                case 8:
                    card = findViewById(R.id.card8);
                    break;
            }
            if (card.getPaddingBottom() != 50) { card.setImageResource(R.drawable.card_back); }
        }
    }

    /*
    Also As advertised
    */
    private void enableCards() {
        card0.setEnabled(true); card1.setEnabled(true); card2.setEnabled(true); card3.setEnabled(true);
        card4.setEnabled(true); card5.setEnabled(true); card6.setEnabled(true); card7.setEnabled(true);
        card8.setEnabled(true);
    }
    private void disableCards() {
        card0.setEnabled(false); card1.setEnabled(false); card2.setEnabled(false); card3.setEnabled(false);
        card4.setEnabled(false); card5.setEnabled(false); card6.setEnabled(false); card7.setEnabled(false);
        card8.setEnabled(false);
    }


    /*
    Countdown courtesy of Joey:
    -Hides cards on finish
    */
    public void countdown(int time) {
        int milli = time * 1000;
        showCards();
        new CountDownTimer(milli, 1000) {
            public void onTick(long millisUntilFinished) { timer.setText("Timer: " + (millisUntilFinished / 1000)); }
            public void onFinish() {
                infoTxt.setText("Level: " + level);
                timer.setText("Good Luck!");
                hideCards();
            } }.start();
    }


    private void setScore(boolean isCorrect) {
        try {
            scoreView.setText("");
            if(isCorrect) { memScore += 100; }
            else {
                int newMemScore = memScore;
                if(newMemScore != 0 && newMemScore >= 100) { memScore -= 100; }
                else if(newMemScore < 100 && newMemScore != 0) { memScore = memScore - newMemScore; }
                else { memScore = 0; }
            }
            scoreView.setText("Score: " + (memScore + totalScore));
        }
        catch (Exception score) { score.printStackTrace(); }
    }


    /*
    Ends the game and displays the next button
    */
    private void endGame() {
        disableCards();
        card0.setAlpha(0.50f); card1.setAlpha(0.50f); card2.setAlpha(0.50f); card3.setAlpha(0.50f);
        card4.setAlpha(0.50f); card5.setAlpha(0.50f); card6.setAlpha(0.50f); card7.setAlpha(0.50f);
        card8.setAlpha(0.50f);
        returnBtn.setVisibility(View.VISIBLE);
        returnBtn.setOnClickListener(cardClicked -> {
            Intent playerInfo = new Intent(getApplicationContext(), PlayerInfo.class);
            playerInfo.putExtra("memScore", memScore);
            if(memMusic.isPlaying()) { memMusic.pause(); memMusic.release(); }
            startActivity(playerInfo);
        });
        timer.setText(""); infoTxt.setText("");
        if (scoreView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) scoreView.getLayoutParams();
            p.setMargins(120, 0, 56, 24);
            scoreView.requestLayout();
        }
        scoreView.setTextSize(36);
        if (titleTxt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) titleTxt.getLayoutParams();
            p.setMargins(38, 150, 37, 0);
            titleTxt.requestLayout();
        }
        if (level != 1) {
            if (memScore == 0) { titleTxt.setText("0 Points This Round??? Why??"); }
            else if (memScore == 100) { titleTxt.setText("100 Points This Round? Try again..."); }
            else if(memScore == 200) { titleTxt.setText("200 Points This Round? Not too bad."); }
            else if(memScore == 300) { titleTxt.setText("300 Points This Round, Amazing!"); }
        } else {
            if (memScore == 0) { titleTxt.setText("0 Points??? Why??"); }
            else if (memScore == 100) { titleTxt.setText("100 Points? Try again..."); }
            else if(memScore == 200) { titleTxt.setText("200 Points? Not too bad."); }
            else if(memScore == 300) { titleTxt.setText("300 Points, Amazing!"); }
        }

        if (level != 3) {
            nextLvLBtn.setVisibility(View.VISIBLE); nextLvLBtn.setOnClickListener(cardClicked -> resetGame());
        } else {
            nextLvLBtn.setVisibility(View.VISIBLE); nextLvLBtn.setOnClickListener(cardClicked -> resetGame());
            nextLvLBtn.setText("Reset");
        }
    }


    /*
    Resets everything to initial state for replay
     */
    private void resetGame() {
        Intent intent = getIntent();
        if (level == 3) { level = 1;}
        else { level++; }
        intent.putExtra("level", level);
        intent.putExtra("prevScore", (memScore + totalScore));
        finish();
        startActivity(intent);
    }
}