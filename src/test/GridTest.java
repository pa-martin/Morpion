package test;

import static org.junit.jupiter.api.Assertions.*;

import morpion.models.Grid;
import org.junit.jupiter.api.*;

public class GridTest {

    private Grid grid;

    @BeforeEach
    public void setUp() {
        grid = new Grid();
    }

    @Test
    public void testInitialIsFullAndNoWin() {
        // Grille initialement vide → pas pleine, pas de victoire
        assertFalse(grid.isFull(), "Une grille vide ne doit pas être considérée comme pleine");
        assertFalse(grid.checkWin('X'), "Aucune victoire pour 'X' sur grille vide");
        assertFalse(grid.checkWin('O'), "Aucune victoire pour 'O' sur grille vide");
    }

    @Test
    public void testPlaceMarkValidAndInvalid() {
        // Placer hors limites
        assertFalse(grid.placeMark(-1, 0, 'X'), "Coordonnée de ligne invalide (-1) → false");
        assertFalse(grid.placeMark(0, 3, 'O'), "Coordonnée de colonne invalide (3) → false");

        // Placer dans une case libre
        assertTrue(grid.placeMark(0, 0, 'X'), "Case (0,0) vide → placer 'X' doit retourner true");
        // La même case devient occupée
        assertFalse(grid.placeMark(0, 0, 'O'), "Case (0,0) est déjà occupée → retourner false");
    }

    @Test
    public void testCheckWinRows() {
        // Remplir la première ligne avec 'X'
        grid.placeMark(0, 0, 'X');
        grid.placeMark(0, 1, 'X');
        grid.placeMark(0, 2, 'X');
        assertTrue(grid.checkWin('X'), "Trois 'X' alignés sur la première ligne → victoire");
        assertFalse(grid.checkWin('O'), "Trois 'X' alignés ne donnent pas victoire à 'O'");
    }

    @Test
    public void testCheckWinColumns() {
        // Remplir la deuxième colonne avec 'O'
        grid.placeMark(0, 1, 'O');
        grid.placeMark(1, 1, 'O');
        grid.placeMark(2, 1, 'O');
        assertTrue(grid.checkWin('O'), "Trois 'O' alignés sur la colonne 1 → victoire");
        assertFalse(grid.checkWin('X'), "Trois 'O' alignés ne donnent pas victoire à 'X'");
    }

    @Test
    public void testCheckWinDiagonals() {
        // Diagonale principale pour 'X'
        grid.placeMark(0, 0, 'X');
        grid.placeMark(1, 1, 'X');
        grid.placeMark(2, 2, 'X');
        assertTrue(grid.checkWin('X'), "Trois 'X' alignés sur la diagonale principale → victoire");

        // Réinitialiser la grille pour test diagonale secondaire
        grid = new Grid();
        grid.placeMark(0, 2, 'O');
        grid.placeMark(1, 1, 'O');
        grid.placeMark(2, 0, 'O');
        assertTrue(grid.checkWin('O'), "Trois 'O' alignés sur la diagonale secondaire → victoire");
    }

    @Test
    public void testIsFull() {
        // Remplir partiellement la grille → pas pleine
        grid.placeMark(0, 0, 'X');
        grid.placeMark(1, 1, 'O');
        assertFalse(grid.isFull(), "Grille partiellement remplie ne doit pas être considérée comme pleine");

        // Remplir complètement la grille
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid.placeMark(i, j, (i + j) % 2 == 0 ? 'X' : 'O');
            }
        }
        assertTrue(grid.isFull(), "Grille complètement remplie doit être considérée comme pleine");
    }
}

