package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSchedule {

    Map<String, Boolean> arrivalPossibilityMap = new HashMap<>();
    {
        arrivalPossibilityMap.put("Warszawa", true);
        arrivalPossibilityMap.put("Paryż", false);
        arrivalPossibilityMap.put("Moskwa", false);
        arrivalPossibilityMap.put("Londyn", true);
        arrivalPossibilityMap.put("Berlin", false);
        arrivalPossibilityMap.put("Chicago", true);
        arrivalPossibilityMap.put("Lizbona", true);
        arrivalPossibilityMap.put("Oslo", true);
    }

    public Map<String, Boolean> getArrivalPossibilityMap() {
        return arrivalPossibilityMap;
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        if (flight != null) {
            if (!arrivalPossibilityMap.containsKey(flight.getArrivalAirport())) {
                throw new RouteNotFoundException(flight);
            } else {
                return arrivalPossibilityMap.get(flight.getArrivalAirport());
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void schedulePrint(){
        System.out.println("Schedule print:");
        for (Map.Entry<String,Boolean> entry: arrivalPossibilityMap.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}