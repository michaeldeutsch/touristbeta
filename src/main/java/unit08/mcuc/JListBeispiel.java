package mcuc;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JListBeispiel extends JFrame {

    private JList<String> liste;
    private JTextArea ausgabe;

    public JListBeispiel() {
        setTitle("JList Beispiel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] daten = {"Java", "Python", "C#", "JavaScript", "Go"};

        liste = new JList<>(daten);
        liste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JButton btnAnzeigen = new JButton("Auswahl anzeigen");
        ausgabe = new JTextArea(8, 25);
        ausgabe.setEditable(false);

        btnAnzeigen.addActionListener(e -> {
            List<String> auswahl = liste.getSelectedValuesList();

            ausgabe.setText("Gewählte Einträge:\n");
            for (String eintrag : auswahl) {
                ausgabe.append("- " + eintrag + "\n");
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(liste), BorderLayout.NORTH);
        add(btnAnzeigen, BorderLayout.CENTER);
        add(new JScrollPane(ausgabe), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JListBeispiel().setVisible(true));
    }
}
