package com.example.studygroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchMedicine extends AppCompatActivity {
    SearchView mySearchView;
    ListView search_group;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_medicine);
        mySearchView = (SearchView) findViewById(R.id.searchMedicine);
        search_group = (ListView) findViewById(R.id.search_medicine);
        ArrayList<String> arrayGroup = new ArrayList<>();
        arrayGroup.addAll(Arrays.asList(getResources().getStringArray(R.array.medicine_departments)));
        adapter = new ArrayAdapter<String>(SearchMedicine.this,
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