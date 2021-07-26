package com.example.latam.activities.airports;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pets.R;

public class AirportEditActivity extends AppCompatActivity {
    private EditText editInitials, editUf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airport_new_activity);
        editInitials = findViewById(R.id.editInitials);
        editUf = findViewById(R.id.editUf);
    }

    public void save(View view) {
        try {
            Toast.makeText(this, "Novo aeroporto inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, AirportsActivity.class));
    }
}
