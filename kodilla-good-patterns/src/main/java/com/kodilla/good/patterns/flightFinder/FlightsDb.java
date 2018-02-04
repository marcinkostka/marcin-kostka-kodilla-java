package com.kodilla.good.patterns.flightFinder;

import java.util.HashSet;
import java.util.Set;

public class FlightsDb {

    private Set<Flight> flightsSet = new HashSet<>();
    {
        flightsSet.add(new Flight("Katowice", "Warszawa"));
        flightsSet.add(new Flight("Katowice", "Kraków"));
        flightsSet.add(new Flight("Katowice", "Rzeszów"));
        flightsSet.add(new Flight("Kraków", "Gdynia"));
        flightsSet.add(new Flight("Kraków", "Lódź"));
        flightsSet.add(new Flight("Rzeszów", "Lódź"));
        flightsSet.add(new Flight("Kraków", "Katowice"));
        flightsSet.add(new Flight("Rzeszów", "Lódź"));
        flightsSet.add(new Flight("Lódź", "Katowice"));
    }

    public Set<Flight> getFlightsSet() {
        return flightsSet;
    }

    @Override
    public String toString() {
        return "FlightsDb{" +
                "flightsSet=" + flightsSet +
                '}';
    }
}
