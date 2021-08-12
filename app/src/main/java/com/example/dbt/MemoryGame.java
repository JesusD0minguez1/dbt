package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MemoryGame extends FileManager {

    private TextView timer, score, infoTxt;
    private ImageView card1, card2, card3, card4, card5, card6;
    private int circleID = R.drawable.circle_card, triangleID = R.drawable.triangle_card,
    squareID = R.drawable.square_card;
    private Button nxtBtn;


    private ArrayList<ImageView> cards = new ArrayList<ImageView>();
    private ArrayList<Integer> cardsSavedIDs = new ArrayList<Integer>();



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


    private void shuffleCards() {
        Collections.shuffle(cards);
    }


    private void hideCards() {
        try {
            for(int i = 0; i < cards.size(); i++) {
                if (!cardsSavedIDs.isEmpty()) {
                    cardsSavedIDs.clear();
                }
                cardsSavedIDs.add(cards.get(i).getId());
                cards.get(i).setImageResource(R.drawable.card_back);
            }
        }
        catch (Exception hC) {
            hC.printStackTrace();
        }
    }
}