package unit08.mcuc;

import javax.swing.*;
import java.awt.*;

public class JListVorbelegungBeispiel extends JFrame {

    public JListVorbelegungBeispiel() {
        setTitle("JList Vorbelegung");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] daten = {"Java", "Python", "C#", "JavaScript"};
        JList<String> liste = new JList<>(daten);

        liste.setSelectedIndices(new int[]{0, 2});

        add(new JScrollPane(liste), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JListVorbelegungBeispiel().setVisible(true));
    }
}
