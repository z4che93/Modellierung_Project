package modellierung_gruppe2;

import java.awt.Color;


/**
 * Die Klasse Springer beinhaltet die Bewegungs- und Färbungslogik der auf dem
 * Feld laufenden Springer.
 *
 * @author Gruppe 2
 *
 */
public class Springer extends Figur {

    /**
     * Im leeren Konstruktor wird der Konstruktor der Oberklasse ausgeführt.
     */
    public Springer() {
        super();
    }

    /**
     * Bewegungslogik des Springers.
     */
    @Override
    public void bewegen() {
        int rndBewegung = randomBewegung();
        zaehler++;
        xPrev = xAktuell;
        yPrev = yAktuell;
        if (aktuelleBlickrichtung == Blickrichtung.OBEN) {
            yAktuell = yAktuell - 2;
            if (rndBewegung == 0) {
                xAktuell = xAktuell - 1;
                aktuelleBlickrichtung = Blickrichtung.LINKS;
            } else {
                xAktuell = xAktuell + 1;
                aktuelleBlickrichtung = Blickrichtung.RECHTS;
            }
        } else if (aktuelleBlickrichtung == Blickrichtung.UNTEN) {
            yAktuell = yAktuell + 2;
            if (rndBewegung == 0) {
                xAktuell = xAktuell + 1;
                aktuelleBlickrichtung = Blickrichtung.RECHTS;
            } else {
                xAktuell = xAktuell - 1;
                aktuelleBlickrichtung = Blickrichtung.LINKS;
            }
        } else if (aktuelleBlickrichtung == Blickrichtung.RECHTS) {
            xAktuell = xAktuell + 2;
            if (rndBewegung == 0) {
                yAktuell = yAktuell - 1;
                aktuelleBlickrichtung = Blickrichtung.OBEN;
            } else {
                yAktuell = yAktuell + 1;
                aktuelleBlickrichtung = Blickrichtung.UNTEN;
            }
        } else if (aktuelleBlickrichtung == Blickrichtung.LINKS) {
            xAktuell = xAktuell - 2;
            if (rndBewegung == 0) {
                yAktuell = yAktuell + 1;
                aktuelleBlickrichtung = Blickrichtung.UNTEN;
            } else {
                yAktuell = yAktuell - 1;
                aktuelleBlickrichtung = Blickrichtung.OBEN;
            }
        }
        if (xAktuell < 0 || xAktuell >= feldlaenge || yAktuell < 0 || yAktuell >= feldbreite) {
            if (randStop) {
                stop = true;
            } else {
                berechneXYNeu();
            }
        }
        benachrichtigeBeobachter();
    }

    /**
     *
     * @return Erzeugt eine Zufallszahl, die 0 oder 1 annimmt. Dabei entspricht 0 die
     * Bewegung nach links und 1 die Bewegung nach rechts.
     */
    public int randomBewegung() {
        return (int) Math.round(Math.random());
    }

    /**
     *
     * @return Gibt weißes Color Objekt zurück.
     */
    @Override
    public Color getAktuelleFarbe() {
        return Color.WHITE;
    }

}