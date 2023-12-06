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

/**
 * Services to allow users to view all reservations of a guest
 * Can be implemented for both Guest users and Travel Agent users
 * @author Danielle Boswell
 */
public class AllReservationsViewServices {
    /**
     * used for conversion of dates to proper format
     */
    private final SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    /**
     * holds the reservations of the guest
     */
    private List<Reservation> list; // save list of reservations of guest
    /**
     * for connecting to reservation database
     */
    private final ReservationDatabase reservationDatabase = new ReservationDatabase();
    /**
     * For interacting with reservation database
     */
    private final ReservationDBO reservationDBO = new ReservationDBO(reservationDatabase.getDBConnection());

    /**
     * used to view all uncancelled reservations of a specified guest
     * modifies list to hold the guest's reservations
     * returns the object version to be handled by the controller
     *
     * @param guestID id of guest
     * @return Object[][]
     * @author Danielle Boswell
     */
    public Object[][] viewUncancelledReservations(long guestID){ // convert to id of Guest???
        list = reservationDBO.find("CUSTOMER_ID = " + guestID + " AND IS_CANCELED = 0"); //make sure only uncancelled res



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
     * prepares to view a single chosen reservation by ID
     *
     * @param reservationID id of reservation
     * @return ReservationViewServices
     * @author Danielle Boswell
     */
    public ReservationViewServices viewReservation(long reservationID) { //based on database
        Reservation selectedReservation = reservationDBO.findByReservationId(reservationID);

        return new ReservationViewServices(selectedReservation);
    }

    /**
     * prepares to view a single chosen reservation straight from list
     * returns a service that allows access to view information of
     * a single reservation
     *
     * @param row row of reservation
     * @return ReservationViewServices
     * @author Danielle Boswell
     */
    public ReservationViewServices viewReservation(int row) { //based on list
        Reservation selectedReservation = list.get(row);

        return new ReservationViewServices(selectedReservation);
    }
}
