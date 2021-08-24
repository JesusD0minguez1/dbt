package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Simon extends AppCompatActivity {
    private int counter = 0;
    ArrayList<Integer>CorrectAnswers = new ArrayList<>();
    ArrayList<Integer>UsersAnswers = new ArrayList<>();

    ImageView g1; //grabbing green images
    ImageView g2;
    ImageView g3;
    ImageView g4;

    ImageView r1;  //grabbing red images
    ImageView r2;
    ImageView r3;
    ImageView r4;
    Button returnBtnSimon;

    int score = 0;
    static boolean NextPattern = false;
    static int LetsGo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simon);
        //grabbing green images
        g1 = findViewById(R.id.g1);
        g2 = findViewById(R.id.g2);
        g3 = findViewById(R.id.g3);
        g4 = findViewById(R.id.g4);
        //grabbing red images
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        Button test = findViewById(R.id.startSimon);
        //set all the red squares to invisible
        r1.setVisibility(View.INVISIBLE);
        r2.setVisibility(View.INVISIBLE);
        r3.setVisibility(View.INVISIBLE);
        r4.setVisibility(View.INVISIBLE);
        //Return Button
        returnBtnSimon = findViewById(R.id.returnBtnSimon);
        returnBtnSimon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View cardClicked) {
                Intent returnToPlayerInfo = new Intent(getApplicationContext(), PlayerInfo.class);
                startActivity(returnToPlayerInfo);
            }
        });
        //Settings
        ImageView settings = findViewById(R.id.simonSettings);
        MediaPlayer simonMusic = MediaPlayer.create(this.getApplicationContext(), R.raw.riddle);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingMenu set = new SettingMenu();
                set.showWindow(Simon.this, settings, simonMusic);
            }
        });
    }

    public void SimonGo(View v){
       switch(LetsGo)
       {
           case 0:
               Pattern(6,1000);
               if(NextPattern == true){ LetsGo++; }
           break;
           case 1:
               Pattern2(6,750);
               if(NextPattern == true){ LetsGo ++; }
           break;
           case 2:
               Pattern3(6,520);
               if(NextPattern == true){ LetsGo +=1; }
           break;
           case 3:
               Pattern4(7,350);
               if(NextPattern == true){ LetsGo +=1; }
           break;
           case 4:
               Pattern5(6,150);
               if(NextPattern == true){ LetsGo +=1; }
           break;
           case 5:
               if(NextPattern == true){ LetsGo = 0; }
           break;
       }
   }
    public void check(View v){
       switch (v.getId())
       {
           case R.id.g1:
               patternSet(g1,r1,2);
               UsersAnswers.add(1);
               if(UsersAnswers.size() == CorrectAnswers.size())
               {
                   if(UsersAnswers.equals(CorrectAnswers)){ checkCorrectConditional();}
                   else{ checkWrongConditional(); }
               }
           break;
           case R.id.g2:
               patternSet(g2,r2,2);
               UsersAnswers.add(2);
               if(UsersAnswers.size() == CorrectAnswers.size())
               {
                   if(UsersAnswers.equals(CorrectAnswers)){ checkCorrectConditional();}
                   else{ checkWrongConditional(); }
               }
               break;
           case R.id.g3:
               patternSet(g3,r3,2);
               UsersAnswers.add(3);

               if(UsersAnswers.size() == CorrectAnswers.size())
               {
                   if(UsersAnswers.equals(CorrectAnswers)){ checkCorrectConditional();}
                   else{ checkWrongConditional(); }
               }
               break;
           case R.id.g4:
               patternSet(g4,r4,2);
               UsersAnswers.add(4);
               if(UsersAnswers.size() == CorrectAnswers.size())
               {
                   if(UsersAnswers.equals(CorrectAnswers)){ checkCorrectConditional();}
                   else{ checkWrongConditional(); }
               }
               break;
       }
   }
    public void Pattern(int time, int interval) {
        int milli = time * 1000;
        final int[] p = {0};
        new CountDownTimer(milli, interval) {
            public void onTick(long millisUntilFinished) {
                p[0] = p[0] + 1;
                switch (p[0]) {
                    case 2:
                        patternSet(g1,r1,1);
                        CorrectAnswers.add(1);
                    break;
                    case 3:
                        patternSet(g2,r2,1);
                        CorrectAnswers.add(2);
                    break;
                    case 4:
                        patternSet(g3,r3,1);
                        CorrectAnswers.add(3);
                    break;
                    case 5:
                        patternSet(g4,r4,1);
                        CorrectAnswers.add(4);
                    break;
                }
            }
            public void onFinish() {
            }
        }.start();
}
    public void Pattern2(int time, int interval) {
        int milli = time * 1000;
        final int[] p = {0};
        int t;
        new CountDownTimer(milli, interval) {
            public void onTick(long millisUntilFinished) {
                p[0] = p[0] + 1;
                switch (p[0]) {
                    case 2:
                        patternSet(g2,r2,1);
                        CorrectAnswers.add(2);
                    break;
                    case 3:
                        patternSet(g4,r4,1);
                        CorrectAnswers.add(4);
                    break;
                    case 4:
                        patternSet(g1,r1,1);
                        CorrectAnswers.add(1);
                    break;
                    case 5:
                        patternSet(g3,r3,1);
                        CorrectAnswers.add(3);
                    break;
                }
            }
            public void onFinish() {
            }
        }.start();

}
    public void Pattern3(int time, int interval) {
        int milli = time * 1000;
        final int[] p = {0};
        int t;
        new CountDownTimer(milli, interval) {
            public void onTick(long millisUntilFinished) {
                p[0] = p[0] + 1;
                switch (p[0]) {
                    case 2:
                        patternSet(g4,r4,1);
                        CorrectAnswers.add(2);
                        break;
                    case 3:
                        patternSet(g3,r3,1);
                        CorrectAnswers.add(4);
                        break;
                    case 4:
                        patternSet(g2,r2,1);
                        CorrectAnswers.add(1);
                        break;
                    case 5:
                        patternSet(g1,r1,1);
                        CorrectAnswers.add(3);
                        break;
                }
            }
            public void onFinish(){}
        }.start();

    }
    public void Pattern4(int time, int interval) {
        int milli = time * 1000;
        final int[] p = {0};
        int t;
        new CountDownTimer(milli, interval) {
            public void onTick(long millisUntilFinished) {
                p[0] = p[0] + 1;
                switch (p[0]) {
                    case 2:
                        patternSet(g2,r2,1);
                        CorrectAnswers.add(2);
                        break;
                    case 3:
                        patternSet(g3,r3,1);
                        CorrectAnswers.add(4);
                        break;
                    case 4:
                        patternSet(g1,r1,1);
                        CorrectAnswers.add(1);
                        break;
                    case 5:
                        patternSet(g4,r4,1);
                        CorrectAnswers.add(3);
                        break;
                }
            }
            public void onFinish() {
            }
        }.start();

    }
    public void Pattern5(int time, int interval) {
        int milli = time * 1000;
        final int[] p = {0};
        int t;
        new CountDownTimer(milli, interval) {
            public void onTick(long millisUntilFinished) {
                p[0] = p[0] + 1;
                switch (p[0]) {
                    case 2:
                        patternSet(g1,r1,1);
                        CorrectAnswers.add(2);
                        break;
                    case 3:
                        patternSet(g4,r4,1);
                        CorrectAnswers.add(4);
                        break;
                    case 4:
                        patternSet(g2,r2,1);
                        CorrectAnswers.add(1);
                        break;
                    case 5:
                        patternSet(g3,r3,1);
                        CorrectAnswers.add(3);
                        break;
                }
            }
            public void onFinish() {
            }
        }.start();

    }
    public void displaySimonScore(int score) {
        TextView scoreDisplay = findViewById(R.id.simonScore);
        String scoreBeingSet = String.valueOf(score);
        scoreDisplay.setText("Score: " + scoreBeingSet);
    }
    public void checkCorrectConditional(){
        score += 100;
        UsersAnswers.clear();
        CorrectAnswers.clear();
        NextPattern = true;
        displaySimonScore(score);
    }
    public void checkWrongConditional() {
        score = score - 100;
        UsersAnswers.clear();
        displaySimonScore(score);
    }
    public void patternSet(ImageView g, ImageView r,int time) {
        g.setVisibility(View.INVISIBLE);
        r.setVisibility(View.VISIBLE);
        int milli = time * 1000;
        final int[] p = {0};
        int t;
        new CountDownTimer(milli, 100) {
            public void onTick(long millisUntilFinished) {
                p[0] = p[0] + 1;
                switch (p[0]) {
                    case 2:
                        g.setVisibility(View.VISIBLE);
                        r.setVisibility(View.INVISIBLE);
                        break;
                }
            }
            public void onFinish() {
            }
        }.start();
    }
}
