package morpion;

import morpion.models.Game;

public class Main {
    /**
     * Point d’entrée du programme.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}