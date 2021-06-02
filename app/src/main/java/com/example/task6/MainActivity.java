package com.example.task6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
      MediaPlayer OurSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       requestWindowFeature(Window.FEATURE_NO_TITLE);
       this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
setContentView(R.layout.activity_main);
getSupportActionBar().hide();
        MediaPlayer OurSound;
        OurSound =MediaPlayer.create(MainActivity.this,R.raw.rensi);
        OurSound.start();

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(5000);

                }
                catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
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