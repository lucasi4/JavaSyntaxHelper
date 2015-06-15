package com.example.lucas.javasyntaxhelper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.javasyntaxhelper.data.TopicContract;


/**
 * A placeholder fragment containing a simple view.
 */
public class TopicInfoFragment extends Fragment {

    TextView mDescriptionTextView;
    ImageView mImageView;
    String mTopic;



    SendData mSendData;


    public TopicInfoFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mSendData = (SendData)activity;
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic_info, container, false);
        Intent intent = getActivity().getIntent();
        String[] topicSelected = new String[1];
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            topicSelected[0] = intent.getStringExtra(Intent.EXTRA_TEXT);
        }

        Cursor cursor = getActivity().getContentResolver().query(
                TopicContract.TopicsEntry.CONTENT_URI,
                null, //columns
                TopicContract.TopicsEntry.COLUMN_TOPIC_NAME + " = ?",
                topicSelected,
                null
        );
        cursor.moveToNext();
        String topicDescription = cursor.getString(cursor.getColumnIndex(
                TopicContract.TopicsEntry.COLUMN_DESCRIPTION));
        String imgFilename = cursor.getString(cursor.getColumnIndex(
                TopicContract.TopicsEntry.COLUMN_IMG_NAME));
        mSendData.send(topicSelected[0]);


        //set title bar
                ((TopicInfo) getActivity())
                .setActionBarTitle(topicSelected[0]);

        mDescriptionTextView = (TextView) view.findViewById(R.id.description_textview);
        mDescriptionTextView.setText(topicDescription);

        //String uri = "drawable/" + imgFilename + ".png";
        int imageResource = getActivity().getResources().getIdentifier(
                imgFilename, "drawable", getActivity().getPackageName());

        mImageView = (ImageView) view.findViewById(R.id.sample_imageview);

        mImageView.setImageResource(imageResource);

        return view;
    }

    public interface SendData {
        public void send(String s);
    }

}

