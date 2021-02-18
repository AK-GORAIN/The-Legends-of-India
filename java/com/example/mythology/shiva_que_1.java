package com.example.mythology;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class shiva_que_1 extends AppCompatActivity {

    private Button but_1;
    private Button but_2;
    private Button but_3;
    private Button but_4;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shiva_que_1);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF3D080D"));
        actionBar.setBackgroundDrawable(colorDrawable);

        but_1 = (Button) findViewById(R.id.button_1);
        but_2 = (Button) findViewById(R.id.button_2);
        but_3 = (Button) findViewById(R.id.button_3);
        but_4 = (Button) findViewById(R.id.button_4);

        but_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openDialog();
            }
        });

        but_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //openDialog_1();
                Intent mainIntent = new Intent(shiva_que_1.this,
                        shiva_que_2.class);
                startActivity(mainIntent);

            }
        });

        but_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openDialog();
            }
        });

        but_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        dialog dia = new dialog();
        dia.show(getSupportFragmentManager(),"anything");
    }

    private void openDialog_1() {
        dialog_1 dia_1 = new dialog_1();
        dia_1.show(getSupportFragmentManager(),"anyone");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater=getMenuInflater();
        //inflater.inflate(R.menu.example_menu,menu);
        getMenuInflater().inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_action:
                Intent mainIntent = new Intent(shiva_que_1.this,
                        openingActivityNew.class);
                startActivity(mainIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast=Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}