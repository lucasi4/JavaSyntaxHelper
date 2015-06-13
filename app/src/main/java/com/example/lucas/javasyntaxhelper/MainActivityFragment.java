package com.example.lucas.javasyntaxhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {





    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] testItems = {"Data Types", "Declarations", "For loops", "While loops", "If statements"
        ,"item 2", "item 4", "item 56", "Data Types", "Declarations", "For loops", "While loops", "If statements"
                ,"item 2", "item 4", "item 56"};

        String thename = "whaldkfd";
        int f = 4;



        List<String> testList = new ArrayList<>(Arrays.asList(testItems));

        ArrayAdapter<String> testAdapter = new ArrayAdapter<>(getActivity()
                , R.layout.list_item, R.id.list_item_textview, testList);

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = (ListView)view.findViewById(R.id.listview_topics);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TopicInfo.class);
                startActivity(intent);
            }
        });
        listView.setAdapter(testAdapter);

        return view;
    }
}
