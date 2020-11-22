package com.example.pytutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LessonLists extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists_page1);
    }

    public String[] questions = {"Q1: Which of these properly stores a list in x?",
            "Q2: What will this print?\nmyList = [1, 2, 3]\nprint(myList[2])",
            "Q3: What will myList contain after this code?\nmyList = [1, 2, 3]\nmyList.append(4)",
            "Q4: What will myList contain after this code?\nmyList = [1, 2, 3]\nmyList.insert(2, 4)",
            "Q5: Which of these will remove the element at index 1 of myList?",
            "Q6: What value does len(myList) return for this list?\n[1, 2, 4]"};
    public String[][] qans = {{"x = (1, 2, 3)", "x = {1, 2, 3}", "x = [1, 2, 3]", "x = \"1, 2, 3\""},
            {"2", "3", "1", "The code does not work"},
            {"[1, 2, 3, 4]", "[1, 2, 4]", "[4, 2, 3]", "[4, 1, 2, 3]"},
            {"[1, 2, 3, 4]", "[1, 2, 4]", "[1, 4, 2, 3]", "[1, 2, 4, 3]"},
            {"myList.del(1)", "remove myList[1]", "del myList[1]", "myList.remove(1)"},
            {"2", "3", "4", "The code does not work"}};
    public int score = 0;
    public int question = 0;
    public boolean first = true;
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

            if(score > 0) editQuestion.setText("CONGRATULATIONS!!!\nLists Complete");
            else editQuestion.setText("Try Again\nLists Complete");
            if(score == 30) editScore.setText("Score: " + score + "/30\nAchievement: Perfect!");
            else editScore.setText("Score: " + score + "/30");
        }
    };
    public void proceed(View view){
        if(first) setContentView(R.layout.activity_lists_page2);
        else setContentView(R.layout.activity_lists_page_last);
        first = false;
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
            editChoice2.setOnClickListener(correct);
        }
        if(question == 2){
            editChoice1.setOnClickListener(correct);
        }
        if(question == 3){
            editChoice4.setOnClickListener(correct);
        }
        if(question == 4){
            editChoice3.setOnClickListener(correct);
        }
        if(question == 5){
            editChoice2.setOnClickListener(correct);
            editResult.setOnClickListener(finish);
        }
    }
}