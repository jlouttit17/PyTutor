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

    public void selectLesson1(View view){
        Intent intent = new Intent(this, LessonSyntax1.class);
        startActivity(intent);
    }
    public void selectLesson2(View view){
        Intent intent = new Intent(this, LessonSyntax2.class);
        startActivity(intent);
    }
    public void selectLesson3(View view){
        Intent intent = new Intent(this, LessonStrings.class);
        startActivity(intent);
    }
    public void selectLesson4(View view){
        Intent intent = new Intent(this, LessonLists.class);
        startActivity(intent);
    }
    public void selectLesson5(View view){
        Intent intent = new Intent(this, LessonTuples.class);
        startActivity(intent);
    }
    public void selectLesson6(View view){
        Intent intent = new Intent(this, LessonLoops.class);
        startActivity(intent);
    }
    public void selectLesson7(View view){
        Intent intent = new Intent(this, LessonClasses.class);
        startActivity(intent);
    }
    public void selectLesson8(View view){
        Intent intent = new Intent(this, LessonFunctions.class);
        startActivity(intent);
    }
}