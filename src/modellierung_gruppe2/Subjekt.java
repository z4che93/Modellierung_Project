package modellierung_gruppe2;

/**
 * Interface zur Klasse Figur.
 *
 * @author Gruppe 2
 *
 */
public interface Subjekt {

    /**
     * Fügt einen Beobachter zur Beobachter-Liste hinzu.
     *
     * @param b Übergabe eines Beobachter-Objektes.
     */
    public void registriereBeobachter(Beobachter b);

    /**
     * Entfernt einen Beobachter aus der Beobachter-Liste.
     *
     * @param b Übergabe eines Beobachter-Objektes.
     */
    public void entferneBeobachter(Beobachter b);

    /**
     * Gibt die Aktualisierungen an alle Beobachter weiter und weist der vorherigen
     * X- und Y-Koordinate die entsprechende aktuelle zu.
     */
    public void benachrichtigeBeobachter();
}