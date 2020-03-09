package com.example.eatgood;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "BTS";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Product";
    public static final String COL_NAME = "name";
    public static final String COL_PIECE_PRICE = "pieceprice";
    public static final String COL_CAKE_PRICE = "cakeprice";

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, " + COL_PIECE_PRICE + " INTEGER, "
                + COL_CAKE_PRICE + " INTEGER);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ผัดไทยกุ้งสด', 1 , 486);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ข้าวขาหมู', 1, 690);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ข้าวผัดกะเพราไก่ไข่ดาว', 1, 630);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ข้าวผัดกุ้งใส่ไข่', 1, 595);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ข้าวผัดแกงเขียวหวานไก่', 1, 630);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ขนมจีนน้ำยา', 1, 332);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ข้าวผัดน้ำพริกลงเรือ', 1, 605);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ข้าวหมูทอดกระเทียม', 1, 525);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ข้าวเหนียวหมูทอด', 1, 440);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('บะหมี่เกี๊ยวเป็ดย่าง', 1, 415);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('ลาบหมู', 1, 119);");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

public class Database {
}
