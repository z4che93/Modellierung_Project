package modellierung_gruppe2;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Die Klasse Figur ist die Superklasse von Ameise und Springer.
 *
 * @author Gruppe 2
 *
 */
public class Figur implements Subjekt, Model {

    protected int feldlaenge, feldbreite, zaehler = 0;
    protected Color aktuellefarbe;
    protected int xAktuell, yAktuell, xPrev, yPrev, xStart, yStart;
    protected Blickrichtung aktuelleBlickrichtung, anfangsBlickrichtung;
    protected ArrayList<Beobachter> beobachter;

    protected boolean randStop, stop;

    /**
     * Im leeren Konstruktor wird eine Liste von Beobachtern initialisiert.
     */
    public Figur() {
        beobachter = new ArrayList<Beobachter>();
    }

    /**
     * Initialisiert das Figur-Objekt.
     *
     * @param figur			   Vom Benutzer vorgegebene verwendete Figur.
     * @param bewegungsabfolge Vom Benutzer vorgegebene Bewegungsabfolge der Figur.
     * @param blickrichtung    Vom Benutzer vorgegebene Blickrichtung der Figur.
     * @param startX           Vom Benutzer vorgegebener X-Koordinaten Startpunkt.
     *                         der Figur.
     * @param startY           Vom Benutzer vorgegebener Y-Koordinaten Startpunkt
     *                         der Figur.
     * @param feldlaenge       Vom Benutzer vorgegebene Länge des Feldes auf dem die
     *                         Figur sich bewegt.
     * @param feldbreite       Vom Benutzer vorgegebene Breite des Feldes auf dem
     *                         die Figur sich bewegt.
     * @param randStop		   Vom Benutzer vorgegebene Abbruchbedingung, am Rand stoppen
     * 					       oder periodisch weiterlaufen.
     */
    @Override
    public void init(String figur, String bewegungsabfolge, Blickrichtung blickrichtung, int startX, int startY,
                     int feldlaenge, int feldbreite, boolean randStop) {
        this.randStop = randStop;
        stop = false;
        this.aktuelleBlickrichtung = blickrichtung;
        this.anfangsBlickrichtung = blickrichtung;
        this.xStart = startX;
        this.yStart = startY;
        this.xAktuell = startX;
        this.yAktuell = startY;
        this.xPrev = startX;
        this.yPrev = startY;
        this.feldlaenge = feldlaenge;
        this.feldbreite = feldbreite;

        Farben listeVerwendeteFarben = new Farben(bewegungsabfolge.length());

        // Erzeugt die FarbenMatrix
        FarbenMatrix matrixFigur = new FarbenMatrix(feldlaenge, feldbreite);
    }

    /**
     * Färbt das aktuelle Feld mit der sich an nächsten Stelle befindeten Farbe aus
     * der Liste der verwendeten Farben.
     */
    protected void farbeArrayNaechsteFarbe() {
        FarbenMatrix.farbenMatrix[xAktuell][yAktuell] = FarbenMatrix.farbenMatrix[xAktuell][yAktuell].getNext();
    }

    /**
     * Bewegungsmethode, die von Ameise und Springer mit unterschiedlicher Bewegungslogik gefüllt wird.
     *
     */
    @Override
    public void bewegen() {}

    /**
     * Methode, die bei periodischer Abbruchbedingung die neuen X- und Y-Koordinaten berechnet.
     *
     */
    protected void berechneXYNeu() {
        if (xAktuell < 0) {
            xAktuell = feldlaenge + xAktuell;
        } else if (xAktuell >= feldlaenge) {
            xAktuell = xAktuell - feldlaenge;
        }
        if (yAktuell < 0) {
            yAktuell = feldbreite + yAktuell;
        } else if (yAktuell >= feldbreite) {
            yAktuell = yAktuell - feldbreite;
        }
    }

    /**
     * Setzt das Programm auf die Startwerte zurück.
     */
    @Override
    public void reset() {
        this.xAktuell = xStart;
        this.yAktuell = yStart;
        this.zaehler = 0;
        this.stop = false;
        aktuelleBlickrichtung = anfangsBlickrichtung;
        FarbenMatrix.feldStandardBefuellen();
    }

    /**
     *
     * @return Gibt die X-Koordinate des Startpunktes zurück.
     */
    @Override
    public int getxStart() {
        return xStart;
    }

    /**
     *
     * @return Gibt die Y-Koordinate des Startpunktes zurück.
     */
    @Override
    public int getyStart() {
        return yStart;
    }

    /**
     *
     * @return Gibt die aktuelle X-Koordinate zurück.
     */
    @Override
    public int getxAktuell() {
        return xAktuell;
    }

    /**
     *
     * @return Gibt die aktuelle Y-Koordinate zurück.
     */
    @Override
    public int getyAktuell() {
        return yAktuell;
    }

    /**
     *
     * @return Gibt die vorherige X-Koordinate zurück.
     */
    @Override
    public int getxPrev() {
        return xPrev;
    }

    /**
     *
     * @return Gibt die vorherige Y-Koordinate zurück.
     */
    @Override
    public int getyPrev() {
        return yPrev;
    }

    /**
     *
     * @return Gibt die aktuelle Farbe zurück.
     */
    @Override
    public Color getAktuelleFarbe() {
        return aktuellefarbe;
    }

    /**
     *
     * @return Gibt die Feldlänge zurück.
     */
    @Override
    public int getFeldlaenge() {
        return feldlaenge;
    }

    /**
     *
     * @return Gibt die Feldbreite zurück.
     */
    @Override
    public int getFeldbreite() {
        return feldbreite;
    }


    /**
     *
     * @return Gibt zurück, ob Ameise mit dem Laufen stoppen soll.
     */
    @Override
    public boolean getStop() {
        return stop;
    }


    /**
     *
     * @return Gibt die Anzahl der durchgeführten Iterationen zurück.
     */
    @Override
    public int getZaehler() {
        return zaehler;
    }

    /**
     * Fügt einen Beobachter zur Beobachter-Liste hinzu.
     *
     * @param b Übergabe eines Beobachter-Objektes.
     */
    @Override
    public void registriereBeobachter(Beobachter b) {
        beobachter.add(b);
    }

    /**
     * Entfernt einen Beobachter aus der Beobachter-Liste.
     *
     * @param b Übergabe eines Beobachter-Objektes.
     */
    @Override
    public void entferneBeobachter(Beobachter b) {
        beobachter.remove(b);
    }

    /**
     * Gibt die Aktualisierungen an alle Beobachter weiter und weist der vorherigen
     * X- und Y-Koordinate die entsprechende aktuelle zu.
     */
    @Override
    public void benachrichtigeBeobachter() {
        for (Beobachter b : beobachter) {
            b.aktualisiere();
        }
    }

}