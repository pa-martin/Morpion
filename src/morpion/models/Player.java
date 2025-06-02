package morpion.models;

public class Player {
    private final String name;   // Nom du joueur (par exemple "Alice" ou "Bob")
    private final char symbol;   // Symbole du joueur ('X' ou 'O')

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    /**
     * Affiche les informations du joueur : son nom et son symbole.<br>
     * Ex : "Joueur Alice (X)"
     */
    public void print() {
        System.out.println("Joueur " + name + " (" + symbol + ")");
    }
}

