package com.example.lucas.javasyntaxhelper.data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Lucas on 6/13/2015.
 */
public class TopicContract {

    public static final String CONTENT_AUTHORITY = "com.example.lucas.javasyntaxhelper";
    public static final Uri BASE_CONTENT_URI =  Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_TOPICS = "topics";



    public static final class TopicsEntry implements BaseColumns {
        public static final String TABLE_NAME = "topics";
        public static final String COLUMN_TOPIC_NAME = "topic";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMG_NAME = "img";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOPICS).build();

        public static Uri buildTopicUri (long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static final class NotesEntry implements BaseColumns {
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_TOPIC_NAME = "topic";
        public static final String COLUMN_COMMENTS = "comments";
    }

}
