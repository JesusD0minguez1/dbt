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
        displayText = findViewById(R.id.displayGmOverScore);
        congrats = findViewById(R.id.Congrats);
        gdSimon = findViewById(R.id.goodSimon11);
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
        if(Status.simonEnd == true)
        {
            displayText.setText(GmOverTxt + simonScore);
            congrats.setText(simonTxt);
            gdSimon.setVisibility(View.VISIBLE);
            setBackEnds();
        }
        if(Status.memoryEnd == true)
        {
            displayText.setText(GmOverTxt + memoryScore);
            setBackEnds();
        }
        if(Status.triviaEnd == true)
        {
            displayText.setText(GmOverTxt + triviaScore);
            setBackEnds();
        }

        if(Status.isekaiEnd == true)
        {
            displayText.setText(GmOverTxt + isekaiScore);
            setBackEnds();
        }
        if(Status.targetEnd == true)
        {
            displayText.setText(GmOverTxt + targetScore);
            setBackEnds();
        }
        if(Status.dumbEnd == true)
        {
            displayText.setText(GmOverTxt + dumbScore);
            setBackEnds();
        }
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
            setFromEndBack();
        }
        if(status.fromMemory)
        {
            type = status.typeOfGame.get(2);
            database.addNewEntry(status.getPlayerName(),type,status.getMemoryScore());
            setFromEndBack();
        }
        if(status.fromTargetGame)
        {
            type = status.typeOfGame.get(3);
            database.addNewEntry(status.getPlayerName(),type,status.getTargetScore());
            setFromEndBack();
        }
        if(status.fromIsekai)
        {
            type = status.typeOfGame.get(4);
            database.addNewEntry(status.getPlayerName(),type,status.getIsekaiScore());
            setFromEndBack();
        }
        if(status.fromTrivia)
        {
            type = status.typeOfGame.get(5);
            database.addNewEntry(status.getPlayerName(),type,status.getTriviaScore());
            setFromEndBack();
        }
        congrats.setText("YOU HAVE SUCCESSFULLY SAVED THE RECORD");
    }

    public void closeApp (View v){ finishAffinity(); }
    private void setBackEnds()
    {
        Status.targetEnd = false;
        Status.triviaEnd = false;
        Status.isekaiEnd = false;
        Status.memoryEnd = false;
        Status.dumbEnd = false;
        Status.simonEnd = false;
    }

    private void setFromEndBack()
    {
        Status.fromIsekai = false;
        Status.fromMemory = false;
        Status.fromTrivia = false;
        Status.fromTargetGame = false;
        Status.fromDumb = false;
        Status.fromSimonGO = false;
    }
}