package com.example.shayriapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView logo=findViewById(R.id.logo);
        TextView appName=findViewById(R.id.appName);
        TextView powerBy=findViewById(R.id.powerBy);
        int splashTimeOut=3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,Home.class);
                startActivity(intent);
                finish();//wehn we back then splash screen menhi ana hai

            }
        },splashTimeOut);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.splashscreen);
        logo.startAnimation(animation);
        appName.startAnimation(animation);
        powerBy.startAnimation(animation);

        //hide the back button



        }


    }
