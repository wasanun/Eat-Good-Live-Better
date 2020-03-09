package com.example.eatgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Mai extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button home,cal,food,set;
    TextView top,nt1;
    Spinner bu,bu1,buu,bun;


    public DatabaseReference test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mai);

        bu = findViewById(R.id.bu);
        bu1 = findViewById(R.id.bu1);
        bun = findViewById(R.id.bun);
        buu = findViewById(R.id.buu);


        home = (Button) findViewById(R.id.home);
        cal = (Button) findViewById(R.id.cal);
        set = (Button) findViewById(R.id.set);
        food = (Button) findViewById(R.id.food);
        nt1 =  findViewById(R.id.nt1);
        top = findViewById(R.id.top);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bu,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bu.setAdapter(adapter);
        bu.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.bu1,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bu1.setAdapter(adapter1);
        bu1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.bu1,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bun.setAdapter(adapter2);
        bun.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.bu1,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        buu.setAdapter(adapter3);
        buu.setOnItemSelectedListener(this);



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Mai.this, Volume.class);
                startActivity(T2);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Mai.this, Food.class);
                startActivity(T2);
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Mai.this, Set.class);
                startActivity(T2);
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        test = database.getReference();
        test.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Map map = (Map)dataSnapshot.getValue();
                Map map1 = (Map) dataSnapshot.child("member").getValue();
                String user1 = String.valueOf(map1.get("msg"));
                nt1.setText(user1);
               /* Map map = (Map)dataSnapshot.getValue();
                String user1 = String.valueOf(map.get("member"));

                String cal = String.valueOf(map.get("Weight"));
                nt.setText(user1+" "+cal);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        String text1 = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text1,Toast.LENGTH_SHORT).show();
        String text2 = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text2,Toast.LENGTH_SHORT).show();
        String text3 = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text3,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}

