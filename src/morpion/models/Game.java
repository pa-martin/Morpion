package morpion.models;

import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Grid grid;
    private final Scanner scanner;

    public Game(String name1, String name2) {
        player1 = new Player(name1, 'X');
        player2 = new Player(name2, 'O');
        currentPlayer = player1;    // Le joueur 1 commence
        grid = new Grid();
        scanner = new Scanner(System.in);
    }

    /**
     * La méthode print() affiche l’état complet de la partie :<br>
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
     * Lance la boucle principale du jeu : <br>
     * - Tant que la partie n’est pas finie (victoire ou égalité), on
     *   affiche la grille, on demande au joueur courant de jouer,
     *   puis on change de joueur.<br>
     * - À la fin, on affiche le résultat (victoire ou match nul).
     */
    public void play() {
        boolean finished = false;

        while (!finished) {
            print();
            System.out.println("Au tour de " + currentPlayer.getName() +
                    " (" + currentPlayer.getSymbol() + ").");
            System.out.print("Entrez un coup ([A-C][1-3], ex : B2) : ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (!isValidFormat(input)) {
                System.out.println("Format invalide. Veuillez entrer, par ex., A1, B3, C2...");
                continue;
            }

            int col = input.charAt(0) - 'A';      // 'A' → 0, 'B' → 1, 'C' → 2
            int row = input.charAt(1) - '1';      // '1' → 0, '2' → 1, '3' → 2

            if (!grid.placeMark(row, col, currentPlayer.getSymbol())) {
                System.out.println("Case déjà occupée ou invalide. Réessayez.");
                continue;
            }

            // Vérifier si le joueur courant a gagné
            if (grid.checkWin(currentPlayer.getSymbol())) {
                print();  // Afficher l’état final
                System.out.println("Bravo " + currentPlayer.getName() + " ! Vous avez gagné.");
                finished = true;
            }
            // Sinon vérification d’une grille pleine ⇒ match nul
            else if (grid.isFull()) {
                print();
                System.out.println("Match nul ! La grille est pleine.");
                finished = true;
            }
            else {
                // On passe au joueur suivant
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }

        scanner.close();
    }

    /**
     * Vérifie que l’entrée est au format attendu ([A-C][1-3]).
     */
    private boolean isValidFormat(String s) {
        if (s.length() != 2) {
            return false;
        }
        char c0 = s.charAt(0);
        char c1 = s.charAt(1);
        return (c0 >= 'A' && c0 <= 'C') && (c1 >= '1' && c1 <= '3');
    }
}

