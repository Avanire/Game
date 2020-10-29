package source.main.game;

import source.main.game.character.Summoner;
import source.main.game.game.Game;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Game game = new Game();
        game.startGame();
    }
}
