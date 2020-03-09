package com.example.eatgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.Map;

public class Volume extends AppCompatActivity {
    TextView top,nt,t2,t3;
    Member member;
    Button home,cal,food,set;
    public DatabaseReference test;
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

       // t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        nt = findViewById(R.id.nt);
        top = findViewById(R.id.top);
        home = (Button) findViewById(R.id.home);
        listView1 = (ListView)findViewById(R.id.t6);
        cal = (Button) findViewById(R.id.cal);
        set = (Button) findViewById(R.id.set);
        food = (Button) findViewById(R.id.food);
        //Integer A = getIntent().getExtras().getInt("A",0);
        //t2.setText(A);
        //Toast.makeText(this, "Name : " + A, Toast.LENGTH_SHORT).show();
        member = new Member();


       /* Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            int star = bundle.getInt("star",0);
            t2.setText("ขนมจีนแกงเขียวหวานไก่ = " + star );
            Toast.makeText(this, "Name : " + star, Toast.LENGTH_SHORT).show();
        }*/
        Intent intent= getIntent();
        final String txt_get_id = intent.getStringExtra("id");
        final String txt_get_title = intent.getStringExtra("title");
        t3.setText(txt_get_title);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        test = database.getReference();
        test.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Map map = (Map)dataSnapshot.getValue();
                Map map1 = (Map) dataSnapshot.child("member").getValue();
                String user1 = String.valueOf(map1.get("msg"));
                nt.setText(user1);

               /* Map map = (Map)dataSnapshot.getValue();
                String user1 = String.valueOf(map.get("member"));

                String cal = String.valueOf(map.get("Weight"));
                nt.setText(user1+" "+cal);*/

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });




        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Volume.this, Food.class);
                startActivity(T2);
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Volume.this, Mai.class);
                startActivity(T2);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Volume.this, Set.class);
                startActivity(T2);
            }
        });


    }

}
