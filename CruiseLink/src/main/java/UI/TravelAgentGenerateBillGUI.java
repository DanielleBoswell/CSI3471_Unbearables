package UI;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TravelAgentGenerateBillGUI {

    //For testing...
    private HashMap<String, String[]> reservations; //Testing with csv file

    //Text fields, buttons, and text boxes
    private JTextField guestNameField, reservationIdField, roomNumberField;
    private JButton searchButton, generateBillButton, sendBillButton, cancelButton;
    private JTextArea reservationSummaryTextArea, billTextArea;

    private UINavigator UINavigator;

    public TravelAgentGenerateBillGUI(UINavigator UINavigator) {
        this.UINavigator = UINavigator;
        readReservationsFromCSV("Travel_agent_generate_bill.csv"); //Testing with csv file
    }

    public JPanel createTravelAgentBilling(){

        JPanel travelAgentBillingPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //Default insets for all components
        Insets insets = new Insets(10, 10, 10, 10);
        gbc.insets = insets;

        JLabel generateBillLabel = new JLabel("Generate Billing Information");
        generateBillLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

        //Set GridBagConstraints for the label
        gbc.gridx = 0; //Align to the first column
        gbc.gridy = 0; //Place at the first row
        gbc.gridwidth = 2; //Span across two columns
        gbc.insets = new Insets(20, 10, 20, 10); //Add some padding
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(generateBillLabel, gbc);

        //Reset insets for other components
        gbc.insets = insets;

        //Input fields for guest name, reservation ID, and room number
        guestNameField = new JTextField(15);
        reservationIdField = new JTextField(15);
        roomNumberField = new JTextField(15);

        //Add labels and text fields to the panel, centered above each text field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(new JLabel("Guest Name:"), gbc);

        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(guestNameField, gbc);

        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(new JLabel("Reservation ID:"), gbc);

        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(reservationIdField, gbc);

        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(new JLabel("Room Number:"), gbc);

        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(roomNumberField, gbc);

        //Search button
        searchButton = new JButton("Search");
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(searchButton, gbc);

        //Need to add a label for the reservation details text box
        JLabel reservationBoxLabel = new JLabel("Reservation Details:");
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(reservationBoxLabel, gbc);

        //Text area for reservation summary
        reservationSummaryTextArea = new JTextArea(5, 20);
        reservationSummaryTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reservationSummaryTextArea);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(scrollPane, gbc);

        //Generate Bill button
        generateBillButton = new JButton("Generate Bill");
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(generateBillButton, gbc);

        //Need to add a label for the billing details text box
        JLabel billDetailsBoxLabel = new JLabel("Billing Details:");
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(billDetailsBoxLabel, gbc);

        //Text area for bill details
        billTextArea = new JTextArea(5, 20);
        billTextArea.setEditable(false);
        JScrollPane billScrollPane = new JScrollPane(billTextArea);
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(billScrollPane, gbc);

        //Send Bill button
        sendBillButton = new JButton("Send Bill");
        gbc.gridy = 13;
        gbc.gridwidth = 2; //Span two columns
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(sendBillButton, gbc);

        //Cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.RED);
        gbc.gridy = 14;
        gbc.gridwidth = 2; //Span two columns
        gbc.anchor = GridBagConstraints.CENTER;
        travelAgentBillingPanel.add(cancelButton, gbc);

        //Set action listeners
        searchButton.addActionListener(e -> onSearch());
        generateBillButton.addActionListener(e -> onGenerateBill());
        sendBillButton.addActionListener(e -> onSendBill(UINavigator));
        cancelButton.addActionListener(e -> onCancel(UINavigator));

        return travelAgentBillingPanel;
    }

    //For testing...
    private void readReservationsFromCSV(String csvFile) {
        reservations = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine(); //Skip the header row
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                reservations.put(values[1], values); //Assuming Reservation ID is the unique key
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onSearch() {

        String reservationId = reservationIdField.getText();
        String roomNumber = roomNumberField.getText();

        if (reservations.containsKey(reservationId)) {
            String[] details = reservations.get(reservationId);
            if (details[2].equals(roomNumber)) {
                reservationSummaryTextArea.setText(String.join("\n", details));
            } else {
                reservationSummaryTextArea.setText("Reservation found, but room number does not match.");
            }
        } else {
            reservationSummaryTextArea.setText("Reservation not found.");
        }
    }

    private void onGenerateBill() {

        String reservationId = reservationIdField.getText();
        String roomNumber = roomNumberField.getText();

        if (reservations.containsKey(reservationId)) {
            String[] details = reservations.get(reservationId);
            if (details[2].equals(roomNumber)) {
                String billDetails = "Bill for Reservation ID: " + details[1] +
                        "\nGuest Name: " + details[0] +
                        "\nRoom Number: " + details[2] +
                        "\nTotal Bill: $" + details[5];
                billTextArea.setText(billDetails);
            } else {
                billTextArea.setText("Room number does not match. No bill to generate.");
            }
        } else {
            billTextArea.setText("No bill to generate. Reservation not found.");
        }
    }

    private void onSendBill(UINavigator UINavigator) {

        //We need to check if any of the text fields are empty
        if (guestNameField.getText().trim().isEmpty() ||
                reservationIdField.getText().trim().isEmpty() ||
                roomNumberField.getText().trim().isEmpty() ||
                billTextArea.getText().trim().isEmpty()) {

            //Show an error message if any field is empty
            JOptionPane.showMessageDialog(null, "Cannot send bill. " +
                    "Please ensure all fields are filled.", "Error", JOptionPane.ERROR_MESSAGE);
            return; //Do not proceed further, just return
        }

        JOptionPane.showMessageDialog(null, "Bill sent to guest account",
                "Bill Generated", JOptionPane.INFORMATION_MESSAGE);

        //Should clear boxes
        guestNameField.setText("");
        reservationIdField.setText("");
        roomNumberField.setText("");
        reservationSummaryTextArea.setText("");
        billTextArea.setText("");

        //Return to travel agent home page
        UINavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }

    private void onCancel(UINavigator UINavigator){

        JOptionPane.showMessageDialog(null, "Bill generation canceled",
                "Returning to travel agent home page", JOptionPane.ERROR_MESSAGE);

        //Should clear boxes
        guestNameField.setText("");
        reservationIdField.setText("");
        roomNumberField.setText("");
        reservationSummaryTextArea.setText("");
        billTextArea.setText("");

        //Return to travel agent home page
        UINavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
    }
}