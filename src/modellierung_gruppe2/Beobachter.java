package modellierung_gruppe2;

/**
 * Interface für das Aktualisieren auf der GUI.
 *
 * @author Gruppe 2
 *
 */
public interface Beobachter {

    /**
     * Gibt die Aktualisierungen an alle Beobachter weiter und weist der vorherigen
     * X- und Y-Koordinate die entsprechende aktuelle zu.
     */
    public void aktualisiere();
}