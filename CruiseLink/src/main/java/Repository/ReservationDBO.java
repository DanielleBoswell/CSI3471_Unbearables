package Repository;

import Domain.Reservation;
import Domain.Reservation;
import Domain.Room;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Kyle Hoang
 * Created on: 11/01/2023
 *
 * This class implements operations for the RESERVATION database.
 * It uses a Connection to interact with the database.
 *
 * Methods: save, delete, findById, getAllReservations, findAll, find, count
 */

public class ReservationDBO {
    private Connection dbConnection;

    public ReservationDBO(Connection connection) {
        this.dbConnection = connection;
    }

    /**
     * @author Kyle Hoang
     * This function inserts or updates a Reservation on RESERVATION database
     * @param res
     */
    public void save(Reservation res) {
        PreparedStatement preparedStatement = null;
        String saveSQL;

        try {
            if (res.getCustomerId() != null) { //FIX ME: HOW DO?
                // Update an existing person
                saveSQL = "UPDATE RESERVATION SET START_DATE = ?, END_DATE = ?, IS_SMOKING = ?, BED_TYPE = ?," +
                        " NUM_BEDS = ?, IS_CANCELED = ?, QUALITY_LVL = ?, WHERE CUSTOMER_ID = ?";
                preparedStatement = dbConnection.prepareStatement(saveSQL);
                preparedStatement.setDate(1, (Date) res.getStartDate());
                preparedStatement.setDate(2, (Date) res.getEndDate());
                preparedStatement.setBoolean(3, res.getRoom().isSmoking());
                preparedStatement.setString(4, res.getRoom().getBedType().toString());
                preparedStatement.setInt(5, res.getRoom().getNumBeds());
                preparedStatement.setBoolean(6, res.isCanceled());
                preparedStatement.setString(7, res.getRoom().getQualityLevel().toString());
            } else {
                // Insert a new person
                saveSQL = "INSERT INTO RESERVATION (CUSTOMER_ID, START_DATE, END_DATE, IS_SMOKING, BED_TYPE, NUM_BEDS," +
                        " IS_CANCELED, QUALITY_LVL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = dbConnection.prepareStatement(saveSQL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, res.getCustomerId()); //FIX ME: HOW DO?
                preparedStatement.setDate(2, (Date) res.getStartDate());
                preparedStatement.setDate(3, (Date) res.getEndDate());
                preparedStatement.setBoolean(4, res.getRoom().isSmoking());
                preparedStatement.setString(5, res.getRoom().getBedType().toString());
                preparedStatement.setInt(6, res.getRoom().getNumBeds());
                preparedStatement.setBoolean(7, res.isCanceled());
                preparedStatement.setString(8, res.getRoom().getQualityLevel().toString());
            }

            preparedStatement.executeUpdate();

            // DONT NEED TO DO IF WE ARE ADDING A customerId field to reservation
//            if (res.getCustomerId() == -1) {
//                // If it was an INSERT, retrieve the generated ID
//                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    res.setCustomerId(generatedKeys.getLong(1));
//                }
//            }

            System.out.println("Reservation saved successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }
        }
    }

    /**
     * @author Kyle Hoang
     * This function deletes a person from the RESERVATION database
     * @param id
     */
    public void delete(Long id) {
        PreparedStatement preparedStatement = null;

        try {
            String deleteSQL = "DELETE FROM RESERVATION WHERE CUSTOMER_ID = ?";
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("RESERVATION with CUSTOMER_ID " + id + " has been deleted.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }
        }
    }

    /**
     * @author Kyle Hoang
     * This function searches the RESERVATION database for a Reservation that matches id
     * @param id
     * @return Reservation found by id
     */
    public Reservation findById(Long id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String findByIdSQL = "SELECT * FROM RESERVATION WHERE ID = ?";
            preparedStatement = dbConnection.prepareStatement(findByIdSQL);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Reservation res = new Reservation(
                        resultSet.getDate("START_DATE"),
                        resultSet.getDate("END_DATE"),
                        resultSet.getBoolean("IS_CANCELED"),
                        resultSet.getLong("CUSTOMER_ID"),
                        new Room(
                                resultSet.getBoolean("IS_SMOKING"),
                                Room.BedType.valueOf(resultSet.getString("BED_TYPE")),
                                resultSet.getInt("NUM_BEDS"),
                                Room.QualityLevel.valueOf(resultSet.getString("QUALITY_LVL"))
                                )
                );

                return res;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing result set or statement: " + e.getMessage());
            }
        }

        return null; // Return null if no person with the given ID is found
    }

    /**
     * @author Kyle Hoang
     * This function returns the result set of the database that contains every reservation
     * @return ResultSet, the group of Reservations found from RESERVATION database
     */
    public ResultSet getAllReservations() {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            String findAllSQL = "SELECT * FROM RESERVATION";
            resultSet = statement.executeQuery(findAllSQL);
        } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resultSet or statement in findAll: " + e.getMessage());
            }
        }

        return resultSet;
    }
    
    
    /**
     * @author Kyle Hoang
     * This function returns a list of every Reservation in the RESERVATION database
     * @return List of Reservations in RESERVATION database
     */
    public List<Reservation> findAll() {
        List<Reservation> resList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            String findAllSQL = "SELECT * FROM RESERVATION";
            resultSet = statement.executeQuery(findAllSQL);

            while (resultSet.next()) {
                Reservation res = new Reservation(
                        resultSet.getDate("START_DATE"),
                        resultSet.getDate("END_DATE"),
                        resultSet.getBoolean("IS_CANCELED"),
                        resultSet.getLong("CUSTOMER_ID"),
                        new Room(
                                resultSet.getBoolean("IS_SMOKING"),
                                Room.BedType.valueOf(resultSet.getString("BED_TYPE")),
                                resultSet.getInt("NUM_BEDS"),
                                Room.QualityLevel.valueOf(resultSet.getString("QUALITY_LVL"))
                        )
                );
                resList.add(res);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resultSet or statement in findAll: " + e.getMessage());
            }
        }

        return resList;
    }


    /**
     * @author Kyle Hoang
     * This function returns a list of people who match the given condition
     * which should be in format of "TABLEFIELD = value"
     * @param condition
     * @return
     */
    public List<Reservation> find(String condition) {
        List<Reservation> resList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            String findSQL = "SELECT * FROM RESERVATION WHERE " + condition;
            resultSet = statement.executeQuery(findSQL);

            while (resultSet.next()) {
                Reservation res = new Reservation(
                        resultSet.getDate("START_DATE"),
                        resultSet.getDate("END_DATE"),
                        resultSet.getBoolean("IS_CANCELED"),
                        resultSet.getLong("CUSTOMER_ID"),
                        new Room(
                                resultSet.getBoolean("IS_SMOKING"),
                                Room.BedType.valueOf(resultSet.getString("BED_TYPE")),
                                resultSet.getInt("NUM_BEDS"),
                                Room.QualityLevel.valueOf(resultSet.getString("QUALITY_LVL"))
                        )
                );
                resList.add(res);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resultSet or statement in find: " + e.getMessage());
            }
        }

        return resList;
    }

    /**
     * @author Kyle Hoang
     * This method counts the number of Persons in PERSON database
     * @return int which is number of Persons in PERSON database
     */
    public int count() {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            String countSQL = "SELECT COUNT(*) AS COUNT FROM RESERVATION";
            resultSet = statement.executeQuery(countSQL);

            if (resultSet.next()) {
                return resultSet.getInt("COUNT");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resultSet or statement in count: " + e.getMessage());
            }
        }

        return 0; // Return 0 if no count is available
    }
}