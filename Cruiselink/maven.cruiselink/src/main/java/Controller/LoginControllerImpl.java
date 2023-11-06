package Controller;

import UI.SignUpGUI;

import javax.swing.*;

public class LoginControllerImpl implements LoginController {

    @Override
    public void onLoginPressed(String username, String password) {

        //Implement my logic here
        System.out.println("Login button pressed");
    }

    @Override
    public void onSignUpPressed() {

        //Call signup GUI if sign up button is clicked
        SwingUtilities.invokeLater(() -> {
            new SignUpGUI().createGUI();
        });
    }

    @Override
    public void onForgotPasswordPressed() {

        //Implement my forgot password logic here
        System.out.println("Forgot Password link clicked");
    }
}
