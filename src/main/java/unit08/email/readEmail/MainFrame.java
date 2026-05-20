package unit08.readEmail;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {

    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> jList = new JList<>(listModel);

    private final DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Inhalt"}, 0);
    private final JTable jTable = new JTable(tableModel);

    private final MailService mailService;

    public MainFrame(MailService mailService) {
        super("Mail TXT Reader");
        this.mailService = mailService;

        initComponents();
        setupTimers();
        
        // Erstmaliger Check
        performMailCheck();
    }

    private void initComponents() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(jList),
                new JScrollPane(jTable));
        splitPane.setDividerLocation(150);

        add(splitPane, BorderLayout.CENTER);

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void setupTimers() {
        // Alle 2 Minuten prüfen
        new Timer(120000, e -> performMailCheck()).start();
    }

    private void performMailCheck() {
        mailService.checkMails(this::addMailToUI, Throwable::printStackTrace);
    }

    private void addMailToUI(MailMessage mail) {
        SwingUtilities.invokeLater(() -> {
            listModel.addElement(mail.subject());
            tableModel.addRow(new Object[]{mail.textContent()});
            
            JOptionPane.showMessageDialog(this, "Neue Datei eingelesen: " + mail.subject());
        });
    }
}
