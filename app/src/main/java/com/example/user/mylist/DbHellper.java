package com.example.user.mylist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHellper extends SQLiteOpenHelper{

    public static final int DB_VErSION = 1;
    public static final String DB_NAME = "data";
    public static final String DB_TABLE = "words";

    public static final String KEY_ID = "_id";
    public static final String KEY_WORD = "word";



    public DbHellper(Context context){
        super(context, DB_NAME, null, DB_VErSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DB_TABLE+"("+KEY_ID + " integer primary key,"+ KEY_WORD + " text)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ DB_TABLE);
        onCreate(db);
    }
}
