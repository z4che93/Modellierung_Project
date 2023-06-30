package modellierung_gruppe2;

import java.awt.Color;

/**
 * Die Klasse Farben beinhaltet alle Farben, mit der die Ameise die Felder
 * färben kann, sowie die Startfarbe und die Farbe der Figur. Die Farben sind in
 * Nodes gespeichert, die jeweils auf das nächste Element verweisen bzw. das
 * Letzte auf das Erste.
 *
 * @author Gruppe 2
 *
 */
public class Farben {

    private Node ersteFarbe;
    private final Node startfarbe = new Node(Color.GREEN);
    private final Node figurfarbe = new Node(Color.RED);

    /**
     * Enthält eine Liste aller verwendeten Farben.
     */
    static public Farben listeVerwendeteFarben;

    /**
     * Im leeren Konstruktor werden alle verwendeten Farben initialisiert.
     */
    public Farben() {
        initFarben();
    }

    /**
     * Im Konstruktor mit Übergabeparameter wird die Liste der verwendeten Farben
     * auf eine vorgegebene Länge angepasst.
     *
     * @param bewegungsabfolge Enthält die Bewegungsrichtungen (R oder L) der einzelnen Farben.
     */
    public Farben(int bewegungsabfolge) {
        initFarben();
        this.ersteFarbe = listeVerwendeteFarben.ersteFarbe;
        Node n = listeVerwendeteFarben.ersteFarbe;
        while (n.getValue() != bewegungsabfolge - 1) {
            n = n.getNext();
        }
        n.connectToFirstEntry(this.ersteFarbe);
    }

    /**
     * Methode, die alle Farben zum färben eines Feldes setzt.
     *
     */
    private void initFarben() {
        Node.setLengthZero();
        Node n0 = new Node(Color.WHITE, null);

        ersteFarbe = n0;

        Node n1 = new Node(Color.BLACK, n0);
        Node n2 = new Node(Color.ORANGE, n1);
        Node n3 = new Node(Color.GRAY, n2);
        Node n4 = new Node(Color.getHSBColor(345, 19, 38), n3); // hellgelb
        Node n5 = new Node(Color.BLUE, n4);
        Node n6 = new Node(Color.DARK_GRAY, n5);
        Node n7 = new Node(Color.MAGENTA, n6);
        Node n8 = new Node(Color.CYAN, n7);
        Node n9 = new Node(Color.YELLOW, n8);
        Node n10 = new Node(Color.PINK, n9);
        Node n11 = new Node(Color.LIGHT_GRAY, n10);
        Node n12 = new Node(Color.getHSBColor(239, 40, 60), n11); // blau-lila
        Node n13 = new Node(Color.getHSBColor(29, 69, 21), n12); // braun
        Node n14 = new Node(Color.getHSBColor(279, 63, 41), n13); // lila
        Node n15 = new Node(Color.getHSBColor(32, 58, 80), n14); // beige

        n15.connectToFirstEntry(ersteFarbe);

        listeVerwendeteFarben = this;
    }

    /**
     *
     * @return Gibt die Startfarbe zurück.
     */
    public Color getStartfarbe() {
        return startfarbe.getFarbe();
    }

    /**
     *
     * @return Gibt die Figurfarbe zurück.
     */
    public Color getFigurfarbe() {
        return figurfarbe.getFarbe();
    }

    /**
     *
     * @return Gibt die erste Farbe in der Liste der verwendeten Farben zurück.
     */
    public Node getErsteFarbe() {
        return ersteFarbe;
    }
}