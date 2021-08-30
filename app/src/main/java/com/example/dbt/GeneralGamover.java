package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GeneralGamover extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_gamover);
        Button gmSelect = findViewById(R.id.selectDiffbtn);
        Button gmQuit = findViewById(R.id.gmQuitbtn);
        Button gmLeader = findViewById(R.id.gmLeaderbtn);
    }

    public void gmSelectDiff(View v)
    {
        Intent toSelectgm = new Intent(getApplicationContext(), PlayerInfo.class);
        startActivity(toSelectgm);
    }

    public void gmLeaderbd(View v)
    {
        Intent toLeaderbd = new Intent(getApplicationContext(), HighScores.class);
        startActivity(toLeaderbd);
    }

    public void closeApp (View v){ finishAffinity(); }
}