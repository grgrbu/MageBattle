package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DuelWaiting extends AppCompatActivity {
    private TextView yourHP;
    private TextView yourDefence;
    private TextView opponentHP;
    private TextView opponentDefence;
    private Button ButtonWaiting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel_waiting);

        yourHP = (TextView) findViewById(R.id.HP_your_player2);
        yourDefence = (TextView) findViewById(R.id.Defence_your_player2);
        opponentHP = (TextView) findViewById(R.id.HP_opponent_player2);
        opponentDefence = (TextView) findViewById(R.id.Defence_opponent_player2);
        ButtonWaiting = (Button) findViewById(R.id.button_to_change);

        ButtonWaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                possible_to_start();
            }
        });

        JSONObject json = new JSONObject();
        try {
            json.put("name", "Egor");
//            json.put("hp",57);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        // URL:
        String url = "http://109.234.37.174/get_hp/";
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
                            yourHP.setText(response.getString("hp"));
                            yourDefence.setText(response.getString("defence"));
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


        json = new JSONObject();
        try {
            json.put("name", "Volodya");
//            json.put("hp",57);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // URL:
        url = "http://109.234.37.174/get_hp/";
        obreq = new JsonObjectRequest(Request.Method.POST, url, json,
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
                            opponentHP.setText(response.getString("hp"));
                            opponentDefence.setText(response.getString("defence"));
                            check_end_of_the_game();
                            System.out.println(opponentDefence);
                            System.out.println(opponentHP);
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

        check_end_of_the_game();
    }

    public void possible_to_start() {
        JSONObject json = new JSONObject();
        try {
            json.put("name", "Egor");
//            json.put("hp",57);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        // URL:
        String url = "http://109.234.37.174/check_turn/";
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
                            Boolean a = response.getBoolean("my_turn");
                            if (a) {
                                openDuel();
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
        check_end_of_the_game();
    }

    public void openDuel() {
        Intent intent = new Intent(this, Duel.class);
        startActivity(intent);
    }
    public void check_end_of_the_game() {
        if (Integer.parseInt(yourHP.getText().toString()) <= 0) {
            openLose();
        }
        if (Integer.parseInt(opponentHP.getText().toString()) <= 0) {
            openWin();
        }
    }

    public void openLose() {
        Intent intent = new Intent(this, DuelLose.class);
        startActivity(intent);
    }

    public void openWin() {
        Intent intent = new Intent(this, DuelWin.class);
        startActivity(intent);
    }
}
