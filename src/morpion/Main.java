package morpion;

import morpion.models.Game;
import java.util.Scanner;

public class Main {
    /**
     * Point d’entrée du programme.<br>
     * On demande les noms des deux joueurs puis on lance la partie.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Nom du Joueur 1 (X) : ");
        String name1 = in.nextLine().trim();
        System.out.print("Nom du Joueur 2 (O) : ");
        String name2 = in.nextLine().trim();

        Game game = new Game(name1, name2);
        game.play();
    }
}