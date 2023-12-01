package UI;

import javax.swing.table.AbstractTableModel;


class RoomTableModel extends AbstractTableModel {
    static Boolean DEBUG = false;
    public String[] columnNames = {"Quality Level",
            "Bed Type",
            "Number of Beds",
            "isSmoking"};

    public Object[][] data = {
            {"Executive", "Twin", "2", "True"},
            {"Comfort", "Full", "2", "False"},
            {"Economy", "Queen", "1", "True"},
            {"Comfort", "Queen", "3", "False"},
            {"Economy", "King", "1", "True"}
    };

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }


}

