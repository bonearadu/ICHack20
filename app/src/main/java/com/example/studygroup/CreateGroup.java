package com.example.studygroup;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CreateGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Spinner Department = findViewById(R.id.spinner);
        final Spinner Faculty = findViewById(R.id.spinner2);
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
    }

}
