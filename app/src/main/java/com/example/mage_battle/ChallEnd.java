package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class ChallEnd extends AppCompatActivity {

    private Button menu;
    private TextView your;
    private TextView maxi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chall_end);

        Intent intent = getIntent();
        final Double total = intent.getDoubleExtra("total_diff", 57.0);
        final Double maximum = intent.getDoubleExtra("max_diff", 57.0);
        final String subj = intent.getStringExtra("subj");
        System.out.println("$$" + subj);
        System.out.println(maximum);

        your = (TextView) findViewById(R.id.your_mark);
        maxi = (TextView) findViewById(R.id.max_mark);

        your.setText(total.toString());
        maxi.setText(maximum.toString());

        JSONObject json = new JSONObject();
        try {
            json.put("name", "Egor");
            json.put("result", total);
            json.put("maximum", maximum);
            json.put("subject", subj);
            System.out.println(subj);
//            json.put("hp",57);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(this);
        // URL:
        String url = "http://109.234.37.174/earn_runes/";
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.POST, url, json,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
//                        TextView results = findViewById(R.id.maintext);
//                        results.setText("I got response");

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

        menu = (Button) findViewById(R.id.toMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });
    }

    public void openMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
