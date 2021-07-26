package com.example.latam.activities.clients;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latam.activities.MainMenuActivity;
import com.example.latam.daos.ClientDAO;
import com.example.latam.models.Client;
import com.example.pets.R;
import com.example.latam.activities.pets.PetsActivity;
import com.example.latam.utils.ClientListAdapter;

import java.util.List;

public class ClientsActivity extends AppCompatActivity {
    private RecyclerView recyclerListClients;
    private ClientDAO clientDAO;
    private List<Client> clients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clients_activity);
        TextView textHeader = findViewById(R.id.textHeader);
        textHeader.setText(R.string.clients);

        clientDAO = new ClientDAO(this);
        clients = clientDAO.list();

        recyclerListClients = findViewById(R.id.recyclerListClients);
        recyclerListClients.setAdapter(new ClientListAdapter(this, clients));
        recyclerListClients.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void goToNewClient(View view) {
        startActivity(new Intent(this, ClientNewActivity.class));
    }

    public void edit(View view, int clientID) {
        Intent intent = new Intent(this, ClientNewActivity.class);
        intent.putExtra("id", clientID);
        startActivity(intent);
    }

    public void show(View view, int clientID) {
        Intent intent = new Intent(this, ClientShowActivity.class);
        intent.putExtra("id", clientID);
        startActivity(intent);
    }

    public void pets(View view, int clientID) {
        Intent intent = new Intent(this, PetsActivity.class);
        intent.putExtra("clientID", clientID);
        startActivity(intent);
    }

    public void remove(View view, int clientID) {
        if (clientDAO.delete(clientID)) {
            Toast.makeText(this, "Cliente id: " + clientID + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro na execução desta remoção do cliente!", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this, ClientsActivity.class));
    }
}
