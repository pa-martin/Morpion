package morpion.models;

import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Grid grid;
    private final Scanner scanner;

    public Game() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;    // Le joueur 1 commence par défaut
        grid = new Grid();
        scanner = new Scanner(System.in);
    }

    /**
     * La méthode affiche l’état complet de la partie :<br>
     * 1) Informations du joueur 1<br>
     * 2) Informations du joueur 2<br>
     * 3) La grille actuelle<br>
     * Chaque appel à print() sur Game appelle à son tour print() sur Player et Grid.
     */
    public void print() {
        System.out.println("=== État du morpion ===");
        player1.print();
        player2.print();
        System.out.println();
        grid.print();
        System.out.println();
    }

    /**
     * Boucle principale du jeu :<br>
     * - Tant que la partie n’est pas finie (victoire ou égalité), on :<br>
     *   1) affiche l’état actuel<br>
     *   2) demande au joueur courant de jouer<br>
     *   3) traite le coup (placer le symbole, vérifier victoire ou match nul, changer de joueur)<br>
     * - À la fin, on affiche le résultat (victoire ou match nul).<br>
     */
    public void play() {
        boolean finished = false;

        while (!finished) {
            print();
            System.out.println("Au tour de " + currentPlayer.getSymbol());
            System.out.print("Entrez un coup ([A-C][1-3], ex : B2) : ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (!isValidFormat(input)) {
                System.out.println("Format invalide. Veuillez entrer, par exemple : A1, B3, C2...");
                continue;
            }

            int col = input.charAt(0) - 'A';  // 'A' → 0, 'B' → 1, 'C' → 2
            int row = input.charAt(1) - '1';  // '1' → 0, '2' → 1, '3' → 2

            // TODO : tenter de placer le symbole du joueur courant sur la grille

            // TODO : Annoncer une victoire potentielle

            // TODO : S'assurer que la grille n'est pas pleine

            // TODO : Changer de joueur
        }

        scanner.close();
    }

    /**
     * Vérifie que la saisie de l’utilisateur est au format attendu : [A-C][1-3].
     * @param s Chaîne à tester (ex : "A1", "C3", etc.)
     * @return true si le format est valide
     */
    public boolean isValidFormat(String s) {
        // TODO : Exercice 3.1
        return false;
    }
}
