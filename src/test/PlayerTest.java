package test;

import static org.junit.jupiter.api.Assertions.*;

import morpion.models.Player;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PlayerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testGetNameAndSymbol() {
        Player p = new Player('X');
        assertEquals('X', p.getSymbol(), "Le symbole du joueur devrait être 'X'");
    }

    @Test
    public void testPrintOutput() {
        Player p = new Player('O');
        p.print();
        String expected = "Joueur O" + System.lineSeparator();
        assertEquals(expected, outContent.toString(), "La méthode print() doit afficher le symbole au format “Joueur <Symbole>”");
    }
}
