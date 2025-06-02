package morpion.models;

public class Grid {
    private final char[][] board;  // matrice 3×3 contenant 'X', 'O' ou '\0' pour vide

    public Grid() {
        board = new char[3][3];
        // Par défaut, un tableau de char est initialisé à '\0', qu'on considérera comme case vide.
    }

    /**
     * Tente de placer le symbole d'un joueur sur la grille aux coordonnées indiquées (row, col).
     * @param row Entre 0 et 2 (0 = ligne 1, 2 = ligne 3)
     * @param col Entre 0 et 2 (0 = colonne A, 2 = colonne C)
     * @param symbol 'X' ou 'O'
     * @return true si la case était libre et l’insertion a réussi, false sinon
     */
    public boolean placeMark(int row, int col, char symbol) {
        // TODO : implémenter la logique pour placer un symbole si la case est libre.
        //        Vérifier que row/col sont dans [0,2] et que board[row][col] == '\0'.
        return false;
    }

    /**
     * Vérifie si un joueur (avec le symbole donné) a gagné.<br>
     * @param symbol 'X' ou 'O'
     * @return true si 3 symboles alignés en ligne, colonne ou diagonale.
     */
    public boolean checkWin(char symbol) {
        // TODO : implémenter la détection de victoire (3 lignes, 3 colonnes, 2 diagonales).
        return false;
    }

    /**
     * Vérifie si la grille est pleine (match nul si personne n’a gagné).
     * @return true si toutes les cases sont occupées (≠ '\0').
     */
    public boolean isFull() {
        // TODO : parcourir board et retourner false dès qu'une case == '\0'.
        return false;
    }

    /**
     * Affiche la grille de façon classique, avec en-tête des colonnes [A-C]
     * et numéros de lignes [1-3]. Les cases vides s’affichent comme un espace.<br><br>
     * Exemple d’affichage :<br>
     *   A B C<br>
     * 1 X| |O<br>
     *   -+-+-<br>
     * 2  |X| <br>
     *   -+-+-<br>
     * 3 O| |X
     */
    public void print() {
        // En-tête des colonnes
        System.out.println("  A B C");
        for (int i = 0; i < 3; i++) {
            // Numéro de ligne
            System.out.print((i + 1) + " ");
            // Contenu des 3 colonnes
            for (int j = 0; j < 3; j++) {
                char c = (board[i][j] == '\0') ? ' ' : board[i][j];
                System.out.print(c);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            // Si ce n’est pas la dernière ligne, afficher la ligne de séparation
            if (i < 2) {
                System.out.println("  -+-+-");
            }
        }
    }
}
