package com.example.eatgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button home,cal,food,set,h,h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        home = (Button) findViewById(R.id.home);
        cal = (Button) findViewById(R.id.cal);
        set = (Button) findViewById(R.id.set);
        food = (Button) findViewById(R.id.food);
        h = (Button) findViewById(R.id.h);
        h1 = (Button) findViewById(R.id.h1);



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Menu.this, Volume.class);
                startActivity(T2);
            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Menu.this, Foodone.class);
                startActivity(T2);
            }
        });
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Menu.this, Foodtwo.class);
                startActivity(T2);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Menu.this, Food.class);
                startActivity(T2);
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Menu.this, Mai.class);
                startActivity(T2);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Menu.this, Set.class);
                startActivity(T2);
            }
        });
    }
}