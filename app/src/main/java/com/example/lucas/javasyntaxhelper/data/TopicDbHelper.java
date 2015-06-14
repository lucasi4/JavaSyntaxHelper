package com.example.lucas.javasyntaxhelper.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lucas.javasyntaxhelper.data.TopicContract.TopicsEntry;

/**
 * Created by Lucas on 6/13/2015.
 */
public class TopicDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "topic.db";

    public TopicDbHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_WEATHER_TABLE = "CREATE TABLE " + TopicsEntry.TABLE_NAME + " (" +
                TopicsEntry.COLUMN_TOPIC_NAME + " TEXT NOT NULL, " +
                TopicsEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                TopicsEntry.COLUMN_IMG_NAME + " TEXT NOT NULL" +" );";

        db.execSQL(SQL_CREATE_WEATHER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
