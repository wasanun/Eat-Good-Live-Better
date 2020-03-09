package com.example.eatgood;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

public class Foodtwo extends AppCompatActivity {


    Button h1;
    TextView textView1/*,t1,t2*/;
    ListView listView1;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodtwo);

        //h1 = (Button) findViewById(R.id.h1);
        listView1 = (ListView)findViewById(R.id.t6);
        textView1 = (TextView) findViewById(R.id.textView1);
       /*t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t5 = (TextView) findViewById(R.id.t5);
        t6 = (TextView) findViewById(R.id.t6);
        t7 = (TextView) findViewById(R.id.t7);
        t8 = (TextView) findViewById(R.id.t8);
        t9 = (TextView) findViewById(R.id.t9);
        t10 = (TextView) findViewById(R.id.t10);*/

        String[] Movies = new String[] {
                "ก๋วยเตี๋ยวคั่วไก่ 1 จาน  435 กิโลแคลอรี่",
                "ขนมจีนแกงเขียวหวานไก่ 1 ชาม 594 กิโลแคลอรี่",
                "ก๋วยเตี๋ยวต้มยำกุ้ง 1 ถ้วย  320 กิโลแคลอรี่",
                "ก๋วยเตี๋ยวเส้นเล็กต้มยำหมู  1 ชาม 335 กิโลแคลอรี่",
                "ก๋วยเตี๋ยวเส้นเล็กหมูแห้ง   1 ชาม  330 กิโลแคลอรี่",
                "ก๋วยเตี๋ยวเส้นใหญ่ผัดซีอิ๊วใส่ไข่  1 จาน  520 กิโลแคลอรี่",
                "ขนมจีนน้ำยา  1 จาน   375 กิโลแคลอรี่",
                "มักกะโรนีขี้เมาไก่  1 จาน 520 กิโลแคลอรี่",
                "ผัดไทยไข่ห่อ  1 จาน  565 กิโลแคลอรี่",
                "ยากิโซบะ  1 จาน  400 กิโลแคลอรี่",
                "ยำขนมจีน  1 จาน  220 กิโลแคลอรี่",
                "หมี่กรอบราดหน้าหมู 1 จาน 690 กิโลแคลอรี่",
                "หมี่กะทิ  1 จาน  405 กิโลแคลอรี่",
                "บะหมี่เกี๊ยวเป็ดย่าง 1 ถ้วย  415 กิโลแคลอรี่",
                "กวยจั๊บญวณ  1 ชาม  235 กิโลแคลอรี่"
        };
        final ListView listViewMovie = (ListView)findViewById(R.id.t6);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Movies);

        listViewMovie.setAdapter(adapter);
        listViewMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition     = position;
                String  itemValue    = (String) listViewMovie.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Click :"+itemPosition+"  Item : " +itemValue , Toast.LENGTH_LONG)
                        .show();

                listViewMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int itemPosition     = position;
                        String  itemValue    = (String) listViewMovie.getItemAtPosition(position);
                        Toast.makeText(getApplicationContext(),
                                "Click :"+itemPosition+"  Item : " +itemValue , Toast.LENGTH_LONG)
                                .show();

                        Intent showPage = new Intent(Foodtwo.this,Volume.class);
                        showPage.putExtra("id",""+itemPosition+"");
                        showPage.putExtra("title",""+itemValue+"");
                        startActivity(showPage);
                    }
                });
            }
        });



       /* h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setcal();

                Intent T1 = new Intent(Foodtwo.this, Volume.class);
               // T1.putExtra("star", 5);
                startActivity(T1);

            }

*/
        //});
      /*  t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent T2 = new Intent(Foodtwo.this, Volume.class);
                T2.putExtra("star", 594);
                startActivity(T2);
            }
        });*/





    }

}