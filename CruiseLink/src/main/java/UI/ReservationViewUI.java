package UI;

import Controller.ReservationGuestViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI for viewing a single reservation
 * Can be used to lead to cancelling or modifying a reservation
 * @author Danielle Boswell
 */
public class ReservationViewUI extends JPanel{


    /**
     * used to navigate between pages
     */
    private UINavigator uiNavigator;
    /**
     * used to interact with reservation
     */
    private ReservationGuestViewController controller;



    private JPanel roomDescription, reserveOptions;
    private JLabel roomName;
    private JLabel qualityLbl,
            bedTypeLbl,
            bedTotalLbl,
            smokingLbl,
            arrivalDateLbl,
            endDateLbl,
            guestTotalLbl;

    private JButton cancelButton, modifyButton, backButton;

    /**
     * For confirming if the user wants to cancel the reservation
     * @author Danielle Boswell
     */
    private final class CancelReservation implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            confirmCancelDialogueBox(controller.cancelReservationGuest());
        }
    }

    /**
     * For cancelling the reservation
     * @author Danielle Boswell
     */
    private final class ConfirmedCancelReservation implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            isCancelledDialogueBox(controller.confirmCancellationGuest());
        }
    }

    //shows that the room is available

    /**
     * shows pop up to confirm if the guest wants to cancel the reservation
     * @param description description of cancellation
     * @author Danielle Boswell
     */
    public void confirmCancelDialogueBox(String description) {
        int ans = JOptionPane.showConfirmDialog(this, "Confirm Cancellation",
                "Are you sure?", JOptionPane.YES_NO_OPTION);
        if (ans==0){
            System.out.println("CANCELLING RESERVATION");
            isCancelledDialogueBox(controller.confirmCancellationGuest());
        }
    }

    /**
     * pops up dialog displaying that reservation is cancelled or not
     * @param ok ok for no fee
     * @author Danielle Boswell
     */
    public void isCancelledDialogueBox(boolean ok) {
                if(ok) {
                    JOptionPane.showMessageDialog(this, "Your Reservation has now been cancelled!",
                            "Reservation Cancelled", JOptionPane.WARNING_MESSAGE);
                    UINavigator.addCard(new ViewReservationsGUI(uiNavigator),UINavigator.VIEW_GUEST_RESERVATIONS);
                    UINavigator.showCard(UINavigator.VIEW_GUEST_RESERVATIONS);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Your Reservation cannot be cancelled! Try again another time",
                            "Reservation Cannot be Cancelled", JOptionPane.WARNING_MESSAGE);
                }
    }

    //makes the GUI for the frame
    /**
     * constructor to create the UI
     *
     * @param uiNavigator uiNavigator
     * @param rGVC reservation guest controller
     * @author Danielle Boswell
     */
    public ReservationViewUI(UINavigator uiNavigator, ReservationGuestViewController rGVC){
        super();

        this.uiNavigator = uiNavigator;
        this.controller = rGVC;

        roomDescription = new JPanel();
        reserveOptions = new JPanel();
        roomName = new JLabel(controller.getQualityLevel() + " Level");
        roomName.setFont(DefaultUI.getTitleFont());
        qualityLbl = new JLabel("Quality: " + controller.getQualityLevel());
        bedTypeLbl = new JLabel("bedType: " + controller.getBedType());
        bedTotalLbl = new JLabel("Bed Total: " + controller.getNumBeds());
        smokingLbl = new JLabel("Smoking: " + controller.getNoSmoking());

        arrivalDateLbl = new JLabel("Start Date: " + controller.getStartDate());
        endDateLbl= new JLabel("End Date: " + controller.getEndDate());
//        guestTotalLbl = new JLabel("Total Guests: " + controller.get);
        cancelButton = new JButton("Cancel Reservation");
        modifyButton = new JButton("Modify Reservation"); // takes to Make Reservation
        cancelButton.addActionListener(new ReservationViewUI.CancelReservation());
        backButton = new JButton("Go Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UINavigator.showCard(UINavigator.VIEW_GUEST_RESERVATIONS);

            }
        });
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);



        //}
        //}
        //catch() {

        //}
        //Layout the components using GridBagConstraints
        setLayout(new GridBagLayout());
        roomDescription.setLayout(new GridBagLayout());
        reserveOptions.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 5, 15, 5); //Padding for the components (buttons, labels, etc)

        //Adding labels and buttons to the frame, using y axis on grid
        constraints.gridy = 0; //0 starts at the top, etc
        roomDescription.add(roomName, constraints);

        ++constraints.gridy;
        roomDescription.add(qualityLbl, constraints);

        ++constraints.gridy;
        roomDescription.add(bedTypeLbl, constraints);

        ++constraints.gridy;
        roomDescription.add(bedTotalLbl, constraints);

        ++constraints.gridy;
        roomDescription.add(smokingLbl, constraints);

        constraints.gridy = 0;
        reserveOptions.add(arrivalDateLbl, constraints);

        ++constraints.gridy;
        reserveOptions.add(endDateLbl, constraints);

        ++constraints.gridy;
        reserveOptions.add(cancelButton, constraints);
        ++constraints.gridy;
        reserveOptions.add(modifyButton,constraints);

        add(roomDescription);
        add(reserveOptions);
        add(backButton);

        //Instead of pack, directly set the frame to be visible
        setVisible(true);
    }



}
