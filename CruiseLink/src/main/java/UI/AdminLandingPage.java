package UI;

import Controller.AdminControllerImpl;

import javax.swing.*;
import java.awt.*;

public class AdminLandingPage {

    private JLabel AdminLabel;
    private JButton createTravelAgentAccountButton;
    private JButton resetUserAccountPasswordButton;

    private JButton logoutButton;

    private AdminControllerImpl adminController;

    public void setController(AdminControllerImpl adminController) {
        this.adminController = adminController;
    }

    private UINavigator UINavigator;

    public AdminLandingPage(UINavigator UINavigator) {
        this.UINavigator = UINavigator;
    }

    public JPanel createAdminLandingPanel() {

        //Initialize a new JPanel with a GridBagLayout manager for layout of components
        JPanel adminLandingPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Initialize the JLabel with text and set its font
        AdminLabel = new JLabel("Admin Landing Page");
        AdminLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

        //Set the grid position and layout constraints for the label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(30, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        //Add the label to the panel with the constraints
        adminLandingPanel.add(AdminLabel, gbc);

        //Create and add buttons
        createTravelAgentAccountButton = addButton("Create Travel Agent Account", adminLandingPanel, gbc, 1);
        resetUserAccountPasswordButton = addButton("Reset User Account Password", adminLandingPanel, gbc, 2);
        logoutButton = addButton("Log Out", adminLandingPanel, gbc, 3);

        //Set action listeners for each button -- Will require controller --
        createTravelAgentAccountButton.addActionListener(e -> adminController.onCreateTravelAgentAccount());

        resetUserAccountPasswordButton.addActionListener(e -> adminController.onResetUserAccountPassword());

        logoutButton.addActionListener(e -> UINavigator.showCard(UINavigator.LOGIN_PANEL));

        //Return the panel
        return adminLandingPanel;
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