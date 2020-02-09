package com.example.studygroup;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

public class StudyGroup {

    private final int id;
    private final String faculty;
    private final String department;
    private final int year;
    private final int maxSize;
    private final List<String> initialModules;
    private final Date startDate;
    private final Date endDate;

    public StudyGroup(int id, String faculty, String department, int year, int maxSize, List<String> initialModules, Date startDate, Date endDate) {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("counter");
        final String[] counter = new String[1];
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                counter[0] = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
        int id1 = Integer.parseInt(counter[0]);
        this.id = id1++;
        myRef.setValue(id + "");
        this.faculty = faculty;
        this.department = department;
        this.year = year;
        this.maxSize = maxSize;
        this.initialModules = initialModules;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public int getYear() {
        return year;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<String> getInitialModules() {
        return initialModules;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
