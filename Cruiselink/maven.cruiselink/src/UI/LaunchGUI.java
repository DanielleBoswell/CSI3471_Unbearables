package Cruiselink.maven.cruiselink.src.UI;

import Cruiselink.maven.cruiselink.src.Controller.LoginController;
import Cruiselink.maven.cruiselink.src.Controller.LoginControllerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchGUI {

    private JFrame frame;
    private JLabel unbearablesLabel;
    private JButton launchSoftwareButton;

    public void LaunchPage() {

        //Initialize main frame
        frame = new JFrame("CruiseLink");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // ------------------- added 1:05

        //This block allows fullscreen mode
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        env.getDefaultScreenDevice().setFullScreenWindow(frame); //Enables Fullscreen

        //Load and display the image
        ImageIcon imageIcon = new ImageIcon("Care Bears Updated.jpg"); //Image has to be in the root directory
        JLabel label = new JLabel(imageIcon);

        //Making and formatting cruise link label
        unbearablesLabel = new JLabel("The unBEARables");
        unbearablesLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
        unbearablesLabel.setHorizontalAlignment(JLabel.CENTER); //Centers the text
        int topPadding = 20; //Lowers the label a bit from the top
        unbearablesLabel.setBorder(BorderFactory.createEmptyBorder(topPadding, 0, 0, 0));

        //Button to launch software (goes to log in page)
        launchSoftwareButton = new JButton("Launch Software");
        launchSoftwareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Software Launched!");

                //Launch the log in page
                SwingUtilities.invokeLater(() -> {

                    //Need to create an instance of the concrete implementation of LoginController
                    LoginController controller = new LoginControllerImpl();

                    //Will pass controller to LoginGUI and create the login GUI
                    LoginGUI loginGUI = new LoginGUI(controller);

                    //Create login GUI
                    loginGUI.createGUI();
                });
            }
        });

        //Place the launchSoftwareButton inside a JPanel to prevent it from stretching
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(launchSoftwareButton);
        int bottomPadding = 50; //Raise it from the bottom of the screen
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, bottomPadding, 0));

        //Add the components to the frame
        frame.setLayout(new BorderLayout());  //Set the layout
        frame.add(unbearablesLabel, BorderLayout.NORTH);
        frame.add(label, BorderLayout.CENTER); //Add the image label
        frame.add(buttonPanel, BorderLayout.SOUTH); //Add the button at the bottom

        frame.setVisible(true);
    }
}