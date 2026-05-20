package unit08.cardlayout_demo;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(MainFrame frame) {
        setLayout(new GridLayout(3, 1, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btn1 = new JButton("Go to Page 1");
        JButton btn2 = new JButton("Go to Page 2");

        btn1.addActionListener(e -> frame.showPage("page1"));
        btn2.addActionListener(e -> frame.showPage("page2"));

        add(new JLabel("Main Menu", SwingConstants.CENTER));
        add(btn1);
        add(btn2);
    }
}
