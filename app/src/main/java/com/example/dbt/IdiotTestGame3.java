package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IdiotTestGame3 extends AppCompatActivity {

    ImageView p1;
    ImageView p2;
    ImageView p3;
    ImageView p4;
    ImageView p5;
    ImageView p6;

    TextView timer;

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiot_test_game3);

        p1=findViewById(R.id.letterO);
        p2=findViewById(R.id.letterR);
        p3=findViewById(R.id.letterD);
        p4=findViewById(R.id.letterB);
        p5=findViewById(R.id.letterE);
        p6=findViewById(R.id.letterR2);

        timer=findViewById(R.id.timer3);
        countdown(10);

    }

    public void countdown(int time)
    {
        int milli = time * 1000;

        new CountDownTimer(milli, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Timer: " + (millisUntilFinished / 1000));
            }

            public void onFinish() {
                timer.setText("Time's up!");
                Intent intent=new Intent(getApplicationContext(),IdiotTestGame4.class);
                startActivity(intent);
            }
        }.start();
    }

    public void RightAnswer3(View v)
    {

        cancel();
        Intent intent=new Intent(this,IdiotTestGame4.class);
        startActivity(intent);
    }

    public void WrongAnswer3(View v)
    {
        cancel();
        Intent intent=new Intent(this,IdiotTestGame4.class);
        startActivity(intent);
    }

    public final void cancel(){
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }
}