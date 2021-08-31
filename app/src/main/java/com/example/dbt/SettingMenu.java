package com.example.dbt;


import android.app.Activity;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.MenuItem;
import android.media.MediaPlayer;


public class SettingMenu extends MainActivity
{


    public void showWindow(Activity activity, ImageView b, MediaPlayer mp)
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
                if (item.getTitle().equals("Music On/Off"))
                {
                    audioChange1(mp);
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


    public void audioChange1(MediaPlayer mp)
    {
        try {
            if(mp.isPlaying()) {
                mp.seekTo(0);
                mp.pause();
            }
            else {
                mp.start();
                mp.setLooping(true);
            }
        }
        catch (Exception music) {
            music.printStackTrace();
        }
    }


    public void quitApp(Activity activity){
        //There was a reason it was like thiiis
        activity.finish();
        System.exit(0);
    }


}
