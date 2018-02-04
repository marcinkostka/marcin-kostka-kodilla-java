package com.kodilla.good.patterns.flightFinder;

class Application
{
    public static void main(String[] args)
    {
        FlightsFinder flightsFinder = new FlightsFinder();
        flightsFinder.printFindFlightFrom("Katowice");
        flightsFinder.printFindFlightTo("Katowice");
        flightsFinder.printFindFlightVia("Katowice");
    }
}

