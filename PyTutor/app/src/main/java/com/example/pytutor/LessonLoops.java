package com.example.pytutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LessonLoops extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_page1);
    }

    public String[] questions = {"Q1: What will this code print?\nx = 1\nwhile x < 4:\n\tprint(x)\n\tx = x + 1",
            "Q2: What statement marks code to be executed if a condition is false?",
            "Q3: Which properly starts a for loop",
            "Q4: Which properly starts an if statement?",
            "Q5: What operator returns true when both its conditions are true"};
    public String[][] qans = {{"1 2 3 4", "2 3 4", "1 4", "1 2 3"},
            {"else", "otherwise", "catch", "after"},
            {"for(x=0; x<myList.length(); x++)", "for x in myList", "for myList", "for myList[x]"},
            {"if x < 0", "if x < 0:", "if x < 0 {", "if x < 0("},
            {"both", "or", "and", "either"}};
    public int score = 0;
    public int question = 0;
    public int page = 1;
    public Button editResult;
    public TextView editQuestion;
    public Button editChoice1;
    public Button editChoice2;
    public Button editChoice3;
    public Button editChoice4;
    public TextView editScore;

    View.OnClickListener correct = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            editResult = (Button) findViewById(R.id.Result);
            editResult.setEnabled(true);
            editResult.setVisibility(View.VISIBLE);
            editResult.setText("CORRECT. TAP TO PROCEED");
            score += 5;
            editScore.setText(String.valueOf(score));
            editChoice1.setEnabled(false);
            editChoice2.setEnabled(false);
            editChoice3.setEnabled(false);
            editChoice4.setEnabled(false);
        }
    };
    View.OnClickListener incorrect = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            editResult = (Button) findViewById(R.id.Result);
            editResult.setEnabled(true);
            editResult.setVisibility(View.VISIBLE);
            editResult.setText("INCORRECT. TAP TO PROCEED");
            editChoice1.setEnabled(false);
            editChoice2.setEnabled(false);
            editChoice3.setEnabled(false);
            editChoice4.setEnabled(false);
        }
    };
    View.OnClickListener finish = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setContentView(R.layout.activity_quiz_result);
            editQuestion = (TextView) findViewById(R.id.congratulations);
            editScore = (TextView) findViewById(R.id.score);

            if(score > 0) editQuestion.setText("CONGRATULATIONS!!!\nLoops Complete");
            else editQuestion.setText("Try Again\nLoops Complete");
            if(score == 25) editScore.setText("Score: " + score + "/25\nAchievement: Perfect!");
            else editScore.setText("Score: " + score + "/25");
        }
    };
    public void proceed(View view){
        if(page == 1) setContentView(R.layout.activity_loop_page2);
        if(page == 2) setContentView(R.layout.activity_loop_page3);
        if(page == 3) setContentView(R.layout.activity_loops_page4);
        page++;
    }

    public void backToLessons(View view){
        Intent intent = new Intent(this, LessonList.class);
        startActivity(intent);
    }

    public void start(View view){
        setContentView(R.layout.quiz);
        editScore = (TextView) findViewById(R.id.points);
        editScore.setText(String.valueOf(score));

        editQuestion = (TextView) findViewById(R.id.question);
        editQuestion.setText(questions[question]);

        editChoice1 = (Button) findViewById(R.id.choice1);
        editChoice1.setText(qans[question][0]);
        editChoice1.setOnClickListener(incorrect);

        editChoice2 = (Button) findViewById(R.id.choice2);
        editChoice2.setText(qans[question][1]);
        editChoice2.setOnClickListener(incorrect);

        editChoice3 = (Button) findViewById(R.id.choice3);
        editChoice3.setText(qans[question][2]);
        editChoice3.setOnClickListener(correct);

        editChoice4 = (Button) findViewById(R.id.choice4);
        editChoice4.setText(qans[question][3]);
        editChoice4.setOnClickListener(incorrect);
    }

    public void nextQuestion(View view){
        question++;
        editResult.setEnabled(false);
        editResult.setVisibility(View.INVISIBLE);
        editQuestion.setText(questions[question]);
        editChoice1.setEnabled(true);
        editChoice2.setEnabled(true);
        editChoice3.setEnabled(true);
        editChoice4.setEnabled(true);

        editChoice1.setText(qans[question][0]);
        editChoice1.setOnClickListener(incorrect);

        editChoice2.setText(qans[question][1]);
        editChoice2.setOnClickListener(incorrect);

        editChoice3.setText(qans[question][2]);
        editChoice3.setOnClickListener(incorrect);

        editChoice4.setText(qans[question][3]);
        editChoice4.setOnClickListener(incorrect);

        if(question == 1){
            editChoice3.setOnClickListener(correct);
        }
        if(question == 2){
            editChoice2.setOnClickListener(correct);
        }
        if(question == 3){
            editChoice4.setOnClickListener(correct);
        }
        if(question == 4){
            editChoice4.setOnClickListener(correct);
        }
        if(question == 5){
            editChoice4.setOnClickListener(correct);
            editResult.setOnClickListener(finish);
        }
    }
}