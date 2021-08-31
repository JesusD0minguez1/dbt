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
        retrieveScores();
    }



    /*
    Will retrieve stored scores from database and fill them into text views
    */
    private void retrieveScores()
    {
        ArrayList<Status> records =  database.readData();
        setScore1(records.get(0).score, records.get(0).uname);
        setScore2(records.sc, "TODO:UserName");
        setScore3("TODO:Score", "TODO:UserName");
    }



    /*
    Sets the three score views with inputted information given != null
    */
    private void setScore1(String newScore, String userName) {
        if(newScore != null && userName != null) {
            score1.setText("1. " + userName + " - " + newScore);
        }
    }
    private void setScore2(String newScore, String userName) {
        if(newScore != null && userName != null) {
            score2.setText("2. " + userName + " - " + newScore);
        }
    }
    private void setScore3(String newScore, String userName) {
        if(newScore != null && userName != null) {
            score3.setText("3. " + userName + " - " + newScore);
        }
    }
}
