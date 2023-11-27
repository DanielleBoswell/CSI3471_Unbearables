package Repository;

import Domain.Person;
import Domain.Reservation;
import Domain.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyle Hoang 11/27/2023
 * This file implements the operations for the RoomDatabase
 * Methods: save, delete, findById, findAll, find, count
 * NOTE: The database is currently modeled after Assignment 10's
 * The values should be changed to match Users
 */

public class RoomDBO {
    private Connection dbConnection;

    public RoomDBO(Connection connection) {
        this.dbConnection = connection;
    }

    /**
     * This function inserts or updates a Person on ReservationDatabase
     * @param room
     */
    public void save(Room room) {
        PreparedStatement preparedStatement = null;
        String saveSQL;

        try {
            if (room.getObjRoomNumber() != null) {
                // Update an existing person
                saveSQL = "UPDATE ROOM SET IS_SMOKING = ?, BED_TYPE = ?," +
                        " NUM_BEDS = ?, IS_RESERVED = ?, QUALITY_LVL = ?, WHERE ROOM_NUM = ?";
                preparedStatement = dbConnection.prepareStatement(saveSQL);
                preparedStatement.setBoolean(1, room.isSmoking());
                preparedStatement.setString(2, room.getBedType().toString());
                preparedStatement.setInt(3, room.getNumBeds());
                preparedStatement.setBoolean(4, room.getIsReserved());
                preparedStatement.setString(5, room.getQualityLevel().toString());
            } else {
                // Insert a new person
                saveSQL = "INSERT INTO ROOM (ROOM_NUM, IS_SMOKING, BED_TYPE, NUM_BEDS," +
                        " IS_RESERVED, QUALITY_LVL) VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement = dbConnection.prepareStatement(saveSQL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, room.getRoomNumber());
                preparedStatement.setBoolean(2, room.isSmoking());
                preparedStatement.setString(3, room.getBedType().toString());
                preparedStatement.setInt(4, room.getNumBeds());
                preparedStatement.setBoolean(5, room.getIsReserved());
                preparedStatement.setString(6, room.getQualityLevel().toString());
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

            System.out.println("Room saved successfully.");
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
     * This function deletes a person from the ReservationDatabase
     * @param roomNum
     */
    public void delete(Integer roomNum) {
        PreparedStatement preparedStatement = null;

        try {
            String deleteSQL = "DELETE FROM ROOM WHERE ROOM_NUM = ?";
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, roomNum);
            preparedStatement.executeUpdate();
            System.out.println("ROOM with ROOM_NUM " + roomNum + " has been deleted.");
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
     * This function searches the ReservationDatabase for a Person that matches id
     * @param roomNum
     * @return
     */
    public Room findById(Integer roomNum) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String findByIdSQL = "SELECT * FROM ROOM WHERE ROOM_NUM = ?";
            preparedStatement = dbConnection.prepareStatement(findByIdSQL);
            preparedStatement.setLong(1, roomNum);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Room room = new Room(
                    resultSet.getBoolean("IS_SMOKING"),
                    Room.BedType.valueOf(resultSet.getString("BED_TYPE")),
                    resultSet.getInt("ROOM_NUM"),
                    resultSet.getInt("NUM_BEDS"),
                    resultSet.getBoolean("IS_RESERVED"),
                    Room.QualityLevel.valueOf(resultSet.getString("QUALITY_LVL"))
                );

                return room;
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
     * This function returns a list of every Person in the ReservationDatabase
     * @return
     */
    public List<Room> findAll() {
        List<Room> roomList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            String findAllSQL = "SELECT * FROM ROOM";
            resultSet = statement.executeQuery(findAllSQL);

            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getBoolean("IS_SMOKING"),
                        Room.BedType.valueOf(resultSet.getString("BED_TYPE")),
                        resultSet.getInt("ROOM_NUM"),
                        resultSet.getInt("NUM_BEDS"),
                        resultSet.getBoolean("IS_RESERVED"),
                        Room.QualityLevel.valueOf(resultSet.getString("QUALITY_LVL"))
                );

                roomList.add(room);
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

        return roomList;
    }


    /**
     * This function returns a list of people who match the given condition
     * condition should be in format of "TABLEFIELD = value"
     * @param condition
     * @return
     */
    public List<Room> find(String condition) {
        List<Room> roomList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            String findSQL = "SELECT * FROM ROOM WHERE " + condition;
            resultSet = statement.executeQuery(findSQL);

            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getBoolean("IS_SMOKING"),
                        Room.BedType.valueOf(resultSet.getString("BED_TYPE")),
                        resultSet.getInt("ROOM_NUM"),
                        resultSet.getInt("NUM_BEDS"),
                        resultSet.getBoolean("IS_RESERVED"),
                        Room.QualityLevel.valueOf(resultSet.getString("QUALITY_LVL"))
                );

                roomList.add(room);
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

        return roomList;
    }

    public int count() {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            String countSQL = "SELECT COUNT(*) AS COUNT FROM ROOM";
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