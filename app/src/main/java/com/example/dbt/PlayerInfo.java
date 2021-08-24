package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class PlayerInfo extends AppCompatActivity {


    private ImageView memGameIcon, triviaGameIcon, simonGameIcon, highScoresIcon, pingPongIcon;
    private EditText userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);


        //set view for username
        userName = findViewById(R.id.userName);
        //Memory Game
        memGameIcon = findViewById(R.id.memGameIcon);
        memGameIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                try {
                    if(checkUserName() == true) {
                        sendUserName();
                        Intent memGame = new Intent(getApplicationContext(), MemoryGame.class);
                        startActivity(memGame);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //Trivia Game
        triviaGameIcon = findViewById(R.id.triviaGameIcon);
        triviaGameIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                try {
                    if(checkUserName() == true) {
                        sendUserName();
                        Intent triviaGame = new Intent(getApplicationContext(), RiddleScreen.class);
                        startActivity(triviaGame);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //Simon Game
        simonGameIcon = findViewById(R.id.simonGameIcon);
        simonGameIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                try {
                    if(checkUserName() == true) {
                        sendUserName();
                        Intent simonGame = new Intent(getApplicationContext(), Simon.class);
                        startActivity(simonGame);
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //High Scores Screen
        highScoresIcon = findViewById(R.id.highScoresIcon);
        highScoresIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                try {
                    if(checkUserName() == true) {
                        sendUserName();
                        Intent simonGame = new Intent(getApplicationContext(), HighScores.class);
                        startActivity(simonGame);
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //Ping Pong Game
        pingPongIcon = findViewById(R.id.pingPongGameIcon);
        pingPongIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                try {
                    if(checkUserName() == true) {
                        sendUserName();
                        /*
                        Intent simonGame = new Intent(getApplicationContext(), HighScores.class);
                        startActivity(simonGame);
                         */
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //Settings
        ImageView settings = findViewById(R.id.settings1);
        MediaPlayer playerInfoMusic = MediaPlayer.create(this.getApplicationContext(), R.raw.riddle);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingMenu set = new SettingMenu();
                set.showWindow(PlayerInfo.this, settings, playerInfoMusic);
            }
        });
    }


    /*
    Get inputted name and send to database
    */
    private void sendUserName() {
        //TODO: send user name to database
    }


    /*
    Check userName not empty or unchanged
    */
    private boolean checkUserName() {
        if(userName.getText().length() == 0) {
            userName.setHint("Please enter user name");
            return false;
        }
        else {
            return true;
        }
    }
}