package com.csi3471.unbearables.maven.cruiselink.ui;

import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MakeReservationGUI extends DefaultUI{
	private MakeReservationController controller;
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
	
	
	public MakeReservationGUI() {
		super();
		
		//try {
			this.controller = new MakeReservationController();
			String[] room = controller.getRoomInfo();
			//if(room.length < 5) {
				//throw
			//}
			//else{
				roomName = new JLabel(room[0] + " Level"); 
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
				
			//}
		//}
		//catch() {
			
		//}
				//Layout the components using GridBagConstraints
				setLayout(new GridBagLayout());
		        GridBagConstraints constraints = new GridBagConstraints();
		        constraints.insets = new Insets(15, 5, 15, 5); //Padding for the components (buttons, labels, etc)

		        //Adding labels and buttons to the frame, using y axis on grid
		        constraints.gridy = 0; //0 starts at the top, etc
		        add(roomName, constraints);

		        ++constraints.gridy;
		        add(description, constraints);

		        ++constraints.gridy;
		        add(qualityLbl, constraints);

		        ++constraints.gridy;
		        add(bedTypeLbl, constraints);

		        ++constraints.gridy;
		        add(bedTotalLbl, constraints);
		        
		        ++constraints.gridy;
		        add(smokingLbl, constraints);

		        ++constraints.gridy;
		        add(new JLabel("Start Date:"), constraints);
		        add(arrivalDateField, constraints);

		        ++constraints.gridy;
		        add(new JLabel("End Date:"), constraints);
		        add(endDateField, constraints);
		        
		        ++constraints.gridy;
		        add(new JLabel("Guest Total: "), constraints);
		        add(guestTotalField, constraints);
		        
		        ++constraints.gridy;
		        add(reserveButton, constraints);

		        //Instead of pack, directly set the frame to be visible
		        setVisible(true);
		
	}
	public JPanel initSideMenu(){		
		JPanel side = super.initSideMenu();
		JButton srchCruiseBtn = new JButton("Search Cruise Reservations");
		side.add(srchCruiseBtn);
		JButton myReservationsBtn = new JButton("My Reservations");
		side.add (myReservationsBtn);
		return side;
	}
	
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
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
}
