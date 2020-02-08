package com.example.studygroup;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.stream.Stream;

public class DatabaseAssistant {

    public final static FirebaseDatabase database = FirebaseDatabase.getInstance();

   public static void addObject(String str, Object obj){
        DatabaseReference myRef = database.getReference(str);
        myRef.setValue(obj);
    }

    public static void addStaticGroup(StudyGroup studyGroup){

    }

    /*public static Stream<StudyGroup> getStudyGroups(){
        DatabaseReference myRef = database.getReference("studyGroups");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }*/

}
