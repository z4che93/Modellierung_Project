package modellierung_gruppe2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;

/**
 * Klasse, auf der die Ameise sich bewegt und Felder färbt
 *
 * @author Gruppe 2
 *
 */
public class GUI_Feld extends JFrame {

    private static final long serialVersionUID = 1L;
    private int geschwindigkeit;
    private boolean programmStart = false;
    private GridBagConstraints gbc;
    private JButton btn_Start, btn_Pause, btn_Reset, btn_NaechsterSchritt;
    private JLabel[][] felder;
    private JPanel contentPane, panel_Ameise = new JPanel();
    private JRadioButton rdbtnEinzelschritt = new JRadioButton("Einzelschritt");
    private JSlider slider = new JSlider();
    private JTextField txt_fldIterator;
    private Strategy strategy;
    private Uhr uhr;

    /**
     * Erzeugt das GUI-Objekt auf der die Ameise läuft und färbt.
     *
     * @param s		Instanz von Strategy.
     */
    public GUI_Feld(Strategy s) {
        // Initialisierungen die GUI.
        setTitle("Figurenfeld");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 660);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Initilaisierungen für Kommunikation zwischen GUI und Logik.
        uhr = new Uhr();
        strategy = s;
        GUI_Eingabe frameEingabe = new GUI_Eingabe(GUI_Feld.this);
        frameEingabe.setVisible(true);

