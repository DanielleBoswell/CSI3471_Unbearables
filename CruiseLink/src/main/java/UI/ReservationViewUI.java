package UI;

import Controller.ReservationGuestViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationViewUI extends JPanel{


    private UINavigator uiNavigator;
    private ReservationGuestViewController controller;

    /**
     * constructor
     * @param uiNavigator
     * @param rGVC
     */
    public ReservationViewUI(UINavigator uiNavigator, ReservationGuestViewController rGVC){
        this.uiNavigator = uiNavigator;
        this.controller = rGVC;
    }

    private JPanel roomDescription, reserveOptions;
    private JLabel roomName;
    private JLabel qualityLbl,
            bedTypeLbl,
            bedTotalLbl,
            smokingLbl,
            arrivalDateLbl,
            endDateLbl,
            guestTotalLbl;

    private JButton cancelButton, modifyButton;

    private final class CancelReservation implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            confirmCancelDialogueBox(controller.cancelReservationGuest());
        }
    }

    private final class ConfirmedCancelReservation implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            isCancelledDialogueBox(controller.confirmCancellationGuest());
        }
    }

    //shows that the room is available
    public void confirmCancelDialogueBox(String description) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDialog box = new JDialog();
                JPanel items = new JPanel();
                items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
                JLabel desc = new JLabel(description);

                desc.setAlignmentX(Component.CENTER_ALIGNMENT);
                JButton confirmBtn = new JButton("Confirm Cancellation"); // FIXME: sends to billing
                confirmBtn.addActionListener(new ConfirmedCancelReservation());
                confirmBtn.setAlignmentX(Component.CENTER_ALIGNMENT);


                box.setPreferredSize(new Dimension(600, 400));
                box.setTitle("Are you sure?");
                items.add(desc);
                items.add(confirmBtn);
                box.add(items);
                box.pack();

                box.setLocationRelativeTo(getParent());
                box.setVisible(true);

            }
        });
    }

    public void isCancelledDialogueBox(boolean ok) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDialog box = new JDialog();
                JPanel items = new JPanel();
                items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
                JButton backToReservationsButton;
                JLabel desc;
                if(ok){
                    desc = new JLabel("Your Reservation has now been cancelled!");
                    backToReservationsButton = new JButton("Go Back to All Reservations");
                    backToReservationsButton.addActionListener(null);
                }
                else{
                    desc = new JLabel("Your Reservation cannot be cancelled! Try again another time");
                    backToReservationsButton = new JButton("Ok");
                    backToReservationsButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });
                }
                desc.setAlignmentX(Component.CENTER_ALIGNMENT);

                box.setPreferredSize(new Dimension(600, 400));
                box.setTitle("Reservation Cancellation");
                items.add(desc);
                box.add(items);
                box.pack();
                box.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

                box.setLocationRelativeTo(getParent());
                box.setVisible(true);

            }
        });
    }

    //makes the GUI for the frame
    public ReservationViewUI() {
        super();

        //try {
        String[] room = new String[0];
        //controller.getRoomInfo()
        //if(room.length < 5) {
        //throw
        //}
        //else{
        roomDescription = new JPanel();
        reserveOptions = new JPanel();
        roomName = new JLabel("Executive" + " Level");
        roomName.setFont(DefaultUI.getTitleFont());
        qualityLbl = new JLabel("Quality: " + "Executive");
        bedTypeLbl = new JLabel("bedType: " + "queen");
        bedTotalLbl = new JLabel("Bed Total: " + 1);
        smokingLbl = new JLabel("Smoking: " + "No");

        arrivalDateLbl = new JLabel("Start Date: " + "12-31-23");
        endDateLbl= new JLabel("End Date: " + "1-34-23");
        guestTotalLbl = new JLabel("Total Guests: " + 1);
        cancelButton = new JButton("Cancel Reservation");
        modifyButton = new JButton("Modify Reservation"); // takes to Make Reservation
        //cancelButton.addActionListener(new MakeReservationGUI.ConfirmReserveRoom());


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
        reserveOptions.add(guestTotalLbl, constraints);

        ++constraints.gridy;
        reserveOptions.add(cancelButton, constraints);
        ++constraints.gridy;
        reserveOptions.add(modifyButton,constraints);

        add(roomDescription);
        add(reserveOptions);

        //Instead of pack, directly set the frame to be visible
        setVisible(true);
    }
//    public JPanel initSideMenu(){
//        JPanel side = super.initSideMenu();
//        JButton srchCruiseBtn = new JButton("Search Cruise Reservations");
//        side.add(srchCruiseBtn);
//        JButton myReservationsBtn = new JButton("My Reservations");
//        side.add (myReservationsBtn);
//        return side;
//    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("CruiseLink - View Room");
        //frame.setUndecorated(true);  //This makes the GUI have no window decorations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes the window close when exit button clicked
        frame.setResizable(false);   //Disables resizing

        //This block allows fullscreen mode
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setAlwaysOnTop(true);
        env.getDefaultScreenDevice().setFullScreenWindow(frame); //Enables Fullscreen

        //Setting layout to Grid Bag Layout
        frame.setLayout(new GridBagLayout());

        //Create and set up the content pane.
        ReservationViewUI newContentPane = new ReservationViewUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}
