package modellierung_gruppe2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class Node_Test {

    @Test
    void testNodeColorNodeNull() {
        Color expected1 = Color.black;
        Node expected2 = null;
        // Er erzeugt zuerst das Objekt in testGetNext() ==> 1
        int expected3 = 1;

        Node n = new Node(expected1, expected2);
        Color actual1 = n.getFarbe();
        Node actual2 = n.getNext();
        int actual3 = n.getValue();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    void testNodeColorNodeNotNull() {
        Color expected1 = Color.black;
        Node m = new Node(Color.white);
        // Er erzeugt zuerst das Objekt in testGetNext() und dann erzeugt er das Objekt in
        // testNodeColorNodeNull() und dann erst hier ==> 2
        int expected3 = 2;

        Node n = new Node(expected1, m);
        Color actual1 = n.getFarbe();
        Node actual2 = m.getNext();
        int actual3 = n.getValue();

        assertEquals(expected1, actual1);
        assertEquals(n, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    void testNodeColor() {
        Color expected1 = Color.black;
        Node n = new Node(expected1);
        Color actual1 = n.getFarbe();
        assertEquals(expected1, actual1);

        int expected2 = -1;
        int actual2 = n.getValue();
        assertEquals(expected2, actual2);
    }

    @Test
    void testConnectToFirstEntry() {

        Node n = new Node(null);
        Node m = new Node(null);

        m.connectToFirstEntry(n);
        Node expected = n;
        Node actual = m.getNext();
        assertEquals(expected, actual);

    }

    @Test
    void testGetFarbe() {
        Color expected = Color.black;
        Node n = new Node(expected);
        Color actual = n.getFarbe();
        assertEquals(expected, actual);
    }

    @Test
    void testGetNext() {
        Node n = new Node(null);
        Node m = new Node(null, n);
        Node expected = m;
        Node actual = n.getNext();
        assertEquals(expected, actual);

    }

    @Test
    void testGetValue() {
        Node n = new Node(null);
        int expected = -1;
        int actual = n.getValue();
        assertEquals(expected, actual);
    }

}