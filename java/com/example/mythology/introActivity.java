package com.example.mythology;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class introActivity extends AppCompatActivity {

    private Button play_1;
    private long backPressedTime;
    private Toast backToast;
    Dialog dialog;
    //private Button dialog_button;
    AudioManager audioManager;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        //int maxVolumn = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //int currentVolumn = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        dialog = new Dialog(introActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_back));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);



        play_1 = (Button) findViewById(R.id.button_play_1) ;

        play_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(introActivity.this,
                        MainActivity.class);
                startActivity(mainIntent);
            }
        });

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF3D080D"));
        actionBar.setBackgroundDrawable(colorDrawable);


        //SeekBar seekBar = (SeekBar) findViewById(R.id.volumn_seek_bar);
        //seekBar.setMax(maxVolumn);
        //seekBar.setProgress(currentVolumn);
        //seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           // @Override
           // public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
           //     audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

          //  }

          //  @Override
          //  public void onStartTrackingTouch(SeekBar seekBar) {

         //   }

         //   @Override
         //   public void onStopTrackingTouch(SeekBar seekBar) {

         //   }
        //});

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
                Intent mainIntent = new Intent(introActivity.this,
                        openingActivityNew.class);
                startActivity(mainIntent);
                return true;

            case R.id.settings_action:

                audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
                int maxVolumn = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                int currentVolumn = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

                dialog.show();

            default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashActivity.introsong.release();
        finish();
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