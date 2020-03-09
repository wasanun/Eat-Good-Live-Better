package com.example.eatgood;

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


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;


public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name,weight,weight1,age,hight;
    TextView top;
    Button next;
    Spinner sex;
    DatabaseReference ref;
    FirebaseDatabase database;
    Member member;
    Spinner burn;
    TextView top1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        weight1 = findViewById(R.id.weight1);
        name = findViewById(R.id.name);
        weight = findViewById(R.id.weight);
        sex = findViewById(R.id.sex);
        age = findViewById(R.id.age);
        hight = findViewById(R.id.hight);
        top1 = findViewById(R.id.top1);
        top = findViewById(R.id.top);
        burn = findViewById(R.id.burn);
        next = findViewById(R.id.next);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sex,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sex.setAdapter(adapter);
        sex.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.burn,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        burn.setAdapter(adapter1);
        burn.setOnItemSelectedListener(this);


        database = FirebaseDatabase.getInstance();
        member = new Member();
        ref = FirebaseDatabase.getInstance().getReference("member");

        Toast.makeText(this, "Database works, food created!", Toast.LENGTH_SHORT).show();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(HomeActivity.this, Volume.class);
                startActivity(T2);
                addMember();
                //calBMI();
                //calBMR();

            }
        });

    }
    public void addMember(){
        String Name = name.getText().toString().trim();
        String Age = age.getText().toString().trim();
        String Hight = hight.getText().toString().trim();
        String Weight = weight.getText().toString().trim();
        String Sex = sex.getSelectedItem().toString();
        String Weight1 = weight1.getText().toString().trim();
        String Burn = burn.getSelectedItem().toString();
        String Msg = calBMR();



        if(!TextUtils.isEmpty(Name) ) {

            String id = ref.push().getKey();
            Member member = new Member(id,Name,Age,Hight,Weight,Sex,Weight1,Burn,Msg);

            ref.setValue(member);
            Toast.makeText(this,"Member add ",Toast.LENGTH_LONG).show();;
        }else {
            Toast.makeText(this,"You shold enter a name ",Toast.LENGTH_LONG).show();;
        }



    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        String text1 = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text1,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    /*public void calBMI() {
        weight = findViewById(R.id.weight);
        hight = findViewById(R.id.hight);
        double w = Double.parseDouble(weight.getText().toString());
        double h = Double.parseDouble(hight.getText().toString());
        h=h/100;
        double bmi = w/((h*h));
        DecimalFormat decFormat = new DecimalFormat("##.##");
        String msg = "ค่า BMI คือ :"+decFormat.format(bmi);
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }*/
    public String calBMR() {
        weight1 = findViewById(R.id.weight1);
        hight = findViewById(R.id.hight);
        age = findViewById(R.id.age);
        sex = findViewById(R.id.sex);

        double w = Double.parseDouble(weight1.getText().toString());
        double h = Double.parseDouble(hight.getText().toString());
        double a = Double.parseDouble(age.getText().toString());
        double bmr = 665+(9.6*w)+(1.8*h)-(4.7*a);;

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
    }


}