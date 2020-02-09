package com.example.studygroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Menu extends AppCompatActivity {

  private Button findStudyGroup;
  private Button createStudyGroup;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
    Toolbar toolbar = findViewById(R.id.header);
    findStudyGroup = findViewById(R.id.findStudyGroup);
    findStudyGroup.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            startActivity(new Intent(Menu.this, FindGroup.class));
          }
        });

    createStudyGroup = findViewById(R.id.createStudyGroup);
    createStudyGroup.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            startActivity(new Intent(Menu.this, CreateGroup.class));
          }
        });
  }
}
