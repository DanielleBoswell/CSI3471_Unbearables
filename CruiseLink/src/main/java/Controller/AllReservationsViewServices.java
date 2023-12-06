package Controller;

import Domain.Reservation;
import Domain.Room;
import Repository.ReservationDBO;
import Repository.ReservationDatabase;
import Repository.ShipDatabase;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

public class AllReservationsViewServices {
    private final SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    private List<Reservation> list; // save list of reservations of guest
    private final ReservationDatabase reservationDatabase = new ReservationDatabase();
    private final ReservationDBO reservationDBO = new ReservationDBO(reservationDatabase.getDBConnection());

    /**
     *
     * @param guestID
     * @return Object[][]
     */
    public Object[][] viewUncancelledReservations(long guestID){ // convert to id of Guest???
        //reservationDBO.save(new Reservation(new Date(2023,12,31), new Date(2024,1,14), false, 123L, 1L, new Room()));
        //list = reservationDBO.find("CUSTOMER_ID = " + guestID + " AND IS_CANCELED = 0"); //make sure only uncancelled res
        list = List.of(new Reservation[]{new Reservation(new Date(2023,12,31), new Date(2024,1,14), false, 123L, 1L, new Room()),
                new Reservation(new Date(2024,1,14), new Date(2024,12,28), false, 334L, 1L, new Room())});



        Object[][] reservations = new Object[20][];//connect to list
        Vector<Object[]> a = new Vector<>();
        for(Reservation r : list){
            a.add(new Object[]{r.getReservationId(), r.getShipName(),r.getRoom().getQualityLevel().name(),
                    sdf.format(r.getStartDate()), sdf.format(r.getEndDate())});
        }

        a.copyInto(reservations);
        return reservations;
    }

    /**
     *
     * @param reservationID
     * @return ReservationViewServices
     */
    public ReservationViewServices viewReservation(long reservationID) { //based on database
        Reservation selectedReservation = reservationDBO.findByReservationId(reservationID);
//        Object[] reservation = {selectedReservation.getReservationId(),
//                selectedReservation.getShipName(),
//                sdf.format(selectedReservation.getStartDate()),
//                sdf.format(selectedReservation.getEndDate())};

        return new ReservationViewServices(selectedReservation);
    }

    /**
     *
     * @param row
     * @return ReservationViewServices
     */
    public ReservationViewServices viewReservation(int row) { //based on list
        Reservation selectedReservation = list.get(row);

        return new ReservationViewServices(selectedReservation);
    }
}
