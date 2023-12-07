package Controller;

import Domain.Admin;
import Domain.Agent;
import Domain.Guest;
import Domain.Person;
import Repository.AccountDBO;
import Repository.AccountDatabase;
import UI.UINavigator;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginControllerSQL implements LoginController{

    private UINavigator uiNavigator;

    public LoginControllerSQL(UINavigator uiNavigator) {
    }

    //Constructor to set the UINavigator instance
    public void LoginControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    /**
     * author Nicholas Revard
     *
     * @param username
     * @param password
     * @throws SQLException
     */
    @Override
    public void onLoginPressed(String username, String password) throws SQLException { // -------------- Working ------------------

        String csvFilePath = "sample_users.csv";
        AccountDatabase foundation = new AccountDatabase();
        foundation.createAccountDatabase();

        AccountDBO accounts = new AccountDBO(foundation.getDBConnection());

        Person possible = accounts.findByUsername(username);
        if(possible== null){
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
/*        String taken = null;
        taken = String.valueOf(possible.stream().
                filter(e-> e.getUsername().equals(username)).findFirst().get());*/

        if(!possible.getPassword().equals(password)){
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
/*        Person loginPerson = possible.stream().
                filter(e-> e.getUsername().equals(username)).findFirst().get();*/
        if(possible instanceof Person){
            uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL);
            return;
        } else if (possible instanceof Agent) {
            uiNavigator.showCard(UINavigator.TRAVEL_AGENT_LANDING_PANEL);
            return;
        }else if (possible instanceof Admin) {
            uiNavigator.showCard(UINavigator.ADMIN_LANDING_PANEL);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            br.readLine(); //Skip the header line

            while ((line = br.readLine()) != null) {

                //System.out.println("Line in CSV: " + line);

                String[] values = line.split(",");

                if (values[4].equals(username) && values[5].equals(password)) {
                    switch (values[6]) {
                        case "guest":
                            uiNavigator.showCard(UINavigator.GUEST_LANDING_PANEL);
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

    /**
     *
     */
    @Override
    public void onSignUpPressed() {

        //Switch to the signup panel using the UINavigator
        uiNavigator.showCard(UINavigator.SIGNUP_PANEL);
    }

    /**
     *
     * @param email
     */
    @Override
    public void onForgotPasswordPressed(String email) {

        //Implement my forgot password logic here
        System.out.println("Forgot Password link clicked");

        //Need to prompt user for email for reset link

    }

}
