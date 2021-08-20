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
    public ImageView card0, card1, card2, card3, card4, card5;
    private int circle, triangle, square, cardBack;
    public Button nxtBtn, startBtn;
    public boolean gameStarted;
    //Array of the card ImageViews just for easy access
    Integer[] cards;
    //Count cards clicked for checking correct
    private int clicked = 1;
    private int totalMatches = 0;
    private int firstClicked, secondClicked;
    private int firstPosition, secondPosition;
    private int prevTag = 10;


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
        nxtBtn = findViewById(R.id.nxtBtnMemory);
        startBtn = findViewById(R.id.startButtonMem);


        gameStarted = false;
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
                card5.setTag("5");
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
                setImageIds();
                Collections.shuffle(Arrays.asList(cards));
                showCards();
                countdown(5);
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
        cards = new Integer[]{1, 2, 3, 11, 12, 13};
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
            }
            if (clicked == 1) {
                firstClicked = cards[cardTag];
                if (firstClicked > 10) {
                    firstClicked = firstClicked - 10;
                }
                prevTag = cardTag;
                clicked = 2;
                firstPosition = cardTag;
            }
            else if (clicked == 2) {
                secondClicked = cards[cardTag];
                if (secondClicked > 10) {
                    secondClicked = secondClicked - 10;
                }
                prevTag = 10;
                clicked = 1;
                secondPosition = cardTag;
                disableCards();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        checkCorrect();
                    }
                }, 1000);
            }
        }
    }


    private void checkCorrect() {
        if (firstClicked == secondClicked) {
            totalMatches += 1;
            if (firstPosition == 0) {
                card0.setEnabled(false);
                card0.setPadding(50, 50, 50, 50);
                //card0.setVisibility(View.INVISIBLE);
            }
            else if (firstPosition == 1) {
                card1.setEnabled(false);
                card1.setPadding(50, 50, 50, 50);
                //card1.setVisibility(View.INVISIBLE);
            }
            else if (firstPosition == 2) {
                card2.setEnabled(false);
                card2.setPadding(50, 50, 50, 50);
                //card2.setVisibility(View.INVISIBLE);
            }
            else if (firstPosition == 3) {
                card3.setEnabled(false);
                card3.setPadding(50, 50, 50, 50);
                //card3.setVisibility(View.INVISIBLE);
            }
            else if (firstPosition == 4) {
                card4.setEnabled(false);
                card4.setPadding(50, 50, 50, 50);
                //card4.setVisibility(View.INVISIBLE);
            }
            else if (firstPosition == 5) {
                card5.setEnabled(false);
                card5.setPadding(50, 50, 50, 50);
                //card5.setVisibility(View.INVISIBLE);
            }
            if (secondPosition == 0) {
                card0.setEnabled(false);
                card0.setPadding(50, 50, 50, 50);
                //card0.setVisibility(View.INVISIBLE);
            }
            else if (secondPosition == 1) {
                card1.setEnabled(false);
                card1.setPadding(50, 50, 50, 50);
                //card1.setVisibility(View.INVISIBLE);
            }
            else if (secondPosition == 2) {
                card2.setEnabled(false);
                card2.setPadding(50, 50, 50, 50);
                //card2.setVisibility(View.INVISIBLE);
            }
            else if (secondPosition == 3) {
                card3.setEnabled(false);
                card3.setPadding(50, 50, 50, 50);
                //card3.setVisibility(View.INVISIBLE);
            }
            else if (secondPosition == 4) {
                card4.setEnabled(false);
                card4.setPadding(50, 50, 50, 50);
                //card4.setVisibility(View.INVISIBLE);
            }
            else if (secondPosition == 5) {
                card5.setEnabled(false);
                card5.setPadding(50, 50, 50, 50);
                //card5.setVisibility(View.INVISIBLE);
            }
            infoTxt.setText("Correct!");
            //TODO Add whatever amount to user's score
        }
        else {
            hideCards();
        }
        if(firstClicked != secondClicked) {
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
        for (int i = 0; i < 6; i++) {
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
            }
            if (cards[i] == 1) {
                card.setImageResource(circle);
            }
            else if(cards[i] == 2) {
                card.setImageResource(square);
            }
            else if(cards[i] == 3) {
                card.setImageResource(triangle);
            }
            else if(cards[i] == 11) {
                card.setImageResource(circle);
            }
            else if(cards[i] == 12) {
                card.setImageResource(square);
            }
            else if(cards[i] == 13) {
                card.setImageResource(triangle);
            }
        }

    }
    private void hideCards() {
        if(card0.getPaddingBottom() != 50) {
            card0.setImageResource(R.drawable.card_back);
        }
        if(card1.getPaddingBottom() != 50) {
            card1.setImageResource(R.drawable.card_back);
        }
        if(card2.getPaddingBottom() != 50) {
            card2.setImageResource(R.drawable.card_back);
        }
        if(card3.getPaddingBottom() != 50) {
            card3.setImageResource(R.drawable.card_back);
        }
        if(card4.getPaddingBottom() != 50) {
            card4.setImageResource(R.drawable.card_back);
        }
        if(card5.getPaddingBottom() != 50) {
            card5.setImageResource(R.drawable.card_back);
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
    }
    private void disableCards() {
        card0.setEnabled(false);
        card1.setEnabled(false);
        card2.setEnabled(false);
        card3.setEnabled(false);
        card4.setEnabled(false);
        card5.setEnabled(false);
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
        nxtBtn.setVisibility(View.VISIBLE);
        timer.setText("Game Over!");
    }


    public void nextActivityMemory(View v) {
        //TODO Someone please implement this
        //Button B12 = findViewById(R.id.nxtBtnMemory);
        //Intent action12 = new Intent(getApplicationContext(), MemoryGame.class);
        //startActivity(action12);
    }


    public void settingsMem(View v)
    {
        ImageView settings = findViewById(R.id.settingsMem);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingMenu set = new SettingMenu();
                set.showWindow(MemoryGame.this, settings);
            }
        });
    }
}