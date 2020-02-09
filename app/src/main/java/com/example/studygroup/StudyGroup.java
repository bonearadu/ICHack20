package com.example.studygroup;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

public class StudyGroup {

    public static List<String> ids = new ArrayList<>();
    private final int id;
    private final String faculty;
    private final String department;
    private final String year;
    private final int maxSize;
    private final String startDate;
    private final String startTime;
    private final String description;

    public StudyGroup(String faculty, String department, String year, int maxSize, String startDate, String startTime, String description) {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("counter");
        //myRef.setValue("0");
        final List<String> counter = new ArrayList<>();
        final String[] values = new String[1];
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                StudyGroup.ids.clear();
                String value = dataSnapshot.getValue(String.class);
                StudyGroup.ids.add(value+"");
                Log.d(TAG, "Value is: " + value);
                Log.d(TAG, "Value iss: " + ids.get(0));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        int id1;
        if(ids.size()>0){
            id1 = Integer.parseInt(ids.get(0));
        }else{
            id1 = ids.size();
        }
        this.id = id1+1;
        myRef.setValue(id + "");
        this.faculty = faculty;
        this.department = department;
        this.year = year;
        this.maxSize = maxSize;
        this.startDate = startDate;
        this.startTime = startTime;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDepartment() {
        return department;
    }

    public String getYear() {
        return year;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getStartDate() {
        return startDate;
    }
}
