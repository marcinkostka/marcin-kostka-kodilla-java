package com.kodilla.good.patterns.challenges;

public class MoviePrint {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        movieStore.getMovies().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .map(n->n+"!")
                .forEach(System.out::print);
    }
}
