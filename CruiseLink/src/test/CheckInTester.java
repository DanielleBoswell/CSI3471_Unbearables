import Domain.Person;
import Domain.Reservation;
import Domain.Room;
import Domain.Room.BedType;
import Domain.Room.QualityLevel;
import InfoExpert.guestInfoExpert;
import Repository.ReservationDBO;
import Repository.ReservationDatabase;
import UI.UINavigator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Date;

public class CheckInTester {
    public static ReservationDatabase rd;

    @BeforeAll
    public void init() {
        rd = new ReservationDatabase();
        try {
            rd.createReservationDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ReservationDBO rDBO = new ReservationDBO(rd.getDBConnection());


        // Sample Bed Types
        BedType kingBed = BedType.KING;
        BedType queenBed = BedType.QUEEN;

        // Sample Quality Levels
        QualityLevel execQuality = QualityLevel.EXECUTIVE;
        QualityLevel comfQuality = QualityLevel.COMFORT;

        // Sample Rooms
        Room room1 = new Room(true, kingBed, 1, execQuality);
        Room room2 = new Room(false, queenBed, 2, comfQuality);

        // Sample Reservations
        Date startDate1 = new Date(); // Replace with your desired start date
        Date endDate1 = new Date();   // Replace with your desired end date
        boolean isCanceled1 = false;
        Long customerId1 = 1L;      // Replace with your desired customer ID
        Long reservationId1 = 1L;

        Reservation reservation1 = new Reservation(startDate1, endDate1, isCanceled1, reservationId1, customerId1, room1);

        Date startDate2 = new Date(); // Replace with your desired start date
        Date endDate2 = new Date();   // Replace with your desired end date
        boolean isCanceled2 = true;
        Long customerId2 = 2L;      // Replace with your desired customer ID
        Long reservationId2 = 2L;

        Reservation reservation2 = new Reservation(startDate2, endDate2, isCanceled2, reservationId2, customerId2, room2);


        Person person1 = new Person(1L, "John Doe", 30, "john_doe", "password123", "john@example.com", "Male");
        Person person2 = new Person(2L, "Jane Smith", 25, "jane_smith", "pass456", "jane@example.com", "Female");
    }

    @Test
    public void testShowCard() {
        guestInfoExpert some = null;
        try{
            some = new guestInfoExpert();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Call launch page
        //Ensuring the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            //Making a new UINavigator to construct the main frame with other GUIs as panels
            //UINavigator uiNavigator =
            new UINavigator();
            //uiNavigator.setVisible(true);
            //UINavigator.showCard(UINavigator.CHECK_IN_PANEL);
        });

        //UINavigator.showCard(UINavigator.CHECK_IN_PANEL);
        some.deleteAccountDatabase();
    }

    @AfterAll
    public void destroy() {
        rd.deleteReservationDatabase();
    }
}
