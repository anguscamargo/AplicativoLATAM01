package com.example.latam.daos.seeds;

import com.example.latam.daos.ClientDAO;
import com.example.latam.models.Client;

import java.util.ArrayList;
import java.util.List;


public class ClientsSeeds {

     public static List<Client> getCollection() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Lucas", "Barretto", 00011122233L, "lucas@teste.com"));
        clients.add(new Client("Gabriel", "Camargo", 11122233344L, "gabriel@teste.com"));
        clients.add(new Client("Nicholas", "Muniz", 22233344455L, "nicholas@teste.com"));
        clients.add(new Client("Brenda", "Glicéria", 33344455566L, "brenda@teste.com"));
        return clients;
    }

    public static void install(ClientDAO clientDAO){
        for (Client client : getCollection()){
            clientDAO.insert(client);
        }
    }
}
