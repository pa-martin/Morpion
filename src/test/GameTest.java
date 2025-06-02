package test;

import static org.junit.jupiter.api.Assertions.*;

import morpion.models.Game;
import org.junit.jupiter.api.*;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testIsValidFormatValidInputs() {
        assertTrue(game.isValidFormat("A1"), "A1 est un format valide");
        assertTrue(game.isValidFormat("B2"), "B2 est un format valide");
        assertTrue(game.isValidFormat("C3"), "C3 est un format valide");
    }

    @Test
    public void testIsValidFormatInvalidInputs() {
        // Longueur incorrecte
        assertFalse(game.isValidFormat("A"), "Trop court → invalide");
        assertFalse(game.isValidFormat("A12"), "Trop long → invalide");
        // Colonne hors [A-C]
        assertFalse(game.isValidFormat("D1"), "Lettre D non autorisée → invalide");
        assertFalse(game.isValidFormat("a1"), "Minuscule 'a' → invalide si pas encore converti (pré-requis .toUpperCase en amont)");
        // Ligne hors [1-3]
        assertFalse(game.isValidFormat("A0"), "0 non autorisé → invalide");
        assertFalse(game.isValidFormat("C4"), "4 non autorisé → invalide");
        // Format incorrect
        assertFalse(game.isValidFormat("11"), "Première position n'est pas lettre → invalide");
        assertFalse(game.isValidFormat("AA"), "Deuxième position n'est pas chiffre → invalide");
    }
}

