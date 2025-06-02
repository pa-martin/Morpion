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
            //        Si placeMark(row, col, currentPlayer.getSymbol()) retourne false,
            //        afficher un message du type « Case déjà occupée ou invalide. Réessayez. »
            //        et continuer la boucle.

            // TODO : si grid.checkWin(currentPlayer.getSymbol()) retourne true :
            //           - appeler print() pour afficher l’état final
            //           - afficher « Bravo <nom> ! Vous avez gagné. »
            //           - mettre finished à true

            // TODO : sinon si grid.isFull() retourne true :
            //           - appeler print() pour afficher la grille pleine
            //           - afficher « Match nul ! La grille est pleine. »
            //           - mettre finished à true

            // TODO : sinon (la partie continue), basculer currentPlayer :
            //           currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        scanner.close();
    }

    /**
     * Vérifie que la saisie de l’utilisateur est au format attendu : [A-C][1-3].
     * @param s Chaîne à tester (ex : "A1", "C3", etc.)
     * @return true si s.length()==2, s.charAt(0) ∈ {'A','B','C'} et s.charAt(1) ∈ {'1','2','3'}
     */
    private boolean isValidFormat(String s) {
        // TODO : implémenter la vérification du format.
        return false;
    }
}
