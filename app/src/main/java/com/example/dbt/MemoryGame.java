package com.example.dbt;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;


/*
Functionality plan -- Mat:
1. On the click of the start button shuffle imageIDs and then hide images so that we always start
 with a random set, then timer will start and you have to memorize the shapes
2. After timer ends, hide images and let the games begin
 */


public class MemoryGame extends FileManager {


    public TextView timer, score, infoTxt;
    public ImageView card1, card2, card3, card4, card5, card6;



    /*
    Android studio gives each image a unique integer which we can use to identify which shapes
    were where and where they are now.
    */
    private int circleID = R.drawable.circle_card, triangleID = R.drawable.triangle_card,
            squareID = R.drawable.square_card, cardBackID = R.drawable.card_back;


    public Button nxtBtn;
    public boolean cardsClickable;
    public boolean isGameOver;


    //Array of the card ImageViews just for easy access
    public ArrayList<Integer> cards = new ArrayList<Integer>();
    //Save to list using saveIDs() anytime a change is created
    public ArrayList<Integer> currentCardIDs  = new ArrayList<>();;
    //Used to store previous IDs while hiding cards so that we know which card is which shape
    public ArrayList<Integer> previousCardIDs  = new ArrayList<>();;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);


        //Declare views
        timer = findViewById(R.id.timerView);
        score = findViewById(R.id.scoreView);
        infoTxt = findViewById(R.id.memoryInfoText);
        card1 = findViewById(R.id.card1);
        card1.setImageResource(R.drawable.circle_card);
        card1.setTag(R.drawable.circle_card);
        card2 = findViewById(R.id.card2);
        card2.setImageResource(R.drawable.triangle_card);
        card2.setTag(R.drawable.triangle_card);
        card3 = findViewById(R.id.card3);
        card3.setImageResource(R.drawable.square_card);
        card3.setTag(R.drawable.square_card);
        card4 = findViewById(R.id.card4);
        card4.setImageResource(R.drawable.square_card);
        card4.setTag(R.drawable.square_card);
        card5 = findViewById(R.id.card5);
        card5.setImageResource(R.drawable.triangle_card);
        card5.setTag(R.drawable.triangle_card);
        card6 = findViewById(R.id.card6);
        card6.setImageResource(R.drawable.circle_card);
        card6.setTag(R.drawable.circle_card);
        nxtBtn = findViewById(R.id.nxtBtnMemory);


        //Turning cardsClickable to false;
        cardsClickable = false;
        isGameOver = false;
    }


    /*
    Saves IDs to given list (currentCardIDs, previousCardIDs)
    */
    private void saveIDs(ArrayList<Integer> listToSaveTo) {
        try {
            if (!listToSaveTo.isEmpty()) {
                listToSaveTo.clear();
            }
            for(int i = 0; i < cards.size(); i++) {
                ImageView card = findViewById(cards.get(i));
                if (card.getTag().equals(circleID)) {
                    listToSaveTo.add(circleID);
                }
                else if (card.getTag().equals(squareID)) {
                    listToSaveTo.add(squareID);
                }
                else if(card.getTag().equals(triangleID)) {
                    listToSaveTo.add(triangleID);
                }
                else {
                    listToSaveTo.add(cardBackID);
                }
            }
        }
        catch (Exception cci) {
            cci.printStackTrace();
        }
    }


    /*
    Starts the game by saving current IDs, shuffling, saving to previousCardIDs,
    hides cards and then making them clickable while starting the timer
    */
    public void onStartBtnClick(View v) {
        try {
            //Create array cards :: CAUSING ISSUES NEEDS FIXING
            cards.add(findViewById(R.id.card1).getId()); cards.add(findViewById(R.id.card2).getId());
            cards.add(findViewById(R.id.card3).getId()); cards.add(findViewById(R.id.card4).getId());
            cards.add(findViewById(R.id.card5).getId()); cards.add(findViewById(R.id.card6).getId());
            System.out.print("HERE \n---------------------\n " +cards.get(0).toString());
            //Shuffle card IDs, save and hide
            saveIDs(currentCardIDs);
            shuffleCardIDs(currentCardIDs);
            saveIDs(previousCardIDs);
            shuffleCardIDs(currentCardIDs);
            saveIDs(currentCardIDs);
            showCards();
            countdown(5);
            cardsClickable = true;
        }
        catch (Exception startBtn) {
            startBtn.printStackTrace();
        }
    }

    //Work in progress: theoretically flips the card that you click
    public void onCardClick(View cardClicked) {
        ImageView card = (ImageView) cardClicked;
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).equals(cardClicked.getId())) {
                flipCard(card, i);
            }
        }
    }


    /*
    Flips card and then counts the amount of flipped cards, if greater than two check for pairs.
    If cards match doesn't hide them again, if they don't match it will re-hide them.
    */
    private void flipCard(ImageView card, int index) {
        try {
                if(cardsClickable) {

                    int countFlipped = 0;
                    for(int i = 0; i < cards.size(); i++) {
                        if(currentCardIDs.get(i) == cardBackID) {
                            countFlipped++;
                        }
                    }
                    if(countFlipped >= 2) {
                        //checkMatchingPairs();
                    }
                    if( card.getTag().equals(R.drawable.card_back)) {
                        card.setImageResource(previousCardIDs.get(index));
                        card.setTag(previousCardIDs.get(index));
                    }
                    else {
                        card.setImageResource(R.drawable.card_back);
                        card.setTag(R.drawable.card_back);
                    }
                    saveIDs(currentCardIDs);
                }
        }
        catch (Exception fc) {
            fc.printStackTrace();
        }
    }


    /*
    Uses Java 'Collections' library to shuffle given list of integers
    lists we use this on are: previousCardIDs and currentCardIDs.
    */
    private void shuffleCardIDs(ArrayList<Integer> listToShuffle) {
        Collections.shuffle(listToShuffle);
    }


    /*
    Saves all card shape values to previousCardIDs then sets all cards to flipped;
    */
    private void hideCards() {
        try {
            saveIDs(previousCardIDs);
            ImageView card;
            for(int i = 0; i < cards.size(); i++) {
                card = findViewById(cards.get(i));
                card.setImageResource(R.drawable.card_back);
                card.setTag(R.drawable.card_back);
            }
        }
        catch (Exception hC) {
            hC.printStackTrace();
        }
    }


    /*
    Sets one card to flipped and then saves to current IDs
    */
    private void hideOneCard(int idToHide) {
        try {
            ImageView card;
            card = findViewById(cards.get(idToHide));
            card.setImageResource(R.drawable.card_back);
            card.setTag(R.drawable.card_back);
            saveIDs(currentCardIDs);
        }
        catch (Exception hoc) {
            hoc.printStackTrace();
        }
    }


    /*
    Sets the image resources of all cards to their previous IDs (AKA Their shapes) then saves to
    current IDs
    */
    private void showCards() {
        try {
            ImageView card;
            for(int i = 0; i < cards.size(); i++) {
                card = findViewById(cards.get(i));
                card.setImageResource(previousCardIDs.get(i));
                card.setTag(previousCardIDs.get(i));
            }
            saveIDs(currentCardIDs);
        }
        catch (Exception showCards) {
            showCards.printStackTrace();
        }
    }


    /*
    Creates two array lists of the index and IDs of cards that are flipped, then
    checks if they have the same shape ID.
     */
    private void checkMatchingPairs() {
        try {
            ArrayList<Integer> tempIDs = new ArrayList<Integer>();
            int countFlipped = 0;
            ArrayList<Integer> tempIndexes = new ArrayList<Integer>();
            for (int i = 0; i < cards.size(); i++) {
                if(currentCardIDs.get(i) != cardBackID) {
                    countFlipped += 1;
                    tempIndexes.add(i);
                }
            }
            for (int j = 0; j < countFlipped; j++) {
                tempIDs.add(currentCardIDs.get(j));
            }
            for (int k = 0; k < tempIDs.size(); k++) {
                for (int o = 0; o < tempIDs.size(); o++) {
                    if(tempIDs.get(k) == tempIDs.get(o)) {
                        setUserScore(getUserScore() + 5);
                    }
                    else {
                        if(getUserScore() != 0)
                        setUserScore(getUserScore() - 5);
                        for(int p = 0; p < tempIndexes.size(); p++) {
                            hideOneCard(cards.get(p));
                        }
                    }
                }
            }
        }
        catch (Exception cmp) {
            cmp.printStackTrace();
        }
    }


    //Only show Next button after the game is over
    private void displayNextButton() {
        try {
            if(isGameOver = true) {
                nxtBtn.setVisibility(View.VISIBLE);
            }
        }
        catch (Exception dnb) {
            dnb.printStackTrace();
        }
    }


    public void countdown(int time) {
        int milli = time * 1000;

        new CountDownTimer(milli, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText((millisUntilFinished / 1000) + "");
            }

            public void onFinish() {
                timer.setText("Time's up!");
                hideCards();
            }
        }.start();
    }
}