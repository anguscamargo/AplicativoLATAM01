package com.example.latam.factories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseFactory extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "pets_app.db";
    public static final int VERSION = 1;
    public static final String[] USER_COLUMNS = {"id", "name", "surname", "CPF", "password", "phone", "role", "admin"};
    public static final String[] ClIENT_COLUMNS = {"id", "name", "surname", "CPF", "email"};
    public static final String[] AIRPORT_COLUMNS = {"id", "name", "category", "quantity", "price",};
    public static final String[] PET_COLUMNS = {"id", "name", "species", "breed", "owner_id"};
    private Context context;

    public DatabaseFactory(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        createTableUser(database);
        createTableClient(database);
        createTableAirport(database);
        createTablePet(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        dropTableDropUser(database);
        dropTableDropClient(database);
        dropTableDropAirport(database);
        dropTableDropPet(database);
    }

    /*(((USERS)))*/

    public void createTableUser(SQLiteDatabase database) {
        try {
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(25) NOT NULL," +
                "surname VARCHAR(25) NOT NULL," +
                "CPF BIGINT NOT NULL UNIQUE, " +
                "password VARCHAR(8) NOT NULL, " +
                "phone BIGINT UNIQUE," +
                "role TINYINT," +
                "admin INTEGER NOT NULL DEFAULT 0)";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void dropTableDropUser(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS user";
        database.execSQL(sql);
    }

    /*(((CLIENTS)))*/

    public void createTableClient(SQLiteDatabase database) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS client (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(25) NOT NULL," +
                    "surname VARCHAR(25) NOT NULL," +
                    "CPF BIGINT NOT NULL UNIQUE, " +
                    "email VARCHAR(25) NOT NULL);";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void dropTableDropClient(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS client";
        database.execSQL(sql);
    }

    /*(((AIRPORTS)))*/

    public void createTableAirport(SQLiteDatabase database) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS airport (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(25) NOT NULL," +
                    "category TINYINT NOT NULL," +
                    "quantity TINYINT NOT NULL," +
                    "price DECIMAL NOT NULL);";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void dropTableDropAirport(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS airport";
        database.execSQL(sql);
    }

    /*(((PETS)))*/

    public void createTablePet(SQLiteDatabase database) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS pet (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(25) NOT NULL UNIQUE," +
                    "species VARCHAR(25) NOT NULL," +
                    "breed VARCHAR(25) NOT NULL, " +
                    "owner_id INTEGER NOT NULL," +
                    "FOREIGN KEY(owner_id) REFERENCES client(id));";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void dropTableDropPet(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS pet";
        database.execSQL(sql);
    }
}
