package com.example.eatgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;

public class Goal extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText weight1;
    TextView top;
    Button next;
    DatabaseReference ref;
    FirebaseDatabase database;
    EditText age,hight;
    Member member;
    Spinner burn;
    Spinner sex;
    Wei wei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);


        weight1 = findViewById(R.id.weight1);



        top = findViewById(R.id.top);
        burn = findViewById(R.id.burn);

        next = findViewById(R.id.next);


        database = FirebaseDatabase.getInstance();
        wei = new Wei();
        ref = FirebaseDatabase.getInstance().getReference("Weight");
       // member = new Member();



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.burn,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        burn.setAdapter(adapter);
        burn.setOnItemSelectedListener(this);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Goal.this, Volume.class);
                startActivity(T2);
                addWei();
              /* ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        member.setWeight(weight1.getText().toString());
                        member.setBurn(burn.getSelectedItem().toString());

                        ref.setValue(member);
                        Toast.makeText(Goal.this,"data inserted sucessfully",Toast.LENGTH_LONG).show();

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });*/
            }
        });
    }
    public void addWei() {

        String Weight1 = weight1.getText().toString().trim();
        String Burn = burn.getSelectedItem().toString();
       // String Msg = calBMR();

        if (!TextUtils.isEmpty(Weight1)) {

            String id = ref.push().getKey();
         //   Wei wei = new Wei(id,Weight1, Burn);

            ref.setValue(wei);
            Toast.makeText(this, "Member add ", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "You shold enter a name ", Toast.LENGTH_LONG).show();

        }
    }

  /*  public String calBMR() {
        weight1 = findViewById(R.id.weight1);
        hight = findViewById(R.id.hight);
        age = findViewById(R.id.age);
        sex = findViewById(R.id.sex);
        double w = Double.parseDouble(weight1.getText().toString());
        double h = Double.parseDouble(hight.getText().toString());
        double a = Double.parseDouble(age.getText().toString());
        double bmr = 665+(9.6*w)+(1.8*h)-(4.7*a);
        // with activity
        // Taking in to account activity
        //double energyWithActivity = 0;
        if(burn.equals("0")) {
            bmr = bmr * 1.2;
        }
        else if(burn.equals("1")) {
            bmr = bmr* 1.375; // slightly_active
        }
        else if(burn.equals("2")) {
            bmr = bmr*1.55; // moderately_active
        }
        else if(burn.equals("3")) {
            bmr = bmr*1.725; // active_lifestyle
        }
        else if(burn.equals("3")) {
            bmr = bmr * 1.9; // very_active
        }

        DecimalFormat decFormat = new DecimalFormat("##.##");
        String msg = decFormat.format(bmr);
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
        return msg;
    }*/




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
