package com.alphaford.projetandroid;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class SplashActivity extends AppCompatActivity {
    ImageView splashImage;
    ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splach_activity);
        splashImage=(ImageView) findViewById(R.id.splashImage);
        splashImage.setImageResource(R.drawable.logo_cup);
        mProgress = (ProgressBar) findViewById(R.id.splash_screen_progress_bar);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);

    }

}
