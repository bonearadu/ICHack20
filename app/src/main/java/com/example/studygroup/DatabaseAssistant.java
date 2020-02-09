package com.example.studygroup;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static android.content.ContentValues.TAG;

public class DatabaseAssistant {

    public final static FirebaseDatabase database = FirebaseDatabase.getInstance();

   public static void addObject(String str, Object obj, String objID){
        DatabaseReference myRef = database.getReference(str);
        myRef.child(objID).setValue(obj);
    }

    public static void addStaticGroup(StudyGroup studyGroup){
       addObject("studyGroups", studyGroup, "1");
       //to change
    }

    public static List<StudyGroup> getStudyGroups(){
        DatabaseReference myRef = database.getReference("studyGroups");
        final List<StudyGroup> result = new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    result.add(postSnapshot.getValue(StudyGroup.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
    });
        return result;
   }

   public void deleteStudyGroup(String id){
       DatabaseReference myRef = database.getReference("studyGroups").child(id);
       myRef.removeValue();
   }





}
