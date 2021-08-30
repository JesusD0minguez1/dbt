package com.example.dbt;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectDifficulty extends AppCompatActivity {
    boolean isItEasy = false;
    boolean isItMedium = false;
    boolean isItHard = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_difficulty);
    }

    public void choseEasy(View v)
    {
        isItEasy = true;
        Intent easy = new Intent(getApplicationContext(), Simon.class);
        easy.putExtra("easy",isItEasy);
        startActivity(easy);
    }

    public void choseMedium(View v)
    {
        isItMedium = true;
        Intent medium = new Intent(getApplicationContext(),Simon.class);
        medium.putExtra("medium",isItMedium);
        startActivity(medium);
    }

    public void choseHard(View v)
    {
        isItHard = true;
        Intent hard = new Intent(getApplicationContext(),Simon.class);
        hard.putExtra("Hard",isItHard);
        startActivity(hard);
    }
}