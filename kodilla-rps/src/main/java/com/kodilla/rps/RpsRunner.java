package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        boolean gameFinished = false;

        Game game = new Game();
        game.initGame();


        /*
        klawisz 1 - zagranie "kamień",
                klawisz 2 - zagranie "papier",
                klawisz 3 - zagranie "nożyce",
                klawisz x - zakończenie gry, poprzedzone pytaniem "Czy na pewno zakończyć grę?",
                klawisz n - uruchomienie gry od nowa, poprzedzone pytaniem "Czy na pewno zakończyć aktualną grę?",
        */

        while(!gameFinished) {

            game.playGame();

        }


    }
}
