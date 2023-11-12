package Controller;

import UI.LoginGUI;
import UI.UINavigator;

import javax.swing.*;

public class LoginControllerImpl implements LoginController {

    //Reference to the UINavigator for changing panels
    private UINavigator uiNavigator;

    //Constructor to set the UINavigator instance
    public LoginControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    @Override
    public void onLoginPressed(String username, String password) {

        //Check the username and password with database system
        //boolean isAuthenticated = /* Authentication logic */;

        //if (isAuthenticated) {
            //If login is successful, switch to another panel
            //Ex: uiNavigator.showCard(UINavigator.NEXT_PANEL);
        //}
        //else {
            //Show error message or reset the login form
            //JOptionPane.showMessageDialog(null, "Invalid login credentials", "Login Error", JOptionPane.ERROR_MESSAGE);
        //}

        System.out.println("Login button pressed");
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