        // Initialisierungen von Objekten auf der GUI.
        JPanel panel_menu = new JPanel();
        panel_menu.setBackground(Color.GRAY);
        panel_menu.setBounds(0, 0, 984, 20);
        contentPane.add(panel_menu);
        panel_menu.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 884, 20);
        panel_menu.add(menuBar);

        JMenu mnNewMenu = new JMenu("Eingabedaten");
        menuBar.add(mnNewMenu);

        menuBar.add(rdbtnEinzelschritt);

        slider.setToolTipText("Geschwindigkeit");
        slider.setMinimum(0);
        slider.setMaximum(999);
        slider.setValue(800);
        menuBar.add(slider);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                geschwindigkeit = slider.getValue();
                if (programmStart) {
                    uhr.stopTicking();
                    uhr.startTicking(1000 - geschwindigkeit, strategy);
                }
            }
        });

        geschwindigkeit = slider.getValue();

        txt_fldIterator = new JTextField();
        txt_fldIterator.setToolTipText("Schritte, die die Figur zurückgelegt hat");
        txt_fldIterator.setText("0");
        menuBar.add(txt_fldIterator);
        txt_fldIterator.setColumns(1);

        btn_Start = new JButton("Start");
        menuBar.add(btn_Start);

        btn_Pause = new JButton("Pause");
        menuBar.add(btn_Pause);

        btn_Reset = new JButton("Reset");
        menuBar.add(btn_Reset);

        btn_NaechsterSchritt = new JButton("Nächster Schritt");
        btn_NaechsterSchritt.setVisible(false);
        menuBar.add(btn_NaechsterSchritt);

        panel_Ameise.setBackground(Color.LIGHT_GRAY);
        panel_Ameise.setBounds(0, 20, 884, 601);
        contentPane.add(panel_Ameise);
        GridBagLayout gbl_panel_Ameise = new GridBagLayout();
        panel_Ameise.setLayout(gbl_panel_Ameise);

        gbc = new GridBagConstraints();
        gbl_panel_Ameise.setConstraints(panel_Ameise, gbc);
        panel_Ameise.setLayout(gbl_panel_Ameise);

        // Initialisierungen von Listenern
        mnNewMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
                GUI_Eingabe frameEingabe = new GUI_Eingabe(GUI_Feld.this);
                frameEingabe.setVisible(true);
            }
        });
        rdbtnEinzelschritt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_NaechsterSchritt.setVisible(rdbtnEinzelschritt.isSelected());
                btn_Start.setVisible(!rdbtnEinzelschritt.isSelected());
                btn_Start.setEnabled(!rdbtnEinzelschritt.isSelected());
                btn_Pause.setVisible(!rdbtnEinzelschritt.isSelected());
                slider.setVisible(!rdbtnEinzelschritt.isSelected());
                programmAnhalten();
            }
        });
        btn_Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_Start.setEnabled(false);
                programmStart = true;
                autoBewegen();
            }
        });
        btn_Pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_Start.setEnabled(true);
                programmAnhalten();
            }
        });
        btn_Reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }

        });
        btn_NaechsterSchritt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                strategy.bewegen();
            }
        });
    }

    /**
     * Methode, die das Programm auf die eingegebenen Startdaten zurücksetzt.
     *
     */
    public void reset() {
        Color farbe = Farben.listeVerwendeteFarben.getErsteFarbe().getFarbe();

        rdbtnEinzelschritt.setEnabled(true);
        btn_Start.setEnabled(true);
        btn_Pause.setEnabled(true);
        slider.setEnabled(true);
        slider.setValue(800);

        programmAnhalten();
        for (int i = 0; i < strategy.getFeldlaenge(); i++) {
            for (int j = 0; j < strategy.getFeldbreite(); j++) {
                gbc.gridx = i;
                gbc.gridy = j;
                felder[i][j].setBackground(farbe);
            }
        }
        felder[strategy.getxStart()][strategy.getyStart()]
                .setBackground(Farben.listeVerwendeteFarben.getStartfarbe());
        this.revalidate();
        strategy.reset();
        txt_fldIterator.setText(String.valueOf(strategy.getZaehler()));
    }

    /**
     * Färbt alle Felder auf das erste Element der Liste der verwendeten Farben.
     */
    public void felderbefuellen() {
        Color farbe = Farben.listeVerwendeteFarben.getErsteFarbe().getFarbe();
        for (int i = 0; i < strategy.getFeldlaenge(); i++) {
            for (int j = 0; j < strategy.getFeldbreite(); j++) {
                gbc.gridx = i;
                gbc.gridy = j;
                felder[i][j] = createLabel(farbe);
                panel_Ameise.add(felder[i][j], gbc);
            }
        }
    }

    /**
     * Methode, die ein Label erzeugt und färbt dieses in der übergebebenen Farbe.
     *
     * @param c Color-Objekt, in das das Feld gefärbt wird.
     * @return Label-Objekt, das in der übergegebenen Farbe gefäbrt wurde.
     */
    private JLabel createLabel(Color c) {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(4, 4));
        label.setOpaque(true);
        label.setBackground(c);
        return label;
    }

    /**
     * Speichert alle Daten, die zur Initialisierung notwendig sind.
     *
     * @param figur			   Vom Benutzer vorgegebene verwendete Figur.
     *
     * @param bewegungsabfolge Vom Benutzer festgelegte Bewegungsabfolge.
     * @param blickrichtung    Vom Benutzer festgelegte Blickrichtung.
     * @param groesseX         Vom Benutzer festgelegte Länge des Feldes auf dem
     *                         sich die Ameise bewegt.
     * @param groesseY         Vom Benutzer festgelegte Breite des Feldes auf dem
     *                         sich die Ameise bewegt.
     * @param startX           Vom Benutzer festgelegte X-Koordinate des
     *                         Startpunktes der Ameise.
     * @param startY           Vom Benutzer festgelegte Y-Koordinate des
     *                         Startpunktes der Ameise.
     * @param randStop         Vom benuter vorgegebener Abbruchbedingung Am Rand
     *                         stoppen oder periodisch weiterlaufen.
     */
    public void my_update(String figur, String bewegungsabfolge, Blickrichtung blickrichtung, int groesseX,
                          int groesseY, int startX, int startY, boolean randStop) {
        panel_Ameise.removeAll();
        strategy.init(figur, bewegungsabfolge, blickrichtung, startX, startY, groesseX, groesseY, randStop);
        felder = new JLabel[groesseX][groesseY];
        felderbefuellen();
        panel_Ameise.repaint();
        felder[startX][startY].setBackground(Farben.listeVerwendeteFarben.getStartfarbe());
        this.setVisible(true);
        this.revalidate();
    }

    /**
     * Methode, die die Farbe des Feldes mit der entsprechenden X- bzw. Y-Koordinate
     * aktualisiert.
     */
    public void aktualisiere() {
        if (strategy.getStop()) {
            felder[strategy.getxPrev()][strategy.getyPrev()].setBackground(strategy.getAktuelleFarbe());
            uhr.stopTicking();
            rdbtnEinzelschritt.setEnabled(false);
            btn_Start.setEnabled(false);
            btn_Pause.setEnabled(false);
            slider.setEnabled(false);
        } else {
            felder[strategy.getxPrev()][strategy.getyPrev()].setBackground(strategy.getAktuelleFarbe());
            felder[strategy.getxStart()][strategy.getyStart()]
                    .setBackground(Farben.listeVerwendeteFarben.getStartfarbe());
            felder[strategy.getxAktuell()][strategy.getyAktuell()]
                    .setBackground(Farben.listeVerwendeteFarben.getFigurfarbe());
            txt_fldIterator.setText(String.valueOf(strategy.getZaehler()));
        }
    }

    /**
     * Methode, die die Geschwindigkeit der Ameise berechnet.
     *
     */
    private void autoBewegen() {
        if (programmStart) {
            uhr.startTicking(1000 - geschwindigkeit, strategy);
        }
    }
    /**
     * Methode, die das Programm anhält.
     */
    private void programmAnhalten() {
        if (programmStart) {
            uhr.stopTicking();
            programmStart = false;
        }
    }
}