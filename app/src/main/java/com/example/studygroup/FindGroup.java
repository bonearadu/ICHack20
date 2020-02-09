package com.example.studygroup;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


public class FindGroup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_group);

        Button buttonEngineer = findViewById(R.id.buttonEngineering);
        buttonEngineer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(FindGroup.this, SearchEngineer.class));
                    }
                });

        Button buttonMedicine = findViewById(R.id.buttonMedicine);
        buttonMedicine.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(FindGroup.this, SearchMedicine.class));
                    }
                });
        Button buttonNatural = findViewById(R.id.buttonNatural);
        buttonNatural.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(FindGroup.this, SearchNatural.class));
                    }
                });
        Button buttonBusiness = findViewById(R.id.buttonBusiness);
        buttonBusiness.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(FindGroup.this, SearchBusiness.class));
                    }
                });


    }
}

