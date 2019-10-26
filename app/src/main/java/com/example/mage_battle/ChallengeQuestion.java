package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class ChallengeQuestion extends AppCompatActivity {

    private Button first;
    private Button second;
    private Button third;
    private Button fourth;
    private TextView question;
    private Integer CorrectAnswer = 0;
    private String CorrectAnswerText = "";
    private String CurSub = "";

    private Double cnt_person = 0.0;
    private Double max_person = 0.0;
    private Double difficulty = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        final String subject = intent.getStringExtra("resent");
        cnt_person = intent.getDoubleExtra("total_diff", 0.0);
        max_person = intent.getDoubleExtra("max_diff", 0.0);
        CurSub = subject;

        System.out.println(subject);

        first = (Button) findViewById(R.id.first_answer);
        second = (Button) findViewById(R.id.second_answer);
        third = (Button) findViewById(R.id.third_answer);
        fourth = (Button) findViewById(R.id.fourth_answer);
        question = (TextView) findViewById(R.id.textQuestion);


        JSONObject json = new JSONObject();
        try {
            json.put("name", "Volodya");
//            json.put("hp",57);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        // URL:
        String url = "http://109.234.37.174/get_new_challenge_task/";
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.POST, url, json,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
//                        TextView results = findViewById(R.id.maintext);
//                        results.setText("I got response");
                        try {
//                            String data = "";
//                            String spell = response.getString("spell");
//                            data = spell;

                            // WHAT TO DO WITH RESULT:
//                        results.setText(response.toString());
                            System.out.println(response.toString());
                            question.setText(response.getString("question"));
                            if (question.getText().length() > 20) {
                                question.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                            }
                            System.out.println(question.getText().toString());


                            first.setText(response.getString("answer0"));
                            second.setText(response.getString("answer1"));
                            third.setText(response.getString("answer2"));
                            fourth.setText(response.getString("answer3"));
                            CorrectAnswer = response.getInt("correct");
                            difficulty = response.getDouble("difficulty");
                            if (CorrectAnswer == 0) {
                                CorrectAnswerText = first.getText().toString();
                            } else if (CorrectAnswer == 1) {
                                CorrectAnswerText = second.getText().toString();
                            } else if (CorrectAnswer == 2) {
                                CorrectAnswerText = third.getText().toString();
                            } else if (CorrectAnswer == 3) {
                                CorrectAnswerText = fourth.getText().toString();
                            } else {
                                openChallEnd();
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        queue.add(obreq);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                String userSaid = first.getText().toString();
                openAnswer(userSaid);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                String userSaid = second.getText().toString();
                openAnswer(userSaid);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                String userSaid = third.getText().toString();
                openAnswer(userSaid);
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                String userSaid = fourth.getText().toString();
                openAnswer(userSaid);
            }
        });
    }
    public void openAnswer(String userSaid) {
        Intent intent = new Intent(this, ChallengeAnswer.class);
        intent.putExtra("userAnswer", userSaid);
        intent.putExtra("correctAnswer", CorrectAnswerText);
        intent.putExtra("Question", question.getText().toString());
        intent.putExtra("subj", CurSub);
        if (CorrectAnswerText == userSaid) {
            cnt_person += difficulty;
        }
        max_person += difficulty;
        intent.putExtra("total_diff", cnt_person);
        intent.putExtra("max_diff", max_person);
        startActivity(intent);
    }
    public void openChallEnd() {
        Intent intent = new Intent(this, ChallEnd.class);
        intent.putExtra("total_diff", cnt_person);
        intent.putExtra("max_diff", max_person);
        startActivity(intent);
    }

}

