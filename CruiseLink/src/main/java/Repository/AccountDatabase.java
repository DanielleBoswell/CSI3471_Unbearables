package Repository;

import Domain.Admin;
import Domain.Agent;
import Domain.Guest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDatabase {

/*    private Map<Integer, Guest> guestAccounts;
    private Map<Integer, Agent> agentAccounts;
    private Map<Integer, Admin> adminAccounts;

    public AccountDatabase(){
        guestAccounts = new TreeMap<>();
        agentAccounts = new TreeMap<>();
        adminAccounts = new TreeMap<>();
    }

    public void addGuest(Guest member){
        guestAccounts.put(guestAccounts.size() +1, member);
    }
    public void addAgent(Agent member){
        agentAccounts.put(guestAccounts.size() +1, member);
    }
    public void addAdmin(Admin member){
        adminAccounts.put(guestAccounts.size() +1, member);
    }

    public Map<Integer, Agent> getAgentAccounts() {
        return agentAccounts;
    }

    public Map<Integer, Admin> getAdminAccounts() {
        return adminAccounts;
    }

    public Map<Integer, Guest> getGuestAccounts() {
        return guestAccounts;
    }*/




    // Begin Kyle Hoang's implementation of Apache Derby Account Database
    /**
     * Author: Kyle Hoang
     * Created on: 11/01/2023
     *
     * This class provides methods for creating and deleting a database table for Persons.
     * It also includes a method for obtaining a connection to the database.
     *
     * The reservation table, named "PERSON," stores details such as ID, name, age, username, password,
     * email, and gender.
     *
     * Methods:
     * - {@link #createAccountDatabase() createAccountDatabase}
     * - {@link #deleteAccountDatabase() deleteAccountDatabase}
     */

    private static String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String DB_CONNECTION = "jdbc:derby:ex1connect;create=true"; //"jdbc:derby:ex1connect;create=true";
    private static String DB_USER = "";
    private static String DB_PASSWORD = "";

/*    public static void main(String[] argv) {
        try {
            createAccountDatabase();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    /**
     * @author Kyle Hoang
     *
     * This function creates a new database table PERSON for the Persons
     * @throws SQLException if a SQL exception occurs during the database operations.
     */
    public void createAccountDatabase() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE PERSON(" + "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY" +
                "(START WITH 1, INCREMENT BY 1), " + "NAME VARCHAR(20) NOT NULL, " + "AGE INTEGER NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, " + "PASSWORD VARCHAR(20) NOT NULL, " + "EMAIL VARCHAR(40) NOT NULL, "
                + "GENDER VARCHAR(20) NOT NULL, " + "CONSTRAINT primary_key PRIMARY KEY (ID) " + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(createTableSQL);
            // Execute SQL statement to create the table
            statement.execute(createTableSQL);
            System.out.println("Table \"PERSON\" is created!");
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
     * This function deletes the PERSON table
     */
    public void deleteAccountDatabase() {
        Connection dbConnection = null;
        Statement statement = null;
        String deleteTableSQL = "DROP TABLE PERSON";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(deleteTableSQL);
            // Execute SQL statement to drop the table
            statement.execute(deleteTableSQL);
            System.out.println("Table \"PERSON\" is dropped!");
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
     * @return Connection used to connect to the database
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