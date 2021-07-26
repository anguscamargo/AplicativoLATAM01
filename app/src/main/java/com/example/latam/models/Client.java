package com.example.latam.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private long CPF;
    private List<Pet> pets;

    public Client() {
        this.pets = new ArrayList<>();
    }

    public Client(String name, String surname, long CPF, String email) {
        this.name = name;
        this.CPF = CPF;
        this.surname = surname;
        this.email = email;
        this.pets = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName(){
        return String.format("%s %s", name, surname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
