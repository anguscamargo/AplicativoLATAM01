package com.example.latam.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.latam.factories.DatabaseFactory;
import com.example.latam.models.Pet;
import com.example.latam.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    private SQLiteDatabase database;
    private ClientDAO clientDAO;
    private Context context;

    public PetDAO(Context context) {
        this.context = context;
        database = Connection.getInstance(context);
        clientDAO = new ClientDAO(context);
//        PetsSeeds.install(this, clientDAO);
    }

    public void insert(Pet pet) {
        try {
            ContentValues values = new ContentValues();
            values.put("name", pet.getName());
            values.put("species", pet.getSpecies());
            values.put("breed", pet.getBreed());
            values.put("owner_id", pet.getOwner().getId());
            database.insert("pet", null, values);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public List<Pet> list(int ownerID) {
        List<Pet> pets = new ArrayList<>();
        final String WHERE = "pet.owner_id=" + ownerID;

        try {
            Cursor cursor = database.query("pet", DatabaseFactory.PET_COLUMNS, WHERE, null, null, null, null);

            while (cursor.moveToNext()) {
                Pet pet = new Pet();
                pet.setId(cursor.getInt(0));
                pet.setName(cursor.getString(1));
                pet.setSpecies(cursor.getString(2));
                pet.setBreed(cursor.getString(3));
                pet.setOwner(clientDAO.find(cursor.getInt(4)));
                pets.add(pet);
            }
        } catch (SQLException e) {
            Toast.makeText(context, "O banco está criado, porém, vazio.", Toast.LENGTH_SHORT).show();
        }

        return pets;
    }

    public Pet find(int id) {
        Pet pet = new Pet();
        final String WHERE = "pet.id=" + id;

        try {
            Cursor cursor = database.query("pet", DatabaseFactory.PET_COLUMNS, WHERE, null, null, null, null);
            cursor.moveToFirst();
            pet.setId(cursor.getInt(0));
            pet.setName(cursor.getString(1));
            pet.setSpecies(cursor.getString(2));
            pet.setBreed(cursor.getString(3));
            pet.setOwner(clientDAO.find(cursor.getInt(4)));

        } catch (SQLiteException e) {
            database.close();
        }
        return pet;
    }

    public void update(Pet pet) {
        String sql = "";
    }

    public boolean delete(int id) {
        final String WHERE = "pet.id=" + id;

        try {
            database.delete("pet", WHERE, null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
