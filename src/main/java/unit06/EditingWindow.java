package unit06;

import javax.swing.*;
import java.awt.*;

public class EditingWindow extends JDialog {

    EditingWindow(MainFrame mainFrame, Hotel hotel, Runnable okAction){
        setSize(300,300);
        setTitle("Editing Window");
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setText(hotel.toString());
        textArea.setEditable(false);
        add(textArea, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        add(okButton, BorderLayout.SOUTH);

        okButton.addActionListener(e->{
            hotel.setName("CHANGEND BY BUTTON");
            okAction.run();

            dispose();
        });

    }
}
