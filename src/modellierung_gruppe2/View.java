package modellierung_gruppe2;


/**
 * Klasse, die alle Aktualisierungen auf der GUI ansteuert.
 *
 * @author Gruppe 2
 *
 */
public class View implements Beobachter {

    private GUI_Feld frame;

    /**
     * Konstrukor, aus dem die GUI, auf der die Figur sich bewegt, aufruft.
     *
     * @param ameise Subjekt-Objekt.
     * @param springer Subjekt-Objekt.
     * @param controller Strategy-Objekt.
     */
    public View(Subjekt ameise, Subjekt springer, Strategy controller) {
        ameise.registriereBeobachter(this);
        springer.registriereBeobachter(this);

        try {
            frame = new GUI_Feld(controller);
            frame.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        controller.reset();
    }

    /**
     * Gibt die Aktualisierungen an alle Beobachter weiter und weist der vorherigen
     * X- und Y-Koordinate die entsprechende aktuelle zu.
     */
    @Override
    public void aktualisiere() {
        frame.aktualisiere();
    }
}