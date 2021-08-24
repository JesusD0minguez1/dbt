package com.example.dbt;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.media.MediaActionSound;


public class SettingMenu extends MainActivity
{

    MediaPlayer rdMusic;
    Status status = new Status();


    public void showWindow(Activity activity, ImageView b)
    {
        PopupMenu popupMenu = new PopupMenu(activity, b);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_layout, popupMenu .getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast t = new Toast(activity);
                Toast.makeText(activity, item.getTitle(),t.LENGTH_LONG).show();
                if (item.getTitle().equals("Music On"))
                {
                    audioChange1(activity);
                    return true;
                }
                else if(item.getTitle().equals("Main Menu"))
                {
                    quitApp(activity);
                    return true;
                }
                else {
                    return false;
                }
            }
        });
    }


    public void audioChange1(Activity a)
    {
        rdMusic = MediaPlayer.create(a,R.raw.riddle);
        if(rdMusic.isPlaying()) {
            rdMusic.pause();
        }
        else {
            rdMusic.start();
            rdMusic.setLooping(true);
        }
    }



    public void quitApp(Activity activity){
        activity.finish();
        System.exit(0);
    }


}
