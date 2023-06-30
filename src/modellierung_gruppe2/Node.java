package modellierung_gruppe2;

import java.awt.Color;

/**
 * Die Klasse legt die Logik der Nodes, die in Farben verwendet werden, fest.
 *
 * @author Gruppe 2
 *
 */
public class Node {

    private Color farbe;
    private Node next;
    private int value;
    static private int length = 0;

    /**
     * Konstruktor mit Color- und Node-Objekt fügt eine neue Farbe in die Liste
     * aller verwendeten Farben hinzu.
     *
     * @param farbe     Color-Objekt, das zur Liste aller verwendeten Farben
     *                  hinzugefügt wird.
     * @param vorherige Node-Objekt, das sich um eine Position vor der neu
     *                  hinzugefügten Farben befindet und auf dieses verweist.
     */
    public Node(Color farbe, Node vorherige) {
        this.value = length;
        this.farbe = farbe;
        if (vorherige != null) {
            vorherige.next = this;
        }
        length++;
    }

    /**
     * Konstruktor mit einem Color-Objekt legt die erste Farbe in der Liste aller
     * verwendeten Farben an.
     *
     * @param farbe Color-Objekt, das die erste Farbe in der Liste aller verwendeten
     *              Farben darstellt.
     */
    public Node(Color farbe) {
        this.farbe = farbe;
        this.value = -1;
    }

    /**
     * Methode, die das übergebene Node-Objekt mit dem ersten Element der Liste
     * aller verwendeten Farben verbindet.
     *
     * @param n Node-Objekt, das mit dem ersten Node-Objekt aus der Liste verbunden
     *          werden soll.
     */
    public void connectToFirstEntry(Node n) {
        this.next = n;
    }

    /**
     *
     * @return Gibt die entsprechende Farbe zurück.
     */
    public Color getFarbe() {
        return farbe;
    }

    /**
     *
     * @return Gibt das nächste Element der aktuellen Node zurück.
     */
    public Node getNext() {
        return next;
    }

    /**
     *
     * @return Gibt den Wert der aktuellen Node zurück.
     */
    public int getValue() {
        return value;
    }

    /**
     * Setzt die Länge der Liste auf 0.
     */
    public static void setLengthZero() {
        length = 0;
    }
}