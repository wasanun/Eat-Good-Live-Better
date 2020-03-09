package com.example.eatgood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Foodone extends AppCompatActivity {

    SQLiteDatabase mDb;
    MyDbHelper mHelper;
    Cursor mCursor;
    Button h1;
    public DatabaseReference test;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_foodone);

        final ListView listView1 = (ListView)findViewById(R.id.listView1);
        h1 = (Button) findViewById(R.id.h1);
        mHelper = new MyDbHelper(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);
        mCursor = mDb.rawQuery("SELECT " + MyDbHelper.COL_NAME + ", "  + MyDbHelper.COL_PIECE_PRICE
                + ", " + MyDbHelper.COL_CAKE_PRICE + " FROM " + MyDbHelper.TABLE_NAME, null);

        ArrayList<String> dirArray = new ArrayList<String>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            dirArray.add(mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_NAME)) + "\n"
                    + "ต่อจาน : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_PIECE_PRICE)) + "\t\t"
                    + "ปริมาณแคลอรี่ : " + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_CAKE_PRICE)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, dirArray);
        listView1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView1.setAdapter(adapterDir);


       /* FirebaseDatabase database = FirebaseDatabase.getInstance();
        test = database.getReference();
        final ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        listView1.setAdapter(adapterDir);
        test.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Map map = (Map)dataSnapshot.getValue();
                Map map1 = (Map) dataSnapshot.child("Food+cal").getValue();

                adapterDir.add(map1);
                adapterDir.notifyDataSetChanged();

                //String value = dataSnapshot.getValue().toString();



            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Foodone.this, Volume.class);
                //T2.putExtra("A",mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_CAKE_PRICE)));
                startActivity(T2);

                String str = "";
                SparseBooleanArray check=listView1.getCheckedItemPositions();

                for (int i = 0; i<listView1.getCount();i++){
                    if (check.get(i)==true){
                        if (!str.equals("")){
                            str +="\n";}
                        str += listView1.getItemAtPosition(i).toString();

                    }
                   // str  = "รายการที่เลือก : \n" + str;
                    Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();
    }
}
