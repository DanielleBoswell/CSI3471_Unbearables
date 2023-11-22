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
     * Created by Kyle Hoang 11/01/2023
     * This file implements the creation and deletion for the AccountDatabase
     * Methods: save, delete, findById, findAll, find, count
     * NOTE: The database is currently modeled after Assignment 10's
     * The values should be changed to match Users
     */

    private static  String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static  String DB_CONNECTION = "jdbc:derby:ex1connect;create=true"; //"jdbc:derby:ex1connect;";
    private static  String DB_USER = "";
    private static  String DB_PASSWORD = "";

/*    public static void main(String[] argv) {
        try {
            createAccountDatabase();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    /**
     * This function creates a new database table for the accounts
     * @throws SQLException
     */
    public  void createAccountDatabase() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        /**
         * Person details
         * id
         * name
         * age
         * username
         * password
         * email
         * gender
         */

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

    public  void deleteAccountDatabase() {
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
     * This function gets the connection to the database
     */
    public  Connection getDBConnection() {
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