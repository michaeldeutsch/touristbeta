/*
 * Created by JFormDesigner on Wed May 20 08:05:15 CEST 2026
 */

package unit08.designer;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author michael.deutsch
 */
public class f extends JFrame {
    public f() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setValueAt("Neuer Wert", 0, 0); // Ändert Zelle in Zeile 0, Spalte 0
        model.addRow(new Object[]{"Neu 1", "Neu 2", "Neu 3"});
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Michael Deutsch (Katharina Gombotz)
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"g", "g", null},
                    {null, "g", null},

                    {null, null, null},
                },
                new String[] {
                    null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(30, 30, 250, 130);

        {
            // calculate preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Michael Deutsch (Katharina Gombotz)
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
