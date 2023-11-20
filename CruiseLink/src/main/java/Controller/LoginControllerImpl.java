package Controller;

import UI.LoginGUI;
import UI.UINavigator;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginControllerImpl implements LoginController {

    //Reference to the UINavigator for changing panels
    private UINavigator uiNavigator;

    //Constructor to set the UINavigator instance
    public LoginControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    @Override
    public void onLoginPressed(String username, String password) { // -------------- Working ------------------

        String csvFilePath = "sample_users.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            br.readLine(); //Skip the header line

            while ((line = br.readLine()) != null) {

                //System.out.println("Line in CSV: " + line);

                String[] values = line.split(",");

                if (values[4].equals(username) && values[5].equals(password)) {
                    switch (values[6]) {
                        case "guest":
                            //uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL); ----------------------------------------
                            return;
                        case "travel agent":
                            uiNavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
                            return;
                        case "admin":
                            uiNavigator.showCard(UINavigator.ADMIN_LANDING_PANEL);
                            return;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid user type", "Login Error", JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "CSV file not found", "File Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading CSV file", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void onSignUpPressed() {

        //Switch to the signup panel using the UINavigator
        uiNavigator.showCard(UINavigator.SIGNUP_PANEL);
    }

    @Override
    public void onForgotPasswordPressed(String email) {

        //Implement my forgot password logic here
        System.out.println("Forgot Password link clicked");

        //Need to prompt user for email for reset link

    }
}