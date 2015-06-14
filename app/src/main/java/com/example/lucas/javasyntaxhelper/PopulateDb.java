package com.example.lucas.javasyntaxhelper;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.example.lucas.javasyntaxhelper.data.TopicContract;
import com.example.lucas.javasyntaxhelper.data.TopicDbHelper;

/**
 * Created by Lucas on 6/13/2015.
 */
public class PopulateDb extends AsyncTask <String, Void, Void> {
    public static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    private final Context mContext;

    public PopulateDb(Context context){
        mContext = context;
    }

    public void dropDb(){
        mContext.deleteDatabase(TopicDbHelper.DATABASE_NAME);
    }

    public String[] getTopics(){
        String[] returnArray = new String[TopicData.topics.length];
        int i = 0;
        Cursor arrayCursor = mContext.getContentResolver().query(
                TopicContract.TopicsEntry.CONTENT_URI,
                null, //sellect all
                TopicContract.TopicsEntry.COLUMN_TOPIC_NAME, //from topics
                null,
                null
        );

        while(arrayCursor.moveToNext()){
            returnArray[i] = arrayCursor.getString(
                    arrayCursor.getColumnIndex(TopicContract.TopicsEntry.COLUMN_TOPIC_NAME));
            i++;
        }

        return returnArray;
    }

    public long addEntry(String topic, String description, String filename){
        Log.v(LOG_TAG, "mmmm addEntry called");

        Cursor topicCursor = mContext.getContentResolver().query(
                TopicContract.TopicsEntry.CONTENT_URI,
                null,  //select all
                TopicContract.TopicsEntry.COLUMN_TOPIC_NAME + " = ?",  //from topics
                new String[]{topic},
                null
        );

        Log.v(LOG_TAG, "mmm cursorinadd " + DatabaseUtils.dumpCursorToString(topicCursor));

        if(topicCursor.moveToFirst()){
            int idIndex = topicCursor.getColumnIndex(TopicContract.TopicsEntry.COLUMN_TOPIC_NAME);
            Log.v(LOG_TAG, "mmm before return");
            return topicCursor.getLong(idIndex);
        } else {
            Log.v(LOG_TAG, "nnn in else " + topic);
            ContentValues topicValues = new ContentValues();
            topicValues.put(TopicContract.TopicsEntry.COLUMN_TOPIC_NAME, topic);
            topicValues.put(TopicContract.TopicsEntry.COLUMN_DESCRIPTION, description);
            topicValues.put(TopicContract.TopicsEntry.COLUMN_IMG_NAME, filename);

            Uri topicInsertUri = mContext.getContentResolver().insert(
                    TopicContract.TopicsEntry.CONTENT_URI, topicValues);

            return ContentUris.parseId(topicInsertUri);
        }
    }

    @Override
    protected Void doInBackground(String... params) {

        //dropDb();

        Log.v(LOG_TAG, "mmmm doInBackground called");


        for(int i = 0; i< TopicData.descriptions.length ; i++){
            addEntry(
                    TopicData.topics[i],
                    TopicData.descriptions[i],
                    TopicData.imgFilenames[i]
            );
        }

        return null;
    }
}
