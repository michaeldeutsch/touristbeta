package unit08.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App extends JFrame {

    private final JTable table;

    public App() {
        setTitle("Swing PDF Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        String[] columns = {"ID", "Name", "Ort"};
        Object[][] data = {
                {1, "Anna", "Wien"},
                {2, "Max", "Graz"},
                {3, "Sara", "Linz"},
                {4, "Tom", "Salzburg"}
        };

        table = new JTable(new DefaultTableModel(data, columns));

        JButton button = new JButton("PDF erstellen");
        button.addActionListener(e -> createPdf());

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

    private void createPdf() {
        File file = new File("tabelle.pdf");

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            PDType1Font bold = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);

            try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                float x = 60;
                float y = 750;

                writeText(cs, bold, 18, x, y, "Kundenliste");
                y -= 30;

                String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                writeText(cs, font, 11, x, y, "Datum: " + date);
                y -= 35;

                writeText(cs, bold, 12, x, y, "Eintraege:");
                y -= 25;

                for (int row = 0; row < table.getRowCount(); row++) {
                    String line = table.getValueAt(row, 0) + " - "
                            + table.getValueAt(row, 1) + ", "
                            + table.getValueAt(row, 2);

                    writeText(cs, font, 11, x, y, line);
                    y -= 20;
                }
            }

            doc.save(file);
            JOptionPane.showMessageDialog(this, "PDF erstellt: " + file.getAbsolutePath());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fehler: " + ex.getMessage());
        }
    }

    private void writeText(PDPageContentStream cs, PDType1Font font, int size,
                           float x, float y, String text) throws Exception {
        cs.beginText();
        cs.setFont(font, size);
        cs.newLineAtOffset(x, y);
        cs.showText(text);
        cs.endText();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}
