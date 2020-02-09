package com.example.studygroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class BusinessFragment extends Fragment {

    public BusinessFragment() {
        super();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_find_group, container, false);

        ListView departments = view.findViewById(R.id.departments);
        departments.setAdapter(new ArrayAdapter<>(
                view.getContext(),
                android.R.layout.simple_list_item_1,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.business_school_departments)))));

        return view;
     }
}
