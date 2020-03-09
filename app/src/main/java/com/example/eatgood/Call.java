package com.example.eatgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Call extends AppCompatActivity {
    Button home,cal,food,set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        home = (Button) findViewById(R.id.home);
        cal = (Button) findViewById(R.id.cal);
        set = (Button) findViewById(R.id.set);
        food = (Button) findViewById(R.id.food);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Call.this, Volume.class);
                startActivity(T2);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Call.this, Food.class);
                startActivity(T2);
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Call.this, Mai.class);
                startActivity(T2);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Call.this, Set.class);
                startActivity(T2);
            }
        });
    }
}
