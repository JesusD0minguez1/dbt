package com.example.dbt;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class HighScores extends MainActivity {


    Button returnBtn;
    TextView score1, score2, score3;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_scores);

        //Set views
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        score3 = findViewById(R.id.score3);
        //SetHighScoreTXT();

        returnBtn = findViewById(R.id.returnBtnHighScores);
        //Set return btn listener onCreate
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                Intent playerInfo = new Intent(getApplicationContext(), PlayerInfo.class);
                startActivity(playerInfo);
            }
        });
        //Retrieve scores
    }



    /*
    Will retrieve stored scores from database and fill them into text views
    */



    /*
    Sets the three score views with inputted information given != null
    */
    /*public void SetHighScoreTXT() {
        ArrayList<Status> records = database.readData();
        score1.setText("1. " + records.get(0).uname + " - " + "Game: "+ records.get(0).tog + "Score: " + records.get(0).score);
        score2.setText("2. " + records.get(1).uname + " - " + "Game: "+ records.get(1).tog  + "Score: " + records.get(1).score);
        score1.setText("3. " + records.get(2).uname + " - " + "Game: "+ records.get(2).tog + "Score: " + records.get(2).score);

    }
*/
}
