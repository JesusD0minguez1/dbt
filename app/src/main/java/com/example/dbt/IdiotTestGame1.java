package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IdiotTestGame1 extends AppCompatActivity {

    ImageView p1;
    ImageView p2;
    ImageView p3;
    ImageView p4;

    TextView timer;

    CountDownTimer countDownTimer;

    static int scoreForDT=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiot_test_game1);

        p1=findViewById(R.id.kungfu);
        p2=findViewById(R.id.arts);
        p3=findViewById(R.id.wedding);
        p4=findViewById(R.id.karate);

        timer=findViewById(R.id.timer);
        countdown(12);
    }

    public void RightAnswer(View v)
    {
        scoreForDT++;
        cancel();
        Intent intent=new Intent(this,IdiotTestGame2.class);
        startActivity(intent);
    }

    public void WrongAnswer(View v)
    {
        Intent intent=new Intent(this,IdiotTestGame2.class);
        startActivity(intent);
        cancel();
    }

    public final void cancel(){
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }

    public void countdown(int time)
    {
        int milli = time * 1000;

        countDownTimer=new CountDownTimer(milli, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Timer: " + (millisUntilFinished / 1000));
            }

            public void onFinish() {
                timer.setText("Time's up!");
                Intent intent=new Intent(getApplicationContext(),IdiotTestGame2.class);
                startActivity(intent);
                cancel();
            }
        }.start();
    }


}