package com.example.latam.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.latam.models.Client;
import com.example.latam.factories.DatabaseFactory;
import com.example.latam.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private SQLiteDatabase database;
    private Context context;

    public ClientDAO(Context context) {
        this.context = context;
        database = Connection.getInstance(context);
//        ClientsSeeds.install(this);
    }

    public void insert(Client client) {
        try {
            ContentValues values = new ContentValues();
            values.put("name", client.getName());
            values.put("surname", client.getSurname());
            values.put("CPF", client.getCPF());
            values.put("email", client.getEmail());
            database.insert("client", null, values);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public List<Client> list() {
        List<Client> clients = new ArrayList<>();

        try {
            Cursor cursor = database.query("client", DatabaseFactory.ClIENT_COLUMNS, null, null, null, null, null);

            while (cursor.moveToNext()) {
                Client client = new Client();
                client.setId(cursor.getInt(0));
                client.setName(cursor.getString(1));
                client.setSurname(cursor.getString(2));
                client.setCPF(cursor.getLong(3));
                client.setEmail(cursor.getString(4));
                clients.add(client);
            }
        } catch (SQLException e) {
            Toast.makeText(context, "O banco está criado, porém, vazio.", Toast.LENGTH_SHORT).show();
        }

        return clients;
    }

    public Client find(int id) {
        Client client = new Client();
        final String WHERE = "client.id=" + id;

        try {
            Cursor cursor = database.query("client", DatabaseFactory.ClIENT_COLUMNS, WHERE, null, null, null, null);
            cursor.moveToFirst();
            client.setId(cursor.getInt(0));
            client.setName(cursor.getString(1));
            client.setSurname(cursor.getString(2));
            client.setCPF(cursor.getLong(3));
            client.setEmail(cursor.getString(4));
            return client;

        } catch (SQLiteException e) {
            database.close();
            throw new RuntimeException(e);
        }
    }

    public void update(Client client) {
        String sql = "";
    }

    public boolean delete(int id) {
        final String WHERE = "client.id=" + id;

        try {
            database.delete("client", WHERE, null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
