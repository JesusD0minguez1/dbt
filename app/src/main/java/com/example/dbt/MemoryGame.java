package com.example.dbt;


import android.os.Bundle;
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


    private TextView timer, score, infoTxt;
    private ImageView card1, card2, card3, card4, card5, card6;



    /*
    Android studio gives each image a unique integer which we can use to identify which shapes
    were where and where they are now.
    */
    private int circleID = R.drawable.circle_card, triangleID = R.drawable.triangle_card,
            squareID = R.drawable.square_card, cardBackID = R.drawable.card_back;


    private Button nxtBtn;
    private boolean cardsClickable;
    private boolean isGameOver;


    //Array of the card ImageViews just for easy access
    private ArrayList<ImageView> cards = new ArrayList<ImageView>();
    //Save to list using saveIDs() anytime a change is created
    private ArrayList<Integer> currentCardIDs = new ArrayList<Integer>();
    //Used to store previous IDs while hiding cards so that we know which card is which shape
    private ArrayList<Integer> previousCardIDs = new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);


        //Declare views
        timer = findViewById(R.id.timerView);
        score = findViewById(R.id.scoreView);
        infoTxt = findViewById(R.id.memoryInfoText);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        nxtBtn = findViewById(R.id.nxtBtnMemory);


        //Create array cards
        cards.add(card1); cards.add(card2); cards.add(card3); cards.add(card4);
        cards.add(card5); cards.add(card6);


        //Turning cardsClickable to false;
        cardsClickable = false;
        isGameOver = false;
    }


    /*
    Saves IDs to given list (currentCardIDs, previousCardIDs)
    */
    private void saveIDs(ArrayList<Integer> listToSaveTo) {
        try {
            for(int i = 0; i < cards.size(); i++) {
                if (!listToSaveTo.isEmpty()) {
                    listToSaveTo.clear();
                }
                listToSaveTo.add(cards.get(i).getId());
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
    private void onStartBtnClick(View v) {
        try {
            //Shuffle card IDs, save and hide
            saveIDs(currentCardIDs);
            shuffleCardIDs(currentCardIDs);
            saveIDs(previousCardIDs);
            showCards();
            cardsClickable = true;
            //TODO: timer()
            displayTimer();
            hideCards();
        }
        catch (Exception startBtn) {
            startBtn.printStackTrace();
        }
    }

    //Work in progress: theoretically flips the card that you click
    private void onCardClick(View v) {
        int viewID = v.getId();
        int countFlipped = 0;
        switch (viewID) {
            case 1:
                flipCard(currentCardIDs.get(0), 0);
                return;
            case 2:
                flipCard(currentCardIDs.get(1), 1);
                return;
            case 3:
                flipCard(currentCardIDs.get(2), 2);
                return;
            case 4:
                flipCard(currentCardIDs.get(3), 3);
                return;
            case 5:
                flipCard(currentCardIDs.get(4), 4);
                return;
            case 6:
                flipCard(currentCardIDs.get(5), 5);
                return;
        }
    }


    /*
    Flips card and then counts the amount of flipped cards, if greater than two check for pairs.
    If cards match doesn't hide them again, if they don't match it will re-hide them.
    */
    private void flipCard(int cardID, int index) {
        try {
                if(cardsClickable) {
                    int countFlipped = 0;
                    for(int i = 0; i < cards.size(); i++) {
                        if(currentCardIDs.get(i) == cardBackID) {
                            countFlipped++;
                        }
                    }
                    if(countFlipped >= 2) {
                        checkMatchingPairs();
                    }
                    if( cardID == R.drawable.card_back) {
                        cards.get(index).setImageResource(previousCardIDs.get(index));
                    }
                    else {
                        cards.get(index).setImageResource(cardBackID);
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
            for(int i = 0; i < cards.size(); i++) {
                cards.get(i).setImageResource(R.drawable.card_back);
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
            cards.get(idToHide).setImageResource(R.drawable.card_back);
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
            for(int i = 0; i < cards.size(); i++) {
                cards.get(i).setImageResource(previousCardIDs.get(i));
            }
            saveIDs(currentCardIDs);
        }
        catch (Exception showCards) {
            showCards.printStackTrace();
        }
    }


    private void displayTimer() {
        timer.setText(time);
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
                            hideOneCard(cards.get(p).getId());
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
}