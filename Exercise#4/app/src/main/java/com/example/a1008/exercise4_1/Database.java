package com.example.a1008.exercise4_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a1008 on 2018/1/3.
 */

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "course";
    private static final int DATABASE_VERSION = 1;
    private static String TABLE_NAME = "course";
    private static final String TABLE_CREATE = "CREATE TABLE "+TABLE_NAME+
            "(CID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Name CHAR(30),Week CHAR(3),STime CHAR(8),ETime CHAR(8))";

    public Database(Context  c){
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
