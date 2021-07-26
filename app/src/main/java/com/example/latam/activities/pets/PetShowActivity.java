package com.example.latam.activities.pets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latam.daos.PetDAO;
import com.example.pets.R;
import com.example.latam.models.Pet;

public class PetShowActivity extends AppCompatActivity {

    private Pet pet;
    private PetDAO petDAO;
    TextView textShowName, textShowSpecies, textShowBreed, textShowOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_show_activity);
        petDAO = new PetDAO(this);
        pet = petDAO.find(getIntent().getExtras().getInt("id"));

        textShowName = findViewById(R.id.textShowName);
        textShowSpecies = findViewById(R.id.textShowSpecies);
        textShowBreed = findViewById(R.id.textShowBreed);

        textShowName.setText(pet.getName());
        textShowSpecies.setText(String.valueOf(pet.getSpecies()));
        textShowBreed.setText(String.valueOf(pet.getBreed()));
    }

    public void back(View view) {
        startActivity(new Intent(this, PetsActivity.class));
    }
}
