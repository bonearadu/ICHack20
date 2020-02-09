package com.example.studygroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private Button findGroup;
    private Button createGroup;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);

    Button findStudyGroup = findViewById(R.id.findStudyGroup);
    findStudyGroup.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            startActivity(new Intent(Menu.this, FindGroup.class));
          }
        });

    Button createStudyGroup = findViewById(R.id.createStudyGroup);
    createStudyGroup.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            startActivity(new Intent(Menu.this, CreateGroup.class));
          }
        });
  }
}
