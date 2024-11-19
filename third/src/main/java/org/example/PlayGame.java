package org.example;

public class PlayGame {
    private Game game;
    public PlayGame() {
        game = new Game(3);
    }
    public PlayGame(int countNumber) {
        game = new Game(countNumber);
    }
    public boolean play(boolean changeChoose) {
//        game.showDoors();
        game.dellDoor();
        if (!changeChoose)
            return game.knowResult(0);

        return game.knowResult(1);
    }
}
