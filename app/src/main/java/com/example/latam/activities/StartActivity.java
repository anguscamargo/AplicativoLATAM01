package com.example.latam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pets.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }

    public void login(View view) {
        Intent intent = new Intent(this, MainMenuActivity.class);
//        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
