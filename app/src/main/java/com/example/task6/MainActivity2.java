package com.example.task6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity2 extends AppCompatActivity {
MediaPlayer OurSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        OurSound = MediaPlayer.create(MainActivity2.this,R.raw.rensi);
        OurSound.start();
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(5000);

                }
                catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        OurSound.release();
        finish();
    }
    }
