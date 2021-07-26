package com.example.latam.activities.airports;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latam.activities.MainMenuActivity;
import com.example.latam.activities.users.UserNewActivity;
import com.example.latam.daos.AirportDAO;
import com.example.latam.models.Airport;
import com.example.latam.utils.AirportListAdapter;
import com.example.pets.R;

import java.util.List;

public class AirportsActivity extends AppCompatActivity {
    private RecyclerView recyclerListAirports;
    private AirportDAO airportDAO;
    private List<Airport> airports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airports_activity);
        TextView textHeader = findViewById(R.id.textAirports);
        //textHeader.setText(R.string.airport);


        airportDAO = new AirportDAO(this);
        airports = airportDAO.list();

        recyclerListAirports = findViewById(R.id.recyclerListAirports);
        recyclerListAirports.setAdapter(new AirportListAdapter(this, airports));
        recyclerListAirports.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void goToNewAirport(View view) {
        startActivity(new Intent(this, AirportNewActivity.class));
    }

    public void edit(View view, int airportID) {
        Intent intent = new Intent(this, AirportNewActivity.class);
        intent.putExtra("id", airportID);
        startActivity(intent);
    }

    public void show(View view, int airportID) {
        Intent intent = new Intent(this, AirportShowActivity.class);
        intent.putExtra("id", airportID);
        startActivity(intent);
    }

    public void remove(View view, int airportID) {
        if (airportDAO.delete(airportID)) {
            Toast.makeText(this, "Aeroporto id: " + airportID + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro na execução desta remoção do aeroporto!", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this, AirportsActivity.class));
    }
}
