package modellierung_gruppe2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Klasse, die die GUI der Benutzereingaben verwaltet.
 *
 * @author Gruppe 2
 *
 */
public class GUI_Eingabe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtfld_Bewegungsabfolge, txtfld_FeldX, txtfld_FeldY, txtfld_StartX, txtfld_StartY;

    /**
     * Erstellt die GUI für die Benutzereingabe
     *
     * @param frame Instanz von GUI_Feld.
     */
    public GUI_Eingabe(GUI_Feld frame) {
        // Initialisierungen für die GUI
        setTitle("Eingabedaten");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 620, 612);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Initialisierungen von Objekten auf der GUI
        JLabel lbl_AuswahlFigur = new JLabel("Figurauswahl");
        lbl_AuswahlFigur.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_AuswahlFigur.setBounds(10, 12, 129, 14);
        contentPane.add(lbl_AuswahlFigur);

        JLabel lbl_Blickrichtung = new JLabel("Blickrichtung");
        lbl_Blickrichtung.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_Blickrichtung.setBounds(144, 12, 129, 14);
        contentPane.add(lbl_Blickrichtung);

        JLabel lbl_Abbruchbedingung = new JLabel("Abbruchbedingung");
        lbl_Abbruchbedingung.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_Abbruchbedingung.setBounds(278, 12, 109, 15);
        contentPane.add(lbl_Abbruchbedingung);

        JLabel lbl_Bewegungsabfolge = new JLabel("Bewegungsabfolge");
        lbl_Bewegungsabfolge.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_Bewegungsabfolge.setBounds(412, 12, 109, 15);
        contentPane.add(lbl_Bewegungsabfolge);

        JComboBox<String> cmbbx_Figur = new JComboBox<String>();
        cmbbx_Figur.setBounds(10, 32, 119, 20);
        cmbbx_Figur.addItem("Ameise");
        cmbbx_Figur.addItem("Springer");
        contentPane.add(cmbbx_Figur);

        JComboBox<String> cmbbx_Blickrichtung = new JComboBox<String>();
        cmbbx_Blickrichtung.setBounds(144, 32, 119, 20);
        cmbbx_Blickrichtung.addItem("OBEN");
        cmbbx_Blickrichtung.addItem("UNTEN");
        cmbbx_Blickrichtung.addItem("LINKS");
        cmbbx_Blickrichtung.addItem("RECHTS");
        contentPane.add(cmbbx_Blickrichtung);

        JComboBox<String> cmbbx_Abbruchbedingung = new JComboBox<String>();
        cmbbx_Abbruchbedingung.setBounds(278, 32, 119, 20);
        cmbbx_Abbruchbedingung.addItem("Nicht periodisch");
        cmbbx_Abbruchbedingung.addItem("Periodisch");
        contentPane.add(cmbbx_Abbruchbedingung);

        txtfld_Bewegungsabfolge = new JTextField();
        txtfld_Bewegungsabfolge.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtfld_Bewegungsabfolge.setText("RL");
        txtfld_Bewegungsabfolge.setBounds(412, 30, 160, 20);
        contentPane.add(txtfld_Bewegungsabfolge);
        txtfld_Bewegungsabfolge.setColumns(10);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 63, 604, 2);
        contentPane.add(separator_1);

        JLabel lbl_Felddaten = new JLabel("Felddaten");
        lbl_Felddaten.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_Felddaten.setBounds(10, 76, 109, 15);
        contentPane.add(lbl_Felddaten);

        JLabel lbl_Feldgroesse = new JLabel("Feldgröße:");
        lbl_Feldgroesse.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Feldgroesse.setBounds(10, 96, 109, 20);
        contentPane.add(lbl_Feldgroesse);

        txtfld_FeldX = new JTextField();
        txtfld_FeldX.setText("150");
        txtfld_FeldX.setBounds(125, 96, 40, 20);
        txtfld_FeldX.setColumns(10);
        contentPane.add(txtfld_FeldX);

        txtfld_FeldY = new JTextField();
        txtfld_FeldY.setText("100");
        txtfld_FeldY.setBounds(175, 96, 40, 20);
        contentPane.add(txtfld_FeldY);
        txtfld_FeldY.setColumns(10);

        JLabel lbl_Startpunkt = new JLabel("Startpunkt:");
        lbl_Startpunkt.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Startpunkt.setBounds(278, 96, 109, 14);
        contentPane.add(lbl_Startpunkt);

        txtfld_StartX = new JTextField();
        txtfld_StartX.setText(String.valueOf((int) (Integer.valueOf(txtfld_FeldX.getText()) * 0.5)));
        txtfld_StartX.setBounds(393, 96, 40, 20);
        txtfld_StartX.setColumns(10);
        contentPane.add(txtfld_StartX);

        txtfld_StartY = new JTextField();
        txtfld_StartY.setText(String.valueOf((int) (Integer.valueOf(txtfld_FeldY.getText()) * 0.5)));
        txtfld_StartY.setBounds(443, 96, 40, 20);
        txtfld_StartY.setColumns(10);
        contentPane.add(txtfld_StartY);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(0, 127, 614, 2);
        contentPane.add(separator_2);

        JButton btn_EingabenSpeichern = new JButton("Eingaben speichern");
        btn_EingabenSpeichern.setBounds(217, 140, 170, 40);
        contentPane.add(btn_EingabenSpeichern);

        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(0, 191, 614, 2);
        contentPane.add(separator_3);

        JLabel lbl_Kommentare = new JLabel("Kommentare / Hinweise zu Benutzereingaben:");
        lbl_Kommentare.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_Kommentare.setBounds(10, 204, 275, 14);
        contentPane.add(lbl_Kommentare);

        JEditorPane textArea = new JEditorPane("text/html", "");
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 10));
        textArea.setBounds(10, 229, 586, 333);
        textArea.setText(
                "<b><u>Abbruchbedingung:</u></b> Periodisch (Rand wird nich beachtet und die Figur setzt entsprechend ihrer Blickrichtung ihre Bewegung fort), Nicht periodisch (Programm stoppt, wenn die Figur einen Rand berührt)<br><br><b><u>Bewegungsabfolge:</u></b> Akzeptiert werden nur die Buchstaben L und R mit minmal 2 und maximal 16 Zeichen.<br><br><b><u>Feldgröße:</u></b> Akzeptiert werden nur positive numerische Werte. Die vorgegebenen Werte sind minimal, können nach oben hin angepasst werden. Maximaler Eintrag im 1. Feld beträgt 220<br>und im 2. Feld 150.<br><br><b><u>Startpunkt:</u></b> Akzeptiert werden nur positive numerische Werte. Diese werden standardmäßig durch ausfüllen des entsprechendes Feldes der Feldgröße automatisch berechnet, können nachträglich<br>geändert werden. Sie dürfen jedoch maximal so groß sein wie das entsprechende Feld der Feldgröße.<br><br><b><u>Eingabe Speichern:</u></b> Wenn ungültige Werte in den Textfeldern eingegeben werden, wird der Button ausgeraugt. Sobald sich in allen wieder gültige Werte befinden, kann der Button wieder benutzt werden.");
        contentPane.add(textArea);

        // Initialisierungen von Listenern.
        cmbbx_Figur.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (cmbbx_Figur.getSelectedItem().toString().equals("Springer")) {
                    lbl_Bewegungsabfolge.setVisible(false);
                    lbl_Bewegungsabfolge.setVisible(false);
                    txtfld_Bewegungsabfolge.setVisible(false);
                } else {
                    lbl_Bewegungsabfolge.setVisible(true);
                    lbl_Bewegungsabfolge.setVisible(true);
                    txtfld_Bewegungsabfolge.setVisible(true);
                }
            }
        });
        txtfld_Bewegungsabfolge.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!inputRegex(txtfld_Bewegungsabfolge.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Die Eingabe der Bewegungsfolge liegt entweder nicht zwischen 2 und 16, oder beinhaltet nicht ausschließlich \"r,l,R,L\" !", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                    btn_EingabenSpeichern.setEnabled(false);
                } else {
                    btn_EingabenSpeichern.setEnabled(eingabeErlaubt());
                    txtfld_Bewegungsabfolge.setText(txtfld_Bewegungsabfolge.getText().toUpperCase());
                }
            }
        });
        txtfld_FeldX.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (widthOutOfRange(Integer.valueOf(txtfld_FeldX.getText()))) {
                    btn_EingabenSpeichern.setEnabled(false);
                    JOptionPane.showMessageDialog(new JFrame(), "Wert liegt nicht zwischen 150 und 220", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    btn_EingabenSpeichern.setEnabled(eingabeErlaubt());
                    txtfld_StartX.setText(String.valueOf((int) (Integer.valueOf(txtfld_FeldX.getText()) * 0.5)));
                }
            }
        });
        txtfld_FeldY.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (heightOutOfRange(Integer.valueOf(txtfld_FeldY.getText()))) {
                    btn_EingabenSpeichern.setEnabled(false);
                    JOptionPane.showMessageDialog(new JFrame(), "Wert liegt nicht zwischen 100 und 150", "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    btn_EingabenSpeichern.setEnabled(eingabeErlaubt());
                    txtfld_StartY.setText(String.valueOf((int) (Integer.valueOf(txtfld_FeldY.getText()) * 0.5)));
                }
            }
        });
        txtfld_StartX.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (startXOutOfRange(Integer.valueOf(txtfld_StartX.getText()))) {
                    int startX = Integer.valueOf(txtfld_FeldX.getText()) - 1;

                    btn_EingabenSpeichern.setEnabled(false);
                    JOptionPane.showMessageDialog(new JFrame(),
                            "X-Koordinate des Startpunktes liegt außerhalb von 0 und " + String.valueOf(startX) + "!",
                            "Dialog", JOptionPane.ERROR_MESSAGE);
                } else {
                    btn_EingabenSpeichern.setEnabled(eingabeErlaubt());
                }
            }
        });
        txtfld_StartY.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (startYOutOfRange(Integer.valueOf(txtfld_StartY.getText()))) {
                    int startY = Integer.valueOf(txtfld_FeldY.getText()) - 1;

                    btn_EingabenSpeichern.setEnabled(false);
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Y-Koordinate des Startpunktes liegt außerhalb von 0 und " + String.valueOf(startY) + "!",
                            "Dialog", JOptionPane.ERROR_MESSAGE);
                } else {
                    btn_EingabenSpeichern.setEnabled(eingabeErlaubt());
                }
            }
        });
        btn_EingabenSpeichern.addActionListener(new ActionListener() {
            /**
             * Setzt das Blickrichtungs-Objekt und übergibt Initilisierungs-Daten an das
             * GUI-Feld.
             *
             * @param e.
             */
            public void actionPerformed(ActionEvent e) {
                if (eingabeErlaubt()) {
                    Blickrichtung blickrichtung = Blickrichtung.OBEN;
                    switch (String.valueOf(cmbbx_Blickrichtung.getSelectedItem()).toUpperCase()) {
                        case "UNTEN":
                            blickrichtung = Blickrichtung.UNTEN;
                            break;
                        case "LINKS":
                            blickrichtung = Blickrichtung.LINKS;
                            break;
                        case "RECHTS":
                            blickrichtung = Blickrichtung.RECHTS;
                            break;
                    }
                    boolean randStop = true;
                    if (String.valueOf(cmbbx_Abbruchbedingung.getSelectedItem()).equals("Periodisch")) {
                        randStop = false;
                    }
                    frame.my_update(cmbbx_Figur.getSelectedItem().toString(), txtfld_Bewegungsabfolge.getText(),
                            blickrichtung, Integer.valueOf(txtfld_FeldX.getText()),
                            Integer.valueOf(txtfld_FeldY.getText()), Integer.valueOf(txtfld_StartX.getText()),
                            Integer.valueOf(txtfld_StartY.getText()), randStop);
                    dispose();
                    frame.setVisible(true);
                }
            }
        });
    }

    /**
     * Methode, die einen String prüft und entsprechenden boolean zurückgibt.
     *
     * @param input String mit der eingegebenen Bewegungsabfolge.
     * @return Liefert true zurück, wenn input mind. ein Zeichen nicht aus {r,l,R,L}
     *         enthält.
     */
    private boolean inputRegex(String input) {
        return input.matches("^([rlRL]){2,16}");
    }

    /**
     * Methode, die die Eingabe prüft und einen entsprechenden boolean
     * zurückliefert.
     *
     * @param width Integer mit der Breite des Ameisenfeldes.
     * @return Liefert true zurück, wenn width kleiner 150, oder größer 220 ist.
     */
    private boolean widthOutOfRange(int width) {
        return width < 150 || width > 220 ? true : false;
    }

    /**
     * Methode, die die Eingabe prüft und einen entsprechenden boolean
     * zurückliefert.
     *
     * @param height Integer mit der Höhe des Ameisenfeldes.
     * @return Liefert true zurück, wenn height kleiner 100, oder größer 150 ist.
     */
    private boolean heightOutOfRange(int height) {
        return height < 100 || height > 150 ? true : false;
    }

    /**
     * Methode, die prüft ob die X-Koordinate des Startpunktes im Feld liegt.
     *
     * @param startX Integer liefert die X-Koordiante des Startpunktes.
     * @return Liefert true zurück, wenn sich die X-Koordinate des Startpunktes
     *         innerhalb des Feldes befindet.
     */
    private boolean startXOutOfRange(int startX) {
        return startX < 0 || startX >= Integer.valueOf(txtfld_FeldX.getText()) ? true : false;
    }

    /**
     * Methode, die prüft ob die Y-Koordinate des Startpunktes im Feld liegt.
     *
     * @param startY Integer liefert die Y-Koordiante des Startpunktes.
     * @return Liefert true zurück, wenn sich die Y-Koordinate des Startpunktes
     *         innerhalb des Feldes befindet.
     */
    private boolean startYOutOfRange(int startY) {
        return startY < 0 || startY >= Integer.valueOf(txtfld_FeldY.getText()) ? true : false;
    }

    /**
     * Methode, die prüft ob alle getätigten Eingaben in den Textfeldern der Vorgabe
     * entsprechen.
     *
     * @return Liefert true zurück, wenn alle Eingaben der Textfeldern korrekt sind.
     */
    private boolean eingabeErlaubt() {
        int startX = Integer.valueOf(txtfld_StartX.getText()), startY = Integer.valueOf(txtfld_StartY.getText()),
                feldBreite = Integer.valueOf(txtfld_FeldX.getText()),
                feldHoehe = Integer.valueOf(txtfld_FeldY.getText());
        String bewegungsabfolge = txtfld_Bewegungsabfolge.getText();

        return inputRegex(bewegungsabfolge) && !startXOutOfRange(startX) && !startYOutOfRange(startY)
                && !heightOutOfRange(feldHoehe) && !widthOutOfRange(feldBreite) ? true : false;
    }
}