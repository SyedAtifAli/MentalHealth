package com.example.mentalhealth.Smiley;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Smiley_DBHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "smiley.db";
        public final String COLUMN_Smile = "smile";
        public final String TABLE_NAME = "smile_days";

        public Smiley_DBHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(" CREATE TABLE " + TABLE_NAME+ " (" + COLUMN_Smile +" INTEGER );");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            this.onCreate(db);
        }

        public void saveSmile(int smile){
            SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            String query = "Delete from "+TABLE_NAME+" Where "+ COLUMN_Smile+" Like \'%\';";
            sQLiteDatabase.execSQL(query);
            contentValues.put(COLUMN_Smile , smile);
            sQLiteDatabase.insert(TABLE_NAME, null, contentValues);
            sQLiteDatabase.close();
        }

        public int getSmile(){
            SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
            String query = "Select * from "+TABLE_NAME+";";
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


