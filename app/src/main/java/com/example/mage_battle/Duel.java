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

public class Duel extends AppCompatActivity {

    private TextView yourHP;
    private TextView yourDefence;
    private TextView opponentHP;
    private TextView opponentDefence;
    private TextView fire_rune;
    private TextView earth_rune;
    private TextView water_rune;
    private TextView air_rune;
    private Integer cnt_clicks = 0;
    private String first_click;
    private String second_click;

    private ImageButton AirButton;
    private ImageButton WaterButton;
    private ImageButton FireButton;
    private ImageButton EarthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel);

        yourHP = (TextView) findViewById(R.id.HP_your_player);
        yourDefence = (TextView) findViewById(R.id.Defence_your_player);
        opponentHP = (TextView) findViewById(R.id.HP_opponent_player);
        opponentDefence = (TextView) findViewById(R.id.Defence_opponent_player);

        fire_rune = (TextView) findViewById(R.id.fireRune);
        water_rune = (TextView) findViewById(R.id.waterRune);
        air_rune = (TextView) findViewById(R.id.airRune);
        earth_rune = (TextView) findViewById(R.id.earthRune);

        AirButton = (ImageButton) findViewById(R.id.air_button_id);
        WaterButton = (ImageButton) findViewById(R.id.water_button_id);
        EarthButton = (ImageButton) findViewById(R.id.earth_button_id);
        FireButton = (ImageButton) findViewById(R.id.fire_button_id);


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
                            System.out.println(opponentDefence);
                            System.out.println(opponentHP);
                            check_end_of_the_game();
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

        json = new JSONObject();
        try {
            json.put("name", "Egor");
//            json.put("hp",57);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        queue = Volley.newRequestQueue(this);
        // URL:
        url = "http://109.234.37.174/get_runes/";
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
                            fire_rune.setText(response.getString("fire"));
                            water_rune.setText(response.getString("water"));
                            air_rune.setText(response.getString("air"));
                            earth_rune.setText(response.getString("earth"));
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

        FireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt_clicks == 0) {
                    first_click = "fire";
                } else if (cnt_clicks == 1) {
                    second_click = "fire";
                }
                cnt_clicks += 1;
                if_clicked();
            }
        });

        WaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt_clicks == 0) {
                    first_click = "water";
                } else if (cnt_clicks == 1) {
                    second_click = "water";
                }
                cnt_clicks += 1;
                if_clicked();
            }
        });

        EarthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt_clicks == 0) {
                    first_click = "earth";
                } else if (cnt_clicks == 1) {
                    second_click = "earth";
                }
                cnt_clicks += 1;
                if_clicked();
            }
        });

        AirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cnt_clicks == 0) {
                    first_click = "air";
                } else if (cnt_clicks == 1) {
                    second_click = "air";
                }
                cnt_clicks += 1;
                if_clicked();
            }
        });

        check_end_of_the_game();

    }

    public void if_clicked() {
        if (cnt_clicks == 2) {
            JSONObject json = new JSONObject();
            try {
                json.put("me", "Egor");
                json.put("rune1", first_click);
                json.put("rune2", second_click);
                json.put("opponent", "Volodya");
//            json.put("hp",57);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            RequestQueue queue = Volley.newRequestQueue(this);
            // URL:
            String url = "http://109.234.37.174/make_magic/";
            JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.POST, url, json,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
//                        TextView results = findViewById(R.id.maintext);
//                        results.setText("I got response");
//                            try {
//                            String data = "";
//                            String spell = response.getString("spell");
//                            data = spell;

                                // WHAT TO DO WITH RESULT:
//                        results.setText(response.toString());
                                System.out.println(response.toString());
//                                fire_rune.setText(response.getString("fire"));
//                                water_rune.setText(response.getString("water"));
//                                air_rune.setText(response.getString("air"));
//                                earth_rune.setText(response.getString("earth"));
//
//                                yourHP.setText(response.getString("myhp"));
//                                yourDefence.setText(response.getString("mydefence"));
//
//                                opponentHP.setText(response.getString("ophp"));
//                                opponentDefence.setText(response.getString("opdefence"));
//                            }
//                            catch (JSONException e) {
//                                e.printStackTrace();
//                            }
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

            System.out.println("!!!!!!!!!!!!!$$$$$$$$$$$$$$$$$\n@\n@\n@|N@|N@|N@|N\n@|N@|N\n");
            Intent intent = new Intent(this, DuelWaiting.class);
            startActivity(intent);

        }
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
