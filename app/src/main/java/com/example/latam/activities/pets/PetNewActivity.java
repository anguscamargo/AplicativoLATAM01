package com.example.latam.activities.pets;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.latam.daos.ClientDAO;
import com.example.latam.daos.PetDAO;
import com.example.pets.R;
import com.example.latam.models.Pet;

public class PetNewActivity extends AppCompatActivity {
    private EditText editName, editSpecies, editBreed;
    private ClientDAO ownerDAO;
    private PetDAO petDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_new_activity);
        petDAO = new PetDAO(this);
        ownerDAO = new ClientDAO(this);
        editName = findViewById(R.id.editName);
        editSpecies = findViewById(R.id.editSpecies);
        editBreed = findViewById(R.id.editBreed);
    }

    public void save(View view) {
        try {
            petDAO.insert(new Pet(
                    editName.getText().toString(),
                    editSpecies.getText().toString(),
                    editBreed.getText().toString(),
                    ownerDAO.find(getIntent().getExtras().getInt("clientID"))
            ));

            Toast.makeText(this, "Novo pet inserido com sucesso!", Toast.LENGTH_SHORT).show();
            goTo(PetsActivity.class);

        } catch (SQLException e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            goTo(PetNewActivity.class);
        }
    }

    public void back(View view) {
        goTo(PetsActivity.class);
    }

    public void goTo(Class<?> activity){
        Intent intent = new Intent(this, activity);
        intent.putExtra("clientID", getIntent().getExtras().getInt("clientID"));
        startActivity(intent);
    }
}
