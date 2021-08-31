package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GeneralGamover extends AppCompatActivity {
    Status status;
    TextView displayText;
    TextView congrats;
    ImageView gdSimon;
    Database database;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_gamover);
        Button gmSelect = findViewById(R.id.selectDiffbtn);
        Button gmQuit = findViewById(R.id.gmQuitbtn);
        Button gmLeader = findViewById(R.id.gmLeaderbtn);
        displayText = findViewById(R.id.displayGmOverScore);
        congrats = findViewById(R.id.Congrats);
        gdSimon = findViewById(R.id.goodSimon);
        status.game();
    }

    public void displayGameOverScore()
    {
        String simonScore = String.valueOf(status.getSimonScore());
        String memoryScore = String.valueOf(status.getMemoryScore());
        String triviaScore = String.valueOf(status.getTriviaScore());
        String isekaiScore = String.valueOf(status.getIsekaiScore());
        String dumbScore = String.valueOf(status.getDumbScore());
        String targetScore = String.valueOf(status.getTargetScore());

        String GmOverTxt = "Your final score is ";
        String simonTxt = "Congratulations in completing Simon in order to reward here is a picture of Good Simon";
        if(status.simonEnd == true)
        {
            displayText.setText(GmOverTxt + simonScore);
            congrats.setText(simonTxt);
            gdSimon.setVisibility(View.VISIBLE);
        }
        if(status.memoryEnd == true) { displayText.setText(GmOverTxt + memoryScore); }
        if(status.triviaEnd == true) { displayText.setText(GmOverTxt + triviaScore); }
        if(status.isekaiEnd == true) { displayText.setText(GmOverTxt + isekaiScore); }
        if(status.targetEnd == true) { displayText.setText(GmOverTxt + targetScore); }
        if(status.dumbEnd == true) { displayText.setText(GmOverTxt + dumbScore); }
    }
    public void gmSelectDiff(View v)
    {
        Intent toSelectgm = new Intent(getApplicationContext(), PlayerInfo.class);
        startActivity(toSelectgm);
    }

    public void saveToLdbd(View v)
    {
        if(status.fromSimonGO)
        {
            type = status.typeOfGame.get(1);
            database.addNewEntry(status.getPlayerName(),type,status.getSimonScore());
            status.fromSimonGO = false;
        }
        if(status.fromMemory)
        {
            type = status.typeOfGame.get(2);
            database.addNewEntry(status.getPlayerName(),type,status.getMemoryScore());
            status.fromMemory = false;
        }
        if(status.fromTargetGame)
        {
            type = status.typeOfGame.get(3);
            database.addNewEntry(status.getPlayerName(),type,status.getTargetScore());
            status.fromTargetGame = false;
        }
        if(status.fromIsekai)
        {
            type = status.typeOfGame.get(4);
            database.addNewEntry(status.getPlayerName(),type,status.getIsekaiScore());
            status.fromIsekai = false;
        }
        if(status.fromTrivia)
        {
            type = status.typeOfGame.get(5);
            database.addNewEntry(status.getPlayerName(),type,status.getTriviaScore());
            status.fromIsekai = false;
        }
        congrats.setText("YOU HAVE SUCCESSFULLY SAVED THE RECORD");
    }

    public void closeApp (View v){ finishAffinity(); }
}