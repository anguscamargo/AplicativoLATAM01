package com.example.latam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.latam.activities.airports.AirportsActivity;
import com.example.pets.R;
import com.example.latam.activities.clients.ClientsActivity;
import com.example.latam.activities.users.UsersActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
    }

    public void goToUsers(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }

    public void goToClients(View view) {
        startActivity(new Intent(this, ClientsActivity.class));
    }

    public void goToAirports(View view) {
        startActivity(new Intent(this, AirportsActivity.class));
    }
}
