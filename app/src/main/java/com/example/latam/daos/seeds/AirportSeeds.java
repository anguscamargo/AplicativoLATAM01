package com.example.latam.daos.seeds;

import com.example.latam.daos.AirportDAO;
import com.example.latam.models.Airport;

import java.util.ArrayList;
import java.util.List;


public class AirportSeeds {

     public static List<Airport> getCollection() {
        List<Airport> airport = new ArrayList<>();
        airport.add(new Airport("GRU", "SP"));
        airport.add(new Airport("CGH", "SP"));
        airport.add(new Airport("GIG", "RJ"));
        airport.add(new Airport("SDU", "RJ"));
        return airport;
    }

    public static void install(AirportDAO airportDAO){
        for (Airport airport : getCollection()){
            airportDAO.insert(airport);
        }
    }
}
