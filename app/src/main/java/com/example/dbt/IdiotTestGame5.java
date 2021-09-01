package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IdiotTestGame5 extends AppCompatActivity {

    ImageView p1;
    ImageView p2;
    ImageView p3;
    ImageView p4;

    TextView timer;

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiot_test_game5);

        p1=findViewById(R.id.jj);
        p2=findViewById(R.id.kk);
        p3=findViewById(R.id.ll);
        p4=findViewById(R.id.mm);

        timer=findViewById(R.id.timer5);
        countdown(10);
    }

    public final void cancel(){
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }

    public void RightAnswer(View v)
    {
        
        cancel();
        Intent intent=new Intent(this,GeneralGamover.class);
        startActivity(intent);
        Status.fromDumb=true;
        Status.dumbEnd=true;
    }
    public void WrongAnswer4(View v)
    {
        cancel();
        Intent intent=new Intent(this,GeneralGamover.class);
        startActivity(intent);
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
                Intent intent=new Intent(getApplicationContext(),GeneralGamover.class);
                startActivity(intent);
            }
        }.start();
    }

}