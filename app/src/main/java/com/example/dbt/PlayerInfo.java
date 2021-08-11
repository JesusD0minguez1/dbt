package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class PlayerInfo extends FileManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);
        Button B5 =findViewById(R.id.button5);
    }

    public  void nextActivity(View v)
    {
        Intent action2 = new Intent(getApplicationContext(), RiddleScreen.class);
        startActivity(action2);
    }


    public void CreatePopUp(View v)
    {
        PopupWindow popUp = new PopupWindow();
        popUp.setWidth(500);
        popUp.setHeight(500);
    }

}