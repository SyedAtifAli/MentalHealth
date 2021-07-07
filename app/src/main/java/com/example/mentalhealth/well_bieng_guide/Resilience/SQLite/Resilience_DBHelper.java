package com.example.mentalhealth.well_bieng_guide.Resilience.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Resilience_DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "resday.db";
    public final String COLUMN_DAY = "day";
    public final String TABLE_NAME = "res_days";

    public Resilience_DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME+ " (" + COLUMN_DAY +" INTEGER );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void saveDay(int day){
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String query = "Delete from "+TABLE_NAME+" Where "+COLUMN_DAY+" Like \'%\';";
        sQLiteDatabase.execSQL(query);
        contentValues.put(COLUMN_DAY , day);
        sQLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sQLiteDatabase.close();
    }

    public int getDay(){
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        String query = "Select * from "+TABLE_NAME+";";
//        sQLiteDatabase.execSQL(query);
        int day = 0;
        Cursor cursor = this.getWritableDatabase().rawQuery(query, null);
        if(cursor.moveToNext()){
            do{
                day = cursor.getInt(0);
            }while (cursor.moveToNext());
        }
        return day;
    }
}
