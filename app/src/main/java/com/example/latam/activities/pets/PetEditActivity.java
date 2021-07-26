package com.example.latam.activities.pets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latam.daos.PetDAO;
import com.example.pets.R;

public class PetEditActivity extends AppCompatActivity {
    private EditText editId, editName,editSpecies, editBreed;
    private PetDAO petDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_new_activity);
        editName = findViewById(R.id.editName);
        editSpecies = findViewById(R.id.editSpecies);
        editBreed = findViewById(R.id.editBreed);
        petDAO = new PetDAO(this);
    }

    public void save(View view) {
        try {
            Toast.makeText(this, "Novo pet inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, PetsActivity.class));
    }
}
