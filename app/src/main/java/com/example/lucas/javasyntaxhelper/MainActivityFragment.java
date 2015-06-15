package com.example.lucas.javasyntaxhelper;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lucas.javasyntaxhelper.data.TopicContract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final String LOG_TAG = MainActivityFragment.class.getSimpleName();
    PopulateDb pdb;
    Cursor mCursor;
    private ArrayAdapter<String> testAdapter;

    public MainActivityFragment() {
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pdb = new PopulateDb(getActivity());
        pdb.execute("");
    }

    public void runQuery(){
        mCursor = getActivity().getContentResolver().query(
                TopicContract.TopicsEntry.CONTENT_URI,
                null,
                null ,
                null,
                null
        );
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String [] test = new String[TopicData.topics.length];

        for(int i = 0; i < mCursor.getCount(); i++){
            mCursor.moveToNext();
            test[i] = mCursor.getString(mCursor.getColumnIndex(
                    TopicContract.TopicsEntry.COLUMN_TOPIC_NAME));
        }
        List<String> testList = new ArrayList<>(Arrays.asList(test));

        testAdapter = new ArrayAdapter<>(getActivity()
                , R.layout.list_item, R.id.list_item_textview, testList);


        View view = inflater.inflate(R.layout.fragment_main, container, false);


        ListView listView = (ListView)view.findViewById(R.id.listview_topics);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String topic = testAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), TopicInfo.class);
                intent.putExtra(Intent.EXTRA_TEXT, topic);
                startActivity(intent);
            }
        });
        listView.setAdapter(testAdapter);

        return view;
    }
}
