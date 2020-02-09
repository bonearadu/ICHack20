package com.example.studygroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchEngineer extends AppCompatActivity {
    SearchView mySearchView;
    ListView search_group;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_engineer);
        mySearchView = (SearchView) findViewById(R.id.searchEngine);
        search_group = (ListView) findViewById(R.id.search_engine);
        ArrayList<String> arrayGroup = new ArrayList<>();
        arrayGroup.addAll(Arrays.asList(getResources().getStringArray(R.array.engineering_departments)));
        adapter = new ArrayAdapter<String>(SearchEngineer.this,
                android.R.layout.simple_list_item_1, arrayGroup);
        search_group.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}