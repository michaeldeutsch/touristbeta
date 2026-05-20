package unit08.readEmail;

import javax.swing.*;

public class AppLauncher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MailService mailService = new MailService();
                MainFrame mainFrame = new MainFrame(mailService);
                mainFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, 
                    "Fehler beim Starten der Anwendung: " + e.getMessage(), 
                    "Startfehler", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
