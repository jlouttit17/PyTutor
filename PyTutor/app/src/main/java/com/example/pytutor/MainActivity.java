package com.example.pytutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int points;
    String score = String.valueOf(points);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLessons(View view){
        Intent intent = new Intent(this, LessonList.class);
        startActivity(intent);
    }

    public void points(View view){
        Intent intent = new Intent(this, Score.class);
        startActivity(intent);
    }
}