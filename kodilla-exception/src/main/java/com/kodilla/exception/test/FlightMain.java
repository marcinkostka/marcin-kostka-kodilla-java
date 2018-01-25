package com.kodilla.exception.test;

import java.util.HashSet;
import java.util.Set;

public class FlightMain {

    public static void main(String[] args){

        Set<Flight> flightSet = new HashSet<>();
        String departureAirport = "Katowice";
        flightSet.add(new Flight(departureAirport, "Warszawa"));
        flightSet.add(new Flight(departureAirport, "Madryt"));
        flightSet.add(new Flight(departureAirport, "Rzym"));
        flightSet.add(new Flight(departureAirport, "Moskwa"));
        flightSet.add(new Flight(departureAirport, "Berlin"));
        flightSet.add(new Flight(departureAirport, "Londyn"));
        flightSet.add(new Flight(departureAirport, "Oslo"));
        flightSet.add(null);

        FlightSchedule flightSchedule = new FlightSchedule();

        for (Flight flight: flightSet) {
            try {
                if (!flightSchedule.findFlight(flight)){
                    System.out.println(flight.getArrivalAirport()
                            + " airport is closed. Flight: "
                            + flight + " is not possible");
                }
            } catch (RouteNotFoundException e) {
                System.out.println("Error: "+e);
            } catch (NullPointerException e){
                System.out.println("Error: "+e);
            }
        }

    }
}