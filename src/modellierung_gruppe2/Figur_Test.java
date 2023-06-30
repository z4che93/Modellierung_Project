package modellierung_gruppe2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Figur_Test {

    static Figur f;

    @BeforeAll
    public static void init() {
        Farben farbenListe = new Farben();
        f = new Figur();
    }

    @Test
    void testFigur() {
        boolean expected = true;
        boolean actual = f.beobachter.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void testFarbeArrayNaechsteFarbe() {
        int startX = 10, startY = 10;
        f.init("Ameise", "LR", Blickrichtung.OBEN, startX, startY, 20, 20, true);
        Node expected = FarbenMatrix.farbenMatrix[startX][startY].getNext();
        f.farbeArrayNaechsteFarbe();
        Node actual = FarbenMatrix.farbenMatrix[startX][startY];
        assertEquals(expected, actual);

    }

    @Test
    void testBerechneXYNeuObenRaus() {
        int feldlaenge = 20, feldbreite = 20;
        f.init("Ameise", "LR", Blickrichtung.OBEN, 0, 0, feldlaenge, feldbreite, true);
        f.yAktuell = -1;
        int expected = feldbreite + f.yAktuell;
        f.berechneXYNeu();
        int actual = f.yAktuell;
        assertEquals(expected, actual);

    }

    @Test
    void testBerechneXYNeuUntenRaus() {
        int feldlaenge = 20, feldbreite = 20;
        f.init("Ameise", "LR", Blickrichtung.OBEN, 0, 0, feldlaenge, feldbreite, true);
        f.yAktuell = feldbreite;
        int expected = feldbreite - f.yAktuell;
        f.berechneXYNeu();
        int actual = f.yAktuell;
        assertEquals(expected, actual);
    }

    @Test
    void testBerechneXYNeuRechtsRaus() {
        int feldlaenge = 20, feldbreite = 20;
        f.init("Ameise", "LR", Blickrichtung.OBEN, 0, 0, feldlaenge, feldbreite, true);

        f.xAktuell = feldlaenge;
        int expected = feldlaenge - f.xAktuell;
        f.berechneXYNeu();
        int actual = f.xAktuell;
        assertEquals(expected, actual);
    }

    @Test
    void testBerechneXYNeuLinksRaus() {
        int feldlaenge = 20, feldbreite = 20;
        f.init("Ameise", "LR", Blickrichtung.OBEN, 0, 0, feldlaenge, feldbreite, true);
        f.xAktuell = -1;
        int expected = feldlaenge + f.xAktuell;
        f.berechneXYNeu();
        int actual = f.xAktuell;
        assertEquals(expected, actual);
    }

    @Test
    void testReset() {
        Blickrichtung blickrichtung = Blickrichtung.OBEN;
        int startX = 10, startY = 15;
        f.init("Ameise", "LR", blickrichtung, startX, startY, 20, 20, true);
        f.reset();
        assertEquals(f.xAktuell, startX);
        assertEquals(f.yAktuell, startY);
        assertEquals(f.zaehler, 0);
        assertEquals(f.stop, false);
        assertEquals(f.aktuelleBlickrichtung, blickrichtung);

    }

    @Test
    void testGetxStart() {
        int startX = 10;
        f.init("Ameise", "LR", Blickrichtung.OBEN, startX, 15, 20, 20, true);
        int actual = f.getxStart();
        int expected = startX;
        assertEquals(expected, actual);

    }

    @Test
    void testGetyStart() {
        int startY = 10;
        f.init("Ameise", "LR", Blickrichtung.OBEN, 10, startY, 20, 20, true);
        int actual = f.getyStart();
        int expected = startY;
        assertEquals(expected, actual);
    }

    @Test
    void testGetxAktuell() {
        int startX = 10;
        f.init("Ameise", "LR", Blickrichtung.OBEN, startX, 15, 20, 20, true);
        int actual = f.getxAktuell();
        int expected = startX;
        assertEquals(expected, actual);
    }

    @Test
    void testGetyAktuell() {
        int startY = 10;
        f.init("Ameise", "LR", Blickrichtung.OBEN, 10, startY, 20, 20, true);
        int actual = f.getyAktuell();
        int expected = startY;
        assertEquals(expected, actual);
    }

    @Test
    void testGetxPrev() {
        int expected = 20;
        f.xPrev = expected;
        int actual = f.getxPrev();
        assertEquals(expected, actual);
    }

    @Test
    void testGetyPrev() {
        int expected = 10;
        f.yPrev = expected;
        int actual = f.getyPrev();
        assertEquals(expected, actual);
    }

    @Test
    void testGetAktuelleFarbe() {
        Color expected = Color.black;
        f.aktuellefarbe = expected;
        Color actual = f.getAktuelleFarbe();
        assertEquals(expected, actual);
    }

    @Test
    void testGetFeldlaenge() {
        int expected = 220;
        f.feldlaenge = expected;
        int actual = f.getFeldlaenge();
        assertEquals(expected, actual);
    }

    @Test
    void testGetFeldbreite() {
        int expected = 150;
        f.feldbreite = expected;
        int actual = f.getFeldbreite();
        assertEquals(expected, actual);
    }

    @Test
    void testGetStop() {
        boolean expected = false;
        f.stop = expected;
        boolean actual = f.getStop();
        assertEquals(expected, actual);
    }

    @Test
    void testGetZaehler() {
        int expected = 5000;
        f.zaehler = expected;
        int actual = f.getZaehler();
        assertEquals(expected, actual);
    }

    @Test
    void testRegistriereBeobachter() {
        class Besucher implements Beobachter {

            @Override
            public void aktualisiere() {
            }

        }
        Besucher b = new Besucher();
        f.registriereBeobachter(b);
        for (Beobachter x : f.beobachter) {
            assertEquals(b, x);
        }
    }

    @Test
    void testEntferneBeobachter() {
        class Besucher implements Beobachter {

            @Override
            public void aktualisiere() {
            }
        }
        Besucher b = new Besucher();
        f.beobachter.add(b);
        f.entferneBeobachter(b);
        for (Beobachter x : f.beobachter) {
            assertNotEquals(b, x);
        }
    }

    @Test
    void testBenachrichtigeBeobachter() {
        class Besucher implements Beobachter {
            @Override
            public void aktualisiere() {
                assertTrue(true);
            }
        }
        Besucher b = new Besucher();
        f.beobachter.add(b);
        f.benachrichtigeBeobachter();
    }
}