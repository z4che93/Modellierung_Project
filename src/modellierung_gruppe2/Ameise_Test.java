package modellierung_gruppe2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Ameise_Test{

    static Ameise ameise;

    @BeforeAll
    public static void init() {
        Farben farbenListe = new Farben();
        ameise = new Ameise();
    }

    @Test
    public void testReset() {
        ameise.init("Ameise", "RL", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        ameise.reset();
        assertEquals(75, ameise.getxPrev());
        assertEquals(50, ameise.getyPrev());
    }

    @Test
    public void testBewegenObenRechts() {
        ameise.init("Ameise", "RL", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        ameise.bewegen();
        assertEquals(76, ameise.getxAktuell());
        assertEquals(50, ameise.getyAktuell());
        assertEquals(Color.BLACK, ameise.getAktuelleFarbe());
        assertEquals(Blickrichtung.RECHTS, ameise.aktuelleBlickrichtung);
    }

    @Test
    public void testBewegenObenLinks() {
        ameise.init("Ameise", "LR", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        ameise.bewegen();
        assertEquals(74, ameise.getxAktuell());
        assertEquals(50, ameise.getyAktuell());
        assertEquals(Color.BLACK, ameise.getAktuelleFarbe());
        assertEquals(Blickrichtung.LINKS, ameise.aktuelleBlickrichtung);
    }

    @Test
    public void testBewegenRechtsRechts() {
        ameise.init("Ameise", "RL", Blickrichtung.RECHTS, 75, 50, 150, 100, false);
        ameise.bewegen();
        assertEquals(75, ameise.getxAktuell());
        assertEquals(51, ameise.getyAktuell());
        assertEquals(Color.BLACK, ameise.getAktuelleFarbe());
        assertEquals(Blickrichtung.UNTEN, ameise.aktuelleBlickrichtung);
    }

    @Test
    public void testBewegenRechtsLinks() {
        ameise.init("Ameise", "LR", Blickrichtung.RECHTS, 75, 50, 150, 100, false);
        ameise.bewegen();
        assertEquals(75, ameise.getxAktuell());
        assertEquals(49, ameise.getyAktuell());
        assertEquals(Color.BLACK, ameise.getAktuelleFarbe());
        assertEquals(Blickrichtung.OBEN, ameise.aktuelleBlickrichtung);
    }

    @Test
    public void testBewegenUntenRechts() {
        ameise.init("Ameise", "RL", Blickrichtung.UNTEN, 75, 50, 150, 100, false);
        ameise.bewegen();
        assertEquals(74, ameise.getxAktuell());
        assertEquals(50, ameise.getyAktuell());
        assertEquals(Color.BLACK, ameise.getAktuelleFarbe());
        assertEquals(Blickrichtung.LINKS, ameise.aktuelleBlickrichtung);
    }

    @Test
    public void testBewegenUntenLinks() {
        ameise.init("Ameise", "LR", Blickrichtung.UNTEN, 75, 50, 150, 100, false);
        ameise.bewegen();
        assertEquals(76, ameise.getxAktuell());
        assertEquals(50, ameise.getyAktuell());
        assertEquals(Color.BLACK, ameise.getAktuelleFarbe());
        assertEquals(Blickrichtung.RECHTS, ameise.aktuelleBlickrichtung);
    }

    @Test
    public void testBewegenLinksRechts() {
        ameise.init("Ameise", "RL", Blickrichtung.LINKS, 75, 50, 150, 100, false);
        ameise.bewegen();
        assertEquals(75, ameise.getxAktuell());
        assertEquals(49, ameise.getyAktuell());
        assertEquals(Color.BLACK, ameise.getAktuelleFarbe());
        assertEquals(Blickrichtung.OBEN, ameise.aktuelleBlickrichtung);
    }

    @Test
    public void testBewegenLinksLinks() {
        ameise.init("Ameise", "LR", Blickrichtung.LINKS, 75, 50, 150, 100, false);
        ameise.bewegen();
        assertEquals(75, ameise.getxAktuell());
        assertEquals(51, ameise.getyAktuell());
        assertEquals(Color.BLACK, ameise.getAktuelleFarbe());
        assertEquals(Blickrichtung.UNTEN, ameise.aktuelleBlickrichtung);
    }

    @Test
    public void testBewegenXAktuellZuGross() {
        ameise.init("Ameise", "RR", Blickrichtung.OBEN, 149, 50, 150, 100, true);
        ameise.bewegen();
        assertTrue(ameise.getStop());
    }

    @Test
    public void testBewegenYAktuellZuKlein() {
        ameise.init("Ameise", "LR", Blickrichtung.RECHTS, 75, 0, 150, 100, true);
        ameise.bewegen();
        assertTrue(ameise.getStop());
    }

    @Test
    public void testBewegenYAktuellZuGross() {
        ameise.init("Ameise", "RR", Blickrichtung.RECHTS, 75, 99, 150, 100, true);
        ameise.bewegen();
        assertTrue(ameise.getStop());
    }

    @Test
    public void testBewegenXAktuellZuKlein() {
        ameise.init("Ameise", "LR", Blickrichtung.OBEN, 0, 50, 150, 100, true);
        ameise.bewegen();
        assertTrue(ameise.getStop());
    }

    @Test
    public void testBewegenXZuKleinPeriodisch() {
        ameise.init("Ameise", "LR", Blickrichtung.OBEN, 0, 50, 150, 100, false);
        ameise.bewegen();
        assertFalse(ameise.getStop());
        assertEquals(149, ameise.getxAktuell());
    }

    @Test
    public void testBewegenXZuGrossPeriodisch() {
        ameise.init("Ameise", "RR", Blickrichtung.OBEN, 149, 50, 150, 100, false);
        ameise.bewegen();
        assertFalse(ameise.getStop());
        assertEquals(0, ameise.getxAktuell());
    }

    @Test
    public void testBewegenYZuKleinPeriodisch() {
        ameise.init("Ameise", "LR", Blickrichtung.RECHTS, 75, 0, 150, 100, false);
        ameise.bewegen();
        assertFalse(ameise.getStop());
        assertEquals(99, ameise.getyAktuell());
    }

    @Test
    public void testBewegenYZuGrossPeriodisch() {
        ameise.init("Ameise", "LR", Blickrichtung.LINKS, 75, 99, 150, 100, false);
        ameise.bewegen();
        assertFalse(ameise.getStop());
        assertEquals(0, ameise.getyAktuell());
    }
}