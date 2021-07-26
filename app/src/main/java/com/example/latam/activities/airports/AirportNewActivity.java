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

import com.example.latam.activities.StartActivity;
import com.example.latam.daos.AirportDAO;
import com.example.latam.models.Airport;
import com.example.pets.R;

public class AirportNewActivity extends AppCompatActivity {
    private EditText editName, editQuantity, editPrice;
    private Spinner spinnerCategory;
    private AirportDAO airportDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airport_new_activity);
        editName = findViewById(R.id.editName);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        editPrice = findViewById(R.id.editPrice);
        editQuantity = findViewById(R.id.editQuantity);
        airportDAO = new AirportDAO(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textSelected = ((TextView) view);
                spinnerCategory.setSelection(position);
                textSelected.setGravity(Gravity.CENTER);
                textSelected.setTextColor(Color.parseColor("#10375E"));
                textSelected.setWidth(spinnerCategory.getWidth());
                textSelected.setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void save(View view) {
        try {
            airportDAO.insert(new Airport(
                    editName.getText().toString(),
                    spinnerCategory.getSelectedItemPosition(),
                    Integer.parseInt(editQuantity.getText().toString()),
                    Double.parseDouble(editPrice.getText().toString())
            ));

            Toast.makeText(this, "Novo produto inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AirportNewActivity.class));
        }
        startActivity(new Intent(this, StartActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
