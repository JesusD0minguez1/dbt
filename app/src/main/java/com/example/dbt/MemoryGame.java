package com.example.dbt;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;


/*
Functionality plan -- Mat:
1. On the click of the start button shuffle imageIDs and then hide images so that we always start
 with a random set, then timer will start and you have to memorize the shapes
2. After timer ends, hide images and let the games begin
 */


public class MemoryGame extends FileManager {


    public TextView timer, score, infoTxt;
    public ImageView card0, card1, card2, card3, card4, card5, card6, card7, card8;
    private int circle, triangle, square, cardBack;
    public Button returnBtn, startBtn;
    public boolean gameStarted;
    //Array of the card ImageViews just for easy access
    Integer[] cards;
    //Count cards clicked for checking correct
    private int clicked = 1;
    private int totalMatches = 0;
    private int firstClicked, secondClicked, thirdClicked;
    private int firstPosition, secondPosition, thirdPosition;
    private int prevTag = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);


        //Declare views
        timer = findViewById(R.id.timerView);
        score = findViewById(R.id.scoreView);
        infoTxt = findViewById(R.id.memoryInfoText);
        card0 = findViewById(R.id.card0);
        card0.setImageResource(R.drawable.card_back);
        card1 = findViewById(R.id.card1);
        card1.setImageResource(R.drawable.card_back);
        card2 = findViewById(R.id.card2);
        card2.setImageResource(R.drawable.card_back);
        card3 = findViewById(R.id.card3);
        card3.setImageResource(R.drawable.card_back);
        card4 = findViewById(R.id.card4);
        card4.setImageResource(R.drawable.card_back);
        card5 = findViewById(R.id.card5);
        card5.setImageResource(R.drawable.card_back);
        card6 = findViewById(R.id.card6);
        card6.setImageResource(R.drawable.card_back);
        card7 = findViewById(R.id.card7);
        card7.setImageResource(R.drawable.card_back);
        card8 = findViewById(R.id.card8);
        card8.setImageResource(R.drawable.card_back);
        returnBtn = findViewById(R.id.returnBtnMemory);
        startBtn = findViewById(R.id.startButtonMem);


        gameStarted = false;


        //Settings menu
        ImageView settings = findViewById(R.id.settingsMem);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingMenu set = new SettingMenu();
                set.showWindow(MemoryGame.this, settings);
            }
        });
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
                card0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View cardClicked) {
                        int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                        cardClick(card0, currentTag);
                    }
                });
                card1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View cardClicked) {
                        int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                        cardClick(card1, currentTag);
                    }
                });
                card2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View cardClicked) {
                        int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                        cardClick(card2, currentTag);
                    }
                });
                card3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View cardClicked) {
                        int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                        cardClick(card3, currentTag);
                    }
                });
                card4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View cardClicked) {
                        int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                        cardClick(card4, currentTag);
                    }
                });
                card5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View cardClicked) {
                        int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                        cardClick(card5, currentTag);
                    }
                });
                card6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View cardClicked) {
                        int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                        cardClick(card6, currentTag);
                    }
                });
                card7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View cardClicked) {
                        int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                        cardClick(card7, currentTag);
                    }
                });
                card8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View cardClicked) {
                        int currentTag = (Integer.parseInt((String) cardClicked.getTag()));
                        cardClick(card8, currentTag);
                    }
                });
                setImageIds();
                Collections.shuffle(Arrays.asList(cards));
                showCards();
                countdown(3);
                gameStarted= true;
            }
        }
        catch (Exception startBtn) {
            startBtn.printStackTrace();
        }
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
        circle = R.drawable.circle_card;
        square = R.drawable.square_card;
        triangle = R.drawable.triangle_card;
        cardBack = R.drawable.card_back;
    }


    /*
    On click checks if two cards are clicked then saves their position and tag to send to checkCorrect
     */
    private void cardClick(ImageView card, int cardTag) {
        if (cardTag != prevTag) {
            switch (cards[cardTag]) {
                case 1:
                    card.setImageResource(circle);
                    break;
                case 2:
                    card.setImageResource(square);
                    break;
                case 3:
                    card.setImageResource(triangle);
                    break;
                case 11:
                    card.setImageResource(circle);
                    break;
                case 12:
                    card.setImageResource(square);
                    break;
                case 13:
                    card.setImageResource(triangle);
                    break;
                case 21:
                    card.setImageResource(circle);
                    break;
                case 22:
                    card.setImageResource(square);
                    break;
                case 23:
                    card.setImageResource(triangle);
            }
            switch (clicked) {
                case 1:
                    firstClicked = cards[cardTag];
                    if (firstClicked > 20) {
                        firstClicked = firstClicked - 20;
                    }
                    else if (firstClicked > 10) {
                        firstClicked = firstClicked - 10;
                    }
                    prevTag = cardTag;
                    clicked = 2;
                    firstPosition = cardTag;
                    break;
                case 2:
                    secondClicked = cards[cardTag];
                    if(secondClicked > 20) {
                        secondClicked = secondClicked - 20;
                    }
                    else if (secondClicked > 10) {
                        secondClicked = secondClicked - 10;
                    }

                    prevTag = cardTag;
                    clicked = 3;
                    secondPosition = cardTag;
                    break;
                case 3:
                    thirdClicked = cards[cardTag];
                    if (thirdClicked > 20) {
                        thirdClicked = thirdClicked - 20;
                    }
                    else if(thirdClicked > 10) {
                        thirdClicked = thirdClicked -10;
                    }
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
            switch (firstPosition) {
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
            switch (secondPosition) {
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
            switch (thirdPosition) {
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
            infoTxt.setText("Correct!");
            //TODO Add whatever amount to user's score
        }
        else {
            hideCards();
        }
        if(firstClicked != secondClicked || firstClicked != thirdClicked || secondClicked != thirdClicked) {
            infoTxt.setText("Incorrect!");
            hideCards();
            //TODO Remove whatever amount from user's score
        }
        enableCards();
        if (totalMatches == 3) {
            endGame();
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
                    card.setImageResource(circle);
                    break;
                case 2:
                    card.setImageResource(square);
                    break;
                case 3:
                    card.setImageResource(triangle);
                    break;
                case 11:
                    card.setImageResource(circle);
                    break;
                case 12:
                    card.setImageResource(square);
                    break;
                case 13:
                    card.setImageResource(triangle);
                    break;
                case 21:
                    card.setImageResource(circle);
                    break;
                case 22:
                    card.setImageResource(square);
                    break;
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
            if (card.getPaddingBottom() != 50) {
                card.setImageResource(R.drawable.card_back);
            }
        }
    }

    /*
    Also As advertised
    */
    private void enableCards() {
        card0.setEnabled(true);
        card1.setEnabled(true);
        card2.setEnabled(true);
        card3.setEnabled(true);
        card4.setEnabled(true);
        card5.setEnabled(true);
        card6.setEnabled(true);
        card7.setEnabled(true);
        card8.setEnabled(true);
    }
    private void disableCards() {
        card0.setEnabled(false);
        card1.setEnabled(false);
        card2.setEnabled(false);
        card3.setEnabled(false);
        card4.setEnabled(false);
        card5.setEnabled(false);
        card6.setEnabled(false);
        card7.setEnabled(false);
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

            public void onTick(long millisUntilFinished) {
                timer.setText((millisUntilFinished / 1000) + "");
            }

            public void onFinish() {
                infoTxt.setText("Time's up!");
                timer.setText("");
                hideCards();
            }
        }.start();
    }


    /*
    Ends the game and displays the next button
    */
    private void endGame() {
        disableCards();
        returnBtn.setVisibility(View.VISIBLE);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                Intent playerInfo = new Intent(getApplicationContext(), PlayerInfo.class);
                startActivity(playerInfo);
            }
        });
        timer.setText("Game Over!");
    }
}