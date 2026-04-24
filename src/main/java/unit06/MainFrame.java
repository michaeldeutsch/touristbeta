package unit06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainFrame  extends JFrame {

    MainFrame(){
        super("Main Frame");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable table = new JTable();
        table.setDefaultEditor(Object.class, null);
       // DefaultTableModel model = new DefaultTableModel();

        ArrayList<Hotel> allHotels = new ArrayList<>();
        allHotels.add(new Hotel(1,"Sacher","Vienna","***"));
        allHotels.add(new Hotel(2,"H2","Vienna","***"));
        allHotels.add(new Hotel(3,"Schönbrunn","Vienna","***"));

        HotelTableModel model = new HotelTableModel(allHotels);
        table.setModel(model);

        /*
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");
        for (int i = 0; i < 10; i++) {
            model.addRow(new Object[]{"Hans", 11, "Male"});
        }
*/

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(e.getClickCount() == 2){
                   //JOptionPane.showMessageDialog(MainFrame.this, "double click");
                  /*  int index = table.getSelectedRow();
                    String name = table.getValueAt(index, 0).toString();
                    String age = table.getValueAt(index, 1).toString();
                    String gender = table.getValueAt(index, 2).toString();
                    System.out.println(name + " " + age + " " + gender);
                          */

                    int row = table.getSelectedRow();

                    if(row >= 0){
                        Hotel temp = model.getHotel(row);
                        //new EditingWindow(name,age,gender).setVisible(true); // legacy approach
                        new EditingWindow(MainFrame.this, temp, () -> model.refreshRow(row)).setVisible(true);
                    }


                }
            }
        });
      

        add(new JScrollPane(table));

    }
}
