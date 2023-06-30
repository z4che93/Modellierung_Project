package modellierung_gruppe2;

import java.awt.Color;

/**
 * Klasse die die Informationen an die Figur weitergibt.
 *
 * @author Gruppe 2
 *
 */
public class Controller implements Strategy {

    private Model mAmeise, mSpringer, mVerwendeteFigur;

    /**
     * Initialisiert das übergebene Figuren-Objekt.
     *
     * @param ameise   Ameisen-Objekt.
     * @param springer Springer-Objekt.
     */
    public Controller(Model ameise, Model springer) {
        this.mAmeise = ameise;
        this.mSpringer = springer;
        this.mVerwendeteFigur = new Figur();
    }

    /**
     * Bewegungslogik der Figur.
     */
    @Override
    public void bewegen() {
        mVerwendeteFigur.bewegen();
    }

    /**
     * Setzt das Programm auf die Startwerte zurück.
     */
    @Override
    public void reset() {
        mVerwendeteFigur.reset();
    }

    /**
     * Initialisiert das Figur-Objekt.
     *
     * @param figur            Vom Benutzer vorgegebene verwendete Figur.
     * @param bewegungsabfolge Vom Benutzer vorgegebene Bewegungsabfolge der Figur.
     * @param blickrichtung    Vom Benutzer vorgegebene Blickrichtung der Figur.
     * @param startX           Vom Benutzer vorgegebener X-Koordinaten Startpunkt.
     *                         der Figur.
     * @param startY           Vom Benutzer vorgegebener Y-Koordinaten Startpunkt
     *                         der Figur.
     * @param feldxlength        Vom Benutzer vorgegebene Länge des Feldes auf dem die
     *                         Figur sich bewegt.
     * @param feldylength       Vom Benutzer vorgegebene Breite des Feldes auf dem
     *                         die Figur sich bewegt.
     * @param randStop		   Vom Benutzer vorgegebene Abbruchbedingung am Rand
     * 						   stoppen oder periodisch weiterlaufen.
     */
    @Override
    public void init(String figur, String bewegungsabfolge, Blickrichtung blickrichtung, int startX, int startY,
                     int feldxlength, int feldylength, boolean randStop) {
        if (figur.equals("Ameise")) {
            this.mVerwendeteFigur = this.mAmeise;
            mAmeise.init(figur, bewegungsabfolge, blickrichtung, startX, startY, feldxlength, feldylength, randStop);
        } else {
            this.mVerwendeteFigur = this.mSpringer;
            mSpringer.init(figur, bewegungsabfolge, blickrichtung, startX, startY, feldxlength, feldylength, randStop);
        }
    }

    /**
     *
     * @return Gibt die X-Koordinate des Startpunktes zurück.
     */
    @Override
    public int getxStart() {
        return mVerwendeteFigur.getxStart();
    }

    /**
     *
     * @return Gibt die Y-Koordinate des Startpunktes zurück.
     */
    @Override
    public int getyStart() {
        return mVerwendeteFigur.getyStart();
    }

    /**
     *
     * @return Gibt die aktuelle X-Koordinate zurück.
     */
    @Override
    public int getxAktuell() {
        return mVerwendeteFigur.getxAktuell();
    }

    /**
     *
     * @return Gibt die aktuelle Y-Koordinate zurück.
     */
    @Override
    public int getyAktuell() {
        return mVerwendeteFigur.getyAktuell();
    }

    /**
     *
     * @return Gibt die vorherige X-Koordinate zurück.
     */
    @Override
    public int getxPrev() {
        return mVerwendeteFigur.getxPrev();
    }

    /**
     *
     * @return Gibt die vorherige Y-Koordinate zurück.
     */
    @Override
    public int getyPrev() {
        return mVerwendeteFigur.getyPrev();
    }

    /**
     *
     * @return Gibt die aktuelle Farbe zurück.
     */
    @Override
    public Color getAktuelleFarbe() {
        return mVerwendeteFigur.getAktuelleFarbe();
    }

    /**
     *
     * @return Gibt die Feldlänge zurück.
     */
    @Override
    public int getFeldlaenge() {
        return mVerwendeteFigur.getFeldlaenge();
    }

    /**
     *
     * @return Gibt die Feldbreite zurück.
     */
    @Override
    public int getFeldbreite() {
        return mVerwendeteFigur.getFeldbreite();
    }

    /**
     *
     * @return Gibt zurück, ob Ameise mit dem Laufen stoppen soll.
     */
    @Override
    public boolean getStop() {
        return mVerwendeteFigur.getStop();
    }

    /**
     *
     * @return Gibt die Anzahl der durchgeführten Iterationen zurück.
     */
    @Override
    public int getZaehler() {
        return mVerwendeteFigur.getZaehler();
    }
}