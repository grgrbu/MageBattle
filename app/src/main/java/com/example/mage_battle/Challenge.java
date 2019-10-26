package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Challenge extends AppCompatActivity {

    private Button FirstChall;
    private Button SecondChall;
    private Button ThirdChall;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        final Button First = (Button) findViewById(R.id.first_challenge);
        final Button Second = (Button) findViewById(R.id.second_challenge);
        final Button Third = (Button) findViewById(R.id.third_challenge);

        JSONObject json = new JSONObject();
        try {
            json.put("name", "Volodya");
//            json.put("hp",57);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        queue = Volley.newRequestQueue(this);
        // URL:
        String url = "http://109.234.37.174/last_3_challenges/";
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
                            First.setText(response.getString("challenge1"));
                            Second.setText(response.getString("challenge2"));
                            Third.setText(response.getString("challenge3"));

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

        First.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject json = new JSONObject();
                try {
                    json.put("name", "Volodya");
                    json.put("challenge", First.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                 queue = Volley.newRequestQueue(this);
                // URL:
                String url = "http://109.234.37.174/join_challenge/";
                JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.POST, url, json,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
//                                try {

                                    System.out.println(response.toString());

//                                }
//                                catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
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
                openQuestion();
            }
        });

        Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject json = new JSONObject();
                try {
                    json.put("name", "Volodya");
                    json.put("challenge", Second.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                 queue = Volley.newRequestQueue(this);
                // URL:
                String url = "http://109.234.37.174/join_challenge/";
                JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.POST, url, json,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
//                                try {

                                System.out.println(response.toString());

//                                }
//                                catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
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
                openQuestion();
            }
        });

        Third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject json = new JSONObject();
                try {
                    json.put("name", "Volodya");
                    json.put("challenge", Third.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                 queue = Volley.newRequestQueue(this);
                // URL:
                String url = "http://109.234.37.174/join_challenge/";
                JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.POST, url, json,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
//                                try {

                                System.out.println(response.toString());

//                                }
//                                catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
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
                openQuestion();
            }
        });



    }

    public void openQuestion() {
        Intent intent = new Intent(this, ChallengeQuestion.class);
        intent.putExtra("cnt", 0);
        startActivity(intent);
    }
}
