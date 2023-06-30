package modellierung_gruppe2;


/**
 * Die Klasse Ameise beinhaltet die Bewegungs- und Färbungslogik der auf dem
 * Feld laufenden Ameise.
 *
 * @author Gruppe 2
 *
 */
public class Ameise extends Figur {

    private char[] bewegungzeichen;

    /**
     * Im leeren Konstruktor wird der Konstruktor der Oberklasse ausgeführt.
     */
    public Ameise() {
        super();
    }

    /**
     * Initialisiert das Ameisen-Objekt
     *
     * @param figur            Vom Benutzer vorgegebene verwendete Figur.
     * @param bewegungsabfolge Vom Benutzer vorgegebene Bewegungsabfolge der Ameise.
     * @param blickrichtung    Vom Benutzer vorgegebene Blickrichtung der Ameise.
     * @param startX           Vom Benutzer vorgegebener X-Koordinaten Startpunkt
     *                         der Ameise.
     * @param startY           Vom Benutzer vorgegebener Y-Koordinaten Startpunkt
     *                         der Ameise.
     * @param feldlaenge       Vom Benutzer vorgegebene Länge des Feldes auf dem die
     *                         Ameise sich bewegt.
     * @param feldbreite       Vom Benutzer vorgegebene Breite des Feldes auf dem
     *                         die Ameise sich bewegt.
     * @param randStop         Vom Benutzer vorgegebener Abbruchbedingung am Rand
     *                         stoppen oder periodisch weiterlaufen.
     */
    @Override
    public void init(String figur, String bewegungsabfolge, Blickrichtung blickrichtung, int startX, int startY,
                     int feldlaenge, int feldbreite, boolean randStop) {

        super.init(figur, bewegungsabfolge, blickrichtung, startX, startY, feldlaenge, feldbreite, randStop);

        this.bewegungzeichen = new char[bewegungsabfolge.length()];

        for (int i = 0; i < bewegungzeichen.length; i++) {
            bewegungzeichen[i] = bewegungsabfolge.charAt(i);
        }

    }

    /**
     *
     * @return Gibt true oder false zurück, ob die Ameise sich nach Links drehen
     *         muss.
     */
    public boolean mussLinks() {
        return bewegungzeichen[FarbenMatrix.farbenMatrix[xAktuell][yAktuell].getValue()] == 'L';

    }

    /**
     * Bewegungslogik der Ameise.
     */
    @Override
    public void bewegen() {
        zaehler++;
        if (aktuelleBlickrichtung == Blickrichtung.OBEN) {
            if (mussLinks()) {
                farbeArrayNaechsteFarbe();
                xAktuell = xAktuell - 1;
                aktuelleBlickrichtung = Blickrichtung.LINKS;
            } else {
                farbeArrayNaechsteFarbe();
                xAktuell = xAktuell + 1;
                aktuelleBlickrichtung = Blickrichtung.RECHTS;
            }
        } else if (aktuelleBlickrichtung == Blickrichtung.UNTEN) {
            if (mussLinks()) {
                farbeArrayNaechsteFarbe();
                xAktuell = xAktuell + 1;
                aktuelleBlickrichtung = Blickrichtung.RECHTS;
            } else {
                farbeArrayNaechsteFarbe();
                xAktuell = xAktuell - 1;
                aktuelleBlickrichtung = Blickrichtung.LINKS;
            }
        } else if (aktuelleBlickrichtung == Blickrichtung.RECHTS) {
            if (mussLinks()) {
                farbeArrayNaechsteFarbe();
                yAktuell = yAktuell - 1;
                aktuelleBlickrichtung = Blickrichtung.OBEN;
            } else {
                farbeArrayNaechsteFarbe();
                yAktuell = yAktuell + 1;
                aktuelleBlickrichtung = Blickrichtung.UNTEN;
            }
        } else {
            if (mussLinks()) {
                farbeArrayNaechsteFarbe();
                yAktuell = yAktuell + 1;
                aktuelleBlickrichtung = Blickrichtung.UNTEN;
            } else {
                farbeArrayNaechsteFarbe();
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
        aktuellefarbe = FarbenMatrix.farbenMatrix[xPrev][yPrev].getFarbe();
        benachrichtigeBeobachter();
        this.xPrev = xAktuell;
        this.yPrev = yAktuell;
    }

    /**
     * Setzt das Programm auf die Startwerte zurück.
     */
    @Override
    public void reset() {
        super.reset();
        this.xPrev = xStart;
        this.yPrev = yStart;

    }
}