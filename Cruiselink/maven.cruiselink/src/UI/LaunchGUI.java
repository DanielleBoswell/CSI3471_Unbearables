package Cruiselink.maven.cruiselink.src.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchGUI {

    //Q: Why do we need a UINavigator object and constructor that sets it?

    //UINavigator contains the cardLayout and cardPanel which manage different panels.
    //Passing the UINavigator instance to a page, gives the page the ability to tell
    //the UINavigator to switch between panels.

    //Declare instance of UINavigator to manage navigation in the UI -------- Needed for switching pages --------
    private UINavigator UINavigator;

    //Constructor that takes a UINavigator instance as an argument -------- Needed for switching pages --------
    public LaunchGUI(UINavigator UINavigator) {
        this.UINavigator = UINavigator;
    }

    //Creates and returns a JPanel for the launch screen
    public JPanel createLaunchPanel() { // -------- Must return the panel for switching --------

        //Create a new JPanel with BorderLayout to organize components
        JPanel launchPanel = new JPanel(new BorderLayout());

        //Create a JLabel for the title and set its properties
        JLabel unbearablesLabel = new JLabel("The unBEARables");
        //Set font type and size
        unbearablesLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
        //Centers the text
        unbearablesLabel.setHorizontalAlignment(JLabel.CENTER);
        //Add empty border for spacing
        unbearablesLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        //Load an image and create an ImageIcon from a file
        //Create an ImageIcon with the given file path
        ImageIcon imageIcon = new ImageIcon("Care Bears Updated.jpg");
        //Create a label with the ImageIcon
        JLabel label = new JLabel(imageIcon);

        //Create a button to launch software (goes to log in page)
        JButton launchSoftwareButton = new JButton("Launch Software");

        launchSoftwareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Calls method from the UINavigator class to switch the view to the login panel
                UINavigator.showCard(UINavigator.LOGIN_PANEL);
            }
        });

        //Place the launchSoftwareButton inside a JPanel to prevent it from stretching
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(launchSoftwareButton);
        //Add empty border for spacing
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 0));

        //Add components to the launch panel
        //Add the unbearables Label at the top (north)
        launchPanel.add(unbearablesLabel, BorderLayout.NORTH);
        //Add the image label in the center
        launchPanel.add(label, BorderLayout.CENTER);
        //Add the button panel at the bottom (south)
        launchPanel.add(buttonPanel, BorderLayout.SOUTH);

        //Return the launch Panel
        return launchPanel;
    }
}