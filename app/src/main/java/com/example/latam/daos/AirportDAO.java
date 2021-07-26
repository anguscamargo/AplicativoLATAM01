package com.example.latam.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.latam.factories.DatabaseFactory;
import com.example.latam.models.Airport;
import com.example.latam.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class AirportDAO {
    private SQLiteDatabase database;
    private Context context;

    public AirportDAO(Context context) {
        this.context = context;
        database = Connection.getInstance(context);
//        AirportsSeeds.install(this);
    }

    public void insert(Airport airport) {
        try {
            ContentValues values = new ContentValues();
            values.put("name", airport.getName());
            values.put("category", airport.getCategory());
            values.put("quantity", airport.getQuantity());
            values.put("price", airport.getPrice());
            database.insert("airport", null, values);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public List<Airport> list() {
        List<Airport> airports = new ArrayList<>();

        try {
            Cursor cursor = database.query("airport", DatabaseFactory.AIRPORT_COLUMNS, null, null, null, null, null);

            while (cursor.moveToNext()) {
                Airport airport = new Airport();
                airport.setId(cursor.getInt(0));
                airport.setName(cursor.getString(1));
                airport.setCategory(cursor.getInt(2));
                airport.setQuantity(cursor.getInt(3));
                airport.setPrice(cursor.getDouble(4));
                airports.add(airport);
            }
        } catch (SQLException e) {
            Toast.makeText(context, "O banco está criado, porém, vazio.", Toast.LENGTH_SHORT).show();
        }

        return airports;
    }

    public Airport find(int id) {
        Airport airport = new Airport();
        final String WHERE = "airport.id=" + id;

        try {
            Cursor cursor = database.query("airport", DatabaseFactory.AIRPORT_COLUMNS, WHERE, null, null, null, null);
            cursor.moveToFirst();
            airport.setId(cursor.getInt(0));
            airport.setName(cursor.getString(1));
            airport.setCategory(cursor.getInt(2));
            airport.setQuantity(cursor.getInt(3));
            airport.setPrice(cursor.getDouble(4));

        } catch (SQLiteException e) {
            database.close();
        }
        return airport;
    }

    public Airport findByName(String name) {
        return null;
    }

    public void update(Airport airport) {
        String sql = "";
    }

    public boolean delete(int id) {
        final String WHERE = "airport.id=" + id;

        try {
            database.delete("airport", WHERE, null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
