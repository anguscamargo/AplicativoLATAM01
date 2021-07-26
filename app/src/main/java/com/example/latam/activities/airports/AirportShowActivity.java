package com.example.latam.activities.airports;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latam.daos.AirportDAO;
import com.example.latam.enums.Category;
import com.example.latam.models.Airport;
import com.example.pets.R;

public class AirportShowActivity extends AppCompatActivity {
    private Airport airport;
    private AirportDAO airportDAO;
    TextView textHeader, textShowName, textShowCategory, textShowAvailablility, textShowPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airport_show_activity);
        airportDAO = new AirportDAO(this);
        airport = airportDAO.find(getIntent().getExtras().getInt("id"));

        textHeader = findViewById(R.id.textHeader);
        textShowCategory = findViewById(R.id.textShowCategory);
        textShowAvailablility = findViewById(R.id.textShowAvailablility);
        textShowPrice = findViewById(R.id.textShowPrice);

        textHeader.setText(airport.getName());
        textShowName.setText(String.valueOf(airport.getName()));
        textShowCategory.setText(Category.stringfy(airport.getCategory()));
        textShowAvailablility.setText(String.valueOf(airport.getQuantity()));
        textShowPrice.setText(airport.toCurrency(airport.getPrice()));
    }

    public void back(View view) {
        startActivity(new Intent(this, AirportsActivity.class));
    }
}
