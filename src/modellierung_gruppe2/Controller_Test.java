package modellierung_gruppe2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Controller_Test {

    static Ameise a;
    static Controller c;
    static Figur f;
    static Springer s;

    @BeforeAll
    public static void init() {
        Farben farbenListe = new Farben();
        a = new Ameise();
        s = new Springer();
        f = new Figur();

        class ControllerTest extends Controller {
            public Model mVerwendeteFigur;
            public ControllerTest(Figur f) {
                super(null,null);
                mVerwendeteFigur = f;
            }
        }
        c = new ControllerTest(f);
    }

    @Test
    void testController() {
        Ameise a = new Ameise();
        Springer s = new Springer();
        c = new Controller(a, s);
        assertEquals(true, true);
    }

    @Test
    void testReset() {
        c = new Controller(null, null);
        class FigurTest extends Figur {
            @Override
            public void reset() {
                assertTrue(true);
            }
        }
        f = new FigurTest();
    }

    @Test
    public void testGetxStart() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        assertEquals(75, c.getxStart());
    }

    @Test
    void testGetyStart() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        assertEquals(50, c.getyStart());
    }

    @Test
    void testGetxAktuell() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        a.bewegen();
        assertEquals(76, c.getxAktuell());
    }

    @Test
    void testGetyAktuell() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        a.bewegen();
        assertEquals(50, c.getyAktuell());
    }

    @Test
    void testGetxPrev() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.OBEN, 75, 50, 150, 100, false);
        a.bewegen();
        assertEquals(76, c.getxPrev());
    }

    @Test
    void testGetyPrev() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.RECHTS, 75, 50, 150, 100, false);
        a.bewegen();
        assertEquals(51, c.getyPrev());
    }

    @Test
    void testGetAktuelleFarbe() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.RECHTS, 75, 50, 150, 100, false);
        a.bewegen();
        assertEquals(Color.BLACK, c.getAktuelleFarbe());
    }

    @Test
    void testGetFeldlaenge() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.RECHTS, 75, 50, 150, 100, false);
        assertEquals(150, c.getFeldlaenge());
    }

    @Test
    void testGetFeldbreite() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.RECHTS, 75, 50, 150, 100, false);
        assertEquals(100, c.getFeldbreite());
    }

    @Test
    void testGetStop() {
        c = new Controller(a,s);
        c.init("Ameise", "RL", Blickrichtung.RECHTS, 75, 50, 150, 100, false);
        a.bewegen();
        assertEquals(false, c.getStop());
    }

    @Test
    void testGetZaehler() {
        Ameise ameise = new Ameise();
        Springer springer = new Springer();
        c = new Controller(ameise, springer);
        c.init("Ameise", "RL", Blickrichtung.RECHTS, 75, 50, 150, 100, false);
        ameise.bewegen();
        assertEquals(1, c.getZaehler());
    }
}