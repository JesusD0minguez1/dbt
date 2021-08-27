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


    private ImageView memGameIcon, triviaGameIcon, simonGameIcon, highScoresIcon, idiotTestIcon;
    private EditText userName;
    MediaPlayer playerInfoMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);


        //Get score from memGame
        Intent getScore = getIntent();
        int memScore = getScore.getIntExtra("memScore", 0);
        System.out.println("HERE -- " + memScore);


        //set view for username
        userName = findViewById(R.id.userName);
        //Memory Game
        memGameIcon = findViewById(R.id.memGameIcon);
        memGameIcon.setOnClickListener(cardClicked -> {
            try {
                if(checkUserName() == true) {
                    sendUserName(); musicRelease();
                    Intent memGame = new Intent(getApplicationContext(), MemoryGame.class);
                    startActivity(memGame);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        //Trivia Game
        triviaGameIcon = findViewById(R.id.triviaGameIcon);
        triviaGameIcon.setOnClickListener(cardClicked -> {
            try {
                if(checkUserName() == true) {
                    sendUserName(); musicRelease();
                    Intent triviaGame = new Intent(getApplicationContext(), RiddleScreen.class);
                    startActivity(triviaGame);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        //Simon Game
        simonGameIcon = findViewById(R.id.simonGameIcon);
        simonGameIcon.setOnClickListener(cardClicked -> {
            try {
                if(checkUserName() == true) {
                    sendUserName(); musicRelease();
                    Intent simonGame = new Intent(getApplicationContext(), Simon.class);
                    startActivity(simonGame);
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        });
        //High Scores Screen
        highScoresIcon = findViewById(R.id.highScoresIcon);
        highScoresIcon.setOnClickListener(cardClicked -> {
            try {
                if(checkUserName() == true) {
                    sendUserName(); musicRelease();
                    Intent simonGame = new Intent(getApplicationContext(), HighScores.class);
                    startActivity(simonGame);
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        });
        //Ping Pong Game
        idiotTestIcon = findViewById(R.id.idiotTestGameIcon);
        idiotTestIcon.setOnClickListener(cardClicked -> {
            try {
                if(checkUserName() == true) {
                    sendUserName(); musicRelease();
                    /*
                    Intent simonGame = new Intent(getApplicationContext(), HighScores.class);
                    startActivity(simonGame);
                     */
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        });
        //Settings
        ImageView settings = findViewById(R.id.settings1);
        playerInfoMusic = MediaPlayer.create(this.getApplicationContext(), R.raw.one_heroes_journey);
        try { playerInfoMusic.prepareAsync(); } catch (Exception prep) {prep.printStackTrace(); }
        settings.setOnClickListener(v -> {
            SettingMenu set = new SettingMenu();
            set.showWindow(PlayerInfo.this, settings, playerInfoMusic);
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


    /*
    Stops and releases music before sending to next activity just in case
    (also saves resources)
     */
    private void musicRelease() { if(playerInfoMusic.isPlaying()) { playerInfoMusic.pause(); playerInfoMusic.release(); } }
}