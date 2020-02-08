package com.example.studygroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchBar extends AppCompatActivity {

    ListView search_group;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);
        search_group = (ListView) findViewById(R.id.search_group);
        ArrayList<String> arrayGroup = new ArrayList<>();
        arrayGroup.addAll(Arrays.asList(getResources().getStringArray(R.array.my_groups)));
        adapter = new ArrayAdapter<String>(SearchBar.this,
                android.R.layout.simple_expandable_list_item_1, arrayGroup);
        search_group.setAdapter(adapter);
    }
}