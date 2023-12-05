package UI;

import Controller.GuestControllerImpl;

import javax.swing.*;
import java.awt.*;

public class GuestLandingPage {

    private JLabel guestLabel;
    private JButton searchCruisesButton;
    private JButton viewReservationsButton;
    private JButton profileButton;

    private JButton logoutButton;

    private GuestControllerImpl guestController;

    public void setController(GuestControllerImpl guestController) {
        this.guestController = guestController;
    }

    private UINavigator UINavigator;

    public GuestLandingPage(UINavigator UINavigator) {
        this.UINavigator = UINavigator;
    }

    public JPanel createGuestLandingPanel() {

        //Initialize a new JPanel with a GridBagLayout manager for layout of components
        JPanel guestLandingPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Initialize the JLabel with text and set its font
        guestLabel = new JLabel("Guest Home Page");
        guestLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

        //Set the grid position and layout constraints for the label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(30, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        //Add the label to the panel with the constraints
        guestLandingPanel.add(guestLabel, gbc);

        //Create and add buttons
        searchCruisesButton = addButton("Search Cruises", guestLandingPanel, gbc, 1);
        viewReservationsButton = addButton("View Reservations", guestLandingPanel, gbc, 2);
        profileButton = addButton("View Profile", guestLandingPanel, gbc, 3);
        logoutButton = addButton("Log Out", guestLandingPanel, gbc, 4);

        //Set action listeners for each button -- Will require controller --
        searchCruisesButton.addActionListener(e -> guestController.onSearchCruises());

        viewReservationsButton.addActionListener(e -> guestController.onViewReservation());

        //guestController.onViewProfile()
        profileButton.addActionListener(e -> guestController.onViewProfile());

        logoutButton.addActionListener(e -> UINavigator.showCard(UINavigator.LOGIN_PANEL));

        //Return the panel
        return guestLandingPanel;
    }

    //Helper method to add a button to the panel
    private JButton addButton(String text, JPanel panel, GridBagConstraints gbc, int yPos) {
        JButton button = new JButton(text);
        gbc.gridx = 0;
        gbc.gridy = yPos;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(button, gbc);
        return button;
    }
}
