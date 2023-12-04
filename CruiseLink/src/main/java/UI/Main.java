package UI;

import javax.swing.*;

import Domain.Person;
import Domain.Reservation;
import Domain.Room;
import InfoExpert.guestInfoExpert;
import Repository.ReservationDBO;
import Repository.ReservationDatabase;
import Repository.RoomDBO;
import Repository.RoomDatabase;

import java.sql.Date;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        ReservationDatabase rd = new ReservationDatabase();
        RoomDatabase roomDatabase = new RoomDatabase();
        //rd.deleteReservationDatabase();
        try {
            roomDatabase.createRoomDatabase();
            rd.createReservationDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ReservationDBO rDBO = new ReservationDBO(rd.getDBConnection());
        RoomDBO roomDBO = new RoomDBO(roomDatabase.getDBConnection());


        // Sample Bed Types
        Room.BedType kingBed = Room.BedType.KING;
        Room.BedType queenBed = Room.BedType.QUEEN;

        // Sample Quality Levels
        Room.QualityLevel execQuality = Room.QualityLevel.EXECUTIVE;
        Room.QualityLevel comfQuality = Room.QualityLevel.COMFORT;

        // Sample Rooms
        Room room1 = new Room(true, kingBed, 1, 1, execQuality);
        Room room2 = new Room(false, queenBed, 2, 2, comfQuality);

        // Sample Reservations
        Date startDate1 = new Date(11,29,2023); // Replace with your desired start date
        Date endDate1 = new Date(12,3,2023);   // Replace with your desired end date
        boolean isCanceled1 = false;
        Long customerId1 = 1L;      // Replace with your desired customer ID

        Reservation reservation1 = new Reservation(startDate1, endDate1, isCanceled1, room1);
        reservation1.setCustomerId(1L);
        reservation1.setReservationId(1L);
        reservation1.setShip("Cruise1");

        Date startDate2 = new Date(3,7,2024); // Replace with your desired start date
        Date endDate2 = new Date(3,15,2024);   // Replace with your desired end date
        boolean isCanceled2 = true;
        Long customerId2 = 2L;      // Replace with your desired customer ID

        Reservation reservation2 = new Reservation(startDate2, endDate2, isCanceled2, room2);
        reservation2.setCustomerId(2L);
        reservation2.setReservationId(2L);
        reservation2.setShip("Cruise2");

        Person person1 = new Person(1L, "John Doe", 30, "john_doe", "password123", "john@example.com", "Male");
        Person person2 = new Person(2L, "Jane Smith", 25, "jane_smith", "pass456", "jane@example.com", "Female");

        rDBO.save(reservation1);
        rDBO.save(reservation2);












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
            new UINavigator();
        });

        //some.deleteAccountDatabase();







        //rd.deleteReservationDatabase();
    }
}
