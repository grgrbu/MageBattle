package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChallengeAnswer extends AppCompatActivity {

    private Button menu;
    private Button toNextQuestion;
    private TextView QuestionTop;
    private TextView UserAnswerTop;
    private TextView CorrectAnswerTop;
    private String CurSub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        QuestionTop = (TextView) findViewById(R.id.question);
        UserAnswerTop = (TextView) findViewById(R.id.userAnswer);
        CorrectAnswerTop = (TextView) findViewById(R.id.correctAnswer);


        Intent intent = getIntent();
        final String UserAnswer = intent.getStringExtra("userAnswer");
        final String CorrectAnswer = intent.getStringExtra("correctAnswer");
        final String Question = intent.getStringExtra("Question");
        final String current_subject = intent.getStringExtra("subj");
        CurSub = current_subject;

        QuestionTop.setText(Question);
        if (QuestionTop.getText().length() > 20) {
            QuestionTop.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        }
        UserAnswerTop.setText(UserAnswerTop.getText().toString() + UserAnswer);
        CorrectAnswerTop.setText(CorrectAnswerTop.getText().toString() + CorrectAnswer);

        menu = (Button) findViewById(R.id.toMenu);
        toNextQuestion = (Button) findViewById(R.id.nextQuestion);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });

        toNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuestion();
            }
        });
    }

    public void openMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void nextQuestion() {
        Intent intent = new Intent(this, ChallengeQuestion.class);
        intent.putExtra("resent", CurSub);
        startActivity(intent);
    }
}
