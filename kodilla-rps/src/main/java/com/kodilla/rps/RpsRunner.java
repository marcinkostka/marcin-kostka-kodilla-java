package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {

        Game game = new Game();
        game.initGame();

        while(!Game.QUIT_GAME) {

            if(!Game.NEW_GAME){
                game.playGame();
            } else {
                game.initGame();
            }
        }
    }
}
