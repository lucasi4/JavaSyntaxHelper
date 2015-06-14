package com.example.lucas.javasyntaxhelper.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.example.lucas.javasyntaxhelper.data.TopicContract.TopicsEntry;

import java.util.HashSet;

/**
 * Created by Lucas on 6/13/2015.
 */
public class TestDb extends AndroidTestCase {

    void deleteTheDatabase() {
        mContext.deleteDatabase(TopicDbHelper.DATABASE_NAME);
    }

    public void setUp() {
        deleteTheDatabase();
    }

    public void testCreateDb() throws Throwable {
        final HashSet<String> tableNameHashSet = new HashSet<String>();
        tableNameHashSet.add(TopicContract.TopicsEntry.TABLE_NAME);

        mContext.deleteDatabase(TopicDbHelper.DATABASE_NAME);
        SQLiteDatabase db = new TopicDbHelper(this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());

        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        assertTrue("Error: This means that the database has not been created correctly",
                c.moveToFirst());

        do {
            tableNameHashSet.remove(c.getString(0));
        } while( c.moveToNext() );

        assertTrue("Error: Your database was created without both the location entry and weather entry tables",
                tableNameHashSet.isEmpty());

        c = db.rawQuery("PRAGMA table_info(" + TopicContract.TopicsEntry.TABLE_NAME + ")",
                null);

        assertTrue("Error: This means that we were unable to query the database for table information.",
                c.moveToFirst());

        final HashSet<String> locationColumnHashSet = new HashSet<String>();
        //locationColumnHashSet.add(TopicContract.TopicsEntry._ID);
        locationColumnHashSet.add(TopicContract.TopicsEntry.COLUMN_TOPIC_NAME);
        locationColumnHashSet.add(TopicContract.TopicsEntry.COLUMN_DESCRIPTION);
        locationColumnHashSet.add(TopicContract.TopicsEntry.COLUMN_IMG_NAME);

        int columnNameIndex = c.getColumnIndex("name");
        do {
            String columnName = c.getString(columnNameIndex);
            locationColumnHashSet.remove(columnName);
        } while(c.moveToNext());

        assertTrue("Error: The database doesn't contain all of the required location entry columns",
                locationColumnHashSet.isEmpty());

                db.close();
    }

    public void testInsertReadDb(){
        String testTopic = "arrays";
        String testDescription = "arrays are blah blah blah";
        String testImg = "34545.png";

        TopicDbHelper dbHelper = new TopicDbHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TopicContract.TopicsEntry.COLUMN_TOPIC_NAME, testTopic);
        values.put(TopicContract.TopicsEntry.COLUMN_DESCRIPTION, testDescription);
        values.put(TopicContract.TopicsEntry.COLUMN_IMG_NAME, testImg);

        long locationRow;
        locationRow = db.insert(TopicsEntry.TABLE_NAME, null, values);

        assertTrue(locationRow != -1);

    }

}
