package Repository;

import Domain.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyle Hoang 11/01/2023
 * This file implements the operations for the AccountDatabase
 * Methods: save, delete, findById, findAll, find, count
 * NOTE: The database is currently modeled after Assignment 10's
 * The values should be changed to match Users
 */

public class AccountDBO {
    private Connection dbConnection;

    public AccountDBO(Connection connection) {
        this.dbConnection = connection;
    }

    /**
     * @author Kyle Hoang
     * This function inserts or updates a Person on PersonDatabase
     * @param person
     */
    public void save(Person person) {
        PreparedStatement preparedStatement = null;
        String saveSQL;

        try {
            if (person.getId() != null) {
                // Update an existing person
                saveSQL = "UPDATE Person SET NAME = ?, AGE = ?, USERNAME = ?, PASSWORD = ?, EMAIL = ?, GENDER = ? WHERE ID = ?";
                preparedStatement = dbConnection.prepareStatement(saveSQL);
                preparedStatement.setString(1, person.getName());
                preparedStatement.setInt(2, person.getAge());
                preparedStatement.setString(3, person.getUsername());
                preparedStatement.setString(4, person.getPassword());
                preparedStatement.setString(5, person.getEmail());
                preparedStatement.setString(6, person.getGender());
            } else {
                // Insert a new person
                saveSQL = "INSERT INTO Person (NAME, AGE, USERNAME, PASSWORD, EMAIL, GENDER) VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement = dbConnection.prepareStatement(saveSQL, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, person.getName());
                preparedStatement.setInt(2, person.getAge());
                preparedStatement.setString(3, person.getUsername());
                preparedStatement.setString(4, person.getPassword());
                preparedStatement.setString(5, person.getEmail());
                preparedStatement.setString(6, person.getGender());
            }

            preparedStatement.executeUpdate();

            if (person.getId() == null) {
                // If it was an INSERT, retrieve the generated ID
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    person.setId(generatedKeys.getLong(1));
                }
            }

            System.out.println("Person saved successfully.");
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
     * This function deletes a person from the PersonDatabase
     * @param id
     */
    public void delete(Long id) {
        PreparedStatement preparedStatement = null;

        try {
            String deleteSQL = "DELETE FROM Person WHERE ID = ?";
            preparedStatement = dbConnection.prepareStatement(deleteSQL);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Person with ID " + id + " has been deleted.");
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
     * This function searches the PersonDatabase for a Person that matches id
     * @param id
     * @return Person found
     */
    public Person findById(Long id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String findByIdSQL = "SELECT * FROM Person WHERE ID = ?";
            preparedStatement = dbConnection.prepareStatement(findByIdSQL);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Person person = new Person(
                        resultSet.getLong("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getInt("AGE"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("GENDER")
                );

                return person;
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
     * This function returns a list of every Person in the AccountDatabase
     * @return List of Persons in the PERSON database
     */
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            String findAllSQL = "SELECT * FROM Person";
            resultSet = statement.executeQuery(findAllSQL);

            while (resultSet.next()) {
                Person person = new Person(
                        resultSet.getLong("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getInt("AGE"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("GENDER")
                );
                persons.add(person);
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

        return persons;
    }


    /**
     * @author Kyle Hoang
     * This function returns a list of people who match the given condition
     * which should be in format of "TABLEFIELD <operator> value"
     * @param condition
     * @return List of Persons found using the condition
     */
    public List<Person> find(String condition) {
        List<Person> persons = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            String findSQL = "SELECT * FROM Person WHERE " + condition;
            resultSet = statement.executeQuery(findSQL);

            while (resultSet.next()) {
                Person person = new Person(
                        resultSet.getLong("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getInt("AGE"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("GENDER")
                );
                persons.add(person);
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

        return persons;
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
            String countSQL = "SELECT COUNT(*) AS COUNT FROM Person";
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