package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class PractiseActivity extends AppCompatActivity {

    private Button btn_maths;
    private Button btn_history;
    private Button btn_english;
    private Button btn_attentiveness;
    private String subject = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise2);

        btn_maths = (Button) findViewById(R.id.button_math);
        btn_english = (Button) findViewById(R.id.button_english);
        btn_history = (Button) findViewById(R.id.button_history);
        btn_attentiveness = (Button) findViewById(R.id.button_attentiveness);

        btn_maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                subject = "Math";
                openQuestion(subject);
            }
        });

        btn_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                subject = "English";
                openQuestion(subject);
            }
        });

        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                subject = "History";
                openQuestion(subject);
            }
        });

        btn_attentiveness.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                subject = "Attentiveness";
                openQuestion(subject);
            }
        });

    }
    public void openQuestion(String subject) {
        Intent intent = new Intent(this, Question.class);
        intent.putExtra("resent", subject);

        startActivity(intent);
    }
}
