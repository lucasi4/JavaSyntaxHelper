package com.example.lucas.javasyntaxhelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class TopicInfo extends ActionBarActivity implements TopicInfoFragment.SendData {
    public static final String LOG_TAG = TopicInfo.class.getSimpleName();

    public String mTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_info);
    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void send(String s){
        mTopic = s;
        Log.v(LOG_TAG, "String " + s);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_launch_browser) {
            Uri uri = Uri.parse("https://www.google.com/search?q="+ mTopic);
            Intent gSearchIntent = new Intent(Intent.ACTION_VIEW, uri);

            startActivity(gSearchIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
