package com.kodilla.good.patterns.flightFinder;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightsFinder {

    private FlightsDb flightsDb = new FlightsDb();

    private List<Flight> findFlightFrom(String city)
    {
        return flightsDb.getFlightsSet().stream()
                .filter(flight -> flight.getFromCity().equals(city))
                .collect(toList());
    }

    public void printFindFlightFrom(String city){
        System.out.println("Flights from " + city + ": " + findFlightFrom(city));
    }

    private List<Flight> findFlightTo(String city)
    {
        return flightsDb.getFlightsSet().stream()
                .filter(flight -> flight.getToCity().equals(city))
                .collect(toList());
    }

    public void printFindFlightTo(String city){
        System.out.println("Flights to " + city + ": " + findFlightTo(city));
    }

    private List<Flight> findFlightVia(String city)
    {
        List<Flight> toViaCity = findFlightTo(city);
        List<Flight> fromViaCity = findFlightFrom(city);

        toViaCity.addAll(fromViaCity);

        return toViaCity;
    }

    public void printFindFlightVia(String city){
        System.out.println("Flights with change in " + city + ": " + findFlightVia(city));
    }
}