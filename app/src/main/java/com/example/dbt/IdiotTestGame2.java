package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IdiotTestGame2 extends AppCompatActivity {

    ImageView p1;
    ImageView p2;
    ImageView p3;
    ImageView p4;

    TextView timer;

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiot_test_game2);

        p1=findViewById(R.id.strawberry);
        p2=findViewById(R.id.alien);
        p3=findViewById(R.id.magician);
        p4=findViewById(R.id.almond);

        timer=findViewById(R.id.timer2);
        countdown(10);
    }

    public void RightAnswer2(View v)
    {
        Status.setDumbScore(2);
        cancel();
        Intent intent=new Intent(this,IdiotTestGame3.class);
        startActivity(intent);
    }

    public void WrongAnswer2(View v)
    {
        Intent intent=new Intent(this,IdiotTestGame3.class);
        startActivity(intent);
    }

    public final void cancel(){
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
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
                Intent intent=new Intent(getApplicationContext(),IdiotTestGame3.class);
                startActivity(intent);
            }
        }.start();
    }
}