package modellierung_gruppe2;

/**
 * Die Klasse FarbenMatrix speichert Zahlen, welche Farben repräsentieren, in einer
 * Matrix ab.
 *
 * @author Gruppe 2
 *
 */
public class FarbenMatrix {

    static Node[][] farbenMatrix = {};

    /**
     * Initialisiert das statische Objekt farbenMatrix mit der übergegebenen Länge
     * und Breite des Feldes und befüllt dieses.
     *
     * @param feldLänge  Länge des Feldes, auf dem die Figur läuft.
     * @param feldBreite Breite des Feldes, auf dem die Figur läuft.
     */
    public FarbenMatrix(int feldLänge, int feldBreite) {
        Node[][] Platzhalter = new Node[feldLänge][feldBreite];
        farbenMatrix = Platzhalter;
        feldStandardBefuellen();
    }

    /**
     * Methode befüllt die farbenMatrix mit der obersten Farbe aus der Liste der
     * verwendeten Farben.
     */
    public static void feldStandardBefuellen() {
        Node farbe = Farben.listeVerwendeteFarben.getErsteFarbe();
        for (int i = 0; i < farbenMatrix.length; i++) {
            for (int j = 0; j < farbenMatrix[i].length; j++) {
                farbenMatrix[i][j] = farbe;
            }
        }
    }
}