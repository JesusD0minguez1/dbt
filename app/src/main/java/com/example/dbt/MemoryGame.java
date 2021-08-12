package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MemoryGame extends FileManager {

    private TextView timer;
    private TextView score;
    private TextView infoTxt;
    private ImageView card1;
    private ImageView card2;
    private ImageView card3;
    private ImageView card4;
    private ImageView card5;
    private ImageView card6;
    private Button nxtBtn;


    private ArrayList<ImageView> cards = new ArrayList<ImageView>();


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


    private void onCardClick() {

    }
}