package com.example.studygroup;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class CreateGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        final Spinner Department = findViewById(R.id.faculty);
        final Spinner Faculty = findViewById(R.id.departament);
        Department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(CreateGroup.this,
                            R.array.engineering_departments, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
                    Faculty.setAdapter(adapter);

                }
                if(i==1){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(CreateGroup.this,
                            R.array.medicine_departments, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
                    Faculty.setAdapter(adapter);

                }
                if(i==2){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(CreateGroup.this,
                            R.array.natural_science_departments, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
                    Faculty.setAdapter(adapter);

                }
                if(i==3){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(CreateGroup.this,
                            R.array.business_school_departments, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
                    Faculty.setAdapter(adapter);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final Spinner year = findViewById(R.id.year);
        EditText size = findViewById(R.id.maxSize);
        final EditText startDate = findViewById(R.id.startDate);
        final EditText endDate = findViewById(R.id.editText3);
        Button submit = findViewById(R.id.button2);
        final Integer size1;
        if(size.getText().toString().equals("")){
            size1 = -1;
        }
        else{
            size1 = Integer.parseInt(size.getText().toString());
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudyGroup studyGroup = new StudyGroup(Department.getSelectedItem().toString(),Faculty.getSelectedItem().toString(),
                        year.getSelectedItem().toString(), size1, startDate.getText().toString(), endDate.getText().toString());
                DatabaseAssistant.addStudyGroup(studyGroup);
            }
        });
    }

}
