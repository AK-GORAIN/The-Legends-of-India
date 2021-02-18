package com.example.mythology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class openingPageActivity extends AppCompatActivity {

    private Button play;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_page);

        play = (Button) findViewById(R.id.button_play) ;

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  mainIntent = new Intent(openingPageActivity.this,
                        introActivity.class);
                startActivity(mainIntent);
            }
        });

        help = (Button) findViewById(R.id.button_help);

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  mainIntent = new Intent(openingPageActivity.this,
                        helpActivity1.class);
                startActivity(mainIntent);
            }
        });
    }
}