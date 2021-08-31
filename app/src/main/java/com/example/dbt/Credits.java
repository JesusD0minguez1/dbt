package com.example.dbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);
        TextView Jesus = findViewById(R.id.jesus);
        TextView Mat = findViewById(R.id.Mat);
        TextView Eric = findViewById(R.id.Eric);
        TextView Moises = findViewById(R.id.Moises);
        TextView Joey = findViewById(R.id.joey);

        String jesustxt = "1) Product Owner/Scrum Master/ Developer Jesus";
        String mattxt = "2) Product Owner/ Scrum Master /Developer/ Groom Matthew";
        String erictxt = "3) Eric";
        String moisestxt = "4) Product Owner Moises";
        String joeytxt = "5) Scrumbag Joey";

        Jesus.setText(jesustxt);
        Mat.setText(mattxt);
        Eric.setText(erictxt);
        Moises.setText(moisestxt);
        Joey.setText(joeytxt);
    }

    public void backToTitle(View v)
    {
        Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(toMain);
    }
}