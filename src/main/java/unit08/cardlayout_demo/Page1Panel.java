package unit08.cardlayout_demo;

import javax.swing.*;
import java.awt.*;

public class Page1Panel extends JPanel {

    public Page1Panel(MainFrame frame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Page 1", SwingConstants.CENTER);
        JButton back = new JButton("Back to Menu");

        back.addActionListener(e -> frame.showPage("menu"));

        add(label, BorderLayout.CENTER);
        add(back, BorderLayout.SOUTH);
    }
}
