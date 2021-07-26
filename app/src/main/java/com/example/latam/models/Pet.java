package com.example.latam.models;

import java.io.Serializable;

public class Pet implements Serializable {

    private int id;
    private String name;
    private String species;
    private String breed;
    private Client owner;

    public Pet() {
    }

    public Pet(Client owner) {
        this.owner = owner;
    }

    public Pet(String name, String species, String breed, Client owner) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}
