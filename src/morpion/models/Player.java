package morpion.models;

public class Player {
    private final char symbol;   // Symbole du joueur ('X' ou 'O')

    public Player(char symbol) {
        this.symbol = symbol;
    }


    public char getSymbol() {
        return symbol;
    }

    /**
     * Affiche les informations du joueur : son nom et son symbole.<br>
     * Exemple : "Joueur Alice (X)"
     */
    public void print() {
        System.out.println("Joueur " + symbol);
    }
}
