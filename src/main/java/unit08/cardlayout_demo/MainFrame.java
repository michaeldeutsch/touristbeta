package cardlayout_demo;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout layout = new CardLayout();
    private JPanel container = new JPanel(layout);

    public MainFrame() {
        setTitle("CardLayout Demo");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        MenuPanel menu = new MenuPanel(this);
        Page1Panel page1 = new Page1Panel(this);
        Page2Panel page2 = new Page2Panel(this);

        container.add(menu, "menu");
        container.add(page1, "page1");
        container.add(page2, "page2");

        add(container);
        showPage("menu");
    }

    public void showPage(String name) {
        layout.show(container, name);
    }
}
