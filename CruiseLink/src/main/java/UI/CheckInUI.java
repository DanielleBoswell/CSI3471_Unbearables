package UI;

import Controller.CheckInController;
import Controller.CheckInControllerImpl;
import Domain.Reservation;
import Domain.Room;
import Repository.ReservationDBO;
import Repository.ReservationDatabase;
import Repository.RoomDBO;
import Repository.RoomDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.util.List;

public class CheckInUI extends JPanel {
    // Constant for setting the text box width
    public static final int TEXT_BOX_WIDTH = 25;

    // Labels
    //private Label cruiseLinkLabel;
    private Label firstNameLabel;
    private Label lastNameLabel;

    // Table of Reservations
    private JTable reservationTable;


    // Making a CheckIn controller impl object
    private CheckInControllerImpl checkInController;

    // Sets the controller
    public void setController (CheckInControllerImpl checkInController) { this.checkInController = checkInController; }

    // Making a UINavigator instance for check in
    private UINavigator uiNavigator;

    // Constructor accepting UINavigator instance - Need this for switching panels
    public CheckInUI (UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    // This method creates the check in UI which will return the panel
    public JPanel createCheckInUIPanel() {
        // Setting layout to GridBagLayout
        this.setLayout(new GridBagLayout());

        // Set up reservationTable
        //reservationTable = new DefaultTableModel();

        // reference: https://www.youtube.com/watch?v=frafcK6fhdQ
        ReservationDatabase resDB = new ReservationDatabase();
        ReservationDBO resDBO = new ReservationDBO(resDB.getDBConnection());
        List<Reservation> resList = resDBO.findAll();

        String[] colNames = {"START_DATE", "END_DATE", "IS_CANCELED", "ROOM_NUMBER", "IS_SMOKING", "BED_TYPE",
                "NUM_BEDS", "QUALITY_LVL"};

        String tblData[][] = new String[resDBO.count()][8];
        int i = 0;
        for (Reservation res : resList) {
            String row[] = res.toStringArray();
            tblData[i] = row;
            ++i;
        }

        reservationTable = new JTable(tblData, colNames);

        this.add(reservationTable);
        reservationTable.setVisible(true);

        // Returning the JPanel
        return this;
    }
}
