package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {

    private TextView yourHP;
    private TextView yourDefence;
    private TextView fire_rune;
    private TextView earth_rune;
    private TextView water_rune;
    private TextView air_rune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        yourHP = (TextView) findViewById(R.id.HP_your_player_profile);
        yourDefence = (TextView) findViewById(R.id.Defence_your_player_profile);

        fire_rune = (TextView) findViewById(R.id.fireRune_profile);
        water_rune = (TextView) findViewById(R.id.waterRune_profile);
        air_rune = (TextView) findViewById(R.id.airRune_profile);
        earth_rune = (TextView) findViewById(R.id.earthRune_profile);

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

    }
}
