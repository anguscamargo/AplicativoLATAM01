package com.example.latam.daos.seeds;

import com.example.latam.daos.ClientDAO;
import com.example.latam.daos.PetDAO;
import com.example.latam.models.Pet;

import java.util.ArrayList;
import java.util.List;


public class PetsSeeds {
    private static ClientDAO ownerDAO;

    public static List<Pet> getCollection() {
        List<Pet> pets = new ArrayList<>();
        try {
            pets.add(new Pet("Ozzy", "Cachorro", "Pitbull", ownerDAO.find(1)));
            pets.add(new Pet("Bob", "Cachorro", "Golden Retriever", ownerDAO.find(1)));
            pets.add(new Pet("Miau", "Gato", "Persian cat", ownerDAO.find(1)));
            pets.add(new Pet("AuAu", "Cachorro", "Pastor Alemão", ownerDAO.find(1)));

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return pets;
    }

    public static void install(PetDAO petDAO, ClientDAO clientDAO) {
        ownerDAO = clientDAO;
        for (Pet pet : getCollection()) {
            petDAO.insert(pet);
        }
    }
}
