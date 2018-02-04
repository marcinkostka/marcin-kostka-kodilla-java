package com.kodilla.good.patterns.flightFinder;

public class Flight {

    private String fromCity;
    private String toCity;

    Flight(String fromCity, String toCity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public String getFromCity(){
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!fromCity.equals(flight.fromCity)) return false;
        return toCity.equals(flight.toCity);
    }

    @Override
    public int hashCode() {
        int result = fromCity.hashCode();
        result = 31 * result + toCity.hashCode();
        return result;
    }
}
