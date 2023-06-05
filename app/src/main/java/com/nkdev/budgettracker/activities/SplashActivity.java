package com.nkdev.budgettracker.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nkdev.budgettracker.R;

public class SplashActivity extends AppCompatActivity {
    //Get reference to the LinearLayout that will hold the background animation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the status bar and make the splash screen a full-screen activity
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        // Get the reference of the background image for animation
        ImageView backgroundImage = findViewById(R.id.SplashScreenImage);
        RelativeLayout layout = findViewById(R.id.id_layout);
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        layout.startAnimation(slideAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, OnboardingActivity.class);
                startActivity(intent);
                finish();
            }
        }, 6000); // 3000 is the delayed time in milliseconds


    }
}