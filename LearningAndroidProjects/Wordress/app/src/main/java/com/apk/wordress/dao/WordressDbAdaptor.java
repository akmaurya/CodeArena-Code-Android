package com.apk.wordress.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.apk.wordress.util.Message;
import com.apk.wordress.model.ScoreVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sanjay.bind1 on 10/1/2017.
 */

public class WordressDbAdaptor {

    WordressDbHelper wordressDbHelper;

    public WordressDbAdaptor(Context context)
    {
        wordressDbHelper = new WordressDbHelper(context);
    }

    public long setDefaultScores()
    {
        long id = 0;
        SQLiteDatabase sqLiteDatabase = wordressDbHelper.getWritableDatabase();
        ContentValues contentValues;
        for (int i=1; i<=3; i++) {
            contentValues = new ContentValues();
            contentValues.put(wordressDbHelper.LEVEL, i);
            contentValues.put(wordressDbHelper.SCORE, 0);
            id = sqLiteDatabase.insert(wordressDbHelper.TABLE_NAME, null , contentValues);
        }

        return id;
    }

    public int getLevelHighestScore(int level)
    {
        SQLiteDatabase db = wordressDbHelper.getWritableDatabase();
        String selectQuery = "SELECT score FROM scoreTable";
        Cursor c = db.rawQuery(selectQuery, null);
        int i=0;
        int counter=0;
        while (c.moveToNext()) {
            counter++;
            if(counter==level) {
                i=c.getInt(0);
            }
        }
        c.close();
        return i;
    }

    public int updateHighestScore(int level, int score) {
        int id;
        SQLiteDatabase sqLiteDatabase = wordressDbHelper.getWritableDatabase();
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put(wordressDbHelper.SCORE, score);
        id = sqLiteDatabase.update(wordressDbHelper.TABLE_NAME, contentValues, wordressDbHelper.LEVEL + "=" + level, null);
        return id;
    }

    static class WordressDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "wordressDatabase";    // Database Name
        private static final String TABLE_NAME = "scoreTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String LEVEL = "level";
        private static final String SCORE = "score";

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                "(" + LEVEL + " INTEGER PRIMARY KEY," + SCORE + " INTEGER" + ")";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public WordressDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}
