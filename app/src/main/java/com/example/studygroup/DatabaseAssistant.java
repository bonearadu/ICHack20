package com.example.studygroup;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DatabaseAssistant {
    public static final List<StudyGroup> result = new ArrayList<>();

    public final static FirebaseDatabase database = FirebaseDatabase.getInstance();

   public static void addObject(String str, Object obj, String objID){
        DatabaseReference myRef = database.getReference(str);
        myRef.child(objID).setValue(obj);
    }

    public static void addStudyGroup(StudyGroup studyGroup){
       addObject("studyGroups", studyGroup, studyGroup.getId() + "");
       //to changeprivate
    }

    public static List<StudyGroup> getStudyGroups(){
        DatabaseReference myRef = database.getReference("studyGroups");
        DatabaseReference ref2 = myRef.child("studyGroups");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DatabaseAssistant.result.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Log.d(TAG, "I was called");
                    DatabaseAssistant.result.add(postSnapshot.getValue(StudyGroup.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
    });
        Log.d(TAG, "Result size is " + DatabaseAssistant.result.size());
        return DatabaseAssistant.result;
   }

   public void deleteStudyGroup(String id){
       DatabaseReference myRef = database.getReference("studyGroups").child(id);
       myRef.removeValue();
   }
}
