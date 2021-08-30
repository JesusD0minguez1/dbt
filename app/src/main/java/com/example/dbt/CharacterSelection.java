package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CharacterSelection extends AppCompatActivity {


    ImageView charcter1;
    ImageView charcter2;
    ImageView charcter3;
    ImageView charcter4;
    ImageView charcter5;
    ImageView charcter6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_selection);

        charcter1 = findViewById(R.id.character1);
        charcter2 = findViewById(R.id.character2);
        charcter3 = findViewById(R.id.character3);
        charcter4 = findViewById(R.id.character4);
        charcter5 = findViewById(R.id.character5);
        charcter6 = findViewById(R.id.character6);

    }

    public void onclick(View v){
        Intent action2 = new Intent(getApplicationContext(),IsekaiPlayerName.class);
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;

        switch (v.getId()){
            case R.id.character1:
                v1 = R.drawable.b;
                v2 = R.drawable.b_attack;
                v3 = R.drawable.b_die;
                v4 = R.drawable.b_win;
                break;
            case R.id.character2:
                v1 = R.drawable.hara;
                v2 = R.drawable.hara_attack;
                v3 = R.drawable.hara_die;
                v4 = R.drawable.hara_win;
                break;
            case R.id.character3:
                v1 = R.drawable.cc;
                v2 = R.drawable.cc_attack;
                v3 = R.drawable.cc_die;
                v4 = R.drawable.cc_win;
                break;
            case R.id.character4:
                v1 = R.drawable.jack;
                v2 = R.drawable.jack_attack;
                v3 = R.drawable.jack_die;
                v4 = R.drawable.jack_win;
                break;
            case R.id.character5:
                v1 = R.drawable.kim;
                v2 = R.drawable.kim_attack;
                v3 = R.drawable.kim_die;
                v4 = R.drawable.kim_win;
                break;
            case R.id.character6:
                v1 = R.drawable.bob;
                v2 = R.drawable.bob_attack;
                v3 = R.drawable.bob_die;
                v4 = R.drawable.bob_win;
                break;
        }

        action2.putExtra("c1",v1);
        action2.putExtra("c2",v2);
        action2.putExtra("c3",v3);
        action2.putExtra("c4",v4);


        startActivity(action2);
    }
}