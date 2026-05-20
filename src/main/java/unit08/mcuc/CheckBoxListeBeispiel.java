package mcuc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CheckBoxListeBeispiel extends JFrame {

    private JCheckBox cbJava;
    private JCheckBox cbPython;
    private JCheckBox cbCSharp;
    private JTextArea ausgabe;

    public CheckBoxListeBeispiel() {
        setTitle("Checkbox Beispiel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cbJava = new JCheckBox("Java");
        cbPython = new JCheckBox("Python");
        cbCSharp = new JCheckBox("C#");

        JButton btnAnzeigen = new JButton("Auswahl anzeigen");
        ausgabe = new JTextArea(8, 25);
        ausgabe.setEditable(false);

        btnAnzeigen.addActionListener(e -> {
            List<String> auswahl = new ArrayList<>();

            if (cbJava.isSelected()) {
                auswahl.add("Java");
            }
            if (cbPython.isSelected()) {
                auswahl.add("Python");
            }
            if (cbCSharp.isSelected()) {
                auswahl.add("C#");
            }

            ausgabe.setText("Gewählte Einträge:\n");
            for (String eintrag : auswahl) {
                ausgabe.append("- " + eintrag + "\n");
            }
        });

        JPanel oben = new JPanel(new GridLayout(3, 1));
        oben.add(cbJava);
        oben.add(cbPython);
        oben.add(cbCSharp);

        setLayout(new BorderLayout());
        add(oben, BorderLayout.NORTH);
        add(btnAnzeigen, BorderLayout.CENTER);
        add(new JScrollPane(ausgabe), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CheckBoxListeBeispiel().setVisible(true));
    }
}
