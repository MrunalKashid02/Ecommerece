package com.example.myapplicationcart;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplicationcart.databinding.ActivitySplashScreenBinding;

public class Splash_Screen extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        reverseTimer(2);
    }

    private void reverseTimer(int Second) {
        new CountDownTimer(Second* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                open();

            }
        }.start();
    }
    private void open(){
        Intent intent = new Intent(this,Sign_UP.class);
        startActivity(intent);
        finish();
    }

}