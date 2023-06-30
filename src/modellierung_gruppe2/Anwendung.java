package modellierung_gruppe2;

/**
 * Die Klasse Anwendung startet das Projekt.
 *
 * @author Gruppe 2
 *
 */
public class Anwendung {

    /**
     * Erzeugt die benötigten Objekte, um das Projekt zu initialisieren.
     *
     * @param args
     */
    public static void main(String[] args) {
        Farben farbenListe = new Farben();
        Subjekt ameise = new Ameise();
        Subjekt springer = new Springer();
        Strategy controller = new Controller((Model) ameise, (Model) springer);
        Beobachter v = new View(ameise, springer, controller);
    }
}