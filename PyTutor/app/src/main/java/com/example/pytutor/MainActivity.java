package com.example.pytutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectLesson(View view){
        Intent intent = new Intent(this, LessonList.class);
        Button button = (Button) findViewById(R.id.button);
        startActivity(intent);
    }
}