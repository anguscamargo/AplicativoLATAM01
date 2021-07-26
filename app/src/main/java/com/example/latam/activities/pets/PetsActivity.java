package com.example.latam.activities.pets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latam.activities.clients.ClientsActivity;
import com.example.latam.daos.PetDAO;
import com.example.pets.R;
import com.example.latam.models.Pet;
import com.example.latam.utils.PetListAdapter;

import java.util.List;

public class PetsActivity extends AppCompatActivity {

    private RecyclerView recyclerListPets;
    private PetDAO petDAO;
    private List<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pets_activity);
        TextView textHeader = findViewById(R.id.textHeader);
        textHeader.setText(R.string.pets);

        petDAO = new PetDAO(this);
        pets = petDAO.list(getIntent().getExtras().getInt("clientID"));

        recyclerListPets = findViewById(R.id.recyclerListPets);
        recyclerListPets.setAdapter(new PetListAdapter(this, pets));
        recyclerListPets.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, ClientsActivity.class));
    }

    public void goToNewPet(View view) {
        Intent intent = new Intent(this, PetNewActivity.class);
        intent.putExtra("clientID", getIntent().getExtras().getInt("clientID"));
        startActivity(intent);
    }

    public void edit(View view, int petID) {
        Intent intent = new Intent(this, PetNewActivity.class);
        intent.putExtra("id", petID);
        startActivity(intent);
    }

    public void show(View view, int petID) {
        Intent intent = new Intent(this, PetShowActivity.class);
        intent.putExtra("id", petID);
        startActivity(intent);
    }

    public void remove(View view, int petID) {
        if (petDAO.delete(petID)) {
            Toast.makeText(this, "Pet id: " + petID + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro na execução desta remoção do pet!", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this, PetsActivity.class));
    }
}
