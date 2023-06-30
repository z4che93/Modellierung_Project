package modellierung_gruppe2;

import java.awt.Color;

/**
 * Interface für die Klasse Figur.
 *
 * @author Gruppe 2
 *
 */
public interface Model {

    /**
     * Bewegungsmethode, die von Ameise und Springer mit unterschiedlicher Bewegungslogik gefüllt wird.
     *
     */
    public void bewegen();

    /**
     * Setzt das Programm auf die Startwerte zurück.
     */
    public void reset();

    /**
     * Initialisiert das Figur-Objekt
     *
     * @param figur            Vom Benutzer vorgegebene verwendete Figur.
     * @param bewegungsabfolge Vom Benutzer vorgegebene Bewegungsabfolge der Ameise.
     * @param blickrichtung    Vom Benutzer vorgegebene Blickrichtung der Figur.
     * @param startX           Vom Benutzer vorgegebener X-Koordinaten Startpunkt
     *                         der Figur.
     * @param startY           Vom Benutzer vorgegebener Y-Koordinaten Startpunkt
     *                         der Figur.
     * @param feldlaenge       Vom Benutzer vorgegebene Länge des Feldes auf dem die
     *                         Figur sich bewegt.
     * @param feldbreite       Vom Benutzer vorgegebene Breite des Feldes auf dem
     *                         die Figur sich bewegt.
     * @param randStop         Vom Benutzer vorgegebener Abbruchbedingung am Rand
     *                         stoppen oder periodisch weiterlaufen.
     */
    public void init(String figur, String bewegungsabfolge, Blickrichtung blickrichtung, int startX, int startY,
                     int feldlaenge, int feldbreite, boolean randStop);

    /**
     *
     * @return Gibt die X-Koordinate des Startpunktes zurück.
     */
    public int getxStart();

    /**
     *
     * @return Gibt die Y-Koordinate des Startpunktes zurück.
     */
    public int getyStart();

    /**
     *
     * @return Gibt die aktuelle X-Koordinate zurück.
     */
    public int getxAktuell();

    /**
     *
     * @return Gibt die aktuelle Y-Koordinate zurück.
     */
    public int getyAktuell();

    /**
     *
     * @return Gibt die vorherige X-Koordinate zurück.
     */
    public int getxPrev();

    /**
     *
     * @return Gibt die vorherige Y-Koordinate zurück.
     */
    public int getyPrev();

    /**
     *
     * @return Gibt die aktuelle Farbe zurück.
     */
    public Color getAktuelleFarbe();

    /**
     *
     * @return Gibt die Feldlänge zurück.
     */
    public int getFeldlaenge();
    /**
     *
     * @return Gibt die Feldbreite zurück.
     */
    public int getFeldbreite();

    /**
     *
     * @return Gibt zurück, ob Ameise mit dem Laufen stoppen soll.
     */
    public boolean getStop();

    /**
     *
     * @return Gibt die Anzahl der durchgeführten Iterationen zurück.
     */
    public int getZaehler();
}