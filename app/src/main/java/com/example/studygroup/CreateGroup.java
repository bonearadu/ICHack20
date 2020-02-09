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

    Button createEvent;

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
        //
        createEvent = findViewById(R.id.button2);

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner facultySpinner = findViewById(R.id.faculty);
                String faculty =(String) facultySpinner.getSelectedItem();


                Spinner departmentSpinner = findViewById(R.id.departament);
                String department = (String) departmentSpinner.getSelectedItem();

                Spinner yearSpinner = findViewById(R.id.year);
                int year = Integer.parseInt((String) yearSpinner.getSelectedItem());

                EditText groupLimitField = findViewById(R.id.maxSize);
                int maxSize = Integer.parseInt(groupLimitField.getText().toString());

                EditText startDateField = findViewById(R.id.startDate);
                String startDate = startDateField.getText().toString();

                EditText startTimeField = findViewById(R.id.startTime);
                String startTime = startTimeField.getText().toString();

                EditText descriptionField = findViewById(R.id.description);
                String description = descriptionField.getText().toString();

                StudyGroup group = new StudyGroup(0,faculty, department, year, maxSize, startDate, startTime, description);
                DatabaseAssistant.addStaticGroup(group);

            }
        });
    }

}
