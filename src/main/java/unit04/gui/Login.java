package unit04.gui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login(){
        setTitle("Welcome to my first GUI program");
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2,2,10, 10 ));
        JButton loginButton = new JButton("Login");

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

         panel.add(new JLabel("Username:"));
         panel.add(username);
        panel.add(new JLabel("Username:"));
        panel.add(password);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // cheat
         add(panel,BorderLayout.CENTER);
         add(loginButton,BorderLayout.SOUTH);

         loginButton.addActionListener(e -> {
             JOptionPane.showMessageDialog(null, "Welcome " + username.getText());
         });


    }


}
