package com.example.pytutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LessonList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list);
    }

    public void selectLesson(View view){
        Intent intent = new Intent(this, LessonInfo.class);
        startActivity(intent);
    }
}