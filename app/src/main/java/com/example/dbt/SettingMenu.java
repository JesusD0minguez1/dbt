package com.example.dbt;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.annotation.ContentView;

import com.google.android.material.chip.ChipGroup;

import java.lang.annotation.Annotation;
import androidx.appcompat.app.AppCompatActivity;

public class SettingMenu extends AppCompatActivity
{

    public void showWindow(Activity activity, ImageView b)
    {
        PopupMenu popupMenu = new PopupMenu(activity, b);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_layout, popupMenu .getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            public boolean onMenuItemClick(MenuItem item) {
                Toast t = new Toast(activity);
                Toast.makeText(activity, item.getTitle(),t.LENGTH_LONG).show();
                if (item.getTitle().equals("On/Off"))
                {
                    SettingOptions options = new SettingOptions();
                    options.audioChange1(activity);
                }
                else if(item.getTitle().equals("Main Menu"))
                {
                    SettingOptions options = new SettingOptions();
                    options.quitApp(activity);
                }
                return true;
            }
        });
        popupMenu.show();
    }

}
