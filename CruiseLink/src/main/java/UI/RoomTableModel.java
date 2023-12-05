package UI;

import Domain.Guest;
import Domain.Person;
import Domain.Room;

import javax.swing.table.AbstractTableModel;
import java.sql.*;


class RoomTableModel extends AbstractTableModel {

    static Boolean DEBUG = false;

    public String[] columnNames = {"Room Number",
            "isSmoking",
            "Bed Type",
            "Number of Beds",
            "Quality Level"};

    //create function
    Object[][] fillTable() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con = DriverManager.getConnection("jdbc:derby:ex1connect;");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery("SELECT * FROM ROOM WHERE IS_RESERVED = 0");

            rs.last();
            Object[][] table = new Object[rs.getRow()][5];
            rs.beforeFirst();
            int count = 0;
            while(rs.next()){

                String roomNum = rs.getString("ROOM_NUM");

                String isSmoking = rs.getString("IS_SMOKING");

                String bedType = rs.getString("BED_TYPE");

                String numBeds = rs.getString("NUM_BEDS");

                String qualityLevel = rs.getString("QUALITY_LVL");



                table[count][0] = roomNum;
                if(isSmoking.equals(0)){
                    table[count][1] = "False";
                }else{
                    table[count][1] = "True";
                }
                table[count][2] = bedType;
                table[count][3] = numBeds;
                table[count][4] = qualityLevel;
                count++;
            }

            return table;

        } catch (SQLException se) {
            throw new RuntimeException(se);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Object[][] data = fillTable();

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

