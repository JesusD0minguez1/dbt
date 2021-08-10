package com.example.dbt;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FileManager extends AppCompatActivity {


    private String userName;
    private int userScore;
    private int time;
    public  int click = 0;

    FileManager(){}
    FileManager(String userName, int userScore) {
        this.userName = userName;
        this.userScore = userScore;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String newName) {
        userName = newName;
    }


    public boolean checkCorrect() {
        return true;
    }


    public void displayImages() {
        //TODO
    }


    public void hideImages() {
        //TODO
    }

//    public void changeGUI(View v)
//    {
//        switch (click)
//        {
//            case  0:
//                Intent action1 = new Intent(getApplicationContext(), PlayerInfo.class);
//                startActivity(action1);
//                click +=1;
//                break;
//            case 1:
//                Intent action2 = new Intent(getApplicationContext(), RiddleScreen.class);
//                startActivity(action2);
//                click +=1;
//                break;
//            case 2:
//                Intent action3 = new Intent(getApplicationContext(), MemoryGame.class);
//                startActivity(action3);
//                click +=1;
//                break;
//            case 3:
//                Intent action4 = new Intent(getApplicationContext(), GameOver.class);
//                startActivity(action4);
//                click +=1;
//                break;
//        }
//
//    }



    public void timer()  {
        //TODO
    }
}
