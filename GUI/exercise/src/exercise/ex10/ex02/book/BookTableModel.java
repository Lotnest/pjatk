package exercise.ex10.ex02.book;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Map;

public class BookTableModel extends AbstractTableModel {

    private Map<Integer, ArrayList<Object>> map;

    @Override
    public int getRowCount() {
        return Book.values().length;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        return null;
    }
}
