package Repository;

import Domain.Guest;
import Domain.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReservationDatabase {
    public Map<Guest, ArrayList<Reservation>> reservationMap;

    public ReservationDatabase(){
        reservationMap = new HashMap<>();
    }

    // Begin Kyle Hoang's implementation of Apache Derby Reservation Database
    /**
     * Author: Kyle Hoang
     * Created on: 11/01/2023
     *
     * This class provides methods for creating and deleting a database table for reservations.
     * It also includes a method for obtaining a connection to the database.
     *
     * The reservation table, named "RESERVATION," stores details such as customer ID, start date, end date,
     * smoking status, bed type, number of beds, quality level, and cancellation status.
     *
     * Methods:
     * - {@link #createReservationDatabase() createReservationDatabase}
     * - {@link #deleteReservationDatabase() deleteReservationDatabase}
     */

    private static  String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static  String DB_CONNECTION = "jdbc:derby:ex1connect;create=true"; //"jdbc:derby:ex1connect;";
    private static  String DB_USER = "";
    private static  String DB_PASSWORD = "";

/*    public static void main(String[] argv) {
    try {
        createReservationDatabase();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}*/

    /**
     * @author Kyle Hoang
     *
     * This function creates a new database table RESERVATION for the Reservation
     * @throws SQLException if a SQL exception occurs during the database operations.
     */
    public  void createReservationDatabase() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE RESERVATION(" + "RESERVATION_ID INTEGER NOT NULL VARCHAR(20), "
                + "CUSTOMER_ID INTEGER NOT NULL VARCHAR(20), " +
                "START_DATE DATE NOT NULL, " + "END_DATE DATE NOT NULL, " + "IS_SMOKING SMALLINT NOT NULL, " +
                "BED_TYPE VARCHAR(20) NOT NULL, " + "NUM_BEDS INTEGER NOT NULL, " +
                "QUALITY_LVL VARCHAR(20) NOT NULL, " + "CHECK_IN_STATUS VARCHAR(20) NOT NULL, "
                + "IS_CANCELED SMALLINT NOT NULL, "
                + "CONSTRAINT primary_key PRIMARY KEY (RESERVATION_ID) " + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(createTableSQL);
            // Execute SQL statement to create the table
            statement.execute(createTableSQL);
            System.out.println("Table \"RESERVATION\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    /**
     * @author Kyle Hoang
     * This method deletes the RESERVATION database
     */
    public void deleteReservationDatabase() {
        Connection dbConnection = null;
        Statement statement = null;
        String deleteTableSQL = "DROP TABLE RESERVATION";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(deleteTableSQL);
            // Execute SQL statement to drop the table
            statement.execute(deleteTableSQL);
            System.out.println("Table \"RESERVATION\" is dropped!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }

            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }

    /**
     * @author Kyle Hoang
     * This function gets the connection to the database
     * @return Connection used to connect to RESERVATION database
     */
    public Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
