package com.example.dbt;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.media.MediaActionSound;

public class SettingOptions
{
    MediaPlayer rdMusic;
    boolean on = true;
    Status status = new Status();

    public boolean audioChange1(Activity a)
    {
        rdMusic = MediaPlayer.create(a,R.raw.riddle);
        if(status.musicStatus == false)
        {
            rdMusic.stop();
            status.musicStatus = true;
        }
        else
        {
            rdMusic.start();
            rdMusic.setLooping(true);
            status.musicStatus = false;
        }
        return false;
    }

    public void quitApp(Activity activity){
        activity.finish();
        System.exit(0);
    }

}
