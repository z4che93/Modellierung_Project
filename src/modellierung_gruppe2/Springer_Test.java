package modellierung_gruppe2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Springer_Test {

    static Springer springer;

    @BeforeAll
    public static void init() {
        Farben farbenListe = new Farben();
        springer = new Springer();
    }

    @Test
    public void testGetAktuelleFarbe() {
        springer.init("Springer", "RL", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        assertEquals(Color.WHITE, springer.getAktuelleFarbe());
    }

    @Test
    public void testRandomBewegung() {
        springer.init("Springer", "RL", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        int random = springer.randomBewegung();
        assertTrue(random == 0 || random == 1);
    }

    @Test
    public void testBewegenXAktuellZukleinPeriodisch() {
        springer.init("Springer", "RL", Blickrichtung.LINKS, 0, 50, 150, 100, false);
        springer.bewegen();
        assertEquals(148, springer.getxAktuell());

    }

    @Test
    public void testBewegenXAktuellZuGrossPeriodisch() {
        springer.init("Springer", "RL", Blickrichtung.RECHTS, 149, 50, 150, 100, false);
        springer.bewegen();
        assertEquals(1, springer.getxAktuell());

    }

    @Test
    public void testBewegenYAktuellZukleinPeriodisch() {
        springer.init("Springer", "RL", Blickrichtung.OBEN, 75, 0, 150, 100, false);
        springer.bewegen();
        assertEquals(98, springer.getyAktuell());

    }

    @Test
    public void testBewegenYAktuellZuGrossPeriodisch() {
        springer.init("Springer", "RL", Blickrichtung.UNTEN, 75, 99, 150, 100, false);
        springer.bewegen();
        assertEquals(1, springer.getyAktuell());

    }

    @Test
    public void testBewegenAusserhalbNichtPeriodisch() {
        springer.init("Springer", "RL", Blickrichtung.UNTEN, 75, 99, 150, 100, true);
        springer.bewegen();
        assertTrue(springer.getStop());

    }
}