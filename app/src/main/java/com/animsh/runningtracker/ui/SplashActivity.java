package com.animsh.runningtracker.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.animsh.runningtracker.R;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    ImageView imgLogo;
    TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imgLogo = findViewById(R.id.img_logo);
        tvTitle = findViewById(R.id.tv_title);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        },1500);

    }
}