package com.example.latam.activities.airports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latam.daos.AirportDAO;
import com.example.latam.daos.UserDAO;
import com.example.latam.models.Airport;
import com.example.latam.models.User;
import com.example.pets.R;

public class AirportNewActivity extends AppCompatActivity {
    private EditText editInitials, editUf;
    private AirportDAO airportDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airport_new_activity);
        editInitials = findViewById(R.id.editInitials);
        editUf = findViewById(R.id.editUf);
        airportDAO = new AirportDAO(this);


    }

    // TODO método para escurecer o fundo do input quando este estiver com focus

    public void save(View view) {
        try {
            airportDAO.insert(new Airport(
                    editInitials.getText().toString(),
                    editUf.getText().toString())
            );
            Toast.makeText(this, "Novo aeroporto inserido com sucesso!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AirportsActivity.class));

        } catch (SQLException e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AirportNewActivity.class));
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, AirportsActivity.class));
    }
}