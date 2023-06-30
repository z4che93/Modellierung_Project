package modellierung_gruppe2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Die Klasse Uhr unterbricht und setzt den Code fort.
 *
 * @author Gruppe 2
 *
 */
public class Uhr {
    private Timer clock;
    private TimerTask tick;

    /**
     * Erzeugt ein neues Timer-Objekt.
     */
    public Uhr() {
        clock = new Timer();
        tick = null;
    }

    /**
     * Starte die Uhr.
     *
     * @param millisekundenZwischenTicks Die Zeit zwischen zwei Ticks in Millisekunden.
     * @param s						 Das verwendete Strategy-Objekt.
     */
    public void startTicking(int millisekundenZwischenTicks, Strategy s) {
        if (millisekundenZwischenTicks > 0) {
            tick = new TimerTask() {
                public void run() {
                    s.bewegen();
                }
            };
            clock.scheduleAtFixedRate(tick, 0, millisekundenZwischenTicks);
        }
    }

    /**
     * Methode, die den Timer stoppt.
     */
    public void stopTicking() {
        tick.cancel();
    }
}