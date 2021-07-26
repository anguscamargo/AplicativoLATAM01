package com.example.latam.daos.seeds;

import com.example.latam.daos.AirportDAO;
import com.example.latam.models.Airport;

import java.util.ArrayList;
import java.util.List;


public class AirportSeeds {

     public static List<Airport> getCollection() {
        List<Airport> airport = new ArrayList<>();
        airport.add(new Airport("Coleira Canina", 1, 20, 15.99));
        airport.add(new Airport("Arranhador", 1, 90, 9.99));
        airport.add(new Airport("Aquario Pequeno", 1, 60, 5.59));
        airport.add(new Airport("Ração", 1, 60, 5.59));

        return airport;
    }

    public static void install(AirportDAO userDAO){
        for (Airport user : getCollection()){
            userDAO.insert(user);
        }
    }
}
