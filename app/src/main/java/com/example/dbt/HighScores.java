package com.example.dbt;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HighScores extends MainActivity {


    Button returnBtn;
    TextView score1, score2, score3;


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
    private void retrieveScores() {
        //TODO: Retrieve scores from database and fill into these methods
        setScore1("TODO:Score", "TODO:UserName");
        setScore2("TODO:Score", "TODO:UserName");
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
