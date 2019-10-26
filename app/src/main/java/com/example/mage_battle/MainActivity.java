package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static Context context;

    private Button button_to_practise;
    private Button button_to_challenge;
    private Button button_to_duel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = this.getApplicationContext();
        setContentView(R.layout.activity_main);

        button_to_practise = (Button) findViewById(R.id.button_practise);
        button_to_practise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPractise();
            }
        });

        button_to_challenge = (Button) findViewById(R.id.button_challenge);
        button_to_challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChallenge();
            }
        });
        button_to_duel = (Button) findViewById(R.id.button_duel);
        button_to_duel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDuel();
            }
        });
    }

    public void openPractise() {
        Intent intent = new Intent(this, PractiseActivity.class);
        startActivity(intent);
    }
    public void openChallenge() {
        Intent intent = new Intent(this, Challenge.class);
        startActivity(intent);
    }
    public void openDuel() {
        Intent intent = new Intent(this, Duel.class);
        startActivity(intent);
    }
}
