package UI;

import Domain.Guest;

import javax.swing.table.AbstractTableModel;
import java.sql.*;


class RoomTableModel extends AbstractTableModel {

    static Boolean DEBUG = false;

    public String[] columnNames = {"Quality Level",
            "Bed Type",
            "Number of Beds",
            "isSmoking"};

    //create function
    public Object[][] data = {
            {"Executive", "Twin", "2", "True"},
            {"Comfort", "Full", "2", "False"},
            {"Economy", "Queen", "1", "True"},
            {"Comfort", "Queen", "3", "False"},
            {"Economy", "King", "1", "True"}
    };
    Object[][] fillTable(Object[][] table) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con = DriverManager.getConnection("jdbc:derby:ex1connect;");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Room");

            if(rs.next()){
                Guest tmp = new Guest();

//                tmp.setId((long)id);
//                tmp.setName(rs.getString("NAME"));
//                tmp.setEmail(rs.getString("EMAIL"));
//                tmp.setAge(rs.getInt("AGE"));
//                tmp.setGender(rs.getString("GENDER"));
//                tmp.setSalary(rs.getLong("SALARY"));


            }

            return table;

        } catch (SQLException se) {
            throw new RuntimeException(se);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

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

