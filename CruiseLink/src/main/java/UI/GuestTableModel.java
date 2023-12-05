package UI;

import javax.swing.table.AbstractTableModel;
import java.sql.*;


class GuestTableModel extends AbstractTableModel {
    static Boolean DEBUG = false;
    public String[] columnNames = {"User ID", "Username", "Email", "Gender", "Age"};


    Object[][] fillTable() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con = DriverManager.getConnection("jdbc:derby:ex1connect;");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PERSON");

            int count = 0;
            Object[][] table = new Object[rs.getFetchSize()][5];
            if(rs.next()){

                String userID = rs.getString("NAME");

                String username = rs.getString("USERNAME");

                String email = rs.getString("EMAIL");

                String gender = rs.getString("GENDER");

                String age = rs.getString("AGE");



                table[count][0] = userID;
                table[count][1] = username;
                table[count][2] = email;
                table[count][3] = gender;
                table[count][4] = age;

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

