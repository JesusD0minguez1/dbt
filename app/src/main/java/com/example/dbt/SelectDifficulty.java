package com.example.dbt;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectDifficulty extends AppCompatActivity {
    Status status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_difficulty);
    }

    public void choseEasy(View v)
    {
        status.isItEasy = true;
        Intent easy = new Intent(getApplicationContext(), Simon.class);
        startActivity(easy);
    }

    public void choseMedium(View v)
    {
        status.isItMedium = true;
        Intent medium = new Intent(getApplicationContext(),Simon.class);
        startActivity(medium);
    }


    public void choseHard(View v)
    {
        status.isItHard = true;
        Intent hard = new Intent(getApplicationContext(),Simon.class);
        startActivity(hard);
    }
}