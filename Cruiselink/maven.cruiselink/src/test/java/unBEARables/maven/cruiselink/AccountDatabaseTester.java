package unBEARables.maven.cruiselink;

import Domain.Person;
import Repository.AccountDatabase;
import Repository.AccountDBO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
//import org.h2.jdbcx.JdbcConnectionPool;

import static org.junit.Assert.*;

public class AccountDatabaseTester {
    private AccountDatabase accountDatabase;
    private AccountDBO accountDBO;
    private Connection testConnection;

    @Before
    public void setUp() {
        // Create a test database connection
        // Initialize the AccountDBO instance with the test connection
        testConnection = createConnection("jdbc:derby:ex1connect;", "", "");
        accountDBO = new AccountDBO(testConnection);
        accountDatabase.main(null);
    }

    @After
    public void tearDown() {
        // Close the test connection and clean up the database
        accountDatabase.deleteAccountDatabase();
        closeConnection(testConnection);
    }

    @Test
    public void testSave() {
        // Test INSERT
        Person person = new Person(null, "John Doe", 25, "Johnnythan", "Passwordius", "johndoe@example.com", "Male");
        accountDBO.save(person);
        assertNotNull("Person should have an ID after save", person.getId());


        // Test UPDATE
        Person updatedPerson = new Person(person.getId(), "Jane Doe", 40, "Janeifer", "Pandora", "janedoe@example.com", "Female");
        accountDBO.save(updatedPerson);
        // Use assertions to check if the update was successful
    }

    @Test
    public void testFindById() {
        Person existingPerson = new Person(null, "Existing Person", 24, "iThink", "iAm", "existing@example.com", "Male");
        accountDBO.save(existingPerson);

        Person retrievedPerson = accountDBO.findById(existingPerson.getId());

        // Check if the retrievedPerson matches existingPerson
        assertNotNull("Existing person should not be null", retrievedPerson);
        assertEquals("Person name should match", existingPerson.getName(), retrievedPerson.getName());
        assertEquals("Person age should match", existingPerson.getAge(), retrievedPerson.getAge());
        assertEquals("Person username should match", existingPerson.getUsername(), retrievedPerson.getUsername());
        assertEquals("Person password should match", existingPerson.getPassword(), retrievedPerson.getPassword());
        assertEquals("Person email should match", existingPerson.getEmail(), retrievedPerson.getEmail());
        assertEquals("Person gender should match", existingPerson.getGender(), retrievedPerson.getGender());

        Person nonExistentPerson = accountDBO.findById(9999L);

        assertNull("Non-existent person should be null", nonExistentPerson);
    }

    @Test
    public void testDelete() {
        Person personToDelete = new Person(null, "To Be Deleted", 74, "boyIamOld", "butStillKicking", "tobedeleted@example.com", "Male");
        accountDBO.save(personToDelete);

        accountDBO.delete(personToDelete.getId());

        assertNull("Deleted person should not exist in the database", accountDBO.findById(personToDelete.getId()));

        // No assertions are needed as it's an expected behavior not to throw an error when trying to delete a non-existent person
        accountDBO.delete(9999L);
    }

    @Test
    public void testFind() {
        Person person1 = new Person(null, "Person 1", 63, "firstPerson", "p3rs0n0fF1rst", "person1@example.com", "Male");
        Person person2 = new Person(null, "Person 2", 34, "secondPerson", "p3rs0n0fS3c0nd", "person2@gmail.com","Female");
        accountDBO.save(person1);
        accountDBO.save(person2);

        // Test only one person matching
        List<Person> personsMatchCondition = accountDBO.find("EMAIL LIKE '%gmail.com'");

        assertEquals("There should be one person matching the condition", 1, personsMatchCondition.size());
        assertTrue("Person 2 should match the condition", personsMatchCondition.contains(person2));

        // Test no persons meet the condition
        List<Person> noMatchingPersons = accountDBO.find("AGE < 30");

        assertTrue("The list should be empty when no persons match the condition", noMatchingPersons.isEmpty());
    }

    @Test
    public void testFindAll() {
        Person person1 = new Person(null, "Person 1", 32, "iLikeBananas", "butHateGreenBeans", "person1@example.com","Male");
        Person person2 = new Person(null, "Person 2", 22, "iCanEatOnions", "butIPreferNotTo", "person2@example.com","Female");
        accountDBO.save(person1);
        accountDBO.save(person2);

        List<Person> persons = accountDBO.findAll();

        assertEquals("There should be two persons in the list", 2, persons.size());
        assertTrue("Person 1 should be in the list", persons.contains(person1));
        assertTrue("Person 2 should be in the list", persons.contains(person2));
    }

    @Test
    public void testFindEmpty() {
        List<Person> emptyList = accountDBO.findAll();

        assertTrue("The list should be empty when no persons exist", emptyList.isEmpty());
    }

    @Test
    public void testCount() {
        Person person1 = new Person(null, "Person 1", 43, "Applesauce", "smashedApples", "person1@example.com", "Male");
        Person person2 = new Person(null, "Person 2", 37, "iEatOranges", "andILoveThem", "person2@example.com", "Female");
        accountDBO.save(person1);
        accountDBO.save(person2);

        int count = accountDBO.count();

        assertEquals("The count should be 2 when there are two persons", 2, count);
    }

    @Test
    public void testCountEmpty() {
        int emptyCount = accountDBO.count();

        assertEquals("The count should be 0 when there are no persons", 0, emptyCount);
    }

    @Test
    public void testUpdate() {
        Person person = new Person(null, "John Doe", 32, "AgainItIsMeJohn", "ItIsMeAgain", "johndoe@example.com", "Male");
        accountDBO.save(person);

        assertNotNull("Person should have an ID after save", person.getId());

        Person retrievedPerson = accountDBO.findById(person.getId());

        // Check if the retrieved person matches the saved person
        assertNotNull("Retrieved person should not be null", retrievedPerson);
        assertEquals("Person name should match", retrievedPerson.getName(), retrievedPerson.getName());
        assertEquals("Person age should match", retrievedPerson.getAge(), retrievedPerson.getAge());
        assertEquals("Person username should match", retrievedPerson.getUsername(), retrievedPerson.getUsername());
        assertEquals("Person password should match", retrievedPerson.getPassword(), retrievedPerson.getPassword());
        assertEquals("Person email should match", retrievedPerson.getEmail(), retrievedPerson.getEmail());
        assertEquals("Person gender should match", retrievedPerson.getGender(), retrievedPerson.getGender());

        Person updatedPerson = new Person(person.getId(), "Jane Doe", 32, "Boo", "AhYouScaredMe!", "janedoe@example.com", "Female");

        accountDBO.save(updatedPerson);

        Person updatedRetrievedPerson = accountDBO.findById(updatedPerson.getId());

        // Check if the update was successful
        assertNotNull("Updated retrieved person should not be null", updatedRetrievedPerson);
        assertEquals("Person name should match", retrievedPerson.getName(), retrievedPerson.getName());
        assertEquals("Person age should match", retrievedPerson.getAge(), retrievedPerson.getAge());
        assertEquals("Person username should match", retrievedPerson.getUsername(), retrievedPerson.getUsername());
        assertEquals("Person password should match", retrievedPerson.getPassword(), retrievedPerson.getPassword());
        assertEquals("Person email should match", retrievedPerson.getEmail(), retrievedPerson.getEmail());
        assertEquals("Person gender should match", retrievedPerson.getGender(), retrievedPerson.getGender());
    }

    // Helper methods to create and close the test database connection
    public static Connection createConnection(String jdbcUrl, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

