package mcuc;

import javax.swing.*;
import java.awt.*;

public class RadioButtonBeispiel extends JFrame {

    private JRadioButton rbRot;
    private JRadioButton rbBlau;
    private JRadioButton rbGruen;
    private JTextArea ausgabe;

    public RadioButtonBeispiel() {
        setTitle("RadioButton Beispiel");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        rbRot = new JRadioButton("Rot");
        rbBlau = new JRadioButton("Blau");
        rbGruen = new JRadioButton("Grün");

        ButtonGroup gruppe = new ButtonGroup();
        gruppe.add(rbRot);
        gruppe.add(rbBlau);
        gruppe.add(rbGruen);

        JButton btnAnzeigen = new JButton("Auswahl anzeigen");
        ausgabe = new JTextArea(5, 20);
        ausgabe.setEditable(false);

        btnAnzeigen.addActionListener(e -> {
            String auswahl = "Keine Auswahl";

            if (rbRot.isSelected()) {
                auswahl = "Rot";
            } else if (rbBlau.isSelected()) {
                auswahl = "Blau";
            } else if (rbGruen.isSelected()) {
                auswahl = "Grün";
            }

            ausgabe.setText("Gewählt: " + auswahl);
        });

        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(rbRot);
        panel.add(rbBlau);
        panel.add(rbGruen);

        add(panel, BorderLayout.NORTH);
        add(btnAnzeigen, BorderLayout.CENTER);
        add(ausgabe, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButtonBeispiel().setVisible(true));
    }
}
