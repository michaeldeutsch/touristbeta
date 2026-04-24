package unit06;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class HotelTableModel extends AbstractTableModel {

    private ArrayList<Hotel> hotels;
    private String [] cols = {"id", "name", "adress","category"};

    HotelTableModel(ArrayList<Hotel> hotels){
        this.hotels = hotels;
    }


    @Override
    public int getRowCount() {
        return hotels.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Hotel h = hotels.get(rowIndex);

        return switch(columnIndex){
            case 0 -> h.getId();
            case 1 -> h.getName();
            case 2 -> h.getAdresse();
            case 3 -> h.getCategory();
            default -> null;
        };
    }

    public Hotel getHotel(int index){
        return hotels.get(index);
    }

    public void refreshRow(int row){
        fireTableRowsUpdated(row,row);
    }
}
