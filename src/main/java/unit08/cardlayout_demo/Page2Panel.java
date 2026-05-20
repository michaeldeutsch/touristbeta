package cardlayout_demo;

import javax.swing.*;
import java.awt.*;

public class Page2Panel extends JPanel {

    public Page2Panel(MainFrame frame) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Page 2", SwingConstants.CENTER);
        JButton back = new JButton("Back to Menu");

        back.addActionListener(e -> frame.showPage("menu"));

        add(label, BorderLayout.CENTER);
        add(back, BorderLayout.SOUTH);
    }
}
