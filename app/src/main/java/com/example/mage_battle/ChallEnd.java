package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        System.out.println(total);
        System.out.println(maximum);

        your = (TextView) findViewById(R.id.your_mark);
        maxi = (TextView) findViewById(R.id.max_mark);

        your.setText(total.toString());
        maxi.setText(maximum.toString());

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
