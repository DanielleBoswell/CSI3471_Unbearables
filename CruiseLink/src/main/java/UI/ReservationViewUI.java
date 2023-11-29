package UI;

import Controller.AllReservationsGuestViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationViewUI extends JPanel{


    private UINavigator uiNavigator;
    private AllReservationsGuestViewController controller;

    /**
     * constructor
     * @param uiNavigator
     * @param rGVC
     */
    public ReservationViewUI(UINavigator uiNavigator, AllReservationsGuestViewController rGVC){
        this.uiNavigator = uiNavigator;
        this.controller = rGVC;
    }

    private JPanel roomDescription, reserveOptions;
    private JLabel roomName;
    private JTextArea description;
    private JLabel qualityLbl,
            bedTypeLbl,
            bedTotalLbl,
            smokingLbl;
    private JTextField arrivalDateField,
            endDateField,
            guestTotalField;
    private JButton reserveButton;

    private final class CancelReservation implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //controller.reserveRoom();
        }
    }

    //shows that the room is available
    public void canCancelDialogueBox() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDialog box = new JDialog();
                JPanel items = new JPanel();
                items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
                JLabel desc = new JLabel("A room is available at these specified dates!");

                desc.setAlignmentX(Component.CENTER_ALIGNMENT);
                JButton confirmBtn = new JButton("Make Reservation"); // FIXME: sends to billing
                //confirmBtn.addActionListener(new MakeReservationGUI.ReserveRoom());
                confirmBtn.setAlignmentX(Component.CENTER_ALIGNMENT);


                box.setPreferredSize(new Dimension(600, 400));
                box.setTitle("Available Room");
                items.add(desc);
                items.add(confirmBtn);
                box.add(items);
                box.pack();

                box.setLocationRelativeTo(getParent());
                box.setVisible(true);

            }
        });
    }

    public void isCancelledDialogueBox() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDialog box = new JDialog();
                JPanel items = new JPanel();
                items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
                JLabel desc = new JLabel("");
                desc.setAlignmentX(Component.CENTER_ALIGNMENT);

                box.setPreferredSize(new Dimension(600, 400));
                box.setTitle("Available Room");
                items.add(desc);
                box.add(items);
                box.pack();

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
        roomName = new JLabel(room[0] + " Level");
        roomName.setFont(DefaultUI.getTitleFont());
        description = new JTextArea("add room description here");
        description.setEditable(false);
        qualityLbl = new JLabel("Quality: " + room[0]);
        bedTypeLbl = new JLabel("bedType: " + room[1]);
        bedTotalLbl = new JLabel("Bed Total: " + room[2]);
        smokingLbl = new JLabel("Smoking: " + room[3]);

        arrivalDateField = new JTextField(8);
        endDateField= new JTextField(8);
        guestTotalField = new JTextField(2);
        reserveButton = new JButton("Reserve");
        //reserveButton.addActionListener(new MakeReservationGUI.ConfirmReserveRoom());


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
        roomDescription.add(description, constraints);

        ++constraints.gridy;
        roomDescription.add(qualityLbl, constraints);

        ++constraints.gridy;
        roomDescription.add(bedTypeLbl, constraints);

        ++constraints.gridy;
        roomDescription.add(bedTotalLbl, constraints);

        ++constraints.gridy;
        roomDescription.add(smokingLbl, constraints);

        constraints.gridy = 0;
        reserveOptions.add(new JLabel("Start Date:"), constraints);
        reserveOptions.add(arrivalDateField, constraints);

        ++constraints.gridy;
        reserveOptions.add(new JLabel("End Date:"), constraints);
        reserveOptions.add(endDateField, constraints);

        ++constraints.gridy;
        reserveOptions.add(new JLabel("Guest Total: "), constraints);
        reserveOptions.add(guestTotalField, constraints);

        ++constraints.gridy;
        reserveOptions.add(reserveButton, constraints);

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
        MakeReservationGUI newContentPane = new MakeReservationGUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void runGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}
