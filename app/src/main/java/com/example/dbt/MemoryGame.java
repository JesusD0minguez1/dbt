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
1. onCreate shuffle imageIDs and then hide images so that we always start with a random set
2. onClick of the ready button images will then flip and show the shapes on a timer
3. after timer is up hide images and let the memory game begin
 */


public class MemoryGame extends FileManager {
    

    private TextView timer, score, infoTxt;
    private ImageView card1, card2, card3, card4, card5, card6;
    private int circleID = R.drawable.circle_card, triangleID = R.drawable.triangle_card,
    squareID = R.drawable.square_card;
    private Button nxtBtn;


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


        //Shuffle card IDs, save and hide
        saveIDs(currentCardIDs);
        shuffleCardIDs(currentCardIDs);
        saveIDs(previousCardIDs);
        hideCards();
    }


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


    private void onCardClick(View v) {
        int viewID = v.getId();
        switch (viewID) {
            case 1:
                flipCard(card1);
                return;
            case 2:
                flipCard(card2);
                return;
            case 3:
                flipCard(card3);
                return;
            case 4:
                flipCard(card4);
                return;
            case 5:
                flipCard(card5);
                return;
            case 6:
                flipCard(card6);
                return;
        }
    }


    private void flipCard(ImageView card) {
        try {

        }
        catch (Exception fc) {
            fc.printStackTrace();
        }
    }


    private void shuffleCardIDs(ArrayList<Integer> listToShuffle) {
        Collections.shuffle(listToShuffle);
    }


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
}